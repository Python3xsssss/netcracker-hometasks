"use strict";
var _a, _b, _c;
var AVLNode = /** @class */ (function () {
    function AVLNode(data, key) {
        this.data = data;
        this.key = key;
        this.height = 1;
        this.left = null;
        this.right = null;
    }
    return AVLNode;
}());
var AVLTree = /** @class */ (function () {
    function AVLTree() {
        this.top = null;
    }
    // Private methods
    AVLTree.prototype.height = function (subtree) {
        return (subtree == null) ? 0 : subtree.height;
    };
    AVLTree.prototype.balanceFactor = function (subtree) {
        return (subtree == null) ? 0 : this.height(subtree.right) - this.height(subtree.left);
    };
    AVLTree.prototype.recalc = function (subtree) {
        if (subtree == null) {
            return;
        }
        var hLeft = this.height(subtree.left);
        var hRight = this.height(subtree.right);
        subtree.height = ((hLeft > hRight) ? hLeft : hRight) + 1;
    };
    AVLTree.prototype.leftRotation = function (subtree) {
        if (subtree == null) {
            return null;
        }
        var subsubtree = subtree.right;
        if (subsubtree == null) {
            return subtree;
        }
        subtree.right = subsubtree.left;
        subsubtree.left = subtree;
        this.recalc(subtree);
        this.recalc(subsubtree);
        return subsubtree;
    };
    AVLTree.prototype.rightRotation = function (subtree) {
        if (subtree == null) {
            return null;
        }
        var subsubtree = subtree.left;
        if (subsubtree == null) {
            return subtree;
        }
        subtree.left = subsubtree.right;
        subsubtree.right = subtree;
        this.recalc(subtree);
        this.recalc(subsubtree);
        return subsubtree;
    };
    AVLTree.prototype.balance = function (subtree) {
        if (subtree == null) {
            return null;
        }
        this.recalc(subtree);
        if (this.balanceFactor(subtree) === 2) {
            if (this.balanceFactor(subtree.right) < 0) {
                subtree.right = this.rightRotation(subtree.right);
            }
            subtree = this.leftRotation(subtree);
        }
        else if (this.balanceFactor(subtree) === -2) {
            if (this.balanceFactor(subtree.left) > 0) {
                subtree.left = this.leftRotation(subtree.left);
            }
            subtree = this.rightRotation(subtree);
        }
        return subtree;
    };
    AVLTree.prototype.findMin = function (subtree) {
        if (subtree == null) {
            return null;
        }
        return (subtree.left == null) ? subtree : this.findMin(subtree.left);
    };
    AVLTree.prototype.delMin = function (subtree) {
        if (subtree == null) {
            return null;
        }
        if (subtree.left == null) {
            return subtree.right;
        }
        subtree.left = this.delMin(subtree.left);
        return this.balance(subtree);
    };
    AVLTree.prototype.privSearch = function (subtree, key) {
        if (this.top == null) {
            return null;
        }
        var canv = document.getElementById("treeWindow");
        var context = canv.getContext("2d");
        var marginTop = 40;
        var x = canv.width / 2;
        var y = marginTop + AVLTree.radius;
        var width = Math.pow(2, this.top.height) * (2 * AVLTree.radius + AVLTree.intervalW) - AVLTree.intervalW;
        while (subtree != null) {
            if (key < subtree.key) {
                subtree = subtree.left;
                x -= width / 4;
            }
            else if (key > subtree.key) {
                subtree = subtree.right;
                x += width / 4;
            }
            else {
                break;
            }
            y += 2 * AVLTree.radius + AVLTree.intervalH;
            width /= 2;
        }
        if (subtree != null && context != null) {
            context.lineWidth = 3;
            context.strokeStyle = "red";
            context.beginPath();
            context.arc(x, y, AVLTree.radius, 0, 2 * Math.PI, false);
            context.stroke();
        }
        return subtree;
    };
    AVLTree.prototype.privInsert = function (subtree, data, key) {
        if (subtree == null) {
            return new AVLNode(data, key);
        }
        if (key < subtree.key) {
            subtree.left = this.privInsert(subtree.left, data, key);
        }
        else {
            subtree.right = this.privInsert(subtree.right, data, key);
        }
        return this.balance(subtree);
    };
    AVLTree.prototype.privRemove = function (subtree, key) {
        if (subtree == null) {
            return null;
        }
        if (key < subtree.key) {
            subtree.left = this.privRemove(subtree.left, key);
        }
        else if (key > subtree.key) {
            subtree.right = this.privRemove(subtree.right, key);
        }
        else {
            var subsubtreeLeft = subtree.left;
            var subsubtreeRight = subtree.right;
            if (subsubtreeRight == null) {
                return subsubtreeLeft;
            }
            var rightmin = this.findMin(subsubtreeRight);
            if (rightmin == null) {
                return subsubtreeLeft;
            }
            rightmin.right = this.delMin(subsubtreeRight);
            rightmin.left = subsubtreeLeft;
            return this.balance(rightmin);
        }
        return this.balance(subtree);
    };
    AVLTree.prototype.drawEdge = function (context, x, y, width, color, left) {
        var shift = AVLTree.radius / Math.sqrt(2);
        var nextX = (left) ? x - width / 4 : x + width / 4;
        var nextY = y + 2 * AVLTree.radius + AVLTree.intervalH;
        context.strokeStyle = color;
        context.moveTo((left) ? x - shift : x + shift, y + shift);
        context.lineTo((left) ? nextX + shift : nextX - shift, nextY - shift);
        context.stroke();
    };
    AVLTree.prototype.bfsRedraw = function (subtree, context, x, y, width) {
        if (subtree == null) {
            return;
        }
        context.beginPath();
        context.arc(x, y, AVLTree.radius, 0, 2 * Math.PI, false);
        context.stroke();
        context.font = "15px sans-serif";
        context.textBaseline = "middle";
        context.fillText(String(subtree.data), x, y, AVLTree.maxlen);
        context.font = "12px sans-serif";
        context.textBaseline = "bottom";
        context.fillText(String(subtree.key), x, y - AVLTree.radius);
        if (subtree.left != null) {
            this.drawEdge(context, x, y, width, "white", true);
            this.bfsRedraw(subtree.left, context, x - width / 4, y + 2 * AVLTree.radius + AVLTree.intervalH, width / 2);
        }
        if (subtree.right != null) {
            this.drawEdge(context, x, y, width, "white", false);
            this.bfsRedraw(subtree.right, context, x + width / 4, y + 2 * AVLTree.radius + AVLTree.intervalH, width / 2);
        }
        return;
    };
    // Public methods
    AVLTree.prototype.search = function (key) {
        var target = this.privSearch(this.top, key);
        return (target == null) ? null : target.data;
    };
    AVLTree.prototype.insert = function (data, key) {
        this.top = this.privInsert(this.top, data, key);
    };
    AVLTree.prototype.remove = function (key) {
        this.top = this.privRemove(this.top, key);
    };
    AVLTree.prototype.clean = function () {
        this.top = null; // this.privClean(this.top);
    };
    AVLTree.prototype.empty = function () {
        return this.top == null;
    };
    AVLTree.prototype.getHeight = function () {
        return this.height(this.top);
    };
    AVLTree.prototype.redrawTree = function () {
        var canv = document.getElementById("treeWindow");
        resizeCanv(canv);
        if (this.top == null) {
            return;
        }
        var context = canv.getContext("2d");
        if (context == null) {
            return;
        }
        context.clearRect(0, 0, canv.width, canv.height);
        context.lineWidth = 3;
        context.strokeStyle = "white";
        context.textAlign = "center";
        context.fillStyle = "white";
        var marginTop = 40;
        var width = Math.pow(2, this.top.height) * (2 * AVLTree.radius + AVLTree.intervalW) - AVLTree.intervalW;
        this.bfsRedraw(this.top, context, canv.width / 2, AVLTree.radius + marginTop, width);
    };
    AVLTree.radius = 30;
    AVLTree.maxlen = 2 * AVLTree.radius - 5;
    AVLTree.intervalW = 0.1 * AVLTree.radius;
    AVLTree.intervalH = 1.1 * AVLTree.radius;
    return AVLTree;
}());
function resizeCanv(canvas) {
    var displayWidth = canvas.clientWidth;
    var displayHeight = canvas.clientHeight;
    if (canvas.width !== displayWidth || canvas.height !== displayHeight) {
        canvas.width = displayWidth;
        canvas.height = displayHeight;
    }
}
var tree = new AVLTree();
var container = document.createElement("div");
function addPressed() {
    tree.redrawTree();
    container.innerHTML = "";
    var data = document.getElementById("addData").value;
    var key = document.getElementById("addKey").value;
    if (key !== "") {
        tree.insert(data, Number(key));
        document.getElementById("addData").value = "";
        document.getElementById("addKey").value = "";
    }
    tree.redrawTree();
}
function findPressed() {
    tree.redrawTree();
    container.innerHTML = "";
    var key = document.getElementById("findKey").value;
    if (key !== "") {
        tree.search(Number(key));
    }
}
function delPressed() {
    tree.redrawTree();
    container.innerHTML = "";
    var key = document.getElementById("delKey").value;
    if (key !== "") {
        tree.remove(Number(key));
        document.getElementById("delKey").value = "";
    }
    tree.redrawTree();
}
(_a = document.getElementById("add")) === null || _a === void 0 ? void 0 : _a.setAttribute("onclick", "addPressed()");
(_b = document.getElementById("find")) === null || _b === void 0 ? void 0 : _b.setAttribute("onclick", "findPressed()");
(_c = document.getElementById("del")) === null || _c === void 0 ? void 0 : _c.setAttribute("onclick", "delPressed()");

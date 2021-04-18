type AVLNodeOrNull<T> = AVLNode<T> | null;

class AVLNode<T> {
    data: T;
    key: number;
    height: number;
    left: AVLNodeOrNull<T>;
    right: AVLNodeOrNull<T>;


    constructor(data: T, key: number) {
        this.data = data;
        this.key = key;
        this.height = 1;
        this.left = null;
        this.right = null;
    }
}

class AVLTree<T> {
    private static radius = 30;
    private static maxlen = 2 * AVLTree.radius - 5;
    private static intervalW = 0.1 * AVLTree.radius;
    private static intervalH = 1.1 * AVLTree.radius;
    private top: AVLNodeOrNull<T>;


    constructor() {
        this.top = null;
    }

    // Private methods
    private height(subtree: AVLNodeOrNull<T>): number {
        return (subtree == null) ? 0 : subtree.height;
    }

    private balanceFactor(subtree: AVLNodeOrNull<T>): number {
        return (subtree == null) ? 0 : this.height(subtree.right) - this.height(subtree.left);
    }

    private recalc(subtree: AVLNodeOrNull<T>): void {
        if (subtree == null) {
            return;
        }

        const hLeft = this.height(subtree.left);
        const hRight = this.height(subtree.right);

        subtree.height = ((hLeft > hRight) ? hLeft : hRight) + 1;
    }

    private leftRotation(subtree: AVLNodeOrNull<T>): AVLNodeOrNull<T> {
        if (subtree == null) {
            return null;
        }

        const subsubtree = subtree.right;
        if (subsubtree == null) {
            return subtree;
        }

        subtree.right = subsubtree.left;
        subsubtree.left = subtree;
        this.recalc(subtree);
        this.recalc(subsubtree);

        return subsubtree;
    }

    private rightRotation(subtree: AVLNodeOrNull<T>): AVLNodeOrNull<T> {
        if (subtree == null) {
            return null;
        }
        const subsubtree = subtree.left;
        if (subsubtree == null) {
            return subtree;
        }

        subtree.left = subsubtree.right;
        subsubtree.right = subtree;
        this.recalc(subtree);
        this.recalc(subsubtree);

        return subsubtree;
    }

    private balance(subtree: AVLNodeOrNull<T>): AVLNodeOrNull<T> {
        if (subtree == null) {
            return null;
        }
        this.recalc(subtree);

        if (this.balanceFactor(subtree) === 2) {
            if (this.balanceFactor(subtree.right) < 0) {
                subtree.right = this.rightRotation(subtree.right);
            }

            subtree = this.leftRotation(subtree);
        } else if (this.balanceFactor(subtree) === -2) {
            if (this.balanceFactor(subtree.left) > 0) {
                subtree.left = this.leftRotation(subtree.left);
            }

            subtree = this.rightRotation(subtree);
        }

        return subtree;
    }

    private findMin(subtree: AVLNodeOrNull<T>): AVLNodeOrNull<T> {
        if (subtree == null) {
            return null;
        }

        return (subtree.left == null) ? subtree : this.findMin(subtree.left);
    }

    private delMin(subtree: AVLNodeOrNull<T>): AVLNodeOrNull<T> {
        if (subtree == null) {
            return null;
        }

        if (subtree.left == null) {
            return subtree.right;
        }

        subtree.left = this.delMin(subtree.left);

        return this.balance(subtree);
    }

    private privSearch(subtree: AVLNodeOrNull<T>, key: number): AVLNodeOrNull<T> {
        if (this.top == null) { return null; }
        const canv = (<HTMLCanvasElement>document.getElementById("treeWindow"));
        const context = canv.getContext("2d");

        const marginTop = 40;
        let x = canv.width / 2;
        let y = marginTop + AVLTree.radius;
        let width = Math.pow(2, this.top.height) * (2 * AVLTree.radius + AVLTree.intervalW) - AVLTree.intervalW;
        while (subtree != null) {
            if (key < subtree.key) {
                subtree = subtree.left;
                x -= width / 4;
            } else if (key > subtree.key) {
                subtree = subtree.right;
                x += width / 4;
            } else {
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
    }

    private privInsert(subtree: AVLNodeOrNull<T>, data: T, key: number): AVLNodeOrNull<T> {

        if (subtree == null) {
            return new AVLNode(data, key);
        }

        if (key < subtree.key) {
            subtree.left = this.privInsert(subtree.left, data, key);
        } else {
            subtree.right = this.privInsert(subtree.right, data, key);
        }

        return this.balance(subtree);
    }

    private privRemove(subtree: AVLNodeOrNull<T>, key: number): AVLNodeOrNull<T> {
        if (subtree == null) {
            return null;
        }

        if (key < subtree.key) {
            subtree.left = this.privRemove(subtree.left, key);
        } else if (key > subtree.key) {
            subtree.right = this.privRemove(subtree.right, key);
        } else {
            const subsubtreeLeft = subtree.left;
            const subsubtreeRight = subtree.right;

            if (subsubtreeRight == null) {
                return subsubtreeLeft;
            }

            const rightmin = this.findMin(subsubtreeRight);
            if (rightmin == null) {
                return subsubtreeLeft;
            }

            rightmin.right = this.delMin(subsubtreeRight);
            rightmin.left = subsubtreeLeft;

            return this.balance(rightmin);
        }

        return this.balance(subtree);
    }

    private drawEdge(context: CanvasRenderingContext2D, x: number, y: number, width: number, color: string, left: boolean): void {
        const shift = AVLTree.radius / Math.sqrt(2);
        const nextX = (left) ? x - width / 4 : x + width / 4;
        const nextY = y + 2 * AVLTree.radius + AVLTree.intervalH;
        context.strokeStyle = color;
        context.moveTo((left) ? x - shift : x + shift, y + shift);
        context.lineTo((left) ? nextX + shift : nextX - shift, nextY - shift);
        context.stroke();
    }

    private bfsRedraw(subtree: AVLNodeOrNull<T>, context: CanvasRenderingContext2D, x: number, y: number, width: number): void {
        if (subtree == null) { return; }
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
    }

    // Public methods
    public search(key: number): T | null {
        const target = this.privSearch(this.top, key);

        return (target == null) ? null : target.data;
    }

    public insert(data: T, key: number): void {
        this.top = this.privInsert(this.top, data, key);
    }

    public remove(key: number): void {
        this.top = this.privRemove(this.top, key);
    }

    public clean(): void {
       this.top = null; // this.privClean(this.top);
    }

    public empty(): boolean {
        return this.top == null;
    }

    public getHeight(): number {
        return this.height(this.top);
    }

    public redrawTree(): void {
        const canv = (<HTMLCanvasElement>document.getElementById("treeWindow"));
        resizeCanv(canv);

        if (this.top == null) { return; }
        const context = canv.getContext("2d");
        if (context == null) {
            return;
        }
        context.clearRect(0, 0, canv.width, canv.height);

        context.lineWidth = 3;
        context.strokeStyle = "white";
        context.textAlign = "center";
        context.fillStyle = "white";

        const marginTop = 40;
        const width = Math.pow(2, this.top.height) * (2 * AVLTree.radius + AVLTree.intervalW) - AVLTree.intervalW;
        this.bfsRedraw(this.top, context, canv.width / 2, AVLTree.radius + marginTop, width);
    }
}

function resizeCanv(canvas: HTMLCanvasElement): void {
    const displayWidth  = canvas.clientWidth;
    const displayHeight = canvas.clientHeight;

    if (canvas.width  !== displayWidth || canvas.height !== displayHeight) {
        canvas.width  = displayWidth;
        canvas.height = displayHeight;
    }
}

const tree: AVLTree<string> = new AVLTree<string>();
const container: HTMLElement = document.createElement("div");


function addPressed(): void {
    tree.redrawTree();
    container.innerHTML = "";
    const data = (<HTMLInputElement>document.getElementById("addData")).value;
    const key = (<HTMLInputElement>document.getElementById("addKey")).value;
    if (key !== "") {
        tree.insert(data, Number(key));
        (<HTMLInputElement>document.getElementById("addData")).value = "";
        (<HTMLInputElement>document.getElementById("addKey")).value = "";
    }

    tree.redrawTree();
}

function findPressed(): void {
    tree.redrawTree();
    container.innerHTML = "";
    const key = (<HTMLInputElement>document.getElementById("findKey")).value;
    if (key !== "") {
        tree.search(Number(key));
    }
}

function delPressed(): void {
    tree.redrawTree();
    container.innerHTML = "";
    const key = (<HTMLInputElement>document.getElementById("delKey")).value;
    if (key !== "") {
        tree.remove(Number(key));
        (<HTMLInputElement>document.getElementById("delKey")).value = "";
    }

    tree.redrawTree();
}


document.getElementById("add")?.setAttribute("onclick", "addPressed()");
document.getElementById("find")?.setAttribute("onclick", "findPressed()");
document.getElementById("del")?.setAttribute("onclick", "delPressed()");

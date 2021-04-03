// Solving the equation
function solveEq(a, b, c)
{
    let discr = b * b - 4 * a * c;
    let x1, x2;
    if (discr < 0)
    {
        x1 = "-";
        x2 = "-";
    }
    else if (a != 0)
    {
        x1 = (- b - Math.sqrt(discr)) / (2 * a);
        x2 = (- b + Math.sqrt(discr)) / (2 * a);
    }
    else
    {
        x2 = "-";

        if (b == 0)
        {
            x1 = "-";
        }
        else if (c == 0)
        {
            x1 = 0;
        }
        else
        {
            x1 = (-b) / c;
        }
    }

    return [x1, x2];
}

// Generating the equation string
function generateEq(a, b, c)
{
    let eq = "";
    if (a != 0)
    {
        if (a < 0)
        {
            eq += "-";
        }

        if (Math.abs(a) != 1)
        {
            eq += String(Math.abs(a));
        }

        eq += "X<sup>2</sup>";
    }

    if (b != 0)
    {
        if (b > 0 && a != 0)
        {
            eq += "+";
        }
        else if (b < 0)
        {
            eq += "-";
        }

        if (Math.abs(b) != 1)
        {
            eq += String(Math.abs(b));
        }

        eq += "X";
    }

    if (c != 0 || (a == 0 && b == 0))
    {
        if (c > 0 && (a != 0 || b != 0))
        {
            eq += "+";
        }
        else if (c < 0)
        {
            eq += "-";
        }
    
        eq += String(Math.abs(c));
    }

    return eq + " = 0";;
}

solvebut.onclick = function()
{
    // Getting the values
    let a = document.getElementById("A").value;
    let b = document.getElementById("B").value;
    let c = document.getElementById("C").value;
    // Solving the equation
    let [x1, x2] = solveEq(a, b, c);
    
    // Working with table
    let tbody = document.getElementById("table").getElementsByTagName("TBODY")[0];

    let row = document.createElement("TR");
    row.setAttribute("onclick", "deleteRow(this)");
    tbody.appendChild(row);

    let eqCell = document.createElement("TD");
    let x1Cell = document.createElement("TD");
    let x2Cell = document.createElement("TD");

    row.appendChild(eqCell);
    row.appendChild(x1Cell);
    row.appendChild(x2Cell);

    // Building the equation string
    let eq = generateEq(a, b, c);

    eqCell.innerHTML = eq;
    x1Cell.innerHTML = x1;
    x2Cell.innerHTML = x2;
}

function deleteRow(row)
{
    row.remove();
}
function showtext() {

    var fname = document.getElementById("fname").value;
    var lname = document.getElementById("lname").value;
    var age = document.getElementById("age").value;
    var add = document.getElementById("add").value;
    var origin = document.getElementById("origin").value;

    document.getElementById("show").innerHTML = fname + "<br>" + lname + "<br>" + age + "<br>" + age + "<br>" + add + "<br>" + origin + "<br>";
}
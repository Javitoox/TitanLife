function setFoods(){
	document.getElementById("search").removeAttribute("required");
	document.getElementById("search").setAttribute("style","background-color:red");
	document.getElementById("cantidad").removeAttribute("disabled");
	document.getElementById("cantidad").setAttribute("required","");
	document.getElementById("cantidad").removeAttribute("style");
	document.getElementById("comidas").setAttribute("required","");
	document.getElementById("botonComidas").value="Añadir comida";
	document.getElementById("botonComidas").removeAttribute("disabled");
}

function setSearch(){
	document.getElementById("search").setAttribute("required","");
	document.getElementById("search").removeAttribute("style");
	document.getElementById("cantidad").setAttribute("disabled","");
	document.getElementById("cantidad").removeAttribute("required");
	document.getElementById("cantidad").setAttribute("style","background-color:red");
	document.getElementById("comidas").removeAttribute("required");
	document.getElementById("botonComidas").value="Buscar comida";
	document.getElementById("botonComidas").removeAttribute("disabled");
	document.getElementById("foodCalories").innerHTML=null;
}

function getCalories(){
	var seleccion=document.getElementById("comidas").selectedIndex;
	var valorSeleccion=document.getElementById("comidas").options[seleccion].value;
	var calorias=valorSeleccion.split("/");
	var gr=document.getElementById("cantidad").value;
	var result=(gr*calorias[2])/100;
	document.getElementById("foodCalories").innerHTML=result+" kcal";
	document.getElementById("caloriasOcultas").value=result;
}
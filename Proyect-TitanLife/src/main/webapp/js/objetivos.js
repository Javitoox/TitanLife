function comprobarObjetivos(imc){
	var result=false;
	var errorImc=document.getElementById["errorImc"];
	if(imc==null || imc.equals("")){
		result=false;
	}
	if(!result){
		errorImc.innerHTML="Debe generar su IMC primero";
	}
	return result;
}
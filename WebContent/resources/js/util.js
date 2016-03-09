/**
 * 
 */
//<C[DATA[

var lNumeros='1234567890';
var lLetras=' ABCÇDEFGHIJKLMNÑOPQRSTUVWXYZabcdefghijklmnñopqrstuvwxyz';
var lSignos = '+-';

function aMayuscula(input){				
//	var idForm = id.substring(0, id.indexOf(':')  );
//	var idInput = id.substring(id.indexOf(':')+1);				
	$(input).val($(input).val().toUpperCase());
}

function trimCadena(x) {
    return x.replace(/^\s+|\s+$/gm,'');
}

function validaSoloNumeros(e) {
	var key = window.Event ? e.which : e.keyCode
	return ((key >= 48 && key <= 57) || (key==8))
}

function validaSoloNumerosFlexion(e) {
	var key = window.Event ? e.which : e.keyCode
	return (key == 50 || key == 51 || key==8)
}

function validaNumeroPunto(e, input)
{	
	// Punto = 46
	var key =  window.Event ? e.which : e.keyCode;
	cadena = input.value;
	if(cadena.indexOf('.')==-1)
	{return (key <= 13 || (key >= 48 && key <= 57) || key == 46);}
	else
	{return (key <= 13 || (key >= 48 && key <= 57));}
}

function validaDecimales(e, input,caso){
	if(caso == 0){
		return validaSoloNumeros(e);
	}else if (caso > 0){
		return validaCantidadDecimal(e, input, caso);
	}else{
		return validaSoloNumeros(e);
	}
}

function validaCantidadDecimal(e, input, cantDecimal){	
	var key =  window.Event ? e.which : e.keyCode;
	cadena = input.value;
	var tamCadena = cadena.length;
	var posPunto = cadena.indexOf('.');
	if(posPunto == -1){
		return (key <= 13 || (key >= 48 && key <= 57) || key == 46);
	}else{
		posPunto = posPunto +1;
		cantDecimal = cantDecimal -1;
		var tamDecimal = tamCadena - posPunto;
		if(tamDecimal <= cantDecimal){
			return (key <= 13 || (key >= 48 && key <= 57));
		}else{
			return (key <= 13);
		}
	}
}

function ingresoLetrasNumeros(e){
	var key;
	var valid = '' + lLetras + lNumeros ;
	
	if(e.which){
		key = String.fromCharCode(e.which);
		if (valid.indexOf("" + key) == "-1")
			e.preventDefault();
	}
	else if(e.keyCode){
		key = String.fromCharCode(e.keyCode);
		if (valid.indexOf("" + key) == "-1")
			e.keyCode = 0;
	}
}

function validarEntero(evt){
	var evento = evt || window.event;
	if(window.event)//IE
	{
		key = evento.keyCode;
		//alert("Tecla: "+key);
	}
	else if(evento.which)//Netscape/Firefox/Opera
	{
		key = evento.which;
		//alert("Tecla: "+key);
	}
	if(key == 8){
		return true;
	}
	for (var i=57; i>=48; i--){
		if (key==i){			
			return true;
		}
	}
	return false;
}

function validarSoloLetras(e){
	key = e.keyCode || e.which;
    tecla = String.fromCharCode(key).toLowerCase();
    letras = " áéíóúabcdefghijklmnñopqrstuvwxyz.,";
//    especiales = [8,37,39,46];
    especiales = [8];
//    alert("Especiales[8,37,39,46]: ->" + String.fromCharCode(8) + "<-" + "->" + String.fromCharCode(37) + "<-" + "->"
//  	   + String.fromCharCode(39) + "<-" + "->" + String.fromCharCode(46) + "<-" + "->");

    tecla_especial = false;
    for(var i in especiales){
    	if(key == especiales[i]){
    		tecla_especial = true;
            	break;
        }
    }

    if(letras.indexOf(tecla)==-1 && !tecla_especial){
    	return false;
    }
}


function validarFormatoFecha(campo) {
    var RegExPattern = /^\d{1,2}\/\d{1,2}\/\d{2,4}$/;
    
    if ((campo.match(RegExPattern)) && (campo!='')) {
          return true;
    } else {
          return false;
    }
}

function validarFormatoCorreoListaCadena(cadenaListaCorreos){
	
	var listaCorreos = cadenaListaCorreos.split(',');
	
	for(var i=0;i<listaCorreos.length;i++){
		if(!validarFormatoCorreo(listaCorreos[i])){
			return false;
		}
	}
	
	return true;
	
}

function validarFormatoCorreo(campo){   
      var regex = /[\w-\.]{2,}@([\w-]{2,}\.)*([\w-]{2,}\.)[\w-]{2,4}/;
      if (regex.test(campo)) {
          return true;
      }
      else {
          return false;
      }
}

function existeFecha(fecha){
    var fechaf = fecha.split("/");
    var day = fechaf[0];
    var month = fechaf[1];
    var year = fechaf[2];
    var date = new Date(year,month,'0');
    if((day-0)>(date.getDate()-0)){
          return false;
    }
    return true;
}


function compararFechas(strFecha1, strFecha2, formato){
	
	var f1 = kendo.parseDate(strFecha1,formato);
	var f2 = kendo.parseDate(strFecha2,formato);

	if ((f1 - f2) == 0) {
	    return 0;
	} else if (f1 > f2) {
	    return 1;
	} else {
	    return -1;
	}
	
}

function validarSesion(response){
	var flag = true;
	var urlRedirect = response.redirect || '';
	if(urlRedirect != ''){
		flag = false;
	}
	return flag;
}

function validarCodigoTipoMolde(e){
	
	var key = window.Event ? e.which : e.keyCode;
//	alert('keyCode: ' + key);
	if( (key >= 48 && key <= 57) || (key==34) || (key==120) || (key==8)){
		return true;
	}else{
		return false;
	}
	
}

function obtenerOpcionMenu(){
	var resultado = null;
	$.ajax({
		url : "obtenerOpcionMenu",
		type : "POST",
		contentType : "application/json; charset=utf-8",
		async : false,
		cache : false,
		processData : false,
		success : function(response) {
			if(!validarSesion(response)){
				cerrarSesion();
			}else{
				resultado = response;
			}
		}
	});
	return resultado;
}

function onSelect(e){
	var dataItem = this.dataItem(e.item.index());
    var ruta = dataItem.ruta;
	if(ruta != null){
		window.location.href = ruta;
	}
	
}




//]]>


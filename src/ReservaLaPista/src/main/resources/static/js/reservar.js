//--- BLOQUEAR FECHAS VENCINAS CALENDARIO DE FECHAS ---
// Obtener fecha actual
let fecha = new Date();
// Obtener cadena en formato yyyy-mm-dd, eliminando zona y hora
let fechaMin = fecha.toISOString().split('T')[0];

// Agregar 3 días
fecha.setDate(fecha.getDate() + 3);
// Obtener cadena en formato yyyy-mm-dd, eliminando zona y hora
let fechaMax = fecha.toISOString().split('T')[0];

// Asignar valor mínimo
document.querySelector('#fecha').min = fechaMin;
// Asignar valor máximo
document.querySelector('#fecha').max = fechaMax;


//----------------------------

$(document).on('change', 'input[type="radio"]', function(e) {
	if (this.id == "hora_inicio") {
		console.log((this.value))
	}
});


//------------------------------------
function getHora_inicio() {
	var x = 0;
	var y = document.getElementsByName("hora_inicio");

	for (var i = 0; i < y.length; i++) {
		if (y[i].checked) {
			x = y[i].value;
		}
	}
	console.log(x);
}

//---------------------


let dia = new Date();
let horaActual = dia.toLocaleString().split(',')[1].substring(1, 3);

let grupo = document.getElementsByName("hora_inicio");
let labelBoton = document.getElementsByName("labelBoton");


//CAMBIAR COLOR A LOS LABEL QUE YA HA PASADO LA HORA
for (var i = 0; i < labelBoton.length; i++) {
	const acortado = labelBoton[i].innerHTML.substring(0, 2)
	//console.log(acortado)
	if (acortado <= horaActual) {
		labelBoton[i].style.backgroundColor = "#FD6161";
		labelBoton[i].style.color = "white";
	}
}

//CAMBIAR DISABLED A LOS INPUT QUE YA HA PASADO LA HORA
grupo.forEach((element) => {
	const values = element.defaultValue.substring(0, 2)

	if (values <= horaActual) {
		//console.log(values)
		element.disabled = true;
	}
})





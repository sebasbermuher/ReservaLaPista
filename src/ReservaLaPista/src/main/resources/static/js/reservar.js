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

$(document).on('change','input[type="radio"]' ,function(e) {
    if(this.id=="hora_inicio") {
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
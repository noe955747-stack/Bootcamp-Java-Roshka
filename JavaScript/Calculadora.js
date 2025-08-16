let calculo = ""
function agregarValor(valor){
    calculo += valor;
    actualizarPantalla();
}
function actualizarPantalla(){
    document.getElementById("pantalla").innerText = calculo || 0;
}
function calcular(){
    const resultado = eval(calculo);
    calculo = resultado.toString();
    actualizarPantalla();
}
function limpiar(){
    calculo="";
    actualizarPantalla();
}
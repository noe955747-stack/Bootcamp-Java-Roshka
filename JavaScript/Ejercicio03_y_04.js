function insertarCadena(id, cadena){
    let objeto = document.getElementById(id)
    objeto.innerHTML = cadena;
}
function insertarRandom(id){
    let objeto = document.getElementById(id)
    objeto.innerHTML = Math.random() * (100 - 1) + 1;
}
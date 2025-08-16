function ponerDado(numero, id) {
    const img = document.getElementById(id);

    switch (numero) {
        case 1:
            img.src = "dado1.png";
            break;
        case 2:
            img.src = "dado2.png";
            break;
        case 3:
            img.src = "dado3.png";
            break;
        case 4:
            img.src = "dado4.png";
            break;
        case 5:
            img.src = "dado5.png";
            break;
        case 6:
            img.src = "dado6.png";
            break;
        default:
            console.warn("Número no reconocido.");
            break;
    }
}
function numeroRandom(){
    return Math.floor(Math.random() * 6) + 1;
}
function lanzarDados(){
    for(i=1;i <= 5; i++){
        let num = numeroRandom()
        ponerDado(num, i.toString())
    }
}

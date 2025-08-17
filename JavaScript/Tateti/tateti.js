const combinacionesGanadoras = [
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9],
    [1, 4, 7],
    [2, 5, 8],
    [3, 6, 9],
    [1, 5, 9],
    [3, 5, 7]
];
let casillasX = [];
let casillasO = [];
let turno = "X";

function verificarGanador(casillasJugador) {
    return combinacionesGanadoras.some(combinacion =>
        combinacion.every(casilla => casillasJugador.includes(casilla))
    );
}

function marcarCasilla(id){
    const casilla = document.getElementById(id);
    const texto= document.getElementById("texto");
    casilla.textContent = turno;
    casilla.disabled = true;

    if (turno === "X") {
        casillasX.push(Number(id));
    } else {
        casillasO.push(Number(id));
    }
    if (verificarGanador(turno === "X" ? casillasX : casillasO)) {
        const reinicio =document.getElementById("reiniciar")
        texto.textContent = `¡Jugador ${turno} ha ganado!`;
        cambiarEstadoCasillas(false);
        reinicio.disabled = false;
        return;
    }
    if (turno === "X") {
        turno = "O";
        texto.textContent= `Jugador: O`;
    } else {
        turno = "X";
        texto.textContent= `Jugador: X`;
    }
    const todasMarcadas = document.querySelectorAll(".casilla");
    const empate = Array.from(todasMarcadas).every(c => c.textContent !== "");

    if (empate) {
        const texto = document.getElementById("texto");
        texto.textContent = "¡Empate!";
        cambiarEstadoCasillas(false);
        const reinicio = document.getElementById("reiniciar");
        reinicio.disabled = false;
    }

}
function cambiarEstadoCasillas(habilitar) {
    const botones = document.querySelectorAll(".casilla");

    botones.forEach(boton => {
        boton.disabled = !habilitar;
    });
}
function reiniciar(){
    const botones = document.querySelectorAll(".casilla");
    botones.forEach(boton => {
        boton.textContent = "";
    });

    casillasX = [];
    casillasO = [];
    turno = "X";

    const texto = document.getElementById("texto");
    texto.textContent = "Jugador: X";

    cambiarEstadoCasillas(true);

    const reinicio = document.getElementById("reiniciar");
    reinicio.disabled = true;
}


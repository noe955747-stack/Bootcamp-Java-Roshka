import java.util.*;
public class Main {
    public static void main(String[] args) {
        Carta[] cartas1 = new Carta[5];
        cartas1[0] = new Carta("7C");
        cartas1[1] = new Carta("5D");
        cartas1[2] = new Carta("6C");
        cartas1[3] = new Carta("8H");
        cartas1[4] = new Carta("5H");
        Carta[] cartas2 = new Carta[5];
        cartas2[0] = new Carta("5S");
        cartas2[1] = new Carta("7D");
        cartas2[2] = new Carta("5C");
        cartas2[3] = new Carta("6H");
        cartas2[4] = new Carta("8C");
        Mazo mazo1 = new Mazo(cartas1);
        Mazo mazo2 = new Mazo(cartas2);

        if (repetidos(cartas1, cartas2)) {
            System.out.println("Hay cartas repetidas entre los mazos");
        } else {
            if (!mazo1.validarMazo() || !mazo2.validarMazo()) {
                System.out.println("Uno de los mazos es inválido");
            } else {
                String ganador = mazo1.compararCon(mazo2);
                if(ganador.equals("EMPATE")){
                    System.out.println("Hubo un EMPATE");
                }else{
                    System.out.println("El mazo ganador es el " + ganador);
                }
            }
        }
    }
    public static boolean repetidos(Carta[] cartas1, Carta[] cartas2) {
        for (Carta c1 : cartas1) {
            for (Carta c2 : cartas2) {
                if (c1.equals(c2)) {
                    return true;
                }
            }
        }
        return false;
    }

}
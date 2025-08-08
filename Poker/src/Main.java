import java.util.*;
public class Main {
    public static void main(String[] args) {
        Carta[] mazo = new Carta[5];
        mazo[0] = new Carta("TS");
        mazo[1] = new Carta("JS");
        mazo[2] = new Carta("QS");
        mazo[3] = new Carta("KS");
        mazo[4] = new Carta("AS");
        boolean valido = validarMazo(mazo);
        if (!valido) {
            System.out.println("Mazo invalido");
        }else{
            String jugada= identificarMazo(mazo);
            System.out.println("El mazo es: "+jugada);
            probabilidad(jugada);
        }
    }
    public static boolean validarMazo(Carta[]mazo){
        Set<String> cartas = new HashSet<>();
        List<String> listaPalos = List.of("S", "C", "H", "D");
        for (Carta carta : mazo) {
            int valor = valorNumerico(carta.valor);
            if ( valor <= 14 && valor >= 2 && listaPalos.contains(carta.palo)) {
                cartas.add(carta.valorPalo());
            }else{
                return false;
            }
        }
        return cartas.size() == mazo.length;
    }
    public static int valorNumerico(String valor) {
        return switch (valor) {
            case "A" -> 14;
            case "K" -> 13;
            case "Q" -> 12;
            case "J" -> 11;
            case "T" -> 10;
            default -> Integer.parseInt(valor);
        };
    }
    public static String identificarMazo(Carta[]mazo) {
        String jugada = "E";
        Set<Integer> valorRep = new TreeSet<Integer>();
        Set<String> palosRep = new HashSet<>();
        int[] rep = new int[13];
        for (Carta carta : mazo) {
            int valor = valorNumerico(carta.valor);
            valorRep.add(valor);
            palosRep.add(carta.palo);
            rep[valor-2]++;
        }
        if (palosRep.size() == 1) {
            if (verificarEscalera((TreeSet<Integer>) valorRep)) {
                return "ESCALERA DE COLOR";
            } else {
                return "COLOR";
            }
        }
        switch(valorRep.size()){
            case 2:
                if (verificarRepeticion(rep, 4)) {
                    jugada = "POKER";
                } else if (verificarRepeticion(rep, 3)) {
                    jugada = "FULL";
                } else {
                    jugada = "CARTA ALTA";
                }
                break;
            case 3:
                if (verificarRepeticion(rep, 3)) {
                    jugada = "TRIO";
                }else if (verificarRepeticion(rep, 2)){
                    int cont = 0;
                    for (int r : rep) {
                        if (r == 2){
                            cont++;
                        }
                    }
                    if(cont == 2){
                        jugada = "DOBLE PAR";
                    }else{
                        jugada = "CARTA ALTA";
                    }
                }else{
                    jugada = "CARTA ALTA";
                }
                break;
            case 4:
                jugada = "PAR";
                break;
            case 5:
                if(verificarEscalera((TreeSet) valorRep)){
                    jugada = "ESCALERA";
                }else{
                    jugada = "CARTA ALTA";
                }
                break;
        }
        return jugada;
    }

    public static boolean verificarEscalera(TreeSet valorRep){
        List<Integer> escaleraA1 = Arrays.asList(14, 2, 3, 4, 5);
        if(valorRep.containsAll(escaleraA1)){
            return true;
        }
        List<Integer> lista = new ArrayList<>(valorRep);
        for (int i = 1; i < lista.size(); i++) {
            if (lista.get(i) != lista.get(i - 1) + 1) {
                return false;
            }
        }
        return true;
    }
    public static boolean verificarRepeticion(int[] rep , int num){
        for (int r : rep) {
            if (r == num) return true;
        }
        return false;
    }
    public static void probabilidad(String  tipoJugada){
        double posibilidades = 2598960;
        double prob = 0;
        switch (tipoJugada){
            case "ESCALERA DE COLOR":
                //probabilidades en un tiro
                prob = 40.0/posibilidades;
                break;
            case "POKER":
                prob = 624.0/posibilidades;
                break;
            case "FULL":
                prob = 3744.0/posibilidades;
                break;
            case "COLOR":
                prob = 5108.0/posibilidades;
                break;
            case "ESCALERA":
                prob = 10200.0/posibilidades;
                break;
            case "TRIO":
                prob = 54912.0/posibilidades;
                break;
            case "PAR":
                prob = 1098240.0/posibilidades;
                break;
            case "PAR DOBLE":
                prob = 123552.0/posibilidades;
                break;
            case "CARTA ALTA":
                prob = 1302540.0/posibilidades;
                break;
        }
        String probabilidad = String.format("%.3f", (prob*100));
        System.out.println("Probabilidad de la jugada en un tiro " + probabilidad+"%");
    }
}
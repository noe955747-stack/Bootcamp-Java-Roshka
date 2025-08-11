import java.util.*;
public class Mazo {
    private Carta[] cartas;

    public Mazo(Carta[] cartas) {
        this.cartas = cartas;
    }

    public boolean validarMazo() {
        Set<String> valoresU = new HashSet<>();
        List<String> palosValidos = List.of("S", "C", "H", "D");
        for (Carta c : cartas) {
            int v = c.valorNumerico();
            if (v < 2 || v > 14 || !palosValidos.contains(c.palo)) return false;
            valoresU.add(c.valorPalo());
        }
        return valoresU.size() == cartas.length;
    }

    public String jugada() {
        if (!validarMazo()) return "INVALIDO";
        return identificarJugada();
    }

    public int valorJugada() {
        return switch (jugada()) {
            case "ESCALERA DE COLOR" -> 9;
            case "POKER" -> 8;
            case "FULL" -> 7;
            case "COLOR" -> 6;
            case "ESCALERA" -> 5;
            case "TRIO" -> 4;
            case "DOBLE PAR" -> 3;
            case "PAR" -> 2;
            case "CARTA ALTA" -> 1;
            default -> 0;
        };
    }


    public String compararCon(Mazo mazo2) {
        int v1 = this.valorJugada();
        int v2 = mazo2.valorJugada();
        if (v1 > v2) return "mazo 1";
        if (v2 > v1) return "mazo 2";
        return desempatarCon(mazo2);
    }

    public String desempatarCon(Mazo mazo2) {
        List<Integer> clave1 = this.getDesempateClave();
        List<Integer> clave2 = mazo2.getDesempateClave();

        for (int i = 0; i < Math.min(clave1.size(), clave2.size()); i++) {
            if (clave1.get(i) > clave2.get(i)) return "Mazo 1";
            if (clave1.get(i) < clave2.get(i)) return "Mazo 2";
        }

        return "EMPATE";
    }

    public List<Integer> getDesempateClave() {
        String tipo = this.jugada();
        boolean asBajo = esEscaleraBaja();
        int[] frecuencia = new int[15]; // índices 2 a 14

        for (Carta c : cartas) {
            frecuencia[c.valorNumerico(asBajo)]++;
        }

        List<Integer> clave = new ArrayList<>();

        if (tipo.equals("ESCALERA") || tipo.equals("ESCALERA DE COLOR")) {
            clave.add(cartaAlta());
            return clave;
        }

        for (int f = 5; f >= 1; f--) {
            for (int v = 14; v >= 2; v--) {
                if (frecuencia[v] == f) {
                    clave.add(v);
                }
            }
        }

        return clave;
    }

    private int cartaAlta() {
        int max = 0;
        boolean asBajo = esEscaleraBaja();
        for (Carta c : cartas) {
            max = Math.max(max, c.valorNumerico(asBajo));
        }
        return max;
    }


    private String identificarJugada() {
        Set<Integer> valoresUnicos = new TreeSet<>();
        Set<String> palosRep = new HashSet<>();
        int[] repeticiones = new int[13];

        for (Carta carta : cartas) {
            int valor = carta.valorNumerico();
            valoresUnicos.add(valor);
            palosRep.add(carta.palo);
            repeticiones[valor - 2]++;
        }

        boolean esColor = palosRep.size() == 1;
        boolean esEscalera = verificarEscalera(valoresUnicos);

        if (esColor && esEscalera) return "ESCALERA DE COLOR";
        if (esColor) return "COLOR";
        if (esEscalera) return "ESCALERA";

        switch (valoresUnicos.size()) {
            case 2:
                if (verificarRepeticion(repeticiones, 4)) return "POKER";
                if (verificarRepeticion(repeticiones, 3)) return "FULL";
                break;
            case 3:
                if (verificarRepeticion(repeticiones, 3)) return "TRIO";
                if (verificarPares(repeticiones) == 2) return "DOBLE PAR";
                break;
            case 4:
                return "PAR";
            case 5:
                return "CARTA ALTA";
        }

        return "CARTA ALTA";
    }
    private boolean verificarEscalera(Set<Integer> valores) {
        List<Integer> lista = new ArrayList<>(valores);
        Collections.sort(lista);
        if (lista.contains(14) && lista.contains(2) &&
                lista.contains(3) && lista.contains(4) &&
                lista.contains(5)) return true;

        for (int i = 1; i < lista.size(); i++) {
            if (lista.get(i) != lista.get(i - 1) + 1) return false;
        }
        return true;
    }

    private boolean verificarRepeticion(int[] rep, int cantidad) {
        for (int r : rep) {
            if (r == cantidad) return true;
        }
        return false;
    }

    private int verificarPares(int[] rep) {
        int pares = 0;
        for (int r : rep) {
            if (r == 2) pares++;
        }
        return pares;
    }
    private boolean esEscaleraBaja() {
        Set<Integer> valores = new HashSet<>();
        for (Carta c : cartas) {
            valores.add(c.valorNumerico());
        }
        return valores.contains(14) && valores.contains(2) &&
                valores.contains(3) && valores.contains(4) &&
                valores.contains(5);
    }
}

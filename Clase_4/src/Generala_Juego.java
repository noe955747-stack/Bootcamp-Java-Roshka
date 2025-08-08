import java.util.*;
import java.util.stream.Collectors;

public class Generala_Juego {
    public static void main(String[] args) {
        Generala_Juego resultado = new Generala_Juego();
        System.out.println(resultado.jugada("32154"));
        probabilidad(resultado.jugada("32154"));
    }
    String jugada(String dados)
    {
        boolean inv = validarJugada(dados);
        if (!inv) {
            return "INVALIDO";
        }
        return identificarJugada(dados);
    }

    public static boolean validarJugada(String dados){
        Scanner sc = new Scanner(System.in);
        if(dados.length()!=5){
            return false;
        }
        boolean b = true;
        for (char c : dados.toCharArray()) {
            if (!Character.isDigit(c) || (c - '0') < 1 || (c - '0') > 6) {
                return false;
            }
        }
        sc.close();
        return true;
    }
    public static String identificarJugada(String jugada) {
        String tipoJugada = "";
        Set<Character> digitosRep = new HashSet<>();
        int[] rep = new int[6];

        List<Character> escalera1 = Arrays.asList('1', '2', '3', '4', '5');
        List<Character> escalera2 = Arrays.asList('2', '3', '4', '5', '6');
        List<Character> escalera3 = Arrays.asList('3', '4', '5', '6', '1');

        for (char c : jugada.toCharArray()) {
            digitosRep.add(c);
            rep[(c - '0') - 1]++;
        }

        int d = digitosRep.size();

        switch (d) {
            case 1:
                tipoJugada = "GENERALA";
                break;
            case 2:
                boolean tieneCuatro = false;
                boolean tieneTres = false;
                for (int r : rep) {
                    if (r == 4) tieneCuatro = true;
                    if (r == 3) tieneTres = true;
                }
                if (tieneCuatro) {
                    tipoJugada = "POKER";
                } else if (tieneTres) {
                    tipoJugada = "FULL";
                } else {
                    tipoJugada = "NADA";
                }
                break;
            case 5:
                List<Character> jugadaList = jugada.chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.toList());

                Set<Character> jugadaSet = new HashSet<>(jugadaList);
                if (jugadaSet.containsAll(escalera1) || jugadaSet.containsAll(escalera2) || jugadaSet.containsAll(escalera3)) {
                    tipoJugada = "ESCALERA";
                } else {
                    tipoJugada = "NADA";
                }
                break;
            default:
                tipoJugada = "NADA";
                break;
        }

        return tipoJugada;
    }

    public static void probabilidad(String  tipoJugada){
        double posibilidades = 7776;
        double prob = 0;
        switch (tipoJugada){
            case "GENERALA":
                //probabilidades en un tiro
                prob = 6.0/posibilidades;
                //probabilidades en dos tiros
                double pNoGenerala = 7770.0 / 7776.0;
                double pFallarDosTiros = pNoGenerala * pNoGenerala;
                double prob2 = 1 - pFallarDosTiros;
                System.out.println("Probabilidad de la jugada en 2 tiros: " + (prob2 * 100) + "%");
                break;
            case "POKER":
                prob = 150/posibilidades;
                break;
            case "FULL":
                prob = 300/posibilidades;
                break;
            case "ESCALERA":
                prob = 3/posibilidades;
                break;
            case "NADA":
                prob = (7776-6-150-300-3)/posibilidades;
                break;
        }
        String probabilidad = String.format("%.3f", (prob*100));
        System.out.println("Probabilidad de la jugada en un tiro " + probabilidad+"%");
    }
}
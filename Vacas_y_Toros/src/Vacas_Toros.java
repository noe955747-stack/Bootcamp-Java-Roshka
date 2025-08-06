import java.util.*;
public class Vacas_Toros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numeroMaquina = generarNumero();
        boolean bandera = true;
        System.out.println("Juego de Vacas y Toros");
        System.out.println("Adivina el numero de 4 digitos (No hay digitos repetidos)");
        System.out.println("Para rendirte simplemente ingresa n");
        System.out.println("Ingresa tu numero: ");
        while(bandera){
            String numeroUser = scanner.nextLine();
            if (numeroUser.equals("n")) {
                System.out.println("Te rendiste! El número era: " + numeroMaquina);
                bandera = false;
                continue;
            }
            if (!verificarNumero(numeroUser)) {
                System.out.println("Numero Invalido. Debes ingresar 4 dígitos únicos.");
                continue;
            }

            int toros = contarToros(numeroMaquina, numeroUser);
            int vacas = contarVacas(numeroMaquina, numeroUser) - toros;
            System.out.printf("Toros: %d, Vacas: %d%n", toros, vacas);

            if (toros == 4) {
                System.out.println("¡Felicidades! Adivinaste el número.");
                bandera = false;
            } else{
                System.out.println("Por favor intente de nuevo: ");
            }
        }

    }
    private static String generarNumero() {
        List<Integer> digitos = new ArrayList<>();
        Random aleatorio = new Random();
        while (digitos.size() < 4) {
            int digito = aleatorio.nextInt(10);
            if (!digitos.contains(digito)) {
                if (digitos.isEmpty() && digito == 0) continue;
                digitos.add(digito);
            }
        }
        StringBuilder stringb = new StringBuilder();
        for (int d : digitos) stringb.append(d);
        return stringb.toString();
    }

    private static boolean verificarNumero(String numeroUser) {
        if (numeroUser.length() != 4) return false;
        Set<Character> digitosRep = new HashSet<>();
        for (char c : numeroUser.toCharArray()) {
            if (!Character.isDigit(c) || digitosRep.contains(c)) return false;
            digitosRep.add(c);
        }
        return numeroUser.charAt(0) != '0';
    }
    private static int contarToros(String numMaquina, String numUser) {
        int toros = 0;
        for (int i = 0; i < 4; i++) {
            if (numMaquina.charAt(i) == numUser.charAt(i)) toros++;
        }
        return toros;
    }

    private static int contarVacas(String numMaquina, String numUser) {
        int vacas = 0;
        for (char c : numUser.toCharArray()) {
            if (numMaquina.contains(Character.toString(c))) vacas++;
        }
        return vacas;
    }
}
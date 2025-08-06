import java.util.*;
public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean b = false;
        String num;
        do{
            b = true;
            System.out.println("Ingrese un numero: ");
            num =  sc.nextLine();
            for (char c : num.toCharArray()){
                if (!Character.isDigit(c)){
                    System.out.println("No es un numero. Intentelo de nuevo");
                    b = false;
                    break;
                }
            }
        }while(!b);
        int[] vector = new int[num.length()];
        for (int i = 0; i < num.length(); i++) {
            vector[i] = Integer.parseInt(String.valueOf(num.charAt(i)));
        }
        System.out.println("El numero contiene "+ vector.length+" digitos");
        System.out.print("Vector: \n");
        for (int j : vector) {
            System.out.println(j);
        }
    }
}

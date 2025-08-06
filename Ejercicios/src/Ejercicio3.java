import java.util.*;
public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa tu palabra o frase: ");
        String p = sc.nextLine();
        char[] letras = p.toCharArray();
        StringBuilder B = new StringBuilder();
        for (int i = 0; i < letras.length; i++) {
            if(letras[i] != ' '){
                B.append(letras[i]);
            }
        }
        StringBuilder pInv = new StringBuilder();
        for (int i = letras.length - 1; i >= 0; i--) {
            if(letras[i] != ' '){
                pInv.append(letras[i]);
            }
        }
        if (pInv.toString().contentEquals(B)) {
            System.out.println("Si es un palindrome");
        }else{
            System.out.println("No es un palindrome");
        }
        System.out.println(pInv.toString());
    }
}

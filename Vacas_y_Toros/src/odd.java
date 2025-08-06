import java.util.*;
public class odd {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean resultado = false;
        System.out.println("Ingrese primer numero:");
        String num1 = sc.next();
        System.out.println("Ingrese primer numero:");
        int num2 = sc.nextInt();
        System.out.println("Ingrese primer numero:");
        int num3 = sc.nextInt();
        if (num2 > num1 & num3 > num2) {
            resultado = true;
        }
        System.out.println("El resultado es:"+ resultado);
    }
}

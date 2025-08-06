import java.util.Arrays;
import java.util.Random;

public class Ejercicio2 {
    public static void main(String[] args) {
        Random aleatorio = new Random();
        int[] vector = new int[100];
        int[] repeticiones = new int[60];
        int[] faltantes = new int[60];
        for(int i = 0; i < vector.length; i++){
            vector[i] = aleatorio.nextInt(30+30)-30;
        }
        for (int j : vector) {
            System.out.println(j);
        }
        for(int i = 0; i < vector.length; i++){
            repeticiones[vector[i]+30]++;
        }
        int m = 0;
        int k = 0;
        for(int i = 1; i < repeticiones.length; i++){
            if(repeticiones[i] > m){
                m = i;
            }
            if (repeticiones[i] == 0){
                faltantes[k] = i-30;
                k++;
            }
        }

        System.out.println("El numero mas repetido es "+(m - 30));
        System.out.println("Se repitio "+repeticiones[m]+ " veces");
        System.out.println("Los numeros faltantes son: ");
        for (int i = 0; i < faltantes.length; i++) {
            if(faltantes[i] != 0){
                System.out.print(+faltantes[i]+",");
            }
        }
    }
}

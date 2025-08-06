import java.util.Random;

public class Ejercicio1 {
    public static void main(String[] args) {
        Random aleatorio = new Random();
        int[] vector = new int[10];
        for(int i = 0; i < vector.length; i++){
            vector[i] = aleatorio.nextInt(5+5)-5;
        }
        for(int i = 0; i < vector.length; i++){
            System.out.println(vector[i]);
        }
        int mayor = vector[0];
        for(int i  = 1; i < vector.length; i++){
            if(vector[i] > mayor){
                mayor = vector[i];
            }
        }
        System.out.println("El numero mayor del vector es: "+mayor);
    }
}

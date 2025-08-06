import java.util.*;

public class RelojDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Ingresa los segundos a partir de media noche: ");
        int seg = input.nextInt();
        Reloj relojDemo = new Reloj(seg);
        System.out.println("El reloj es: "+relojDemo);
        System.out.println("Metodo tick: ");
        for(int i = 0; i < 10; i++){
            relojDemo.tick();
            System.out.println(relojDemo);
        }
        System.out.println("Ingrese horas, minutos y segundos: ");
        int horas = input.nextInt();
        int minutos = input.nextInt();
        int segundos = input.nextInt();
        Reloj reloj2 = new Reloj(horas, minutos, segundos);
        System.out.println(reloj2);
        relojDemo.restaReloj(reloj2);
        System.out.println("La diferencia es: "+relojDemo);
    }
}

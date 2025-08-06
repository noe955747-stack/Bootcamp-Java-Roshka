import java.util.*;
public class Ejercicios {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 5;
        System.out.println("Ejercicio 1:");
        Ejercicio01(num1, num2);
        System.out.println("\nEjercicio 2:");
        Ejercicio02(num1, num2);
        System.out.println("\nEjercicio 3:");
        Ejercicio03();
        System.out.println("\nEjercicio 5:");
        Ejercicio04();
        System.out.println("\nEjercicio 5:");
        Ejercicio05();
        System.out.println("\nEjercicio 6:");
        Ejercicio06();
        System.out.println("\nEjercicio 7:");
        Ejercicio07();
        System.out.println("\nEjercicio 8:");
        Ejercicio08();
        System.out.println("\nEjercicio 9:");
        Ejercicio09();
        System.out.println("\nEjercicio 10:");
        Ejercicio10();
    }
    public static void Ejercicio01( int num1, int num2) {
        System.out.println("Suma: " + (num1 + num2));
        System.out.println("Resta: " + (num1 - num2));
        System.out.println("Multiplicacion: " + (num1 * num2));
        System.out.println("Division: " + (num1 / num2));
        System.out.println("Modulo: " + (num1 % num2));
    }
    public static void Ejercicio02(int num1, int num2) {
        if (num1 > num2) {
            System.out.println(num1  + " es mayor");
        }else if (num1 < num2) {
            System.out.println(num2 + " es mayor");
        }else{
            System.out.println("Los numeros son iguales");
        }
    }
    public static void Ejercicio03() {
        String nombre = "Cinthia";
        System.out.println("Bienvenido/a " + nombre);
    }
    public static void Ejercicio04() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese su nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Bienvenido/a " + nombre);
    }
    public static void Ejercicio05() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un numero: ");
        int num = sc.nextInt();
        if(num % 2 == 0){
            System.out.println(num + " es divisible entre 2");
        }else{
            System.out.println(num + " no es divisible entre 2");
        }
    }
    public static void Ejercicio06() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el precio: ");
        double precio = sc.nextInt();
        double precioIVA = precio + (precio *0.1);
        System.out.println("Precio con IVA: "+ precioIVA);
    }
    public static void Ejercicio07() {
        for(int i = 0; i <= 100; i++){
            if(i % 2 == 0 || i % 3 == 0 ){
                System.out.println(i);
            }
        }
    }
    public static void Ejercicio08() {
        Scanner sc = new Scanner(System.in);
        boolean bandera = false;
        do{
            System.out.println("Ingrese un numero: ");
            int num = sc.nextInt();
            if(num >= 0){
                bandera = true;
                System.out.println("El numero: "+ num +" es mayor o igual a 0");
            }else{
                System.out.println("El numero es negativo. Intentelo de nuevo");
            }
        }while(!bandera);
    }
    public static void Ejercicio09() {
        Scanner sc = new Scanner(System.in);
        String password = "holamundo123";
        int intentos = 3;
        do{
            System.out.println("Adivina la contrasena: ");
            String pass = sc.nextLine();
            if(pass.equals(password)){
                System.out.println("Acertaste!");
                break;
            }else{
                intentos--;
                System.out.println("Contrasena incorrecta. Intentos restantes: "+intentos);
            }
        }while(intentos > 0);
        if(intentos == 0){
            System.out.println("Jaja Fallaste!");
        }
    }
    public static void Ejercicio10() {
        Scanner sc = new Scanner(System.in);
        String[] dias ={"Lunes", "Martes","Miercoles", "Jueves", "Viernes", "Sabado", "Domingo" };
        boolean bandera = false;
        do{
            System.out.println("Ingrese un dia de la semana: ");
            String dia = sc.nextLine();
            if(Arrays.asList(dias).contains(dia)){
                bandera = true;
                if(dia.equals("Sabado") ||dia.equals("Domingo") ){
                    System.out.println(dia + " no es un dia laboral");
                } else{
                    System.out.println(dia + " es un dia laboral");
                }
            }else{
                System.out.println("Valor ingresado no valido. Intente de nuevo");
            }
        }while(!bandera);
    }
}

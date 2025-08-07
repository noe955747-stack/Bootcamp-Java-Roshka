import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean bandera = false;
        System.out.println("Jugador 1 ingrese su nombre: ");
        Jugador jugador1 = new Jugador(sc.next());
        System.out.println("Jugador 2 ingrese su nombre: ");
        Jugador jugador2 = new Jugador(sc.next());
        Pila A = new Pila();
        Pila B = new Pila();
        Pila C = new Pila();
        int turno = 1;
        Jugador jugadorActual = new Jugador(jugador1.getNombre());
        System.out.println("A:"+A.getContadores()+"  B:"+B.getContadores()+"  C:"+C.getContadores());
        do{
            System.out.print(jugadorActual.getNombre()+", elija una pila:");
            String pila = leerPila(A, B, C);
            reducirContadores(pila, A, B, C);
            System.out.println("\nA:"+A.getContadores()+"  B:"+B.getContadores()+"  C:"+C.getContadores());
            if (!A.getEstado() && !B.getEstado() && !C.getEstado()) {
                System.out.println(jugadorActual.getNombre()+", ya no quedan contadores, asi que... Ganaste!");
                bandera = true;
            }else{
                turno++;
                if(turno % 2 == 0){
                    jugadorActual.setNombre(jugador2.getNombre());
                }else{
                    jugadorActual.setNombre(jugador1.getNombre());
                }
            }
        }while(!bandera);
        sc.close();
    }
    private static String leerPila(Pila A, Pila B, Pila C){
        Scanner sc = new Scanner(System.in);
        boolean bandera = false;
        String pilaSec = "";
        do{
            String pila = sc.nextLine();
            switch (pila) {
                case "A":
                    if(!A.getEstado()){
                        System.out.println("Esta pila ya esta vacia!. Ingresa otra: ");
                        break;
                    }
                    pilaSec = pila;
                    bandera = true;
                    break;
                case "B":
                    if(!B.getEstado()){
                        System.out.println("Esta pila ya esta vacia!. Ingresa otra: ");
                        break;
                    }
                    pilaSec = pila;
                    bandera = true;
                    break;
                case "C":
                    if(!C.getEstado()){
                        System.out.println("Esta pila ya esta vacia!. Ingresa otra: ");
                        break;
                    }
                    pilaSec = pila;
                    bandera = true;
                    break;
                default:
                    System.out.println("Pila no valida. Ingresa de nuevo: ");
            }
        }while(!bandera);
        sc.close();
        return pilaSec;
    }
    private static void reducirContadores(String pila, Pila A, Pila B, Pila C){
        Scanner sc = new Scanner(System.in);
        boolean bandera = false;
        do{
            System.out.print("Cuanto quitara de la Pila "+pila+": ");
            int cant= sc.nextInt();
            if(cant>0){
                switch (pila) {
                    case "A":
                        A.reducirPila(cant);
                        bandera = true;
                        break;
                    case "B":
                        B.reducirPila(cant);
                        bandera = true;
                        break;
                    case "C":
                        C.reducirPila(cant);
                        bandera = true;
                        break;
                }
            }else{
                System.out.println("Cantidad no valida.");
            }
        }while(!bandera);
        sc.close();
    }
}
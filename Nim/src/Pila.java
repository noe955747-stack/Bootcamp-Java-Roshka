import java.util.Random;

public class Pila {
    private int contadores;

    private boolean estado;

    public Pila() {
        this.contadores = obtenerContadores();
        this.estado = true;
    }
    public int getContadores() {
        return contadores;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public boolean getEstado() {
        return estado;
    }
    public void reducirPila(int cantidad) {
        contadores -= cantidad;
        if (contadores <= 0) {
            this.estado = false;
        }
    }
    public int obtenerContadores() {
        Random rand = new Random();
        int num= rand.nextInt(6)+1;
        return num;
    }
}

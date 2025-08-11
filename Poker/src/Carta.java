import java.util.Objects;

public class Carta {
    String valor;
    String palo;

    public Carta(String codigo) {
        this.valor = codigo.substring(0, 1);
        this.palo = codigo.substring(1);
    }

    public String valorPalo() {
        return valor + palo;
    }

    public int valorNumerico() {
        return switch (valor) {
            case "A" -> 14;
            case "K" -> 13;
            case "Q" -> 12;
            case "J" -> 11;
            case "T" -> 10;
            default -> Integer.parseInt(valor);
        };
    }
    public int valorNumerico(boolean asBajo) {
        return switch (valor) {
            case "A" -> asBajo ? 1 : 14;
            case "K" -> 13;
            case "Q" -> 12;
            case "J" -> 11;
            case "T" -> 10;
            default -> Integer.parseInt(valor);
        };
    }

    @Override
    public String toString() {
        return valor + palo;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Carta carta = (Carta) obj;
        return valor.equals(carta.valor) && palo.equals(carta.palo);
    }

}

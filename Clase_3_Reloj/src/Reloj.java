public class Reloj {
    private int horas;

    private int minutos;

    private int segundos;

    public Reloj(){
        horas = 12;
        minutos = 0;
        segundos = 0;
    }

    public Reloj(int horas, int minutos, int segundos){
        setHoras(horas);
        setMinutos(minutos);
        setSegundos(segundos);
    }

    public Reloj(int segM){
        setReloj(segM);
    }
    public void setReloj(int segM){
        this.segundos = segM % 60;
        int temp = segM / 60;
        if(temp >= 60){
            this.horas = temp /60;
            this.minutos = temp % 60;
        }else{
            this.horas = 0;
            this.minutos = temp;
        }
    }

    public void setHoras(int horas) {
        if (horas >= 0 && horas <= 23) {
            this.horas = horas;
        } else {
            throw new IllegalArgumentException("Horas fuera de rango.");
        }
    }
    public void setMinutos(int minutos) {
        if (minutos >= 0 && minutos <= 59) {
            this.minutos = minutos;
        } else {
            throw new IllegalArgumentException("Minutos fuera de rango.");
        }
    }
    public void setSegundos(int segundos) {
        if (segundos >= 0 && segundos <= 59) {
            this.segundos = segundos;
        } else {
            throw new IllegalArgumentException("Segundos fuera de rango.");
        }
    }

    public int getHoras() {
        return horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void tick(){
        segundos++;
        if(segundos == 60) {
            segundos = 0;
            minutos++;
            if(minutos == 60) {
                minutos = 0;
                horas++;
                if(horas == 24){
                    horas = 0;
                }
            }
        }
    }
    public void addReloj(Reloj reloj2){
        int totalSeg = this.convertirASegundos() + reloj2.convertirASegundos();
        if(totalSeg >= 86400){
            setReloj(totalSeg-86400);
        }else{
            setReloj(totalSeg);
        }
    }
    @Override
    public String toString(){
        return String.format("[%02d:%02d:%02d]", horas, minutos, segundos);
    }
    public void restaReloj(Reloj reloj2){
        int diferencia = Math.abs(this.convertirASegundos() - reloj2.convertirASegundos());
        setReloj(diferencia);
    }
    private int convertirASegundos(){
        return ((horas * 3600) + (minutos * 60) + segundos);
    }

}

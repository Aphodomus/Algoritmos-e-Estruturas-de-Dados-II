public class Hora {
    //Atributos
    private int hora;
    private int minuto;
    private int segundo;

    //Metodos especiais
    public Hora() {
        this.hora = 0;
        this.minuto = 0;
        this.segundo = 0;
    }

    public Hora(int hora, int minuto, int segundo) {
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getHora() {
        return this.hora;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public int getMinuto() {
        return this.minuto;
    }

    public void setSegundo(int segundo) {
        this.segundo = segundo;
    }

    public int getSegundo() {
        return this.segundo;
    }

    //Metodos
    public Hora clone() {
        Hora resp = new Hora();

        resp.hora = this.hora;
        resp.minuto = this.minuto;
        resp.segundo = this.segundo;

        return resp;
    }
}

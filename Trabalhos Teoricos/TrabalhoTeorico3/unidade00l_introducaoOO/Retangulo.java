public class Retangulo {
    //Atributos
    private double base;
    private double altura;

    //Metodos especiais
    public Retangulo() {
        this.altura = 0;
        this.base = 0;
    }

    public Retangulo(double base,double altura) {
        this.base = base;
        this.altura = altura;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getBase() {
        return this.base;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getAltura() {
        return this.altura;
    }

    //Metodos
    public double getArea() {
        return (getBase() * getAltura());
    }

    public double getPerimetro() {
        return ((getBase() * 2) + (getAltura() * 2));
    }

    public double getDiagonal() {
        return (Math.sqrt(Math.pow(getBase(), 2) + Math.pow(getAltura(), 2)));
    }
}

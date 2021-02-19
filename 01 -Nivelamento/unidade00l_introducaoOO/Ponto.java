public class Ponto {
    //Atributos
    private double x;
    private double y;
    private int id;
    private int nextID;

    //Metodos especiais
    public Ponto() {
        this.x = 0.0;
        this.y = 0.0;
        this.id = 0;
        this.nextID = 0;
    }

    public Ponto(double x, double y) {
        this.x = x;
        this.y = y;
        this.id = 0;
        this.nextID = 0;
    }

    public Ponto(double x, double y, int id, int nextID) {
        this.id = id;
        this.nextID = nextID;
        this.x = x;
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getX() {
        return this.x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getY() {
        return this.y;
    }

    public void setID(int id) {
        this.id = id;
    }

    public int getID() {
        return this.id;
    }

    public void setNextID(int nextID) {
        this.nextID = nextID;
    }

    //Metodos
    public double dist(Ponto p2) {
        return (Math.sqrt(Math.pow((getX() - (p2.getX())), 2) + Math.pow((getY() - (p2.getY())), 2)));
    }

    public double dist(double x, double y) {
        return (Math.sqrt(Math.pow((getX() - (x)), 2) + Math.pow((getY() - (y)), 2)));
    }

    public static double dist(double x1, double y1, double x2, double y2) {
        return (Math.sqrt(Math.pow(((x1) - (x2)), 2) + Math.pow(((y1) - (y2)), 2)));
    }
}

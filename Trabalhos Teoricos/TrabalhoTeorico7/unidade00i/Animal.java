public class Animal {
    //Atributos
    public String nome;
    public int idade;
    public int caracter;

    //Metodos especiais
    public Animal() {
        this.nome = "";
        this.idade = 0;
        this.caracter = '-';
    }

    public Animal(String nome, int idade, char caracter) {
        this.nome = nome;
        this.idade = idade;
        this.caracter = caracter;
    }

    public Animal(String nome, char caracter) {
        this.nome = nome;
        this.caracter = caracter;
        this.idade = 0;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setCaracter(int caracter) {
        this.caracter = caracter;
    }

    public int getCaracter() {
        return this.caracter;
    }
    
    //Metodos
}

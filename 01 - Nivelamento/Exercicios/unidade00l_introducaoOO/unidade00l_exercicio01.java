//Seja a classe Lixão abaixo e a Funcionário do exemplo anterior, faça o quadro de memória para o código abaixo

public class unidade00l_exercicio01 {
    public static void main(String[] args) {
        Funcionario f1;
        f1 = new Funcionario();
        f1 = new Funcionario(5);

        MyIO.println("ADDRs:");
        MyIO.println("f1: " + f1);
        MyIO.println("Atributos:");
        MyIO.println("f1 funcionarios: " + f1.getFuncionarios());
    }
}

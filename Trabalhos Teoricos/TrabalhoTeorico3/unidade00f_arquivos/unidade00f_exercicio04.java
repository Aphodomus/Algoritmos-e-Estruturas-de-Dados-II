// Leia o nome de um arquivo e mostre seu conteúdo convertido para letras maiúsculas

public class unidade00f_exercicio04 {
    public static void main(String[] args) {
        //Ler arquivo
        Arq.openRead("Balacobaco.txt");

        //Ler conteudo do arquivo
        String nome = Arq.readLine();

        //Fechar arquivo
        Arq.close();

        //Colocar em maiusculas
        String nomeMaiusculo = nome.toUpperCase();

        //Printar o conteudo da string nome
        MyIO.println("Nome com letras maiusculas: " + nomeMaiusculo);
    }
}

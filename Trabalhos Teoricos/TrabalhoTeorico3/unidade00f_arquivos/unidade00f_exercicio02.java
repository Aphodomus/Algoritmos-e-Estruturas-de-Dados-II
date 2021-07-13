// Leia o nome de um arquivo e mostre seu conteúdo na tela

public class unidade00f_exercicio02 {
    public static void main(String[] args) {
        //Ler arquivo
        Arq.openRead("Balacobaco.txt");

        //Ler dados do arquivo
        String nome = Arq.readLine();

        //Fechar arquivo
        Arq.close();

        //Printar

        MyIO.println("Nome escrito no arquivo: " + nome);
    }
}

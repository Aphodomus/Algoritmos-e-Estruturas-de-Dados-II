public class Matriz {
    public static void main(String[] args) {
        //Declarando as variaveis
        int tamanho = 0;
        int matriz[][] = new int[10][10];
        int soma[] = new int[10];

        //Lendo o tamanho
        tamanho = MyIO.readInt();

        //Ler os elementos e adicionar na matriz
        for (int i = 0; i < tamanho; i = i + 1) {
            for (int j = 0; j < tamanho; j = j + 1) {
                matriz[i][j]= MyIO.readInt();
            }
        }

        //Somar cada coluna
        for (int k = 0; k < tamanho; k = k + 1) {
            soma[k] = 0;
            for (int l = 0; l < tamanho; l = l + 1) {
                soma[k] = soma[k] + matriz[l][k];
            }
        }
        
        //Saida
        for (int m = 0; m < tamanho; m = m + 1) {
            MyIO.print(soma[m] + " ");
        }
    }
}

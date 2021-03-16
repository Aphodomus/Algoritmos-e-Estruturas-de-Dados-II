public class pesquisaSequencial {
    public static int pesquisaSequencial(int number) {
        int tamanho = 30;
        int array[] = new int[tamanho];
        int resp = -1;

        for (int i = 0; i < tamanho; i++) {
            array[i] = (i * 2) + 1;
        }

        for (int i = 0; i < tamanho; i++) {
            if (array[i] == number) {
                resp = i;
                i = tamanho;
            }
        }
        
        return resp;
    }

    public static void main(String[] args) {
        int number = MyIO.readInt("Qual numero deseja pesquisar: ");
        int resultado = pesquisaSequencial(number);

        if (resultado >= 0) {
            MyIO.println("Valor encontrado na posicao : " + resultado);
        } else {
            MyIO.println("Valor nao encontrado");
        }
    }
}

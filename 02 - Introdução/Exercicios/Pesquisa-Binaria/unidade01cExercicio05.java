//• A solução apresentada para pesquisa binária faz duas comparações entre elementos do array em cada execução da repetição,
// modifique o código para efetuarmos apenas uma

public class unidade01cExercicio05 {
    public static boolean pesquisaBinaria(int array[], int x, int tamanho) {
        boolean resp = false;
        int dir = tamanho - 1;
        int esq = 0;
        int meio = 0;

        while (esq <= dir) {
            meio = (esq + dir) / 2;
            if (x >= array[meio]) {
                esq = meio + 1;
            } else {
                dir = meio - 1;
            }
        }

        if (dir <= tamanho - 1 && dir >= 0)  {
            if (array[dir] == x) {
                resp = true;
                return resp;
            }
        }

        return resp;
    }
    public static void main(String[] args) {
        int[] array = new int[12];

        for (int i = 0; i < array.length; i = i + 1) {
            array[i] = i;
        }

        int procurar = 3;

        
        boolean resp = pesquisaBinaria(array, procurar, array.length);

        MyIO.println("Valor encontrado: " + resp);
    }
}

public class BinarySearch2 {

    // Metodo que realiza a busca sequencial, caso ache o valor retorna 1, caso
    // contrario retorna -1
    public static int buscaSequencial(int x, int n, int v[]) {
        int m = 0;
        while (m < n && v[m] < x)
            ++m;
        if (m < n && v[m] == x)
            return 1;
        else
            return -1;
    }

    public static int buscaBinaria(int x, int n, int v[]) {
        int e = -1, d = n; // atenção!
        while (e < d - 1) {
            int m = (e + d) / 2;
            if (v[m] < x)
                e = m;
            else
                d = m;
        }

        return v[d] >= 0 ? 1 : -1;
    }

    public static void buscaBinaria1(int x) {
        int n = 12;
        boolean resp = false;
        int direita = n - 1, esquerda = 0, meio;
        int array[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 14, 15 };
        while (esquerda <= direita) {
            meio = (esquerda + direita) / 2;

            if (array[meio] < x) {
                esquerda = meio;
            } else {
                direita = meio;
            }
        }
        MyIO.println(direita);
    }

    public static boolean buscaBinaria2(int x) {
        int n = 4;
        boolean resp = false;
        int direita = n - 1, esquerda = 0, meio;
        int array[] = { 1, 2, 3, 4 };
        // esquerda = posicao 0;
        // direita = 4 - 1 = posicao 3;
        // procurar por 4
        // direita = 
        //
        while (esquerda != direita) {
            meio = (esquerda + direita) / 2;

            if (array[meio] > x) {
                direita = meio - 1;
            } else {
                esquerda = meio;
            }
        }

        if (array[esquerda] == x) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean buscaBinaria4(int x) {
        int n = 4;
        boolean resp = false;
        int direita = n - 1, esquerda = 0, meio;
        int array[] = { 1, 2, 3, 4 };
        // esquerda = posicao 0;
        // direita = 4 - 1 = posicao 3;
        // procurar por 2
        // esquerda = 1
        // direita = 3
        // direita = 2 - 1 = 1
        while (esquerda != direita && direita > esquerda) {
            meio = (esquerda + direita) / 2;

            if (array[meio] >= x) {
                direita = meio - 1;
            } else {
                esquerda = meio - 1;
            }
        }

        if (array[esquerda] == x || array[direita] == x) {
            System.out.println("Entrou");
            return true;
        } else {
            return false;
        }
    }

    public static boolean pesquisaBinaria(int x) {
        int n = 12;
        boolean resp = false;
        int array[] = {1,2,3,4,5,6,7,8,9,10,14,15};
        int dir = n - 1, esq = 0, meio = 0;
        while (esq <= dir) {
            meio = (esq + dir) / 2;
            if (array[meio] <= x) {
                esq = meio + 1;
            } else {
                dir = meio - 1;
            }
        }

        if (dir <= n-1 && dir >= 0)  {
            if (array[dir] == x) {
                resp = true;
                return resp;
            }
        }
        return resp;
    }

    public static void main(String[] args) {
        int array[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 14, 15 };
        int n = 12;
        int esquerda = 0;
        int direita = n - 1;
        int meio = 0;
        int x = 18;
        boolean resposta = false;

        resposta = pesquisaBinaria(x);

        MyIO.println(resposta);
    }
}

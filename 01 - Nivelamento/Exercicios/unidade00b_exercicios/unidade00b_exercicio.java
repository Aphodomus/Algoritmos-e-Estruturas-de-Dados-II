import java.io.IOException;
import java.util.Scanner;

public class unidade00b_exercicios {

    public static void method00() throws IOException {
        System.out.print("Aperte ENTER para terminar.");
        System.in.read();
    }

    public static boolean encontrar_valor(int array[], int valor) {

        for (int i = 0; i < array.length; i = i + 1) {
            if (array[i] == valor) {
                return true;
            }
        }

        return false;
    }

    public static void method01() throws IOException {
        /*
         * Faça um método que receba um array de inteiros e um número inteiro x e
         * retorne um valor booleano informando se o elemento x está contido no array
         */

        int[] array = { 1, 6, 3, 7, 2, 4, 7, 4, 3, 6 };

        int valor = MyIO.readInt("Digite um numero inteiro para ser procurado: ");

        boolean valorEncontrado = encontrar_valor(array, valor);

        if (valorEncontrado) {
            MyIO.print("O valor " + valor + " foi encontrado.\n");
        } else {
            MyIO.print("O valor " + valor + " NAO foi encontrado.\n");
        }

        System.out.print("Aperte ENTER para terminar.");
        System.in.read();
    }

    public static boolean encontrar_valor_meio(int array[], int valor) {
        int limite_esquerda = 0;
        int limite_direita = array.length - 1;
        int meio;

        while (limite_esquerda <= limite_direita) {
            meio = (limite_esquerda + limite_direita) / 2;

            if (valor == array[meio]) {
                return true;
            }

            if (array[meio] < valor) {
                limite_esquerda = meio + 1;
            } else {
                limite_direita = meio - 1;
            }
        }

        return false;
    }

    public static void method02() throws IOException {
        /*
         * Repita o exercício acima considerando que os elementos do array estão
         * ordenados de forma crescente. Uma sugestão seria começar a pesquisa pelo meio
         * do array
         */

        int[] array = { 10, 20, 25, 30, 35, 60, 80, 85, 90, 95, 100 };

        int valor = MyIO.readInt("Digite um numero inteiro para ser procurado: ");

        boolean valorEncontrado = encontrar_valor_meio(array, valor);

        if (valorEncontrado) {
            MyIO.print("O valor " + valor + " foi encontrado.\n");
        } else {
            MyIO.print("O valor " + valor + " NAO foi encontrado.\n");
        }

        System.out.print("Aperte ENTER para terminar.");
        System.in.read();
    }

    public static void mostrar_maior_menor(int array[]) {
        int menor, maior;

        menor = array[9];
        maior = array[0];

        for (int i = 0; i < array.length; i = i + 1) {
            if (array[i] < menor) {
                menor = array[i];
            }
        }

        for (int j = 0; j < array.length; j = j + 1) {
            if (array[j] > maior) {
                maior = array[j];
            }
        }

        MyIO.print("\nMaior valor = " + maior);
        MyIO.print("\nMenor valor = " + menor);
    }

    public static void method03() throws IOException {
        /*
         * Faça um método que receba um array de inteiros e mostre na tela o maior e o
         * menor elementos do array.
         */

        int[] array = { 10, 20, 25, 30, 35, 60, 80, 85, 90, 95, 100 };

        mostrar_maior_menor(array);

        System.out.print("\nAperte ENTER para terminar.");
        System.in.read();
    }

    public static void mostrar_maior_menor_melhor(int array[]) {
        int menor, maior;

        menor = array[9];
        maior = array[0];

        for (int i = 0; i < array.length; i = i + 1) {
            if (array[i] < menor) {
                menor = array[i];
            }

            if (array[i] > maior) {
                maior = array[i];
            }
        }

        MyIO.print("\nMaior valor = " + maior);
        MyIO.print("\nMenor valor = " + menor);
    }

    public static void method04() throws IOException {
        /*
         * Repita o exercício acima fazendo menos comparações com os elementos do array
         */

        int[] array = { 10, 20, 25, 30, 35, 60, 80, 85, 90, 95, 100 };

        mostrar_maior_menor_melhor(array);

        System.out.print("\nAperte ENTER para terminar.");
        System.in.read();
    }

    boolean doidao(char c) {
        boolean resp = false;
        int v = (int) c;
        if (v == 65 || v == 69 || v == 73 || v == 79 || v == 85 || v == 97 || v == 101 || v == 105 || v == 111
                || v == 117) {
            resp = true;
        }
        return resp;
    }

    public static void method05() throws IOException {
        /* O que o código abaixo faz ? */
        /*
         * boolean doidao (char c){ boolean resp= false; int v = (int) c; if (v == 65 ||
         * v == 69 || v == 73 || v == 79 || v == 85 || v == 97 || v == 101 || v ==105 ||
         * v == 111 || v == 117){ resp = true; } return resp; }
         */
        // Verifica se o caracter passado como parametro 'c', depois de ser transformado
        // em um inteiro por meio de (int)
        // E usando o numero da tabela ASCII
        // Corresponde a alguma letra do alfabeto = 'A', 'E', 'I', 'O', 'U', 'a', 'e',
        // 'i', 'o', 'u'
        // Ou seja, verifica se o caracter e uma vogal
        // Se for uma vogal, ele atribui o valor true a variavel resp e retorna ela no
        // final, caso contrario, retorna a variavel
        // Com o valor false

        System.out.print("Aperte ENTER para terminar.");
        System.in.read();
    }

    public static char toUpper(char c){
        return (c >= 'a' && c <= 'z') ? ((char) (c - 32)) : c ;
    }

    public static boolean isVogal(char c) {
        c = toUpper(c);
        return (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');
    }

    

    public static void method06() throws IOException {
        /* Um aluno desenvolveu o código abaixo, corrija-o: */

        char caracter = MyIO.readChar("Digite um caracter: ");

        // O codigo possui um else a mais

        System.out.print("Aperte ENTER para terminar.");
        System.in.read();
    }

    public static void method07() throws IOException {

        System.out.print("Aperte ENTER para terminar.");
        System.in.read();
    }

    public static void method08() throws IOException {

        System.out.print("Aperte ENTER para terminar.");
        System.in.read();
    }

    public static void main(String[] args) throws IOException {
        int x = 0;
        Scanner entrada = new Scanner(System.in);

        do {
            System.out.println("\n");
            System.out.println("Data: 10/12/2020\n");
            System.out.println("Trabalho Pratico\n");
            System.out.println("Matricula: 716417\nNome: Daniel Vitor De Oliveira Santos");
            System.out.println("");

            System.out.println("Opcoes");
            System.out.println("0 - parar");
            System.out.println("1 - Exercicio 1");
            System.out.println("2 - Exercicio 2");
            System.out.println("2 - Exercicio 3");
            System.out.println("2 - Exercicio 4");
            System.out.println("2 - Exercicio 5");
            System.out.println("2 - Exercicio 6");
            System.out.println("2 - Exercicio 7");
            System.out.println("2 - Exercicio 8");
            System.out.println("");

            System.out.print("Entrar com uma opcao: ");
            x = entrada.nextInt();

            switch (x) {
                case 0:
                    method00();
                    break;
                case 1:
                    method01();
                    break;
                case 2:
                    method02();
                    break;
                case 3:
                    method03();
                    break;
                case 4:
                    method04();
                    break;

                case 5:
                    method05();
                    break;

                case 6:
                    method06();
                    break;

                case 7:
                    method07();
                    break;

                case 8:
                    method08();
                    break;
                default:
                    break;
            }
        } while (x != 0);

        System.out.println("Aperte ENTER para terminar.");
        System.in.read();
        entrada.close();
    }
}

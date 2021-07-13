/*Faça um método que receba um array de inteiros e mostre na
tela o maior e o menor elementos do array. */

public class unidade00b_exercicio03 {
    public static void mostrar_maior_menor(int array[]) {
        int menor, maior;

        menor = array[0];
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
        MyIO.print("\nMenor valor = " + menor + "\n");
    }
    public static void main(String[] args) {
        int[] array = {23,3,7,76,113,56,3,45,34,98,776,54,334};

        mostrar_maior_menor(array);

        MyIO.pause("Aperte ENTER para fechar o programa.\n");
    }
}

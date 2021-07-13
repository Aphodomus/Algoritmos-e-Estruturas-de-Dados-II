// Faça um método recursivo que receba um array de números inteiros e um número inteiro n indicando o tamanho do array e retorne o maior elemento

public class unidade00h_exercicio06 {
    public static int maior(int vet[], int n, int i) {
        int resp;
        if (i == n - 1) {
            resp = vet[n - 1];
        } else {
            resp = maior(vet, n, i + 1);
            if (resp < vet[i]) {
                resp = vet[i];
            }
        }
        return resp;
    }

    public static void main(String[] args) {
        int array[] = {1, 2, 3, 34, 77, 45, 32, 43, 12, 98, 11, 87, 67, 56};
        int n = 14;
        int resp = maior(array, n, 0); 
        MyIO.println(resp);
    }
}

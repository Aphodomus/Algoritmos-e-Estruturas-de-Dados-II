import java.util.Random;

public class BinaryTree01 {
    public static void main(String[] args) throws Exception {
        /* Insira 100000 elementos de forma aleatória. Para cada inserção, mostre na
        tela o número de elementos da árvore, o logaritmo (base 2) desse número e
        a altura da árvore */
        ArvoreBinaria arvore = new ArvoreBinaria();

        Random gerador = new Random();

        gerador.setSeed(0);

        for (int i = 1; i <= 100000; i++) {
            int valor;

            do {
                valor = Math.abs(gerador.nextInt());
            } while(arvore.pesquisar(valor) == true);

            arvore.inserir(valor);

            if (i % 1000 == 0) {
                double log2 = (Math.log(i) / Math.log(2));
                log2 = log2 * 1.39;
                System.out.println("Numero de nos = " + i + " --- log2(i) = " + log2 + " --- altura = " + arvore.getAltura());
            }
        }
    }
}

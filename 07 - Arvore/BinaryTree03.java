public class BinaryTree03 {
    public static void main(String[] args) throws Exception {
        /* • Faça um método que retorne a soma dos elementos existentes na árvore */
        ArvoreBinaria arvore = new ArvoreBinaria();

        for (int i = 0; i < 1000; i++) {
            arvore.inserir(i);
        }

        System.out.println("quantidade de elementos pares da arvore = " + arvore.quantidadePares());
    }
}

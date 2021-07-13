public class BinaryTree02 {
    public static void main(String[] args) throws Exception {
        /* • Faça um método que retorne a soma dos elementos existentes na árvore */
        ArvoreBinaria arvore = new ArvoreBinaria();

        for (int i = 0; i < 1000; i++) {
            arvore.inserir(i);
        }

        System.out.println("Soma dos elementos da arvore = " + arvore.soma());
    }
}

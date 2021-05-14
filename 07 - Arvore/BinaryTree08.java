public class BinaryTree08 {
    public static void main(String[] args) throws Exception {
        ArvoreBinaria arvore = new ArvoreBinaria();

        arvore.inserir(5);
        arvore.inserir(7);
        arvore.inserir(14);
        arvore.inserir(10);
        arvore.inserir(3);

        arvore.caminharCentral(arvore.raiz);

        arvore.remover(14);

        arvore.caminharCentral(arvore.raiz);
    }
}

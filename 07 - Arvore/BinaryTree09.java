public class BinaryTree09 {
    public static void main(String[] args) throws Exception {
        ArvoreBinaria arvore = new ArvoreBinaria();

        arvore.inserir(3);
        arvore.inserir(8);
        arvore.inserir(4);
        arvore.inserir(14);
        arvore.inserir(13);
        arvore.inserir(21);

        int resp = arvore.remover3(3);
        System.out.println("Elemento = " + resp);
    }
}

public class BinaryTree04 {
    public static void main(String[] args) throws Exception {
        /*Faca um método estático que recebe dois objetos do tipo arvore Binaria:
        Pesquisa e Caminhamento e retorne um booleano indicando se as duas
        arvores sao iguais*/
        ArvoreBinaria arvore1 = new ArvoreBinaria();
        ArvoreBinaria arvore2 = new ArvoreBinaria();

        for (int i = 0; i < 1000; i++) {
            arvore1.inserir(i);
        }

        for (int i = 0; i < 1000; i++) {
            arvore2.inserir(i);
        }

        System.out.println("Sao iguais = " + arvore1.iguais(arvore1, arvore2));
    }
}

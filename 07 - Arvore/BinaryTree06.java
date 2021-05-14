public class BinaryTree06 {
    public static void main(String[] args) throws Exception {
        /*Um algoritmo de ordenação e o TreeSort que insere os elementos do array
        em uma arvore binaria: Pesquisa e Caminhamento e utiliza um "caminhar"
        para ordenar os elementos do array. Implemente o TreeSort e faça a analise
        de complexidade do mesmo*/
        TreeSort arvore1 = new TreeSort();
        int array[] = {5, 4, 7, 2, 11};

        for (int i = 0; i < array.length; i++) {
            System.out.println("antes: " + array[i]);
        }

        for (int i = 0; i < array.length; i++) {
            arvore1.inserir(array[i]);
        }

        array = arvore1.sort();

        for (int i = 0; i < array.length; i++) {
            System.out.println("depois: " + array[i]);
        }
        
    }
}

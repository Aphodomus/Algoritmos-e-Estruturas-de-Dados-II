public class SimpleLinkedList {
    public static void main(String[] args) throws Exception {
        try {
            System.out.println("Lista flexivel simplesmente encadeada");

            ListSimple lista = new ListSimple();
        
            lista.inserirInicio(1);
            lista.inserirInicio(3);
            lista.inserirFim(9);
            lista.inserirFim(2);
            lista.inserir(4, 3);
            lista.inserir(23, 1);
            lista.inserir(14, 5);
            lista.inserir(-1, 0);
            lista.inserir(21, 8);

            lista.mostrar();

            lista.removerSegundaPosicao();

            lista.mostrar();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

public class FlexQueueADS {
    public static void main(String[] args) throws Exception {
        FilaFlex fila = new FilaFlex();

        fila.inserir(5);
        fila.inserir(3);
        fila.inserir(2);
        fila.inserir(1);
        fila.mostrar();
        fila.remover();
        fila.mostrar();
        fila.inserir(5);
        fila.inserir(5);
        fila.mostrar();
    }
}

public class StackADT {
    public static void main(String[] args) {
        Pilha p = new Pilha();

        p.empilhar(3);
        p.empilhar(9);
        p.empilhar(6);
        p.empilhar(1);
        p.empilhar(2);
        p.empilhar(7);
        p.empilhar(13);

        System.out.println("Antes: ");
        p.mostrar();

        p.desempilhar();
        p.desempilhar();
        p.desempilhar();

        System.out.println("Depois: ");
        p.mostrar();
    }
}

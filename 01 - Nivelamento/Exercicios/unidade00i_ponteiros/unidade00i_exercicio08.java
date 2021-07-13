public class unidade00i_exercicio08 {
    public static void main(String[] args) {
        Cliente c1 = null, c2 = null, c3 = null;
        MyIO.println("ADDRs:\nc1(" + c1 + ")\nc2(" + c2 + ")\nc3(" + c3 + ")");

        //c1 aponta para um novo endereco de memoria distinto
        c1 = new Cliente(1, "aa");
        //c2 vai ter os mesmos atributos de c1, mas apontar para um local diferente na memoria
        c2 = c1.clone();
        //c3 aponta para um novo endereco de memoria distinto
        c3 = new Cliente(2, "bb");
        MyIO.println("ADDRs:\nc1(" + c1 + ")\nc2(" + c2 + ")\nc3(" + c3 + ")");

        //como c2 aponta para c1, o valor do codigo de ambos vai mudar
        c2.setCodigo(3);
        //c1.setCodigo(3); Da no mesmo

        MyIO.println("ATRIBUTOs:");
        MyIO.println("c1(" + c1.getCodigo() + " / " + c1.getNome() + ")");
        MyIO.println("c2(" + c2.getCodigo() + " / " + c2.getNome() + ")");
        MyIO.println("c3(" + c3.getCodigo() + " / " + c3.getNome() + ")");
    }
}

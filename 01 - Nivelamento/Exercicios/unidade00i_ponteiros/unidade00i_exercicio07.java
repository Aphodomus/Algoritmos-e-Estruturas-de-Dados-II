public class unidade00i_exercicio07 {
    public static Cliente setar2(Cliente y){
        y.setCodigo(6);
        y.setNome("ff");
        return y;
    }

    public static void setar1(Cliente x){
        x.setCodigo(4);
        x.setNome("dd"); 

        //Nao faz diferenca na main, trabalha apenas nesse escopo
        x = new Cliente (5, "ee");
    }

    public static void main (String[] args){
        Cliente c1 = new Cliente(1, "aa"), c2 = null;
        Cliente c3 = new Cliente(2, "bb");
        //Cria um ponteiro dessa vez pegando os atributos do c1 porem apontando para um endereco/objeto distinto
        c2 = c1.clone();

        MyIO.println("ADDRs:");
        MyIO.println("c1: " + c1);
        MyIO.println("c2: " + c2);
        MyIO.println("c3: " + c3);
        MyIO.println("Atributos:");
        MyIO.println("c1 codigo: " + c1.getCodigo() + "  c1 nome: " + c1.getNome());
        MyIO.println("c2 codigo: " + c2.getCodigo() + "  c2 nome: " + c2.getNome());
        MyIO.println("c3 codigo: " + c3.getCodigo() + "  c3 nome: " + c3.getNome());

        setar1(c1);
        MyIO.println("\nAPOS SETAR1: \n");
        MyIO.println("ADDRs:");
        MyIO.println("c1: " + c1);
        MyIO.println("c2: " + c2);
        MyIO.println("c3: " + c3);
        MyIO.println("Atributos:");
        MyIO.println("c1 codigo: " + c1.getCodigo() + "  c1 nome: " + c1.getNome());
        MyIO.println("c2 codigo: " + c2.getCodigo() + "  c2 nome: " + c2.getNome());
        MyIO.println("c3 codigo: " + c3.getCodigo() + "  c3 nome: " + c3.getNome());

        c3 = setar2(c2);
        MyIO.println("\nAPOS SETAR2: \n");
        MyIO.println("ADDRs:");
        MyIO.println("c1: " + c1);
        MyIO.println("c2: " + c2);
        MyIO.println("c3: " + c3);
        MyIO.println("Atributos:");
        MyIO.println("c1 codigo: " + c1.getCodigo() + "  c1 nome: " + c1.getNome());
        MyIO.println("c2 codigo: " + c2.getCodigo() + "  c2 nome: " + c2.getNome());
        MyIO.println("c3 codigo: " + c3.getCodigo() + "  c3 nome: " + c3.getNome());
    } 
}

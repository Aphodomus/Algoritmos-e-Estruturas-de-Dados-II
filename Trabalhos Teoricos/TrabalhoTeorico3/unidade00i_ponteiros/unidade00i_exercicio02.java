public class unidade00i_exercicio02 {
    public static void passagemDeTipoPrimitivo(int a){
        MyIO.println("a: " + a);
        a = 10;
        MyIO.println("a: " + a);
    }

    public static void main(String[] args) {
        int x = 5;
        MyIO.println("x: " + x);
        passagemDeTipoPrimitivo(x);
        MyIO.println("x: " + x);
    }
}

//Logo, o Java não pode alterar o valor de uma variavel por referência,como em C.


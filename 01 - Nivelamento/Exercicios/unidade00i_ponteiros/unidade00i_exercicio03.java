public class unidade00i_exercicio03 {
    public static void passagemDeArray(int[] b){
        //Nesse codigo baixo o loop esta modificando o valor do array original contigo na main
        for (int i = 0; i < 5; i++){
            b[i] = b[i] * 5;
            MyIO.println("b[" + i + "]: " + b[i]);
        }

        //Mesmo declarando outro array, o array da main nao e afetado, esse NOVO array b vai ser exclusivo para o escopo dessa funcao
        //Um NOVO espaco na memoria
        b = new int [5];

        //Adicionando valores a cada uma das posicoes do novo array b
        for (int i = 0; i < 5; i++){
            b[i] = i;
            MyIO.println("b[" + i + "]: " + b[i]);
        } 
    }

    public static void main(String[] args) {
        // y aponta para o endereço de memoria
        int[] y = new int[5];
        for (int i = 0; i < 5; i++) {
            y[i] = i;
            MyIO.println("y[" + i + "]: " + y[i]);
        }

        //Passagem por valor
        passagemDeArray(y);

        for (int i = 0; i < 5; i++) {
            MyIO.println("y[" + i + "]: " + y[i]);
        }
    }
}

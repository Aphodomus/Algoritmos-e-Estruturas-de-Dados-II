public class unidade00b_exercicio11 {
    /* Por que o código abaixo imprime [46 - 11]? */
    //Porque e utilizado um operador de mudança de bit
    //O operador << faz com que os bits sejam deslocados para a esquerda, adicionando 0 na posicao vazia
    //O operador >> faz com que os bits sejam deslocados para a direita, adicionando 0 na posicao vazia

    //Primeiro, o x que vale 10111 em binario passa a valer 101110 depois de usar o comando x << 1
    //Ou seja, o valor 10111 e movido para a esquerda e um 0 e adicionado na posicao vazia

    //Segundo, o y que vale 10111 em binario passa a valer 01011 depois de usar o comando y >> 1
    //Ou seja, o valor 10111 e movido para a direita e um 0 e adicional na posicao vazia

    public static void main(String[] args) {
        int x = 23, y = 23;
        x = x << 1;
        y = y >> 1;
        System.out.println("[" + x + " - " + y + "]");
    }
}

// Qual será o resultado da execução do programa ExemploMyIO?

class ExemploMyIO {
   public static void main (String[] args){
      String str = MyIO.readString("Entre com uma palavra: ");
      int inteiro = MyIO.readInt("Entre com um inteiro: ");
      double real = MyIO.readDouble("Entre com um real: ");
      char caractere = MyIO.readChar("Entre com um caractere: ");

      MyIO.println("Sua string: " + str);
      MyIO.println("Seu inteiro: " + inteiro);
      MyIO.println("Seu real: " + real);
      MyIO.println("Seu caractere: " + caractere);
   }
}

/* Se java ExemploMyIO, o programa lê do teclado e escreve na tela ?
 * Correto, o programa vai ler os dados do teclado
 * 
 * Se java ExemploMyIO < in.txt, ele lê o arquivo in.txt e escreve na tela (in.txt contém uma string, inteiro, real e caractere, respectivamente) ?
 * Verdade, ele imprime uma string, um inteiro, um real e por ultimo um caracter
 * 
 * Se java ExemploMyIO > out.txt, ele lê do teclado e escreve em out.txt ?
 * Correto, ele pediu para inserir os respectivos valores e no final printou todos em um arquivo.txt
 * 
 * Se java ExemploMyIO < in.txt > out.txt, ele lê de in.txt e escreve em out.txt ?
 * Verdade, ele inseriu os dados que estavam dentro do in.txt e no final printou os resultados dentro de um out.txt
 * 
 * 
 * 
 * 
 */

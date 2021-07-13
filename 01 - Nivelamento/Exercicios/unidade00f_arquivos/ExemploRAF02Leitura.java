import java.io.*;

class ExemploRAF02Leitura {
   public static void main (String[] args) throws Exception{
      RandomAccessFile raf = new RandomAccessFile("exemploRAF.txt", "rw");

      int inteiro  = raf.readInt();
      double real = raf.readDouble();
      char caractere  = raf.readChar();
      boolean boleano  = raf.readBoolean();
      String str  = raf.readLine();
      String nome = raf.readLine();
      int telefone = raf.readInt();
      char letra = raf.readChar();

      raf.close();

      System.out.println("inteiro: " + inteiro);
      System.out.println("real: " + real);
      System.out.println("caractere: " + caractere);
      System.out.println("boleano: " + boleano);
      System.out.println("str: " + str);
      System.out.println("nome: " + nome);
      System.out.println("telefone: " + telefone);
      System.out.println("letra: " + letra);
   }
}


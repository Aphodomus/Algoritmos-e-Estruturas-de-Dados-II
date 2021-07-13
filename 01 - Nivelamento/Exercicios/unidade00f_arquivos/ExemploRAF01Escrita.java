import java.io.*;  

public class ExemploRAF01Escrita {  
   public static void main(String args[]) throws Exception {

      RandomAccessFile raf = new RandomAccessFile("exemploRAF.txt","rw");  

      raf.writeInt(1);  
      raf.writeDouble(5.3);  
      raf.writeChar('X');  
      raf.writeBoolean(true);  
      raf.writeBytes("Algoritmos");
      raf.writeBytes("Daniel Vitor de Oliveira Santos");
      raf.writeByte(75258677);
      raf.writeChar('Y');   

      raf.close();
   }  
}  

import java.io.*;

public class TP01Q09 {
    public static void LerValoresAndSalvarArquivo(int len) throws Exception {
        RandomAccessFile RAF = new RandomAccessFile("dados.txt", "rw");

        for (int i = 0; i < len; i++) {
            RAF.writeDouble(MyIO.readDouble());
        }

        RAF.close();
    }
    
    public static void LerArquivoSalvo(int len) throws Exception {
        RandomAccessFile RAF = new RandomAccessFile("dados.txt", "rw");
        double value = 0.0;
        int inteiro = 0;
        int i = 0;

        while (i < len) {
            RAF.seek((len - 1) * 8);
            value = RAF.readDouble();
            inteiro = (int) value;

            if (value == (long) value) {
                MyIO.println(inteiro);
            } else {
                MyIO.println(value);
            }
            len--;
        }

        RAF.close();
    }

    public static void main(String[] args) throws Exception {
        int quantidade = MyIO.readInt();

        LerValoresAndSalvarArquivo(quantidade);

        LerArquivoSalvo(quantidade);

    }
}

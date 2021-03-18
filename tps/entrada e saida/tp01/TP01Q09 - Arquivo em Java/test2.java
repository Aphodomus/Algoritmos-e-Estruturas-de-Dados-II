import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;


public class test2 {

    public static void writeFileAndReadFile(String fileName) throws IOException {
        try {
            FileOutputStream FileOPS = new FileOutputStream(fileName);
            ObjectOutputStream ObjectOPS = new ObjectOutputStream(FileOPS);
            int quantidade = MyIO.readInt();
            ObjectOPS.writeInt(quantidade);

            for (int i = 0; i < quantidade; i++) {
                ObjectOPS.writeDouble(MyIO.readDouble());
            }

            ObjectOPS.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            //FileInputStream FileIPS = new FileInputStream(fileName);
            RandomAccessFile ObjectIPS = new RandomAccessFile(fileName, "r");

            double real;
            ObjectIPS.seek(0);
            int inteiro = ObjectIPS.readInt();
            //MyIO.println(inteiro);
            while(ObjectIPS.getFilePointer() < inteiro) {
                MyIO.println(ObjectIPS.readDouble());
            }
            /*
            while (x < quantidade) {
                real = ObjectIPS.readDouble();
                MyIO.println(real);
                x++;
            }
            */
            ObjectIPS.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        writeFileAndReadFile("teste.txt");
    }
}

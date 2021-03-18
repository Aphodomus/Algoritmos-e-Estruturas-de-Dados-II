import java.io.IOException;
import java.io.RandomAccessFile;

class Arquivo {
    ​ ​ ​ ​ ​
    /*
     * @method : Copia para um ark s@param : s Double
     * 
     * @param : n inteiro total
     **/
public static void saveark(Double s,int n) throwsException{​ ​ ​ ​ ​ RandomAccessFile raf=newRandomAccessFile("exemplo.txt","rw");for(int i=0;i<n;i++){​ ​ ​ ​ ​ s=MyIO.readDouble();raf.writeDouble(s);

}​ ​ ​ ​ ​ raf.close();}​ ​ ​ ​ ​
/*
 * @method : printa ao contrario
 * 
 * @param : n inteiro total
 **/
public static void printark(int n)throwsException{​ ​ ​ ​ ​ RandomAccessFile raf=newRandomAccessFile("exemplo.txt","rw");double real=0;int inteiro=0;for(int i=0;i<n;n--){​ ​ ​ ​ ​ raf.seek((n-1)*8);real=raf.readDouble();inteiro=(int)real;if(real==(long)real)MyIO.println(inteiro);else{​ ​ ​ ​ ​ MyIO.println(real);}​ ​ ​ ​ ​}​ ​ ​ ​ ​ raf.close();}​ ​ ​ ​ ​

public static void main(String[] args)throwsException{​ ​ ​ ​ ​ int n=MyIO.readInt();Double str=0.0;saveark(str,n);printark(n);

// }​​​​​
}​ ​ ​ ​ ​

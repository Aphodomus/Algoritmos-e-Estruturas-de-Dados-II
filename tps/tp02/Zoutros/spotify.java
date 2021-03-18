import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;
import javax.xml.crypto.Data;

import org.w3c.dom.css.CSSValue;

public class spotify {

    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }
   
    public static void main(String[] args){

        String[] text = new String[1000];
        int numEntrada = 0;
        int number = 0;

        //classe c1 = new classe();

        spotify c1 = new spotify();

        String file = "data.csv";
        BufferedReader reader = null;
        String line = "";

        try {
            reader = new BufferedReader(new FileReader(file));
            while((line = reader.readLine()) != null) {

                String[] row = line.split(",");

                for(String index : row){
                    System.out.printf("%-10s", index);
    
                }
                MyIO.println();   
            }

        }catch(Exception e) {
            e.printStackTrace();
        }
        
        
    }

}
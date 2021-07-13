/**
 Leia o nome de dois arquivos e copie o conteúdo do primeiro
para o segundo invertendo a ordem dos caracteres. O último
caractere no arquivo de entrada será o primeiro do de saída, o
penúltimo caractere será o segundo, ...
 */

import java.lang.*;
import java.io.*;
import java.util.*;

public class unidade00f_exercicio07 {
    
    public static void main(String[] args) {
        //Abrir arquivo
        Arq.openRead(MyIO.readString("Digite o nome do arquivo para copiar: "));

        //Ler conteudo
        String str = "";
        while (Arq.hasNext() == true){
            str += Arq.readLine() + "\n";
        }

        //Criando objeto para armazenar a string invertida
        StringBuilder strInvertida = new StringBuilder();

        //Copiando uma string para outra
        strInvertida.append(str);

        //Invertendo a string
        strInvertida.reverse();

        String invertida = strInvertida.toString();
        
        //Fechar primeiro arquivo
        Arq.close();
        
        //Abrir arquivo para copiar o conteudo invertido nele, e depois fechar
        Arq.openWrite(MyIO.readString("Digite o nome do arquivo onde quer salvar o conteudo: "));
        Arq.print(invertida);
        Arq.close();
        
    }
}

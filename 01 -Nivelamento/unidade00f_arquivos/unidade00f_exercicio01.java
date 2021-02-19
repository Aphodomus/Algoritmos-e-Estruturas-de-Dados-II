//Faça um programa que abre um arquivo e cria uma cópia

public class unidade00f_exercicio01 {
    public static void main (String[] args){
        Arq.openRead("exemplo.txt");
        String str = "";
        
        while (Arq.hasNext() == true){
            str += Arq.readLine() + "\n";//Aqui ele lê uma linha inteira, mas pode ser modificado para ler um int, double etc...
        }
        
        //str = Arq.readAll(); //Comando util para quando se quer copiar TUDO de um arquivo para outro

        Arq.close();
        Arq.openWrite("copia.txt");
        Arq.print(str);
        Arq.close();
    }
}

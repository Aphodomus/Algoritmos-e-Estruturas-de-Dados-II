class ExemploArq02bLeitura
{
  public static void main(String[] args)
  {
     //Abrir o arquivo texto
     Arq.openRead("exemplo.txt");


     //Ler o arquivo texto
     int inteiro = Integer.parseInt(Arq.readLine());
     double real = Double.parseDouble(Arq.readLine().replace(",","."));
     char caractere = Arq.readLine().charAt(0);
     boolean boleano = Boolean.parseBoolean(Arq.readLine());
     String str = Arq.readLine();
     String nome = Arq.readLine();
     String frase = Arq.readLine();
     int telefone = Integer.parseInt(Arq.readLine());


     //Fechar o arquivo texto
     Arq.close();

     //Mostrar os valores lidos na tela
     MyIO.println("inteiro: " + inteiro);
     MyIO.println("real: " + real);
     MyIO.println("caractere: " + caractere);
     MyIO.println("boleano: " + boleano);
     MyIO.println("str: " + str);
     MyIO.println("Nome: " + nome);
     MyIO.println("Frase: " + frase);
     MyIO.println("Telefone: " + telefone);

  } // Fim main()
} // Fim class

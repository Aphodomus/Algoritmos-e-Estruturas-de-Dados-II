class ExemploArq01Escrita
{
  public static void main(String[] args)
  {
     //Abrir o arquivo texto
     Arq.openWrite("exemplo.txt");


     //Escreve diretamente no arquivo texto
     Arq.println(1);
     Arq.println(5.3);
     Arq.println('X');
     Arq.println(true);
     Arq.println("Algoritmos");
     Arq.println("Daniel Vitor de Oliveira Santos");
     Arq.println("Ola, esse e um teste");
     Arq.println(75258677);


     //Fechar o arquivo texto
     Arq.close();

  } // Fim main()
} // Fim class

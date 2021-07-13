public class Questao4 {
    public static void main (String[] args) {
        int pequenas = 0;
        int medias = 0;

        int camisas = MyIO.readInt();

        String linha = MyIO.readLine();
        String[] corteLinha = linha.split(" ");

        int quantidadePequenas = MyIO.readInt();
        int quantidadeMedias = MyIO.readInt();

        for (int i = 0; i < camisas; i++) {
            if (corteLinha[i].equals("1")) {
                pequenas++;
            } else if (corteLinha[i].equals("2")) {
                medias++;
            } else {
                MyIO.println("Invalido");
            }
        }

        if (quantidadePequenas == pequenas && quantidadeMedias == medias) {
            MyIO.println("S");
        } else {
            MyIO.println("N");
        }
    }
}

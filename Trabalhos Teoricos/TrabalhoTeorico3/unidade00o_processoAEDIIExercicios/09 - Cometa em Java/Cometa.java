public class Cometa {
    public static void main(String[] args) {
        int year = -1, quantidadeDeVezes = 0;

        while (year != 0) {
            year = MyIO.readInt();

            quantidadeDeVezes = (year - 10) / 76;
            quantidadeDeVezes = quantidadeDeVezes + 1;

            if (year != 0) {
                MyIO.println(quantidadeDeVezes * 76 + 10);
            }
        }
    }
}

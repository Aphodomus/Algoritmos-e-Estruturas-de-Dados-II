public class DonaM {
    public static void main(String[] args) {
        int donaM = -1, filhoVelho = 0, filhoUm = 0, filhoDois = 0;
        while (donaM != 0) {
            donaM = MyIO.readInt();
            filhoUm = MyIO.readInt();
            filhoDois = MyIO.readInt();
            

            filhoVelho = donaM - (filhoUm + filhoDois);
            if (donaM != 0) {
                MyIO.println(filhoVelho);
            }
        }
    }
}

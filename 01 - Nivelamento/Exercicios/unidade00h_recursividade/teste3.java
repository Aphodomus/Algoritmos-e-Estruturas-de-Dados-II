public class teste3 {
    public static void esvaziarVaso(int flores) {
        if (flores > 0) {
            //MyIO.println(flores);
            MyIO.println(flores);
            esvaziarVaso(flores - 1);
        }
    }
    public static void main(String[] args) {
        int numero = MyIO.readInt();
        esvaziarVaso(numero);
    }
}

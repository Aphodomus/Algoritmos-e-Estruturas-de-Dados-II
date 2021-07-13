public class BinaryTree05 {
    public static void main(String[] args) throws Exception {
        /*• Faca um metodo que retorna true se a arvore contém algum número
        divisivel por onze*/
        ArvoreBinaria arvore1 = new ArvoreBinaria();

        for (int i = 0; i < 1000; i++) {
            arvore1.inserir(i);
        }

        System.out.println("Possui elemento divisivel por 11 = " + arvore1.divisivelPor11());
    }
}

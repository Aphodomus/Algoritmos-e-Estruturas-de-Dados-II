public class BinaryTree07 {
    public static void main(String[] args) throws Exception {
        /* Faca o metodo No toAB(Celula p1, CelulaDupla p2) que recebe o no
        cabeca de uma lista simples e o de outra dupla. Em seguida, crie uma
        arvore binaria: Pesquisa e Caminhamento contendo os elementos
        intercalados das duas listas e retorne o endereço do no raiz da arvore
        criada*/
        ListaSimples listasimples = new ListaSimples();
        ListaDupla listadupla = new ListaDupla();
        ArvoreBinaria arvore = new ArvoreBinaria();

        for (int i = 0; i < 5; i++) {
            listasimples.inserirFim(i);
        }

        for (int i = 5; i < 10; i++) {
            listadupla.inserirFim(i);
        }

        listasimples.mostrar();
        listadupla.mostrar();

        arvore.raiz = arvore.toAB(listasimples.primeiro, listadupla.primeiro);

        arvore.caminharCentral(arvore.raiz);
    }
}

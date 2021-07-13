public class unidade06c_pagina40 {
    public class FilaFlex {
        // Atributos
        private Celula ultimo;
    
        // Metodos especiais
        public FilaFlex() {
            // O primeiro vai ser "Café com leite", na verdade nao guarda elemento algum
            ultimo = new Celula();
        }
    
        // Funcoes e metodos
        // Inserir um elemento na fila
        public void inserir(int x) {
            ultimo.prox = new Celula(x);
            ultimo = ultimo.prox;
        }
    
        // Remover um elemento na fila
        public int remover() throws Exception {
            // Verificar se a fila esta vazia
            if (ultimo.prox == null) {
                throw new Exception("Erro !!!");
            }
    
            Celula tmp = ultimo.prox;
            ultimo = tmp.prox; // Ou ultimo.prox.prox
            int elemento = tmp.elemento;
            tmp.prox = null;
            tmp = null;
            return elemento;
        }
    
        // Mostrar os elementos na fila
        public void mostrar() {
            System.out.print("[ ");
    
            for (Celula i = ultimo.prox; i != null; i = i.prox) {
                System.out.print(i.elemento + " ");
            }
    
            System.out.print("]");
        }
    }
}

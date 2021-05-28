     CelulaDupla celula = new CelulaDupla();

            if (posicao < 0 || posicao > this.size) {
                MyIO.println("Erro !!! a posicao e menor que zero ou maior que o tamanho da lista");
                MyIO.println("posicao ("+ posicao +"/ tamanho = " + this.size +") invalida");
                return celula;
            } else if (posicao == 0) {
                comparisons = comparisons + 2;
                celula = primeiro.prox.elemento;
                return celula;
            } else if (posicao == this.size) {
                comparisons = comparisons + 3;
                celula = ultimo.elemento;
                return celula;
            } else {
                comparisons = comparisons + 3;
                CelulaDupla ant = primeiro;
                for (int i = 0; i < posicao; i++) {
                    ant = ant.prox;
                }

                celula = ant.elemento;

                return celula;
            }
        }
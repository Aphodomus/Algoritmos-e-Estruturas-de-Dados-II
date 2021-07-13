public class unidade00b_exercicio08 {
    /* Qual é a sua opinião sobre o código REAL abaixo? */
    //O codigo possui nomes muito grandes para as funcoes e metodos, o que acaba por atrapalhar o codigo e dificultar o entendimento
    

    public static Unidade recuperarUnidadeComCodigoDeUCI(Unidade unidadeFilha) {
        Unidade retorno = null;
        if (unidadeFilha.getCodUci() != null && !unidadeFilha.getCodUci().isEmpty()) {
            retorno = unidadeFilha;
        } else {
            retorno = unidadeFilha.getUnidadeSuperior();
        }
        while (retorno == null || retorno.getCodUci() == null || retorno.getCodUci().isEmpty()) {
            retorno = retorno.getUnidadeSuperior();
        }
        return retorno;
    }

    public static void main(String[] args) {

    }
}

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

class Musica {
    //----------------------------------------------------- Atributos -----------------------------------------------------
    private String id = "";
    private String nome = "";
    private String key = "";
    private String artists = "";
    private Date realease_date = new Date();
    private double acousticness = 0.0;
    private double danceability = 0.0;
    private double energy = 0.0;
    private int duration_ms = 0;
    private double instrumentalness = 0.0;
    private double valence = 0.0;
    private int popularity = 0;
    private float tempo = 0.0f;
    private double liveness = 0.0;
    private double loudness = 0.0;
    private double speechiness = 0.0;
    private int year = 0;

    //----------------------------------------------------- Metodos Especiais -----------------------------------------------------
    public Musica() {
        //Padrao
    }
    
    public Musica(String id, String nome, String key, String artists, Date realease_date, double acousticness, double danceability, double energy, int duration_ms, double instrumentalness, double valence, int popularity, float tempo, double liveness, double loudness, double speechiness, int year) {
        this.id = id;
        this.nome = nome;
        this.key = key;
        this.artists = artists;
        this.realease_date = realease_date;
        this.acousticness = acousticness;
        this.danceability = danceability;
        this.energy = energy;
        this.duration_ms = duration_ms;
        this.instrumentalness = instrumentalness;
        this.valence = valence;
        this.popularity = popularity;
        this.tempo = tempo;
        this.liveness = liveness;
        this.loudness = loudness;
        this.speechiness = speechiness;
        this.year = year;
    }
    
    public Musica clone() {
        Musica m1 = new Musica(this.id, this.nome, this.key, this.artists, this.realease_date, this.acousticness, this.danceability, this.energy, this.duration_ms, this.instrumentalness, this.valence, this.popularity, this.tempo, this.liveness, this.loudness, this.speechiness, this.year);
        return m1;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getArtists() {
        return this.artists;
    }

    public void setArtists(String artists) {
        this.artists = artists;
    }

    public String getRealeaseDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
        String strDate = formatter.format(this.realease_date);  
        return strDate;
    }

    public void setRealeaseDate(String realease_date) {
        try {
            DateFormat formatUS = new SimpleDateFormat("yyyy-MM-dd");
            Date date = formatUS.parse(realease_date);

            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
            String strDate = formatter.format(date);

            DateFormat formatBR2 = new SimpleDateFormat("MM/dd/yyyy");
            Date newDate = formatBR2.parse(strDate);

            this.realease_date = newDate;   
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public double getAcousticness() {
        return this.acousticness;
    }

    public void setAcousticnecc(double acousticness) {
        this.acousticness = acousticness;
    }

    public double getDanceability() {
        return this.danceability;
    }

    public void setDanceability(double danceability) {
        this.danceability = danceability;
    }

    public double getEnergy() {
        return this.energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public int getDurationMs() {
        return this.duration_ms;
    }

    public void setDurationMs(int duration_ms) {
        this.duration_ms = duration_ms;
    }

    public double getInstrumentalness() {
        return this.instrumentalness;
    }

    public void setInstrumentalness(double instrumentalness) {
        this.instrumentalness = instrumentalness;
    }

    public double getValence() {
        return this.valence;
    }

    public void setValence(double valence) {
        this.valence = valence;
    }

    public int getPopularity() {
        return this.popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public float getTempo() {
        return this.tempo;
    }

    public void setTempo(float tempo) {
        this.tempo = tempo;
    }

    public double getLiveness() {
        return this.liveness;
    }

    public void setLiveness(double liveness) {
        this.liveness = liveness;
    }

    public double getLoudness() {
        return this.loudness;
    }

    public void setLoudness(double loudness) {
        this.loudness = loudness;
    }

    public double getSpeechiness() {
        return this.speechiness;
    }

    public void setSpeechiness(double speechiness) {
        this.speechiness = speechiness;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    //----------------------------------------------------- Funcoes e Metodos -----------------------------------------------------
    public void imprimir() {
        MyIO.println(id + " ## " + getArtists() + " ## " + nome + " ## " + getRealeaseDate() + " ## " + acousticness + " ## " + danceability + " ## " + instrumentalness + " ## " + liveness + " ## " + loudness + " ## " + speechiness + " ## " + energy + " ## " + duration_ms);
    }

    public boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public void ler(String[] data) {
        id = data[8];
        setNome(data[14].replace("\"", ""));
        key = data[10];
        setArtists(data[3].replace("\'", "").replace("\"", ""));
        if (data[16].length() < 8){
            String temp = data[16];
            temp = temp + "-01-01";
            
            data[16] = temp;
            setRealeaseDate(data[16]);
        } else {
            setRealeaseDate(data[16]);
        }
        acousticness = Double.parseDouble(data[2]);
        danceability = Double.parseDouble(data[4]);
        energy = Double.parseDouble(data[6]);
        duration_ms = Integer.parseInt(data[5]);
        instrumentalness = Double.parseDouble(data[9]);
        valence = Double.parseDouble(data[0]);
        popularity = Integer.parseInt(data[15]);
        tempo = Float.parseFloat(data[18]);
        liveness = Double.parseDouble(data[11]);
        loudness = Double.parseDouble(data[12]);
        speechiness = Double.parseDouble(data[17]);
        year = Integer.parseInt(data[1]);
    }
}

class Tempo {
    //Atributos
    private double time;

    //Metodos especiais
    public Tempo() {
        this.time = 0.0;
    }

    public double getTime() {
        return this.time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    //Metodos
    public void start() {
        time = new Date().getTime();
    }

    public void stop() {
        time = ((new Date().getTime()) - time)/1000;
    }
}

class Celula {
    // Atributos
    public Musica elemento;
    public Celula prox;

    // Metodos especiais
    public Celula() {
        this.elemento = new Musica();
    }

    public Celula(Musica x) {
        this.elemento = x;
        this.prox = null;
    }
    
}

class CelulaDupla {
    // Atributos
    public Musica elemento;
    public CelulaDupla ant;
    public CelulaDupla prox;

    // Metodos especiais
    public CelulaDupla() {

    }

    public CelulaDupla(Musica elemento) {
        this.elemento = elemento;
        this.ant = null;
        this.prox = null;
    }

}

class ListaDupla {
    static int comparisons = 0;
    static int moves = 0;
    //----------------------------------------------- Atributos -------------------------------------------------------//

    private CelulaDupla primeiro;
    private CelulaDupla ultimo;
    private int size;

    //----------------------------------------------- Metodos especiais -------------------------------------------------------//

    public ListaDupla() {
        primeiro = new CelulaDupla();
        ultimo = primeiro;
        size = 0;
    }

    //----------------------------------------------- Funcoes e Metodos -------------------------------------------------------//

    // Retornar o numero de comparacoes
    public int comparacoes() {
        return comparisons;
    }

    // Retornar o numero de movimentacoes
    public int moves() {
        return moves;
    }
    // Inserir um elemento no inicio da lista dupla
    public void inserirInicioListaDupla(Musica x) {
        Musica music = new Musica();
        music = x.clone();

        CelulaDupla tmp = new CelulaDupla(music);

        tmp.ant = primeiro;
        tmp.prox = primeiro.prox;
        primeiro.prox = tmp;

        if (primeiro.equals(ultimo)) {
            ultimo = tmp;
        } else {
            tmp.prox.ant = tmp;
        }

        tmp = null;

        this.size++;
    }

    // Inserir um elemento no fim da lista dupla
    public void inserirFimListaDupla(Musica x) {
        Musica music = new Musica();
        music = x.clone();
        ultimo.prox = new CelulaDupla(x);
        ultimo.prox.ant = ultimo;
        ultimo = ultimo.prox;
        this.size++;
    }

    // Inserir um elemento em uma posicao da lista dupla
    public void inserirListaDupla(Musica x, int pos) throws Exception {

        if (pos < 0 || pos > this.size) {
            throw new Exception("Erro ao inserir posicao (" + pos + " / tamanho = " + this.size + ") invalida!");
        } else if (pos == 0) {
            inserirInicioListaDupla(x);
        } else if (pos == this.size) {
            inserirFimListaDupla(x);
        } else {
            Musica music = new Musica();

            CelulaDupla ant = primeiro;
            for (int i = 0; i < pos; i++) {
                ant = ant.prox;
            }

            CelulaDupla temp = new CelulaDupla(music);
            temp.prox = ant.prox;
            temp.prox.ant = temp;
            temp.ant = ant;
            ant.prox = temp;
            this.size++;
        }
    }

    // Remover um elemento do fim da lista dupla
    public Musica removerFimListaDupla() throws Exception {
        Musica music = new Musica();

        if (primeiro.equals(ultimo)) {
            throw new Exception("Erro ao remover (Lista dupla vazia) !!!");
        }

        CelulaDupla temp = ultimo;
        music = temp.elemento; // pode ter erro

        ultimo = ultimo.ant;
        ultimo.prox = null;
        this.size--;

        return music;
    }

    // Metodo para remover do inicio da lista dupla
    Musica removerInicioDupla() throws Exception {
        return removerListaDupla(0);
    }

    // Remover um elemento de uma posicao da lista dupla
    public Musica removerListaDupla(int pos) throws Exception {
        Musica resp = new Musica();

        if (primeiro.equals(ultimo)){
            throw new Exception("Erro ao remover (vazia)!");
        } else if (pos < 0 || pos > this.size - 1){
            throw new Exception("Erro ao remover (posicao " + pos + " / " + this.size + " invalida!");
        } else if (pos == this.size - 1){
            resp = removerFimListaDupla();
            return resp;
        } else {
            
            CelulaDupla ant = primeiro;
            for (int i = 0; i < pos; i++) {
                ant = ant.prox;
            }

            CelulaDupla temp = ant.prox;
            resp = temp.elemento; // pode ter erro

            temp.prox.prox = ant;
            ant.prox = temp.prox;

            this.size--;
        }

		return resp;
    }
    
    // Retornar o tamanho da lista dupla em forma de inteiro
    public int tamanhoListaDupla() {
        return this.size;
    }

    // Mostrar os elementos
    public void mostrarListaDupla() {
        for(CelulaDupla i = primeiro.prox; i != null; i = i.prox) {
            MyIO.println(i.elemento.getId() + " ## " + i.elemento.getArtists() + " ## " + i.elemento.getNome() + " ## " + i.elemento.getRealeaseDate() + " ## " + i.elemento.getAcousticness() + " ## " + i.elemento.getDanceability() + " ## " + i.elemento.getInstrumentalness() + " ## " + i.elemento.getLiveness() + " ## " + i.elemento.getLoudness() + " ## " + i.elemento.getSpeechiness() + " ## " + i.elemento.getEnergy() + " ## " + i.elemento.getDurationMs());
        }
    }

    // Mostrar os elementos em ordem inversa
    public void mostrarInverso() {
        for(CelulaDupla i = ultimo; i != primeiro; i = i.ant) {
            MyIO.println(i.elemento.getId() + " ## " + i.elemento.getArtists() + " ## " + i.elemento.getNome() + " ## " + i.elemento.getRealeaseDate() + " ## " + i.elemento.getAcousticness() + " ## " + i.elemento.getDanceability() + " ## " + i.elemento.getInstrumentalness() + " ## " + i.elemento.getLiveness() + " ## " + i.elemento.getLoudness() + " ## " + i.elemento.getSpeechiness() + " ## " + i.elemento.getEnergy() + " ## " + i.elemento.getDurationMs());
        }
    }

    // Pesquisar uma musica dentro da lista dupla e retornar verdadeiro caso encontrar
    public boolean pesquisar(int x) {
		boolean resp = false;
		for (CelulaDupla i = primeiro.prox; i != null; i = i.prox) {
         if(i.elemento.equals(x)){
            resp = true;
            i = ultimo;
         }
		}
		return resp;
	}

    // Pesquisar um elemento dentro da lista dupla e retornar ele caso encontrar
    public Musica pesquisarElementoListaDupla(int posicao) {
        Musica music = new Musica();

        if (posicao < 0 || posicao > this.size) {
            MyIO.println("Erro !!! a posicao e menor que zero ou maior que o tamanho da lista");
            MyIO.println("posicao ("+ posicao +"/ tamanho = " + this.size +") invalida");
            return music;
        } else if (posicao == 0) {
            comparisons = comparisons + 2;
            music = primeiro.prox.elemento;
            return music;
        } else if (posicao == this.size) {
            comparisons = comparisons + 3;
            music = ultimo.elemento;
            return music;
        } else {
            comparisons = comparisons + 3;
            CelulaDupla ant = primeiro;
            for (int i = 0; i < posicao; i++) {
                ant = ant.prox;
            }

            music = ant.elemento;

            return music;
        }
    }

    // Metodo para trocar um elemento de posicao
    public void trocarListaDupla(CelulaDupla music1, CelulaDupla music2) {
        //Musica music = new Musica();

        Musica music = music1.elemento;
        music1.elemento = music2.elemento;
        music2.elemento = music;
    }

    public int pegarPosicao(CelulaDupla posicao) {
        CelulaDupla i = primeiro.prox;
        int contador = 0;

        for (i = primeiro.prox; i.elemento.getDurationMs() != posicao.elemento.getDurationMs(); i = i.prox, contador++);

        return contador;
    }

    public void quickSort() {
        quickSort(primeiro.prox, ultimo);
    }

    public void quickSort(CelulaDupla esq, CelulaDupla dir) {
        int pivo = pegarPivo(esq, dir);
        CelulaDupla i = esq;
        CelulaDupla j = dir;
        comparisons = comparisons + 1;
        while (pegarPosicao(i) <= pegarPosicao(j)) {
            comparisons = comparisons + 1;
            while (i.elemento.getDurationMs() < pivo) {
                i = i.prox; // i++
            }

            comparisons = comparisons + 1;
            while (j.elemento.getDurationMs() > pivo) {
                j = j.ant; // j--
            }

            comparisons = comparisons + 1;
            if (pegarPosicao(i) <= pegarPosicao(j)) {
                trocarListaDupla(i, j);
                moves = moves + 3;
                
                i = i.prox; // i++
                j = j.ant; // j--
            }
        }

        comparisons = comparisons + 1;
        if (pegarPosicao(esq) < pegarPosicao(j)) {
            quickSort(esq, j);
        }

        comparisons = comparisons + 1;
        if (pegarPosicao(i) < pegarPosicao(dir)) {
            quickSort(i, dir);
        }
    }

    public int pegarPivo(CelulaDupla esq, CelulaDupla dir) {
        CelulaDupla i = new CelulaDupla();
        i = primeiro.prox;

        int contador = 0;
        int comparar = 0;

        int sum = pegarPosicao(esq) + pegarPosicao(dir);
        for (int j = 0; j < sum/2; j++, i = i.prox);

        return i.elemento.getDurationMs();

    }

}

class PilhaFlexivel {
    //----------------------------------------------- Atributos -------------------------------------------------------//

    private Celula topo;

    //----------------------------------------------- Metodos especiais -------------------------------------------------------//

    public PilhaFlexivel() {
        topo = null;
    }

    //----------------------------------------------- Funcoes e Metodos -------------------------------------------------------//

    // Inserir uma musica na pilha
    public void inserir(Musica musica) {
        Celula tmp = new Celula(musica);
        tmp.prox = topo;
        topo = tmp;
        tmp = null;
    }

    // Vai remover uma musica, e fazer o topo apontar para o proximo
    public Musica remover() throws Exception {
        if (topo == null) {
            throw new Exception("Erro !!! a pilha esta vazia.");
        }

        Musica elemento = topo.elemento.clone();
        Celula tmp = topo;
        topo = topo.prox;
        //Desvincular a caixinha do elemento retirado
        tmp.prox = null;
        tmp = null;

        return elemento;
    }

    // Mostra os elementos da pilha
    public void mostrar (){
        int contador = 0;
    
        for(Celula i = topo; i != null; i = i.prox) {
            MyIO.println("[" + contador + "] " + i.elemento.getId() + " ## " + i.elemento.getArtists() + " ## " + i.elemento.getNome() + " ## " + i.elemento.getRealeaseDate() + " ## " + i.elemento.getAcousticness() + " ## " + i.elemento.getDanceability() + " ## " + i.elemento.getInstrumentalness() + " ## " + i.elemento.getLiveness() + " ## " + i.elemento.getLoudness() + " ## " + i.elemento.getSpeechiness() + " ## " + i.elemento.getEnergy() + " ## " + i.elemento.getDurationMs());
            contador = contador + 1;
        }

    }

    // Mostrar o tamanho da pilha
    public int tamanho() {
        int contador = 0;
        for (Celula i = topo; i != null; i = i.prox) {
            contador = contador + 1;
        }
        return contador;
    }

    // Mostrar as musicas na ordem que de insercao RECURSIVO
    public void mostrarRecursivamente() {
        Celula tmp = topo;
        int contador = tamanho();
        showRecursive(tmp, contador);
    }

    public void showRecursive(Celula i, int contador) {
        if (i != null) {
            contador--;
            showRecursive(i.prox, contador);
            MyIO.println("[" + contador + "] " + i.elemento.getId() + " ## " + i.elemento.getArtists() + " ## " + i.elemento.getNome() + " ## " + i.elemento.getRealeaseDate() + " ## " + i.elemento.getAcousticness() + " ## " + i.elemento.getDanceability() + " ## " + i.elemento.getInstrumentalness() + " ## " + i.elemento.getLiveness() + " ## " + i.elemento.getLoudness() + " ## " + i.elemento.getSpeechiness() + " ## " + i.elemento.getEnergy() + " ## " + i.elemento.getDurationMs());
        }
    }
}

public class TP03Q09 {
    //Variaveis globais
    final static int tamanho = 170653;
    static int comparisons = 0;
    static int moves = 0;

    //Criar todos os objetos do tipo Musica
    public static Musica[] createAllObject() {
        String data = "";
        String[] dataTreated = new String[20];
        Musica[] m = new Musica[tamanho];
        int i = 0;
        Arq.openRead("/tmp/data.csv", "UTF-8");

        data = Arq.readLine();

        while (Arq.hasNext()) {
            data = "";
            data = Arq.readLine();
            dataTreated = processData(data);
            m[i] = new Musica();
            m[i].ler(dataTreated);
            i++;
        }

        Arq.close();

        return m;
    }

    //Verificar se a linha lida e igual a FIM
    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }   

    //Tratar os dados, de modo que o return seja um array de string com todos os atributos separados
    public static String[] processData(String data) {
        String resp[] = new String[20];

        
        resp = data.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
        return resp;
    }

    //Buscar os ids no arquivo, e imprimir seus dados caso encontrado
    public static void searchIdInFile(String[] id, int numEntrada) {
        Musica[] m = new Musica[tamanho];
        Musica[] result = new Musica[100];
        int w = 0;
        m = createAllObject();
        
        for (int k = 0; k < numEntrada; k++) {
            for (int j = 0; j < tamanho; j++) {
                try {
                    if (m[j].getId().equals((id[k]))) {
                        m[j].imprimir();
                    }
                } catch (Exception e) {
                   
                }
            }
        }
        

        Arq.close();
    }

    //Buscar os ids no arquivo, e retornar o dado caso encontrado
    public static Musica[] searchIdInReturnArrayMusic(String[] id, int numEntrada) {
        Musica[] m = new Musica[tamanho];
        Musica[] result = new Musica[numEntrada];
        m = createAllObject();
        int w = 0;

        for (int k = 0; k < numEntrada; k++) {
            for (int j = 0; j < tamanho; j++) {
                try {
                    if (m[j].getId().equals((id[k]))) {
                        result[w] = m[j];
                        w++;
                    }
                } catch (Exception e) {
                   
                }
            }
        }

        return result;
    }

    //Buscar os ids no arquivo, e retornar as musicas encontradas correspondentes aos ids
    public static PilhaFlexivel searchIdInReturnStackFlex(Musica[] musica, PilhaFlexivel pilha, String[] id, int numEntrada) {
        boolean achou = false;

        for (int k = 0; k < numEntrada; k++) {
            for (int j = 0; j < tamanho && achou == false; j++) {
                try {
                    if (musica[j].getId().equals((id[k]))) {
                        pilha.inserir(musica[j]);
                        achou = true;
                    }
                } catch (Exception e) {
                   
                }
            }
            achou = false;
        }

        return pilha;
    }

    //Fazer a pesquisa sequencial no arquivo
    public static boolean sequentialSearch(String[] array1, String procurar) {
        boolean resp = false;
        
        for (int i = 0; i < array1.length; i++) {
            comparisons = comparisons + 1;
            if (array1[i].intern() == procurar.intern()) {
                resp = true;
                i = array1.length;
            }
        }
        
       return resp;
    }

    //Ordenar as musicas por meio do Selecao
    public static void sortBySelection(Musica[] music, int n) {
        Musica temp = new Musica();
        int menor = 0;
        int comparasionsSelection = 0;

        for (int i = 0; i < (n - 1); i++) {
            menor = i;
            for (int j = (i + 1); j < n; j++) {
                if (music[menor].getNome().compareTo(music[j].getNome()) > 0) {
                    menor = j;
                }
            }
            
            //Trocar o menor elemento encontrado
            if (menor != i) {
                temp = music[i];
                music[i] = music[menor];
                music[menor] = temp;
            }
        }

        moves = 3*(n - 1);
        comparasionsSelection = (int) (Math.pow((n - 1), 2) + (n - 1))/2;
        comparisons = comparisons + comparasionsSelection;
    }

    //Ordenar as musicas por meio do Insercao
    public static void sortByInsertion(Musica[] music, int n) {
        Musica tmp = new Musica();
        int comparasionsSelection = 0;

        for (int i = 1; i < n; i++) {
            tmp = music[i];
            int j = i - 1;
            while ((j >= 0) && (music[j].getId().compareTo(tmp.getId()) > 0)) {
                music[j + 1] = music[j]; // Deslocamento
                j--;
            }
            music[j + 1] = tmp;
        }

        moves = (n*(n + 1) - 2)/2; //Numero de movimentos no pior caso
        comparasionsSelection = ((n - 1)*n)/2; //Numero de comparacoes no pior caso
        comparisons = comparisons + comparasionsSelection;
    }

    public static void merge(Musica[] music, int esquerda, int meio, int direita) {
        //Definindo tamanho dos dois subarrays
        int tamanhoEsquerda = (meio + 1) - esquerda;
        int tamanhoDireita = direita - meio;

        Musica[] arrayEsq = new Musica[tamanhoEsquerda];
        Musica[] arrayDir = new Musica[tamanhoDireita];

        //Index do subarray da esquerda, direita e do merge
        int countEsq, countDir, i = esquerda;

        //Inicializar primeiro subarray
        for (countEsq = 0; countEsq < tamanhoEsquerda; countEsq++) {
            arrayEsq[countEsq] = music[esquerda + countEsq];
        }

        //Inicializar segundo subarray
        for (countDir = 0; countDir < tamanhoDireita; countDir++) {
            arrayDir[countDir] = music[(meio + 1) + countDir];
        }

        countEsq = 0;
        countDir = 0;

        while (countEsq < tamanhoEsquerda && countDir < tamanhoDireita) {
            if (arrayEsq[countEsq].getEnergy() <= arrayDir[countDir].getEnergy()) {
                music[i] = arrayEsq[countEsq];
                countEsq++;
            } else {
                music[i] = arrayDir[countDir];
                countDir++;
            }
            i++;
        }

        //Copiar o restante dos elementos do arrayEsq, se tiver algum
        while (countEsq < tamanhoEsquerda) {
            music[i] = arrayEsq[countEsq];
            countEsq++;
            i++;
        }

        //Copiar o restante dos elementos do arrayDir, se tiver algum
        while (countDir < tamanhoDireita) {
            music[i] = arrayDir[countDir];
            countDir++;
            i++;
        }
    }

    //Ordenar as musicas por meio do Merge Sort
    public static void sortByMergeSort(Musica[] music, int esquerda, int direita) {
        if (esquerda < direita) {
            int meio = (esquerda + direita) / 2;
            sortByMergeSort(music, esquerda, meio);
            sortByMergeSort(music, meio + 1, direita);
            merge(music, esquerda, meio, direita);
        }
    }

    //Ordenar as musicas por meio do Selecao PARCIAL
    public static void sortBySelectionPartial(Musica[] music, int n) {
        Musica temp = new Musica();
        int menor = 0;
        for (int i = 0; i < (n - 1); i++) {
            menor = i;
            for (int j = (i + 1); j < n; j++) {
                comparisons = comparisons + 1;
                if (music[menor].getNome().compareTo(music[j].getNome()) > 0) {
                    menor = j;
                }
            }
            
            //Trocar o menor elemento encontrado
            comparisons = comparisons + 1;
            if (menor != i) {
                temp = music[i];
                music[i] = music[menor];
                music[menor] = temp;
                moves = moves + 3;
            }
        }
    }

    //Ordenar as musicas por meio do QuickSort
    public static void sortByQuickSort(Musica[] music, int esq, int dir, int k) {
        Musica pivo = new Musica();
        Musica tmp = new Musica();
        pivo = music[(esq + dir) / 2];
        int i = esq, j = dir;

        while (i <= j) {
            while (music[i].getDurationMs() < pivo.getDurationMs()) {
                i++;
            }

            while (music[j].getDurationMs() > pivo.getDurationMs()) {
                j--;
            }

            if (i <= j) {
                tmp = music[i];
                music[i] = music[j];
                music[j] = tmp;
                
                i++;
                j--;
            }
        }

        if (esq < j) {
            sortByQuickSort(music, esq, j, k);
        }
        if (i < k && i < dir) {
            sortByQuickSort(music, i, dir, k);
        }
    }

    //Criar o log
    public static void createLog(Tempo tempo, int comparacoes, int movimentos) {
        Arq.openWrite("DadosQuestao09.txt");

        Arq.println("Matricula: 716417\tTempo: " + tempo.getTime() + "\tComparacoes: " + comparacoes + "\tMovimentacoes: " + movimentos);

        Arq.close();
    }

    //Procurar uma musica
    public static Musica procurarUmaMusica(Musica[] musica, String id) {
        Musica music = new Musica();
        boolean achou = false;
        
        for (int j = 0; j < tamanho && achou == false; j++) {
            try {
                if (musica[j].getId().equals((id))) {
                    music = musica[j].clone();
                    achou = true;
                }
            } catch (Exception e) {
                
            }
        }

        return music;
    }

    //Ler a linha, quebrar ela com um split e ver qual comando esta pedindo para ser executado, e executado.
    public static PilhaFlexivel tratarComandos(String[] entrada, PilhaFlexivel pilha, Musica[] musica, int tamanho) throws Exception {
        for (int i = 0; i < entrada.length && i < tamanho; i++){
            Musica music;
            String[] linha = entrada[i].split(" ");

            //Verificar qual dos comandos devera ser executado
            switch (linha[0]) {
                case "I":
                    music = procurarUmaMusica(musica, linha[1]);
                    pilha.inserir(music);
                break;
                case "R":
                    music = pilha.remover();
                    MyIO.println("(R) " + music.getNome());
                break;
            
                default:
                break;
            }
        }

        return pilha;
    }

    //Buscar os ids no arquivo, e retornar as musicas encontradas correspondentes aos ids
    public static ListaDupla searchIdInReturnDoublyList(Musica[] musica, ListaDupla lista, String[] id, int numEntrada) {
        boolean achou = false;
        int w = 0;

        for (int k = 0; k < numEntrada; k++) {
            for (int j = 0; j < tamanho && achou == false; j++) {
                try {
                    if (musica[j].getId().equals((id[k]))) {
                        lista.inserirListaDupla(musica[j], w);
                        achou = true;
                        w++;
                    }
                } catch (Exception e) {
                   
                }
            }
            achou = false;
        }

        return lista;
    }
    
    public static void main(String[] args) throws Exception {
        //iniciar o temporizador
        Tempo time = new Tempo();

        //Declarando variaveis
        MyIO.setCharset("UTF-8");
        String[] entrada = new String[1000];
        String[] entrada2 = new String[1000];
        Musica[] m = new Musica[tamanho];
        m = createAllObject();
        int i = -1;
        int quantidade = 0;
        int contador = 0;

        //Lendo a primeira parte da entrada
        do {
            i++;
            entrada[i] = "";
            entrada[i] = MyIO.readString();
        } while (!isFim(entrada[i]));

        //Declarando a lista dupla
        ListaDupla music = new ListaDupla();

        //Iniciar o relogio
        time.start();

        //Criar as musicas pedidas
        music = searchIdInReturnDoublyList(m, music, entrada, i);

        //Ordenar por meio do quick sort
        music.quickSort();

        //Mostrar os elementos ordenados da lista dupla
        music.mostrarListaDupla();

        //Receber o numero de comparacoes
        comparisons = music.comparacoes();

        //Receber o numero de movimentacoes
        moves = music.moves();

        ////Parar o temporizador e fazer o log
        time.stop();
        createLog(time, comparisons, moves);
    }
}


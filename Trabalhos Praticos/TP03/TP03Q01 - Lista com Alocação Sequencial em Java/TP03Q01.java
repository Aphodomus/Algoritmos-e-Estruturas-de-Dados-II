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

class ListaSequencial {
    final static int tamanho = 170653;

    // Atributos
    private Musica[] arrayMusica; // Pode ser de qualquer outro tipo
    private int n;

    // Metodos especiais
    public ListaSequencial() {
        this.arrayMusica = Musica[tamanho]; // Tamanho padrao
        this.n = 0;
    }

    public ListaSequencial(int tamanho) {
        arrayMusica = new Musica[tamanho];
        n = 0;
    }

    public Musica[] getArrayMusica() {
        return this.arrayMusica;
    }

    public void setArrayMusica(Musica[] arrayMusica) {
        this.arrayMusica = arrayMusica;
    }

    public int getTamanho() {
        return this.n;
    }

    public void setTamanho(int n) {
        this.n = n;
    }

    // Metodos

    // Insere um elemento na primeira posicao da lista e move os demais elementos para o fim
    public void inserirInicio(Musica x) throws Exception {
        // Validar insercao
        if (n >= arrayMusica.length) {
            throw new Exception("Erro ao inserir !!!");
        }

        // Levar elementos para o fim do array
        for (int i = n; i > 0; i--) {
            arrayMusica[i] = arrayMusica[i - 1].clone();
        }

        // Coloca o elemento x na primeira posicao
        arrayMusica[0] = x.clone();
        n++;
    }

    // Insere um elemento na ultima posicao
    public void inserirFim(Musica x) throws Exception {
        // Validar insercao
        if (n >= arrayMusica.length) {
            throw new Exception("Erro ao inserir !!!");
        }

        // Coloca o elemento x na ultima posicao
        arrayMusica[n] = x.clone();
        n++;
    }

    // Insere um elemento na posicao especificada e move os demais para o fim
    public void inserir(Musica x, int posicao) throws Exception {
        // Validar insercao
        if (n >= arrayMusica.length || posicao < 0 || posicao > n) {
            throw new Exception("Erro ao inserir !!!");
        }

        // Levar elementos para o fim do array
        for(int i = n; i > posicao; i--){
            arrayMusica[i] = arrayMusica[i - 1].clone();
        }

        //Colocar o elemento na posicao especificada, apos mover os demais
        arrayMusica[posicao] = x.clone();
        n++;
    }

    // Remove um elemento da primeira posicao da lista e movimenta os demais para o inicio
    public Musica removerInicio() throws Exception {
        // Validar remocao
        if (n == 0) {
            throw new Exception("Erro ao remover, tamanho igual a zero !!!");
        }

        //Guarda o elemento da primeira posicao em resp, e diminui o tamanho do array para sinalizar que removeu
        Musica resp = arrayMusica[0].clone();
        n--;

        for(int i = 0; i < n; i++){
            arrayMusica[i] = arrayMusica[i + 1].clone();
        }

        return resp;
    }

    // Remove um elemento da ultima posicao
    public Musica removerFim() throws Exception {
        // Validar remocao
        if (n == 0) {
            throw new Exception("Erro ao remover, tamanho igual a zero !!!");
        }

        // Decrementa primeiro e depois devolve o valor
        return arrayMusica[--n];
    }

    // Remove um elemento de uma posicao especifica e move os demais elementos para o inicio
    public Musica remover(int posicao) throws Exception {
        // Validar remocao
        if (n == 0 || posicao < 0 || posicao >= n) {
            throw new Exception("Erro ao remover !!!");
        }

        // Pega o elemento da posicao desejada e retira um do tamanho, para sinalizar que removeu
        Musica resp = arrayMusica[posicao];
        n--;

        // Move os elementos para preencher o buraco do elemento removido
        for(int i = posicao; i < n; i++){
            arrayMusica[i] = arrayMusica[i + 1].clone();
        }

        return resp;
    }

    // Mostra os elementos da lista
    public void mostrar (){
    
        for(int i = 0; i < n; i++){
           MyIO.println("[" + i + "] " + arrayMusica[i].getId() + " ## " + arrayMusica[i].getArtists() + " ## " + arrayMusica[i].getNome() + " ## " + arrayMusica[i].getRealeaseDate() + " ## " + arrayMusica[i].getAcousticness() + " ## " + arrayMusica[i].getDanceability() + " ## " + arrayMusica[i].getInstrumentalness() + " ## " + arrayMusica[i].getLiveness() + " ## " + arrayMusica[i].getLoudness() + " ## " + arrayMusica[i].getSpeechiness() + " ## " + arrayMusica[i].getEnergy() + " ## " + arrayMusica[i].getDurationMs());
        }

    }

    // Procura um elemento e retorna true or false se ele existe
    public boolean pesquisar(Musica x) {
        boolean resp = false;

        // Faz uma busca sequencial para ver se encontra o valor
        for (int i = 0; i < n && resp == false; i++) {
            resp = (arrayMusica[i].equals(x));
        }

        return resp;
    }
}

public class TP03Q01 {
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
    public static ListaSequencial searchIdInReturnSequentialList(Musica[] musica, ListaSequencial lista, String[] id, int numEntrada) {
        boolean achou = false;

        for (int k = 0; k < numEntrada; k++) {
            for (int j = 0; j < tamanho && achou == false; j++) {
                try {
                    if (musica[j].getId().equals((id[k]))) {
                        lista.inserirFim(musica[j]);
                        achou = true;
                    }
                } catch (Exception e) {
                   
                }
            }
            achou = false;
        }

        return lista;
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
    public static void createLog(Tempo tempo) {
        Arq.openWrite("DadosQuestao01.txt");

        Arq.println("Matricula: 716417\tTempo: "+ tempo.getTime());

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
    public static ListaSequencial tratarComandos(String[] entrada, ListaSequencial lista, Musica[] musica, int tamanho) throws Exception {
        for (int i = 0; i < entrada.length && i < tamanho; i++){
            Musica music;
            String[] linha = entrada[i].split(" ");

            //Verificar qual dos comandos devera ser executado
            switch (linha[0]) {
                case "II":
                    music = procurarUmaMusica(musica, linha[1]);
                    lista.inserirInicio(music);
                break;
                case "IF":
                    music = procurarUmaMusica(musica, linha[1]);
                    lista.inserirFim(music);
                break;
                case "I*":
                    music = procurarUmaMusica(musica, linha[2]);
                    lista.inserir(music, Integer.parseInt(linha[1]));
                break;
                case "RI":
                    music = lista.removerInicio();
                    MyIO.println("(R) " + music.getNome());
                break;
                case "RF":
                    music = lista.removerFim();
                    MyIO.println("(R) " + music.getNome());
                break;
                case "R*":
                    music = lista.remover(Integer.parseInt(linha[1]));
                    MyIO.println("(R) " + music.getNome());
                break;
            
                default:
                break;
            }
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

        //Ler a quantidade de operacoes que serao realizadas
        quantidade = MyIO.readInt();

        //Lendo os comandos das operacoes
        do {
            entrada2[contador] = MyIO.readLine();
            contador++;
        } while(contador < quantidade);

        //Declarando a lista com um tamanho maior, pois precisa de mais espaco devido as insercoes (saudades de ser dinamico...)
        ListaSequencial music = new ListaSequencial(100);

        //Iniciar o relogio
        time.start();

        //Criar as musicas pedidas
        music = searchIdInReturnSequentialList(m, music, entrada, i);

        //Tratar e executar os comandos
        music = tratarComandos(entrada2, music, m, contador);

        //Imprimir as informacoes da musica
        music.mostrar();
        
        ////Parar o temporizador e fazer o log
        time.stop();
        createLog(time);
    }
}


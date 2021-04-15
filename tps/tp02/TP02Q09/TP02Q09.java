import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

class Musica {
    //----------------------------------------------------- Atributos -----------------------------------------------------
    private String id = "";
    private String nome = "";
    private String key = "";
    private String artists = "";
    private String realease_date = "";
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
    
    public Musica(String id, String nome, String key, String artists, String realease_date, double acousticness, double danceability, double energy, int duration_ms, double instrumentalness, double valence, int popularity, float tempo, double liveness, double loudness, double speechiness, int year) {
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
        //SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
        //String strDate = formatter.format(this.realease_date);  
        return this.realease_date;
    }

    public String getRealeaseDateInverted() {
        String data = this.realease_date;
        String finalData = "";
        
        String temp1[] = new String[3];

        temp1 = data.split("/");

        finalData = finalData + temp1[2];
        finalData = finalData + "/" + temp1[1];
        finalData = finalData + "/" + temp1[0];

        return finalData;
    }

    public void setRealeaseDate(String realease_date) {
        try {
            DateFormat formatUS = new SimpleDateFormat("yyyy-MM-dd");
            Date date = formatUS.parse(realease_date);

            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
            String strDate = formatter.format(date);

            DateFormat formatBR2 = new SimpleDateFormat("MM/dd/yyyy");
            Date newDate = formatBR2.parse(strDate);
            
            SimpleDateFormat formatterFinal = new SimpleDateFormat("dd/MM/yyyy");  
            String strDateFinal = formatterFinal.format(newDate);

            this.realease_date = strDateFinal;   
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

public class TP02Q09 {
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
        Arq.openRead("data.csv", "UTF-8");

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
        Musica[] result = new Musica[100];
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

        Arq.close();

        return result;
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

    //Converter árvore em uma estrutura heap
    public static void heapify(Musica[] music, int n, int i) {
        int maior = i; //Inicializar o maior como raiz
        int esq = 2 * i ; //Esquerda = 2 * i + 1
        int dir = 2 * i + 1; //Direita = 2 * i + 2

        //Se o filho da esquerda for maior que a raiz
        comparisons = comparisons + 1;
        if (esq < n && music[esq].getRealeaseDateInverted().compareTo(music[maior].getRealeaseDateInverted()) == 0) {
            comparisons = comparisons + 1;
            if (music[esq].getNome().compareTo(music[maior].getNome()) > 0) {
                maior = esq;
            }
        } else {
            comparisons = comparisons + 1;
            if (esq < n && music[esq].getRealeaseDateInverted().compareTo(music[maior].getRealeaseDateInverted()) > 0) {
                maior = esq;
            }
        }

        //Se o filho da direita for maior do que o maior ate agora
        comparisons = comparisons + 1;
        if (dir < n && music[dir].getRealeaseDateInverted().compareTo(music[maior].getRealeaseDateInverted()) == 0) {
            comparisons = comparisons + 1;
            if (music[dir].getNome().compareTo(music[maior].getNome()) > 0) {
                maior = dir;
            }
        } else {
            comparisons = comparisons + 1;
            if (dir < n && music[dir].getRealeaseDateInverted().compareTo(music[maior].getRealeaseDateInverted()) > 0) {
                maior = dir;
            }
        }

        //Se o maior nao e a raiz
        comparisons = comparisons + 1;
        if (maior != i) {
            moves = moves + 3;
            Musica swap = music[i];
            music[i] = music[maior];
            music[maior] = swap;

            //Montar recursivamente a subarvore
            heapify(music, n, maior);
        }
    }

    public static void sortByHeapSort(Musica[] music, int n) {
        //Construir heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            comparisons = comparisons + 1;
            heapify(music, n, i);
        }

        //Extrair um por um dos elementos da pilha
        for (int i = n - 1; i > 0; i--) {
            comparisons = comparisons + 1;
            //Mover a raiz atual para o fim do array
            Musica temp = music[0];
            music[0] = music[i];
            music[i] = temp;

            //chamar heap reduzido
            heapify(music, i, 0);
        }
    }

    //Criar o log
    public static void createLog(Tempo tempo) {
        Arq.openWrite("matricula_heapsort.txt");

        Arq.println("Matricula: 716417\tTempo: "+ tempo.getTime() + "s \tComparacoes: " + comparisons + "\tMovimentos: " + moves);

        Arq.close();
    }
    
    public static void main(String[] args) {
        //iniciar o temporizador
        Tempo time = new Tempo();

        //Declarando variaveis
        int quantidadeMusica = 100;
        Musica[] music = new Musica[quantidadeMusica];
        MyIO.setCharset("UTF-8");
        String[] entrada = new String[101];
        int i = -1;

        //Lendo a primeira parte da entrada
        do {
            i++;
            entrada[i] = "";
            entrada[i] = MyIO.readString();
        } while (!isFim(entrada[i]));
    
        //Procurar as musicas e retornar elas
        music = searchIdInReturnArrayMusic(entrada, i);

        //Organizar as musicas pelo nome
        time.start();
        sortByHeapSort(music, quantidadeMusica);
        
        //Imprimir as informacoes da musica agora ordenada
        for (int m = 0; m < 100; m++) {
            music[m].imprimir();
        }
    
        //Parar o temporizador e fazer o log
        time.stop();
        createLog(time);
    }
}


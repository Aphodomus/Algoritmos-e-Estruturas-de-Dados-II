public class Musica {

    // Atributos
    private String id;
    private String nome;
    private String key;
    private String artists;
    private String realease_date;
    private double acousticness;
    private double danceability;
    private double energy;
    private int duration_ms;
    private double instrumentalness;
    private double valence;
    private int popularity;
    private float tempo;
    private double liveness;
    private double loudness;
    private double speechiness;
    private int year;

    

    //setter do construtor
    public Musica (String id, String nome, String key, String artists, String realease_date, double acousticness, double danceability, double energy, int duration_ms, double instrumentalness, double valence, int popularity, float tempo, double liveness, double loudness, double speechiness, int year) {
        
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

    public String getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getKey() {
        return key;
    }    
    public String getArtists() {
        return artists;
    }
    public String getRealease_date() {
        return realease_date;
    }
    public double getAcousticness() {
        return acousticness;
    }
    public double getDanceability() {
        return danceability;
    }
    public double getEnergy() {
        return energy;
    }
    public int getDuration_ms() {
        return duration_ms;
    }
    public double getInstrumentalness() {
        return instrumentalness;
    }
    public double getValence() {
        return valence;
    }
    public int getPopularity() {
        return popularity;
    }
    public float getTempo() {
        return tempo;
    }
    public double getLiveness() {
        return liveness;
    }
    public double getLoudness() {
        return loudness;
    }
    public double getSpeechiness() {
        return speechiness;
    }
    public int getYear() {
        return year;
    }


    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static void main (String[] args){
        String[] datacsv = new String[170626];
        String[] datacsv2 = new String[300];
        int linha = 0;
        int linha2 = 0;
        int linhaIds = 0;
        String [] idsPubIn = new String[300];
        //Leitura da datacsv e salvar em string
        do {
           datacsv[linha] = MyIO.readLine();
           linha++;
        } while ( linha <= 170625);
        //Leitura dos Ids do pub.in

        do {
           idsPubIn[linhaIds] = MyIO.readLine();
           linhaIds++;
        } while (isFim(idsPubIn[linhaIds++]) == false);
        linhaIds--;

            // procurar se o ID esta presente na linha em datacsv[i]
            // se estiver salvar em datacsv2[linha2] e linha2++
            for(int i = 0; i <= linha; i++){
                    for (int j = 0; j<=linhaIds; j++) {
                    if (datacsv[i].contains(idsPubIn[j])) {
                        datacsv2[linha2] = datacsv[i];
                        linha2++;}
                    }

                // Em seguida pegar o datacsv2 e fazer o split
                // Separando cada linha em uma String pelas ","]]


                // Printar em outro arquivo xxx.out  
                // id ## artists ## name ## realease date ## acousticness ## danceability ##
                // instrumentalness ## liveness ## loudness ## speechiness ## energy ## duration

            }
           
        }
}


import java.util.List;
import java.util.Set;

import java.util.*;

public class spoty {

    private int id;
    private String nome;
    private String key;
    private String artist;
    private Date release_date;
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

    public spoty(){

        this.setid(0);
        this.setNome("a");
        this.setKey("0");
        //this.setAcousticness("0");
        //this.release_date = "10/05";
        this.acousticness = 0;
        this.danceability = 0;
        this.energy = 0;
        this.duration_ms = 0;
        this.instrumentalness = 0;
        this.valence = 0;
        this.popularity = 0;
        this.tempo = 0;
        this.liveness = 0;
        this.loudness = 0;
        this.speechiness = 0;
        this.year = 0;
    }

    public spoty(int id, String nome, String key, List artist, Date releDate, double acousticness, double danceability, double energy, int duration_ms, double instrumentalness, double valence, int popularity, float tempo, double liveness, double loudness, double speechiness, int year){

        this.setid(id);
        this.setNome(nome);
        this.setKey(key);
        this.setArtists(artist);
        this.setDate(release_date);
        this.setAcousticness(acousticness);
        this.setDanceability(danceability);
        this.setEnergy(energy);
        this.setDuration(duration_ms);
        this.setInstrumentalness(instrumentalness);
        this.setValence(valence);
        this.setPopularity(popularity);
        this.setTempo(tempo);
        this.setLiveness(liveness);
        this.setLoudness(loudness);
        this.setSpeachiness(speechiness);
        this.setYear(year);
    }

    /*
    public classe(){

        this.id = 1234567;
        this.nome = "Usuario_1";
        this.key = "99999999";
    //  this.artist = 
//    this.double = "48567"
        this.acousticness = 0.6;
        this.danceability = 0.3333;
        this.energy = 0.8796;
        this.duration_ms = 25;
        this.instrumentalness = 0.456;
        this.valence = 0.7812;
        this.popularity = 7;
        this.tempo = 3;
        this.liveness = 3.26;
        this.loudness = 7.456;
        this.speechiness = 3.265;
        this.year = 2020;
    }*/

    /*public classe(){

        this.id = getid();
        this.nome = getnome();
        this.key = getkey();
    //  this.artist = 
//    this.double = "48567"
        this.acousticness = getAcousticness();
        this.danceability = getDanceability();
        this.energy = getEnergy();
        this.duration_ms = getDuration();
        this.instrumentalness = getInstrumentalness();
        this.valence = getValence();
        this.popularity = getPopularity();
        this.tempo = getTempo();
        this.liveness = getLiveness();
        this.loudness = getLoudness();
        this.speechiness = getSpeachiness();
        this.year = getYear();
    }*/     
    /*
    public classe_2(){

        this.nome = "Usuario_2"; ?????????????????
    }*/

    public void setid(int id){
        this.id = id;
    }

    public int getid(){
        return id;
    }

    public void printaId(){
        MyIO.println(getid());
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getnome(){
        return nome;
    }

    public void printaName(/*String x*/){
    
        MyIO.println(getnome());
    }

    public void setKey(String key){
        this.key = key;     
    }

    public String getkey(){
        return key;
    }

    public void printaKey(){
        MyIO.println(getkey());
    }

    public List getArtists(){
        return artist;
    }

    public void setArtists(List artist){
        this.artist = artist;
    }

    public void printaArtists(){
       // MyIO.println(getArtists()); ????????????????????
    }

    public Date getDate(){
        return release_date;
    }

    public void setDate(Date release_date){
        this.release_date = release_date;
    }

    public void printaDate(){
       getDate();
    }


    public double getAcousticness(){
        return acousticness;
    }

    public void setAcousticness(Double acousticness){
        this.acousticness = acousticness;
    }

    public void printaAcousticness(){
        MyIO.println(getAcousticness());
    }

    public double getDanceability(){
        return danceability;
    }

    public void setDanceability(double danceability){
        this.danceability = danceability;
    }

    public void printaDanceability(){
        MyIO.println(getDanceability());
    }

    public double getEnergy(){
        return energy;
    }

    public void setEnergy(double energy){
        this.energy = energy;
    }

    public void printaEnergy(){
        MyIO.println(getEnergy());
    }

    public int getDuration(){
        return duration_ms;
    }

    public void setDuration(int duration_ms){
        this.duration_ms = duration_ms;
    }

    public void printaDuration(){
        MyIO.println(getDuration());
    }

    public double getInstrumentalness(){
        return instrumentalness;
    }

    public void setInstrumentalness(double instrumentalness){
        this.instrumentalness = instrumentalness;
    }

    public void printaInstrumentalness(){
        MyIO.println(getInstrumentalness());
    }

    public double getValence(){
        return valence;
    }

    public void setValence(double valence){
        this.valence = valence;
    }

    public void printaValence(){
        MyIO.println(getValence());
    }

    public int getPopularity(){
        return popularity;
    }

    public void setPopularity(int popularity){
        this.popularity = popularity;
    }
    
    public void printaPopularity(){
        MyIO.println(getPopularity());
    }
    public float getTempo(){
        return tempo;
    }

    public void setTempo(float tempo){
        this.tempo = tempo;
    }

    public void printaTempo(){
        MyIO.println(getTempo());
    }

    public double getLiveness(){
        return liveness;
    }

    public void setLiveness(double liveness){
        this.liveness = liveness;
    }

    public void printaLiveness(){
        MyIO.println(getLiveness());
    }

    public double getLoudness(){
        return loudness;
    }

    public void setLoudness(double loudness){
        this.loudness = loudness;
    }

    public void printaLoudness(){
        MyIO.println(getLoudness());
    }

    public double getSpeachiness(){
        return speechiness;
    }

    public void setSpeachiness(double speechiness){
        this.speechiness = speechiness;
    }

    public void printaSpeachiness(){
        MyIO.println(getSpeachiness());
    }

    public int getYear(){
        return year;
    }

    public void setYear(int year){
        this.year = year;
    }

    public void printaYear(){
        MyIO.println(getYear());
    }

    public void imprime_tudo(){
        MyIO.println(getid());
        MyIO.println(getnome());
        MyIO.println(getkey());
        //MyIO.println(getArtists());
        MyIO.println(getAcousticness());
        MyIO.println(getDanceability());
        MyIO.println(getDuration());
        MyIO.println(getInstrumentalness());
        MyIO.println(getValence());
        MyIO.println(getPopularity());
        MyIO.println(getTempo());
        MyIO.println(getLiveness());
        MyIO.println(getLoudness());
        MyIO.println(getSpeachiness());
        MyIO.println(getYear());
    }


}

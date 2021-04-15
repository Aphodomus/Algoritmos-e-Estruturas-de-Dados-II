#include   <stdio.h> //      Para entradas e saidas
#include  <stdlib.h> //      Para alocacao dinamica
#include  <string.h> // para manipulacao de strings
#include <stdbool.h> //   para definicoes booleanas
#include <math.h>

#define FILE_LENGTH 170625

typedef char* String;

//definindo struct Musica
typedef
struct Musica{
    // Atributos
    char                id[30];
    char             nome[300];
    char               key[30];
    char          artists[600];
    char     realease_date[10];
    double     acousticness;
    double     danceability;
    double instrumentalness;
    double          valence;
    double           energy;
    double       popularity;
    float             tempo;
    double         liveness;
    double         loudness;
    double      speechiness;
    int                year;
    int         duration_ms;
}Musica;


// ---------Metodos e funcoes-----------



/**
 * Inicializa os atributos de uma musica
 * 
 * @param *musica, recebe um endereco de musica
 * 
*/
Musica inicializarMusica () {
    Musica m1;

    strcpy(m1.id, "");
    strcpy(m1.nome, "");
    strcpy(m1.key, "");
    strcpy(m1.artists, "");
    strcpy(m1.realease_date, "");
    m1.acousticness = 0.0;
    m1.danceability = 0.0;
    m1.energy = 0.0;
    m1.duration_ms = 0;
    m1.instrumentalness = 0.0;
    m1.valence = 0.0;
    m1.popularity = 0;
    m1.tempo = 0.0;
    m1.liveness = 0.0;
    m1.loudness = 0.0;
    m1.speechiness = 0.0;
    m1.year = 0;
    
    return m1;
}

// Imprimindo os atributos da instância
void imprimir(Musica* musica) {
    printf("%s ## %s ## %s ## %s ## %g ## %g ## %g ## %g ## %g ## %g ## %g ## %d\n",
    musica->id, musica->artists, musica->nome, musica->realease_date, musica->acousticness, 
    musica->danceability, musica->instrumentalness, musica->liveness, musica->loudness, musica->speechiness, 
    musica->energy, musica->duration_ms);
}

String inicializarString(){
    String str = (String) calloc(1000, sizeof(char));
    return str;
}
String inicializarID(){
    String str = (String) calloc(22, sizeof(char));
    return str;
}
String inicializarStringCortes(){
    String str = (String) calloc(200, sizeof(char));
    return str;
}

int toNumber(char c){
    return (int)c - 48;
}

int toInt(String number){
    int resp = 0;
    int i = 0;
    int sinal = 1;
    if(number[0] == '-'){
        sinal = -1;
        i++;
    }

    while(i < strlen(number)){
        resp += (toNumber(number[i])*(pow(10, (strlen(number) - 1 - i))));
        i++;
    }
    
    return sinal*resp;
}

void separarNumberReal(String number, String amplitude[]){
    int j = 0;
    int i = 0;
    int k = 0;
    amplitude[0] = inicializarString();
    amplitude[1] = inicializarString();

    while(i < strlen(number)) {
        if(number[i] != '.'){
            amplitude[j][k] = number[i];
            k++;
        }else{
            j++;
            k = 0;
        }

        i++;
    }
}

double toDouble(String number){
    int parte_inteira = 0;
    int sinal = 1;
    double parte_fracionaria = 0.0;


    String amplitude[2];
    separarNumberReal(number, amplitude);

    if(strcmp(amplitude[0],"") != 0){
        parte_inteira += toInt(amplitude[0]);
    }

    if(parte_inteira<0){
        sinal = -1;
    }

    if(strcmp(amplitude[1],"") != 0){
        for (int i = 0; i < strlen(amplitude[1]); i++) {
            parte_fracionaria += (double)(toNumber(amplitude[1][i])*(pow(10, -(i+1))));
        }
    }

    return ((double)parte_inteira + parte_fracionaria*sinal);
}

float toFloat(String number){
    int parte_inteira = 0;
    double parte_fracionaria = 0.0f;

    String amplitude[2];
    separarNumberReal(number, amplitude);

    if(strcmp(amplitude[0],"") != 0){
        parte_inteira += toInt(amplitude[0]);
    }

    if(strcmp(amplitude[1],"") != 0){
        for (int i = 0; i < strlen(amplitude[1]); i++) {
            parte_fracionaria += (float)(toNumber(amplitude[1][i])*(pow(10, -(i+1))));
        }
    }

    return ((float)parte_inteira + parte_fracionaria);
}

//void atribuirMusicas(Musica *musica, String atributos[]){
void atribuirMusicas(Musica *musica, char** atributos){


    strcpy(musica->id, atributos[8]);
    strcpy(musica->nome, atributos[14]);
    strcpy(musica->key, atributos[10]);
    strcpy(musica->artists, atributos[3]);
    strcpy(musica->realease_date, atributos[16]);

    musica->acousticness     =     toDouble(atributos[2]);
    musica->danceability     =     toDouble(atributos[4]);
    musica->duration_ms      =      toInt(atributos[5]);
    musica->energy           =     toDouble(atributos[6]);
    musica->instrumentalness =     toDouble(atributos[9]);
    musica->liveness         =     toDouble(atributos[11]);
    musica->loudness         =     toDouble(atributos[12]);
    musica->speechiness      =    toDouble(atributos[17]);
}


String atribuirString(char s[]){
    String s_pointer = inicializarString();
    
    for (size_t i = 0; i < strlen(s); i++) {
        s_pointer[i] = s[i]; 
    }
    
    return s_pointer;
}


void zerarSplits(String splits[]){
    for (size_t i = 0; i < 24; i++){
        splits[i] = inicializarString(); 
    }
}

int lerIds(String id[]){
    int i = 0;
    int k = 0;
    char aux[23];  

    for (size_t i = 0; i < 300;i++){
        id[i] = inicializarID();
    }

    scanf("%s", &aux[0]);

    while(strcmp(aux, "FIM") != 0){
        id[i] = atribuirString(aux);
        i++;
        k++;
        scanf("%s", &aux[0]); // alternativa ==> fgets(variavel, tamanho, stdin);
    }
    
    return k;
}

String tratarDado(String dado){
    char* dado_tratado = inicializarString();
    int j = 0;
    
    for (int i = 0; i < strlen(dado); i++){
        if(dado[i] == '\"'){
            i++;
            
            if (dado[i] == '[') {
                while(dado[i] != '\"'){
                    if (dado[i] != '\'') {
                        dado_tratado[j] = dado[i];
                        j++;
                    }

                    i++;
                }
            } else {
                while(dado[i] != '\"'){
                    dado_tratado[j] = dado[i];
                    j++;    
                    i++;
                }
            }
        } else if(dado[i] == '['){
            while(dado[i] != ']'){
                if(dado[i] != '\''){
                    dado_tratado[j] = dado[i];
                    j++;    
                }
                
                i++;
            }

            dado_tratado[j] = dado[i];
            j++;   
        } else if(dado[i] == ','){
            dado_tratado[j] = ';';
            j++; 
        } else {
            dado_tratado[j] = dado[i];
            j++;
        }
    }
    
    return dado_tratado;
}

void zerarLinhas(char s[]){
    for (size_t i = 0; i < strlen(s); i++){
        s[i] = '\0';
    }
}

void swap(Musica *x, Musica *y)
{
    Musica* temp = x;
    x = y;
    y = temp;
}
  
void selectionSort(Musica** arr, int n, int i, int j, int min_idx)
{ 
    // One by one move boundary of unsorted subarray
    if(i < n-1)
    {
        // Find the minimum element in unsorted array
        min_idx = i;
        for (j = i+1; j < n; j++)
          if (arr[j] < arr[min_idx])
            min_idx = j;
  
        // Swap the found minimum element with the first element
        swap(arr[min_idx], arr[i]);
        selectionSort(arr, n, i++, j, min_idx);
    }
}

void lerDados(String ids[], int cont_ids){
    FILE *fp = fopen("data.csv", "r");
    
    char linha[1000];
    
    String arquivo = inicializarString();
    String arquivo_new = inicializarString();
    String* arquivo_final = (String*) calloc(1000, sizeof(char*));

    String splits[19];

    zerarSplits(splits);
    
    Musica **musicas = (Musica**) malloc(FILE_LENGTH*sizeof(Musica));
    Musica **musicas_resp = (Musica**) malloc(cont_ids*sizeof(Musica)); 
    
    int i = 0;

    arquivo = fgets(linha, 1000, fp);

    for (int i = 0; i < FILE_LENGTH; i++){
        //split(tratarDado(arquivo), splits);
        arquivo_new = inicializarString();
        arquivo     = inicializarString();
       
        arquivo = fgets(linha, 1000, fp);
        arquivo = tratarDado(arquivo);
        
        arquivo_new = strtok(arquivo, ";");

        //Colocar os dados quebrados em um array de char
        int w = 0;
        while (arquivo_new != NULL) { 
            arquivo_final[w++] = arquivo_new;
            arquivo_new = strtok(NULL, ";");
        }
        
        *musicas[i] = inicializarMusica();
        atribuirMusicas(musicas[i], arquivo_final);
        // //zerarSplits(splits);
        // zerarLinhas(linha);
    }

    for (size_t i = 0; i < cont_ids; i++){
        for (size_t j = 0; j < FILE_LENGTH; j++){
            if(strcmp(musicas[j]->id, ids[i]) == 0){
                musicas_resp[i] = musicas[j];
            }
        }
    }

    selectionSort(musicas_resp, cont_ids, 0, 0, 0);
    
    for (size_t i = 0; i < cont_ids; i++){
        imprimir(musicas_resp[i]);
    }

    fclose(fp);
}

int main(){
    
    String ids[310];
    int count_ids = lerIds(ids);
    lerDados(ids, count_ids);

    return 0;
}
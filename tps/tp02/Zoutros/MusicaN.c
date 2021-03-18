#include   <stdio.h> //      Para entradas e saidas
#include  <stdlib.h> //      Para alocacao dinamica
#include  <string.h> // para manipulacao de strings
#include <stdbool.h> //   para definicoes booleanas

typedef char* String;

//definindo struct Musica
typedef
struct Musica{
    // Atributos
    String                id;
    String              nome;
    String               key;
    String           artists;
    String     realease_Date;
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
}Musica;


// ---------Metodos e funcoes-----------

/**
 * Inicializa os atributos de uma musica
 * 
 * @param *musica, recebe um endereco de musica
 * 
*/
void imprimirMusica(Musica *musica){
    printf("%s\n",musica->id);
    printf("%s\n",musica->nome);
    printf("%s\n",musica->key );
    printf("%s\n",musica->artists);
    printf("%s\n",musica->realease_Date);
    printf("%8lf",musica->acousticness);
    printf("%8lf",musica->danceability);
    printf("%8lf",musica->instrumentalness);
    printf("%8lf",musica->valence);
    printf("%8lf",musica->energy);
    printf("%8lf",musica->popularity);
    printf("%8f",musica->tempo);
    printf("%8lf",musica->liveness);
    printf("%8lf",musica->loudness);
    printf("%8lf",musica->speechiness);
    printf("%8d",musica->year); 
}


/**
 * Inicializa os atributos de uma musica
 * 
 * @param *musica, recebe um endereco de musica
 * 
*/
Musica* inicializarMusica(){
    Musica *musica = (Musica*) malloc(sizeof(Musica));
    
    musica->id               =  (String) calloc(100, sizeof(char));
    musica->nome             =  (String) calloc(100, sizeof(char));
    musica->key              =  (String) calloc(100, sizeof(char));
    musica->artists          =  (String) calloc(100, sizeof(char));
    musica->realease_Date    =  (String) calloc(100, sizeof(char));
    musica->acousticness     =                                 0.0;
    musica->danceability     =                                 0.0;
    musica->instrumentalness =                                 0.0;
    musica->valence          =                                 0.0;
    musica->energy           =                                 0.0;
    musica->popularity       =                                 0.0;
    musica->tempo            =                                0.0f;
    musica->liveness         =                                 0.0;
    musica->loudness         =                                 0.0;
    musica->speechiness      =                                 0.0;
    musica->year             =                                   0;  

    return musica;
}

String inicializarString(){
    String str = (String) calloc(1000, sizeof(char));
    return str;
}

String atribuirString(char s[]){
    String s_pointer = inicializarString();
    
    for (size_t i = 0; i < strlen(s); i++) {
        s_pointer[i] = s[i]; 
    }
    
    return s_pointer;
}

int lerIds(String id[]){
    int i = 0;
    int k = 0;
    char aux[23];  

    for (size_t i = 0; i < 300;i++){
        id[i] = inicializarString();
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

/*
2q95XoeFGixx8b5LNF6Ey1 ## [Pitbull, Flo Rida, LunchMoney Lewis] ## Greenlight (feat. Flo Rida & LunchMoney Lewis) ## 22/07/2016 ## 0.245 ## 0.695 ## 0.0 ## 0.3670000000000001 ## -5.617000000000001 ## 0.281 ## 0.8370000000000001 ## 244174
*/

int split(String dado_tratado, String splits[]){
    String dado_split = inicializarString();

    int k   = 0;
    int j   = 0;
    int i   = 0;

    while(j < strlen(dado_tratado)){
        k = 0;

        while(dado_tratado[j] != ';' && j < strlen(dado_tratado)){
            dado_split[k] = dado_tratado[j];
            j++;
            k++;
        }

        j++;

        splits[i] = atribuirString(dado_split);
        dado_split = inicializarString();
        i++;
    }

    //retornando a quantidade de cortes
    return i;
}

// String tratarRealeaseDate(String data){
//     String data_ptbr = inicializarString();
//     int i = 0;
//     int k = strlen(data);
//     while(i < 8){
//         while(data[]){

//         }

//     }

//     //retornando a quantidade de cortes
//     return i;
// }
/*
String tratarDado(String dado){
    String dado_tratado = inicializarString();
    int j = 0;
    
    for (size_t i = 0; i < strlen(dado); i++){
        if(dado[i] == '['){
            i++;
            while(dado[i] != ']'){
                if(dado[i] != '\''){
                    dado_tratado[j] = dado[i];
                    j++;    
                }
                
                i++;
            }

            dado_tratado[j] = dado[i];
            j++;

        }else if(dado[i] == ','){
            dado_tratado[j] = ';';
            j++;    
        }else{
            dado_tratado[j] = dado[i];
            j++;
        }
    }
    printf("%s\n", dado_tratado);
    return dado_tratado;
}
*/
/*
String tratarDado(String data){
    String data_process = defineMemoryForString();
    int j = 0;
    
    for (int i = 0; i < strlen(data); i++){
        if(data[i] == '\"'){
            if (data[i+1] == '[') {
                i++;
                while(data[i] != ']'){
                    if(data[i] != '\''){
                        data_process[j] = data[i];
                        j++;    
                    }
                    
                    i++;
                }

                data_process[j] = data[i];
                j++;   
            } else {
                while(data[i] != '\"'){
                    data_process[j] = data[i];
                    j++;    
                    i++;
                }
            }
             
        } else if(data[i] == '['){
            while(data[i] != ']'){
                if(data[i] != '\''){
                    data_process[j] = data[i];
                    j++;    
                }
                
                i++;
            }

            data_process[j] = data[i];
            j++;   
        } else if(data[i] == ','){
            data_process[j] = ';';
            j++; 
        } else {
            data_process[j] = data[i];
            j++;
        }
    }
    
    return data_process;
}
*/

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

// void lerDados(String ids[]){
//     FILE *fp = fopen("tmp/data.csv", "wr");
//     String arquivo;
//     int i = 0;

//     while(feof(fp) != 0){
//         if(id[i] == fgets(arquivo, ))
//     }

//     fclose(fp);
// }

char* organizeDate(char* string) {
    char* novaData1 = inicializarString();
    char* novaData2 = inicializarString();
    char* resp = inicializarString();
    const char delimeter[4] = "-";

    if (strlen(string) > 5) {
        char** dateFinal = (char**) malloc(1000 * sizeof(char*));
        char* tmp = (char*) malloc(100 * sizeof(char));
        tmp = strtok(string, delimeter);

        int w = 0;
        while (tmp != NULL) { 
            dateFinal[w++] = tmp;
            tmp = strtok(NULL, delimeter);
        }

        strcat(resp, dateFinal[2]);
        strcat(resp, "/");
        strcat(resp, dateFinal[1]);
        strcat(resp, "/");
        strcat(resp, dateFinal[0]);
        
        return resp;
    } else {
        strcpy(novaData2, "01/01/");
        int len = strlen(novaData2);
        int j = 0;
        for (int i = 0; i < strlen(string); i++) {
            novaData2[len + j] = string[i];
            j++;
        }
        return novaData2;
    }
}

int main(){
    Musica* musicas[200];

    //======== teste 01 - alocando e imprimindo atributo das músicas -> [OK]=====
    // for (size_t i = 0; i < 200; i++){
    //     musicas[i] = inicializarMusica();
    //     imprimirMusica(musicas[i]);
    // }
    
    //======== teste 02 - alocando e lendo IDs (manualmente) -> [OK]=====
    // String id[200];
    // int entradas = lerIds(id);

    //======== teste 03 - alocando e lendo IDs (redirecionamento de arquivo) -> [OK]=====
    // String id[300];
    // int entradas = lerIds(id);
    // for (size_t i = 0; i < 300; i++){
    //     printf("%s\n", id[i]);
    // }
    
    //======== teste 04 - ler e tratar os dados (manualmente)-> [OK]=====
    // String dado = inicializarString();
    // String dado_tratado = inicializarString();
   
    // scanf("%[^\n]%*c", dado);
    // dado_tratado = tratarDado(dado); 
    // printf("\n%s\n", dado_tratado);

    //======== teste 05 - ler, tratar e alocar string na split (manualmente)-> [OK]=====
    String dado = inicializarString();
    String dado_tratado = inicializarString();
    String s_split[19];
    char* dateOrganized = (char*) malloc(1000 * sizeof(char));

    scanf("%[^\n]%*c", dado);
    dado_tratado = tratarDado(dado);

    int cortes = split(dado_tratado, s_split); 

    for (int i = 0; i < cortes; i++){
        printf("\n%d: %s\n", i, s_split[i]);
    }

    dateOrganized = s_split[16];
    dateOrganized = organizeDate(dateOrganized);
    strcpy(s_split[16], dateOrganized);
    
    for (int i = 0; i < cortes; i++){
        printf("\n%d: %s\n", i, s_split[i]);
    }

    free(dateOrganized);



    return 0;
}
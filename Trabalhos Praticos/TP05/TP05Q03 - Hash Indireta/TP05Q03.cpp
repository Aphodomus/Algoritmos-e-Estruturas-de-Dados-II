#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <assert.h>
#include <time.h>
#include <math.h>
#define FILE_LENGTH 170625
#define MAX_ID 30
#define MAX_NOME 300
#define MAX_KEY 30
#define MAX_REALEASE_DATE 10
#define MAX_ARTISTS 600
#define MAX_CHARS 300
static int comparisons = 0;
static int moves = 0;

//------------------------------------------------------------- Definindo struct Musica e metodos ------------------------------------------

typedef struct Musica Musica;
struct Musica {
    //Atributos
    char id[MAX_ID];
    char nome[MAX_NOME];
    char key[MAX_KEY];
    char artists[MAX_ARTISTS];
    char realease_date[MAX_REALEASE_DATE];
    double acousticness;
    double danceability;
    double energy;
    int duration_ms;
    double instrumentalness;
    double valence;
    int popularity;
    float tempo;
    double liveness;
    double loudness;
    double speechiness;
    int year;
};

//Clone
Musica clone(Musica *musica) {
    Musica tmp;

    strcpy(tmp.id, musica->id);
    strcpy(tmp.nome, musica->nome);
    strcpy(tmp.key, musica->key);
    strcpy(tmp.artists, musica->artists);
    strcpy(tmp.realease_date, musica->realease_date);
    tmp.acousticness = musica->acousticness;
    tmp.danceability = musica->danceability;
    tmp.energy = musica->energy;
    tmp.duration_ms = musica->duration_ms;
    tmp.instrumentalness = musica->instrumentalness;
    tmp.valence = musica->valence;
    tmp.popularity = musica->popularity;
    tmp.tempo = musica->tempo;
    tmp.liveness = musica->liveness;
    tmp.loudness = musica->loudness;
    tmp.speechiness = musica->speechiness;
    tmp.year = musica->year;

    return tmp;
}

void cloneEntrePonteiros(Musica *tmp, Musica *musica2) {
    strcpy(tmp->id, musica2->id);
    strcpy(tmp->nome, musica2->nome);
    strcpy(tmp->key, musica2->key);
    strcpy(tmp->artists, musica2->artists);
    strcpy(tmp->realease_date, musica2->realease_date);
    tmp->acousticness = musica2->acousticness;
    tmp->danceability = musica2->danceability;
    tmp->energy = musica2->energy;
    tmp->duration_ms = musica2->duration_ms;
    tmp->instrumentalness = musica2->instrumentalness;
    tmp->valence = musica2->valence;
    tmp->popularity = musica2->popularity;
    tmp->tempo = musica2->tempo;
    tmp->liveness = musica2->liveness;
    tmp->loudness = musica2->loudness;
    tmp->speechiness = musica2->speechiness;
    tmp->year = musica2->year;
}

//Clone que retorna um ponteiro de musica
Musica* clonePonteiro(Musica musica) {
    Musica *tmp = (Musica*) malloc(sizeof(Musica)); // Lembrar do malloc

    strcpy(tmp->id, musica.id);
    strcpy(tmp->nome, musica.nome);
    strcpy(tmp->key, musica.key);
    strcpy(tmp->artists, musica.artists);
    strcpy(tmp->realease_date, musica.realease_date);
    tmp->acousticness = musica.acousticness;
    tmp->danceability = musica.danceability;
    tmp->energy = musica.energy;
    tmp->duration_ms = musica.duration_ms;
    tmp->instrumentalness = musica.instrumentalness;
    tmp->valence = musica.valence;
    tmp->popularity = musica.popularity;
    tmp->tempo = musica.tempo;
    tmp->liveness = musica.liveness;
    tmp->loudness = musica.loudness;
    tmp->speechiness = musica.speechiness;
    tmp->year = musica.year;

    return tmp;
}

//Transformar dado recebido em double
double toDouble(char* str) {
   double result = 0.00;
   result = strtod(str, NULL);
   
   return result;
}

//Ler os dados recebidos e atribuir eles nas estruturas, cada valor na sua respectiva posicao
void ler(char** data, Musica *musica) {
    strcpy(musica->id, data[8]);
    strcpy(musica->nome, data[14]);
    strcpy(musica->key, data[10]);
    strcpy(musica->artists, data[3]);
    strcpy(musica->realease_date, data[16]);
    musica->acousticness = atof(data[2]);
    musica->danceability = atof(data[4]);
    musica->energy = atof(data[6]);
    musica->duration_ms = atoi(data[5]);
    musica->instrumentalness = atof(data[9]);
    musica->valence = atof(data[0]);
    musica->popularity = atoi(data[15]);
    musica->tempo = atof(data[18]);
    musica->liveness = atof(data[11]);
    musica->loudness = atof(data[12]);
    musica->speechiness = atof(data[17]);
    musica->year = atoi(data[1]);
}

//Construtor da Musica, inicializando com valores padrao
Musica new_Musica () {
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

//Construtor da Musica, inicializando com valores definidos pelo programador
Musica new_Musica_two (char id[], char nome[], char key[], char artists[], char realease_date[], double acousticness, double danceability, double energy, int duration_ms, double instrumentalness, double valence, int popularity, float tempo, double liveness, double loudness, double speechiness, int year) {
    Musica m1;

    strcpy(m1.id, id);
    strcpy(m1.nome, nome);
    strcpy(m1.key, key);
    strcpy(m1.artists, artists);
    strcpy(m1.realease_date, realease_date);
    m1.acousticness = acousticness;
    m1.danceability = danceability;
    m1.energy = energy;
    m1.duration_ms = duration_ms;
    m1.instrumentalness = instrumentalness;
    m1.valence = valence;
    m1.popularity = popularity;
    m1.tempo = tempo;
    m1.liveness = liveness;
    m1.loudness = loudness;
    m1.speechiness = speechiness;
    m1.year = year;
    
    return m1;
}

//Faz um malloc para armazenar espaco na memoria
char* defineMemoryForString(){
    char* string = (char*) calloc(1000, sizeof(char));

    return string;
}

//Formatar a data
char* organizeDate(char* string) {
    char* novaData1 = defineMemoryForString();
    char* novaData2 = defineMemoryForString();
    char* resp = defineMemoryForString();
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

        free(dateFinal);
        free(tmp);
        
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

//Imprimir na tela os dados requiridos
void imprimir(Musica *musica) {
    char* dateOrganized = (char*) malloc(1000 * sizeof(char));

    printf("%s ## ", (*musica).id);
    printf("%s ## ", (*musica).artists);
    printf("%s ## ", (*musica).nome);

    //Tratar a data da Musica
    dateOrganized = (*musica).realease_date;
    dateOrganized = organizeDate(dateOrganized);
    strcpy((*musica).realease_date, dateOrganized);

    printf("%s ## ", (*musica).realease_date);
    printf("%G ## ", (*musica).acousticness);
    printf("%G ## ", (*musica).danceability);
    printf("%G ## ", (*musica).instrumentalness);
    printf("%G ## ", (*musica).liveness);
    printf("%G ## ", (*musica).loudness);
    printf("%G ## ", (*musica).speechiness);
    printf("%G ## ", (*musica).energy);
    printf("%d \n", (*musica).duration_ms);
    
}

//------------------------------------------------------------- Metodos e funcoes da Lista Simples e Hash -------------------------
typedef struct Celula {
    Musica elemento;
    struct Celula *prox;
} Celula;

Celula* new_celula(Musica *elemento) {
    Celula *temp = (Celula*)malloc(sizeof(Celula));
    temp->elemento = *elemento;
    temp->prox = NULL;
    return temp;
}

typedef struct ListaSimples {
    struct Celula *primeiro, *ultimo;
} ListaSimples;

ListaSimples* new_lista_simples() {
    Musica music = new_Musica();

    ListaSimples *lista = (ListaSimples*)malloc(sizeof(ListaSimples));
    lista->primeiro = new_celula(&music);
    lista->ultimo = lista->primeiro;

    return lista;
}

void inserir(ListaSimples *lista, Musica *elemento) {
    lista->ultimo->prox = new_celula(elemento);
    lista->ultimo = lista->ultimo->prox;
}

bool pesquisar(ListaSimples *lista, Musica *elemento) {
    bool resp = false;

    for (Celula *i = lista->primeiro; i != NULL && resp != true; i = i->prox) {
        comparisons++;
        if (strcmp(i->elemento.id, elemento->id) == 0) {
            resp = true;  
        }
    }

    return resp;
}

typedef struct Hash {
    struct ListaSimples **tabela;
    int tamanho;
} Hash;

Hash* new_hash(Hash *hash, int tamanho) {

    hash->tabela = (ListaSimples**)malloc(tamanho * sizeof(ListaSimples*));
    hash->tamanho = tamanho;

    for (int i = 0; i < tamanho; i++) {
        hash->tabela[i] = new_lista_simples();
    }

    return hash;
}

int hash_function(Hash *hash, Musica *elemento) {
    return elemento->duration_ms % hash->tamanho;
}

void inserirHash(Hash *hash, Musica *elemento) {
    comparisons++;
    if (elemento->duration_ms != 0) {
        int posicao = hash_function(hash, elemento);
        inserir(hash->tabela[posicao], elemento);
    } else {
        printf("Nao e possivel inserir uma musica vazia");
    }
}

void mostrarHash(Hash *hash) {
    for (int i = 0; i < hash->tamanho; i++) {
        for (Celula *j = hash->tabela[i]->primeiro->prox; j != NULL; j = j->prox) {
            printf("tabela [%d] | id = %s\n", i, j->elemento.id);
        }
    }
}

bool pesquisarHash(Hash *hash, Musica musica) {
    bool resp = false;

    comparisons++;
    if (musica.duration_ms != 0) {
        int posicao = hash_function(hash, &musica);

        resp = pesquisar(hash->tabela[posicao], &musica);
    }
    
    return resp;
}

//------------------------------------------------------------- Metodos e funcoes utilizados na questao -------------------------

//Limpar caracteres inuteis na string
void cleanString(char* string) {
    for (int i = 0; i < strlen(string); i++) {
        if (string[i] == '\'' || string[i] == '\"') {
            string[i] = (char) 0;
        }
    }
}

//Processar a linha recebida
char* processData(char* dado){
    char* dado_tratado = defineMemoryForString();
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

//Criar todos os objetos de musica
Musica* createAllObject() {
    FILE* file = fopen("/tmp/data.csv", "r");
    char linha[1000];
    char* data = defineMemoryForString();
    char* dataTreated = (char*) malloc(1000 * sizeof(char));
    char** dataTreatedFinal = (char**) malloc(1000 * sizeof(char*));
    char* dateOrganized = (char*) malloc(1000 * sizeof(char));
    char* dado_pre_tratado = (char*) malloc(1000 * sizeof(char));
    Musica *m = (Musica*) malloc(FILE_LENGTH * sizeof(Musica));
    const char delimeter[4] = ";"; 
    int w = 0;
    int i = 0;

    //Ler a primeira linha e descartar
    data = fgets(linha, 1000, file);

    while (!feof(file) && i < FILE_LENGTH) {
        //Ler as linhas do arquivo
        data = fgets(linha, 1000, file);
        
        //Tratar os dados, e coloca-los em uma linha
        dado_pre_tratado = processData(data);

        //Quebrar o dado pre tratado em partes, de acordo com um delimitador
        dataTreated = strtok(dado_pre_tratado, delimeter);

        //Colocar os dados quebrados em um array de char
        w = 0;
        while (dataTreated != NULL) { 
            dataTreatedFinal[w++] = dataTreated;
            dataTreated = strtok(NULL, delimeter);
        }
        
        //"Construtor" da struct, que define o valor padrao
        m[i] = new_Musica();

        // //Ler os dados do array de char e armazenar na struct
        ler(dataTreatedFinal, &m[i]);

        i++;
    }

    //Liberar espaco na memoria utilizado
    free(dataTreated);
    free(dado_pre_tratado);
    free(dateOrganized);
    free(dataTreatedFinal);

    fclose(file);

    return m;
}

//Metodo para verificar se a linha lida e igual a FIM
bool isFim(char palavra[]) {
    if (palavra[0] == 'F' && palavra[1] == 'I' && palavra[2] == 'M') {
        return true;
    }
    return false;
}

//Criar o log
void createLog(clock_t inicio, clock_t fim) {
    FILE* arquivo = fopen("matricula_hashIndireta.txt", "w");

    double resultado = ((fim - inicio) / (double)CLOCKS_PER_SEC);

    fprintf(arquivo, "Matricula: 716417\tTempo: %lfs\tComparacoes: %d\tMovimentos: %d", resultado, comparisons, moves);

    fclose(arquivo);
}

//Inverter a data
char* getRealeaseDateInverted(char* data) {
    char* finalData = defineMemoryForString();
    const char delimeter[4] = "/";

    char* dataTreated = (char*) malloc(20 * sizeof(char));
    char** temp1 = (char**) malloc(3 * sizeof(char*));

    dataTreated = strtok(data, delimeter);

    int w = 0;
    while (dataTreated != NULL) {
        temp1[w++] = dataTreated;
        dataTreated = strtok(NULL, delimeter);
    }

    strcat(finalData, temp1[2]);
    strcat(finalData, "/");
    strcat(finalData, temp1[1]);
    strcat(finalData, "/");
    strcat(finalData, temp1[0]);

    return finalData;
}

// Procurar pelos ids e adicionar na arvore
void searchIdAndReturnHashList(Musica *musica, Hash *hash, char id[][30], int numEntrada, Musica *output2, char id2[][30], int numEntrada2) {
    bool achou = false;
    int w = 0;

    for (int k = 0; k < numEntrada; k++) {
        for (int j = 0; j < FILE_LENGTH && achou == false; j++) {
            comparisons++;
            if (strcmp(musica[j].id, id[k]) == 0) {
                inserirHash(hash, &musica[j]);
                achou = true;
            }
        }
        achou = false;
    }

    for (int k = 0; k < numEntrada2; k++) {
        for (int j = 0; j < FILE_LENGTH && achou == false; j++) {
            comparisons++;
            if (strcmp(musica[j].id, id2[k]) == 0) {
                output2[w] = clone(&musica[j]);
                achou = true;
                w++;
            }
        }
        achou = false;
    }
}

int main() {
    //Iniciando o cronometro
    clock_t inicio, fim;
    char entrada[MAX_CHARS][30];
    char entrada2[MAX_CHARS][30];
    int i = -1;
    int j = -1;
    int contador = 0;
    int quantidadeMusica = 120;
    int quantidade = 0;

    //Criando todos os objetos do tipo musica
    Musica *musica = (Musica*) malloc(FILE_LENGTH * sizeof(Musica));
    musica = createAllObject();

    //Lendo a primeira parte da entrada
    do {
        i++;
        scanf("%s", entrada[i]); 
    } while (!isFim(entrada[i]));

    //Lendo a segunda parte da entrada
    do {
        j++;
        scanf("%s", entrada2[j]); 
    } while (!isFim(entrada2[j]));

    //Iniciando o cronometro
    inicio = clock();

    //Declarando a hash de listas
    Hash *hash;
    hash = (Hash*)malloc(sizeof(Hash));

    //Construtor da fila circular flexivel
    hash = new_hash(hash, 25);

    //Procurar os ids desejados e adicionar na arvore
    Musica *output2 = (Musica*) malloc(j * sizeof(Musica)); //Local onde vai armazenar as musicas da entrada2
    searchIdAndReturnHashList(musica, hash, entrada, i, output2, entrada2, j);

    //mostrarHash(hash);

    //Fazer a pesquisa e printar a resposta e o caminho percorrido
    for (int k = 0; k < j; k++) {
        printf("%s", output2[k].id);
        if (pesquisarHash(hash, output2[k]) == true) {
            printf(" SIM\n");
        } else {
            printf(" NAO\n");
        }
    }

    //Finalizando o cronometro
    fim = clock();

    //Criar o log e liberar espaco de memoria
    createLog(inicio, fim);
    free(musica);
    free(hash);

    return 0;
}
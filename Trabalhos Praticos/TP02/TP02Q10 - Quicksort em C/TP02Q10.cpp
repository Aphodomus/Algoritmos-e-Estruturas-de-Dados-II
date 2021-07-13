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
#define MAX_CHARS 101
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

//Funcao principal, faz a maioria das coisas para solucionar a questao
void searchIdInFile(char id[][30], int numEntrada) {
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

        //Tratar a data da Musica
        //dateOrganized = dataTreatedFinal[16];
        //dateOrganized = organizeDate(dateOrganized);
        //strcpy(dataTreatedFinal[16], dateOrganized);

        // //Ler os dados do array de char e armazenar na struct
        ler(dataTreatedFinal, &m[i]);

        i++;
    }

    //Procurar pelos ids dentro das structs, e caso encontrar, imprimir os valores pedidos
    for (int k = 0; k < numEntrada; k++) {
        for (int j = 0; j < FILE_LENGTH; j++) {
            if (strcmp(m[j].id, id[k]) == 0) {
                imprimir(&m[j]);
            }
        }
    }

    //Liberar espaco na memoria utilizado
    free(dataTreated);
    free(dado_pre_tratado);
    free(dateOrganized);
    free(dataTreatedFinal);
    free(m);

    fclose(file);
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

//Fazer uma busca por meio da pesquisa binaria
bool binarySearch(char array[][30], char* procurar) {
    bool resp = false;
    int direita = MAX_CHARS - 1;
    int esquerda = 0;
    int meio = 0;

    while (esquerda <= direita) {
        meio = (esquerda + direita) / 2;

        if (strcmp(procurar, array[meio]) >= 0) {
            esquerda = meio + 1;
        } else {
            direita = meio - 1;
        }
        comparisons = comparisons + 2; // Contando comparacoes
    }

    comparisons++;

    if (direita <= MAX_CHARS - 1 && direita >= 0) {
        comparisons = comparisons + 3; // Contando comparacoes
        if (strcmp(array[direita], procurar) == 0) { // Contando comparacoes
            resp = true;
            return resp;
        }
    }
    // Assumindo a saida do if no pior caso
    comparisons = comparisons + 2;

    return resp;
}

//Criar o log
void createLog(clock_t inicio, clock_t fim) {
    FILE* arquivo = fopen("matricula_quicksort.txt", "w");

    double resultado = ((fim - inicio) / (double)CLOCKS_PER_SEC);

    fprintf(arquivo, "Matricula: 716417\tTempo: %lfs\tComparacoes: %d\tMovimentacoes: %d", resultado, comparisons, moves);

    fclose(arquivo);
}

//Procurar pelo id e retornar a musica
Musica* searchIdInReturnArrayMusic(char id[][30], int numEntrada) {
    Musica *m = (Musica*) malloc(FILE_LENGTH * sizeof(Musica));
    Musica *result = (Musica*) malloc(100 * sizeof(Musica));
    m = createAllObject();
    int w = 0;

    for (int k = 0; k < numEntrada; k++) {
        for (int j = 0; j < FILE_LENGTH; j++) {
            if (strcmp(m[j].id, id[k]) == 0) {
                result[w] = m[j];
                w++;
            }
        }
    }

    return result;
}

//Ordenar um array de string por meio do Selecao
void sortBySelection(Musica *music, int n){
    Musica *temp = (Musica*) malloc(1 * sizeof(Musica));
    int menor = 0;
    int comparasionsSelection = 0;

    for (int i = 0; i < (n - 1); i++) {
        menor = i;
        for (int j = (i + 1); j < n; j++){
            if (strcmp(music[menor].nome, music[j].nome) > 0){
                menor = j;
            }
        }

        //Trocar o menor elemento encontrado

        if (menor != i) {
            temp[0] = music[i];
            music[i] = music[menor];
            music[menor] = temp[0];
        }
    }

    moves = 3*(n - 1);
    comparasionsSelection = (int) (pow((n - 1), 2) + (n - 1))/2;
    comparisons = comparisons + comparasionsSelection;
}

//Ordenar um array de string por meio do Selecao Recursiva
void sortBySelectionRecursive(Musica *music, int n, int i) {
    if (i >= n - 1) {
        return;
    }

    int menor = i;

    for (int j = (i + 1); j < n; j++) {
        if (strcmp(music[menor].nome, music[j].nome) > 0) {
            menor = j;
        }
    }

    //Trocar posicao de lugar

    Musica *temp = (Musica*) malloc(1 * sizeof(Musica));
    temp[0] = music[i];
    music[i] = music[menor];
    music[menor] = temp[0];

    //Fazer a chamada recursiva
    sortBySelectionRecursive(music, n, i + 1);

    //Contar o numero de movimentacoes e comparacoes
    int comparasionsSelection = 0;
    moves = 3*(n - 1);
    comparasionsSelection = (int) (pow((n - 1), 2) + (n - 1))/2;
    comparisons = comparisons + comparasionsSelection;
}

//Ordenar um array de string por meio do Shell sort
void insercaoPorCor (Musica *music, int cor, int h, int n) {
    for (int i = (h + cor); i < n; i += h) {
        //Declarar variaveis
        Musica *tmp = (Musica*) malloc(1 * sizeof(Musica));
        tmp[0] = music[i];
        int j = i - h;

        //Fazer a comparacao
        while ((j >= 0) && (strcmp(music[j].id, tmp[0].id) > 0)) {
            comparisons = comparisons + 1;
            moves = moves + 1;
            music[j + h] = music[j];
            j -= h;
        }
        
        //Trocar
        music[j + h] = tmp[0];
        moves = moves + 1;

        //Liberar memoria
        free(tmp);
    }
}

//Ordenar um array de string por meio do Shell sort
void sortByShellSort(Musica *music, int n) {
    int h = 1;

    do {
        h = (h * 3) + 1;
    } while(h < n);

    do {
        h /= 3;
        for (int cor = 0; cor < h; cor++) {
            insercaoPorCor(music, cor, h, n);
        }
    } while (h != 1);
}

//Ordenar um array de string por meio do Quick sort
void ppsortByQuickSort(Musica *music, int esq, int dir) {
    Musica *pivo = (Musica*) malloc(1 * sizeof(Musica));
    pivo[0] = music[(esq + dir) / 2];
    int i = esq, j = dir;
    Musica *tmp = (Musica*) malloc(1 * sizeof(Musica));

    while(i <= j) {
        while (music[i].duration_ms < pivo[0].duration_ms) {
            i++;
        }

        while (music[j].duration_ms > pivo[0].duration_ms) {
            j--;
        }

        if (i <= j) {
            //Trocar
            tmp[0] = music[i];
            music[i] = music[j];
            music[j] = tmp[0];

            i++;
            j--;
        }
    }
    free(pivo);
    if (esq < j) {
        sortByQuickSort(music, esq, j);
    }
    if (i < dir) {
        sortByQuickSort(music, i, dir);
    }
}

int main() {
    //Iniciando o cronometro
    clock_t inicio, fim;
    inicio = clock();
    char entrada[MAX_CHARS][30];
    int i = -1;
    int quantidadeMusica = 100;
    Musica *music = (Musica*) malloc(100 * sizeof(Musica));

    //Lendo a primeira parte da entrada
    do {
        i++;
        scanf("%s", entrada[i]); 
    } while (!isFim(entrada[i]));

    //Procurar as musicas e retornar elas
    music = searchIdInReturnArrayMusic(entrada, i);

    //Ordenando por Selecao
    sortByQuickSort(music, 0, i - 1);

    //Imprimir as informacoes da musica agora ordenada
    
    for (int m = 0; m < 100; m++) {
        imprimir(&music[m]);
    }
    
    //Finalizando o cronometro
    fim = clock();

    createLog(inicio, fim);
    return 0;
}
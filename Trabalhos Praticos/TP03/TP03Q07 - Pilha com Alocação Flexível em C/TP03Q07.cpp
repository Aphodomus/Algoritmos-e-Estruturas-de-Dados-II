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

// Celula, ou "caixinha" para armazenar os "objetos"
typedef struct Celula{
    Musica elemento; // Pode ter erro
    struct Celula *prox;
}Celula;

// Criar uma nova Celula
Celula* new_celula(Musica *elemento){
    Celula *temp = (Celula*)malloc(sizeof(Celula));
    temp->elemento = *elemento; // Pode ter erro
    temp->prox = NULL;
    return temp;
}

/*---------------------------------------------------- Definindo a FilaCircularFlexivel e seus metodos ------------------//*/

// Fila circular flexivel propriamente dita
typedef struct FilaCircularFlexivel {
    struct Celula *primeiro, *ultimo;
    int size;
}FilaCircularFlexivel;

// Construtor para uma nova fila circular flexivel
FilaCircularFlexivel* new_filaCircularFlexivel(FilaCircularFlexivel *filaCircularFlexivel){
    Musica music = new_Musica();
    filaCircularFlexivel->primeiro = new_celula(&music);
    filaCircularFlexivel->ultimo = filaCircularFlexivel->primeiro;
    filaCircularFlexivel->size = 0;

    return filaCircularFlexivel;
}

// Retornar o tamanho da lista simples
int tamanhoFila(FilaCircularFlexivel *fila){
    int tamanho = 0;
    Celula *i;

    for (i = fila->primeiro->prox; i != NULL; i = i->prox) {
        tamanho = tamanho + 1;
    }

    return tamanho;
}

// Inserir uma musica da fila circular flexivel
void inserir(FilaCircularFlexivel *fila, Musica *elemento) {
    fila->ultimo->prox = new_celula(elemento);
    fila->ultimo = fila->ultimo->prox;
    fila->size++;
}

// Remove uma musica da primeira posicao da fila circular, e movimenta os demais elementos para o inicio
Musica remover(FilaCircularFlexivel *fila) {
    Musica vazia = new_Musica();
    // Verificar se a fila esta vazia
    if (fila->primeiro == fila->ultimo){
        printf("\nA fila esta vazia!\n");
        return vazia;
    }

    Celula *temp = fila->primeiro;
    fila->primeiro = fila->primeiro->prox;
    fila->size--;
    free(temp);
    return fila->primeiro->elemento;
}

// Mostra as musicas da fila circular
void mostrarFila(FilaCircularFlexivel *fila) {
    Celula *i;
    printf("[");
    for (i = fila->primeiro->prox; i != NULL; i = i->prox) {
        printf("%s, ", i->elemento.id);
    }
    printf("] \n");
}

// Mostrar media arredondada da duration de todas as musicas da fila circular flexivel
int mediaArredondada(FilaCircularFlexivel *fila) {
    Celula *i;
    double soma = 0;
    int result = 0;
    double contador = 0;

    for (i = fila->primeiro->prox; i != NULL; i = i->prox) {
        soma = soma + (double) i->elemento.duration_ms;
        contador = contador + 1;
    }

    result = (int) round(soma / contador);

    return result;
}

// Deletar fila
void deleteFila(FilaCircularFlexivel *fila) {
    while(fila->size > 0) {
        deleteFila(fila);
    }

    free(fila->primeiro);
}

/*---------------------------------------------------- Definindo a PilhaFlexivel e seus metodos ------------------//*/

// Definindo a estrutura do tipo pilha flexivel
typedef struct PilhaFlexivel {
    struct Celula *topo;
    int size;
} PilhaFlexivel;

// Construtor para inicializar a pilha flexivel
PilhaFlexivel* new_PilhaFlexivel(PilhaFlexivel *pilha) {
    pilha->topo = NULL;
    pilha->size = 0;

    return pilha;
}

// Metodo para retornar o tamanho da pilha flexivel
int tamanhoPilha(PilhaFlexivel *pilha) {
    return pilha->size;
}

// Inserir um elemento na pilha flexivel
void inserirPilha(PilhaFlexivel *pilha, Musica *elemento) {
    Celula *temp = new_celula(elemento);
    temp->prox = pilha->topo;
    pilha->topo = temp;
    pilha->size++;
}

// Remover uma musica da pilha de musicas
Musica removerPilha(PilhaFlexivel *pilha) {
    Musica musica = new_Musica();

    // Verificar se a pilha esta vazia
    if (pilha->topo == NULL) {
        printf("\nA pilha esta vazia !!!\n");
        return musica;
    }

    musica = pilha->topo->elemento;
    Celula *temp = pilha->topo;
    pilha->topo = pilha->topo->prox;
    pilha->size--;
    free(temp);

    return musica;
}

// Mostrar os elementos contidos na pilha flexivel
void mostrarPilha(PilhaFlexivel *pilha) {
    Celula *i;
    int contador = 0;

    for (i = pilha->topo; i != NULL; i = i->prox) {
        printf("[%d] ", contador);
        printf("%s ## ", i->elemento.id);
        printf("%s ## ", i->elemento.artists);
        printf("%s ## ", i->elemento.nome);
        printf("%s ## ", i->elemento.realease_date);
        printf("%G ## ", i->elemento.acousticness);
        printf("%G ## ", i->elemento.danceability);
        printf("%G ## ", i->elemento.instrumentalness);
        printf("%G ## ", i->elemento.liveness);
        printf("%G ## ", i->elemento.loudness);
        printf("%G ## ", i->elemento.speechiness);
        printf("%G ## ", i->elemento.energy);
        printf("%d \n", i->elemento.duration_ms);
        contador = contador + 1;
    }
}

// Imprimir os atributos da musica
void imprimirPilha(Musica *musica) {
    char* dateOrganized = (char*) malloc(100 * sizeof(char));

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

// Mostrar a pilha recursivamente e imprimir seus valores
void showRecursive(PilhaFlexivel *pilha, Celula *i, int contador) {
    if (i != NULL) {
        contador--;
        showRecursive(pilha, i->prox, contador);
        printf("[%d] ", contador);

        Musica *musica = clonePonteiro(i->elemento);

        imprimirPilha(musica);
    }
}

// Metodo para fazer a primeira chamada recursiva
void mostrarPilhaRecursivamente(PilhaFlexivel *pilha) {
    Celula *tmp = pilha->topo;
    int contador = pilha->size;
    showRecursive(pilha, tmp, contador);
}

// Deletar a pilha flexivel
void deletarPilha(PilhaFlexivel *pilha) {
    while(pilha->size > 0) {
        removerPilha(pilha);
    }
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
    FILE* arquivo = fopen("DadosQuestao07.txt", "w");

    double resultado = ((fim - inicio) / (double)CLOCKS_PER_SEC);

    fprintf(arquivo, "Matricula: 716417\tTempo: %lfs", resultado);

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
void sortByQuickSort(Musica *music, int esq, int dir) {
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

//Ordenar um array de string por meio do Bubble sort
void sortByBubbleSort(Musica *music, int n) {
    Musica *tmp = (Musica*) malloc(1 * sizeof(Musica));

    for (int i = (n - 1); i > 0; i--) {
        for (int j = 0; j < i; j++) {
            if (music[j].danceability > music[j + 1].danceability) {
                tmp[0] = music[j];
                music[j] = music[j + 1];
                music[j + 1] = tmp[0];
            }
        }
    }
}

//Ordenar um array por meio do InsertionSort
void sortByInsertion(Musica *music, int n) {
    Musica *tmp = (Musica*) malloc(1 * sizeof(Musica));

    for (int i = 1; i < n; i++) {
        tmp[0] = music[i];
        int j = i - 1;
        while ((j >= 0) && (strcmp(music[j].id, tmp[0].id) > 0)) {
            music[j + 1] = music[j];
            j--;
        }
        music[j + 1] = tmp[0];
    }
}

//Ordenar um array por meio do InsertionSort parcial
void sortByInsertionPartial(Musica *music, int n, int k) {
    Musica *tmp = (Musica*) malloc(1 * sizeof(Musica));
    int inicio = 0;
    int j = 0;

    for (int i = 1; i < n; i++) {
        tmp[0] = music[i];
        
        if (i > k - 1) {
            inicio = k - 1;
        } else {
            inicio = i - 1;
        }

        for (j = inicio; j >= 0 && strcmp(music[j].id, tmp[0].id) > 0; j--) {
            music[j + 1] = music[j];
        }

        music[j + 1] = tmp[0];
    }
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

//Converter arvore em uma estrutura heap
void heapify(Musica *music, int n, int i) {
    int maior = i; //Inicializar o maior como raiz
    int esq = 2 * i; //Esquerda = 2 * i + 1
    int dir = 2 * i + 1; //Direita = 2 * i + 2

    //Se o filho da esquerda for maior que a raiz
    if (esq < n && strcmp(music[esq].realease_date, music[maior].realease_date) == 0) {
        if (strcmp(music[esq].nome, music[maior].nome) > 0) {
            maior = esq;
        }
    } else {
        if (esq < n && strcmp(music[esq].realease_date, music[maior].realease_date) > 0) {
            maior = esq;
        }
    }

    //Se o filho da direita for maior do que o maior ate agora
    if (dir < n && strcmp(music[dir].realease_date, music[maior].realease_date) == 0) {
        if (strcmp(music[dir].nome, music[maior].nome) > 0) {
            maior = dir;
        }
    } else {
        if (dir < n && strcmp(music[dir].realease_date, music[maior].realease_date) > 0) {
            maior = dir;
        }
    }

    //Se o maior nao e a raiz
    if (maior != i) {
        Musica *tmp = (Musica*) malloc(1 * sizeof(Musica));
        tmp[0] = music[i];
        music[i] = music[maior];
        music[maior] = tmp[0];
        free(tmp);

        //Montar recursivamente a subarvore
        heapify(music, n, maior);
    }
}

//Ordenar um array por meio do HeapSort
void sortByHeapSortPartial(Musica *music, int n, int k) {
    //Construir
    for (int i = n / 2 - 1; i >= 0; i--) {
        heapify(music, n, i);
    }

    //Extrair um por um dos elementos da pilha
    for (int i = n - 1; i > 0; i--) {
        Musica *tmp = (Musica*) malloc(1 * sizeof(Musica));
        //Mover a raiz atual para o fim do array
        tmp[0] = music[0];
        music[0] = music[i];
        music[i] = tmp[0];
        free(tmp);

        //Chamar o heap reduzido
        heapify(music, i, 0);
    }
}

// Procurar os ids e adicionar na fila circular flexivel com tamanho maximo de 5
void searchIdAndAddCircularRow (Musica *musica, FilaCircularFlexivel *filaCircular, char id[][30], int numEntrada) {
    bool achou = false;

    for (int k = 0; k < numEntrada; k++) {
        for (int j = 0; j < FILE_LENGTH && achou == false; j++) {
            if (strcmp(musica[j].id, id[k]) == 0) {
                if (tamanhoFila(filaCircular) < 5) {
                    inserir(filaCircular, &musica[j]);
                    printf("%d\n", mediaArredondada(filaCircular));
                    achou = true;
                } else {
                    remover(filaCircular);
                    inserir(filaCircular, &musica[j]);
                    printf("%d\n", mediaArredondada(filaCircular));
                    achou = true;
                }
            }
        }
        achou = false;
    }
}

// Procurar pelos ids e adicionar na pilha
void searchIdInReturnStackFlex(Musica *musica, PilhaFlexivel *pilha, char id[][30], int numEntrada) {
    bool achou = false;

    for (int k = 0; k < numEntrada; k++) {
        for (int j = 0; j < FILE_LENGTH && achou == false; j++) {
            if (strcmp(musica[j].id, id[k]) == 0) {
                inserirPilha(pilha, &musica[j]);
                achou = true;
            }
        }
        achou = false;
    }
}

//Procurar uma musica e retornar ela
Musica procurarUmaMusica(Musica *musica, char id[100]) {
    Musica music;
    bool achou = false;

    for (int j = 0; j < FILE_LENGTH && achou == false; j++) {
        if (strstr(musica[j].id, id) != NULL) {
            music = clone(&musica[j]);
            achou = true;
        }
    }

    return music;
}

//Um split para quebrar uma string em partes
/* char** split(char *string, const char delimiter) {
    int length = 0, count = 0, i = 0, j = 0;

    while(*(string++)) {
        if (*string == delimiter) count++;
        length++;
    }

    string -= (length + 1); // string was incremented one more than length
    char **array = (char **)malloc(sizeof(char *) * (length + 1));
    char ** base = array;
    for(i = 0; i < (count + 1); i++) {
        j = 0;
        while(string[j] != delimiter) j++;
        j++;
        *array = (char *)malloc(sizeof(char) * j);
        memcpy(*array, string, (j-1));
        (*array)[j-1] = '\0';
        string += j;
        array++;
    }

    *array = '\0';

    return base;  
} */

//Tratar cada um dos comandos da entrada 2
/* void tratarComandos(char entrada[][30], FilaCircularFlexivel *filaCircularFlexivel, Musica *musica, int numEntrada) {
    int w = 0;
    const char delimeter[4] = " ";
    Musica music;
    char** linha = (char**) malloc(100 * sizeof(char*));
    char* tmp = (char*) malloc(100 * sizeof(char));

    for (int i = 1; i < numEntrada; i++){ 
        linha = split(entrada[i], ' ');

        //printf("Linha[0]: %s\n", linha[0]);
        //printf("Linha[1]: %s\n", linha[1]);

        //Verificar qual dos comandos devera ser executado
        if (strcmp(linha[0], "I") == 0) {
            if (tamanho(filaCircularFlexivel) < 5) {
                music = procurarUmaMusica(musica, linha[1]);
                inserir(filaCircularFlexivel, &music);
                printf("%d\n", mediaArredondada(filaCircularFlexivel));
            } else {
                remover(filaCircularFlexivel);
                music = procurarUmaMusica(musica, linha[1]);
                inserir(filaCircularFlexivel, &music);
                printf("%d\n", mediaArredondada(filaCircularFlexivel));
            }
        } else {
            if (strcmp(linha[0], "R") == 0) {
                music = remover(filaCircularFlexivel);
                printf("(R) %s\n", music.nome);
            }
        }
    }

    free(tmp);
    free(linha);
} */

int main() {
    //Iniciando o cronometro
    clock_t inicio, fim;
    inicio = clock();
    char entrada[MAX_CHARS][30];
    char entrada2[MAX_CHARS][30];
    char entrada3[MAX_CHARS][30];
    int i = -1;
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

    //Ler a quantidade de operacoes que serao realizadas
    scanf("%d", &quantidade);

    //Declarando a lista com um tamanho maior, pois precisa de mais espaco devido as insercoes (saudades de ser dinamico...)
    PilhaFlexivel *pilhaflexivel;
    pilhaflexivel = (PilhaFlexivel*)malloc(sizeof(PilhaFlexivel)); // Se não dar um malloc não da pra acessar

    //Construtor da fila circular flexivel
    pilhaflexivel = new_PilhaFlexivel(pilhaflexivel);

    //Procurar os ids desejados e adicionar na fila circular flexivel
    searchIdInReturnStackFlex(musica, pilhaflexivel, entrada, i);

    Musica music;

    //Lendo os comandos das operacoes e tratando os comandos
    do {
        scanf("%s", entrada2[contador]);
        if (strcmp(entrada2[contador], "I") == 0) {
            scanf("%s", entrada3[contador]);
            music = procurarUmaMusica(musica, entrada3[contador]);
            inserirPilha(pilhaflexivel, &music);
        } else {
            if (strcmp(entrada2[contador], "R") == 0) {
                music = removerPilha(pilhaflexivel);
                printf("(R) %s\n", music.nome);
            }
        }
        contador++;
    } while (contador < quantidade);

    mostrarPilhaRecursivamente(pilhaflexivel);

    //Finalizando o cronometro
    fim = clock();

    createLog(inicio, fim);
    free(musica);
    deletarPilha(pilhaflexivel);

    return 0;
}
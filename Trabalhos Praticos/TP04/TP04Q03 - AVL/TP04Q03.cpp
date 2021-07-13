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

//------------------------------------------------------------- Metodos e funcoes da Arvore AVL -------------------------
typedef struct No {
    Musica elemento;
    struct No *esq, *dir;
    int nivel;
} No;

No* new_no(Musica *elemento) {
    No *temp = (No*)malloc(sizeof(No));
    temp->elemento = *elemento;
    temp->dir = NULL;
    temp->esq = NULL;
    temp->nivel = 1; // Pode dar erro
    return temp;
}

typedef struct ArvoreAVL {
    struct No *raiz;
    int comparisons;
    int moves;
} ArvoreAVL;

ArvoreAVL* new_ArvoreAVL(ArvoreAVL *arvore) {
    arvore->comparisons = 0;
    arvore->moves = 0;
    arvore->raiz = NULL;

    return arvore;
}

int getComparisons(ArvoreAVL *arvore) {
    int resp = arvore->comparisons;
    return resp;
}

int getMoves(ArvoreAVL *arvore) {
    int resp = arvore->moves;
    return resp;
}

// Metodos e funcoes da Arvore AVL

int getNivel(No *no) {
    comparisons++;
    return (no == NULL) ? 0 : no->nivel;
}

int max(int x, int y) {
    comparisons++;
    return (x > y) ? x : y;
}

void setNivel(No *no) {
    no->nivel = 1 + max(getNivel(no->esq), getNivel(no->dir));
}

//Rotacionar para a direita quando a arvore estiver desbalanceada para esquerda
No* rotacionarDir(No *no) {
    No* noEsq = no->esq;
    No* noEsqDir = noEsq->dir;

    noEsq->dir = no;
    no->esq = noEsqDir;

    setNivel(no);
    setNivel(noEsq);

    return noEsq;
}

//Rotacionar para a esquerda quando a arvore estiver desbalanceada para a direita
No* rotacionarEsq(No *no) {
    No* noDir = no->dir;
    No* noDirEsq = noDir->esq;

    noDir->esq = no;
    no->dir = noDirEsq;

    setNivel(no);
    setNivel(noDir);

    return noDir;
}

// Funcao para inserir
No* balancear(No *no) {
    comparisons++;
    if (no != NULL) {
        int fator = getNivel(no->dir) - getNivel(no->esq);

        //Se estiver balanceada
        if (abs(fator) <= 1) {
            comparisons++;
            setNivel(no);

        //Se estiver desbalanceada para a direita
        } else if (fator == 2) {
            comparisons = comparisons + 3;
            int fatorFilhoDir = getNivel(no->dir->dir) - getNivel(no->dir->esq);

            //Se o filho a direita tambem estiver desbalanceado
            if (fatorFilhoDir == -1) {
                no->dir = rotacionarDir(no->dir);
            }

            no = rotacionarEsq(no);

        //Se estiver desbalanceada para a esquerda
        } else if (fator == -2) {
            comparisons = comparisons + 4;
            int fatorFilhoEsq = getNivel(no->esq->dir) - getNivel(no->esq->esq);

            //Se o filho a esquerda tambem estiver desbalanceado
            if (fatorFilhoEsq == 1) {
                no->esq = rotacionarEsq(no->esq);
            }

            no = rotacionarDir(no);
        } else {
            comparisons = comparisons + 4;
            printf("Erro ao tentar balancear o no %s\n", no->elemento.id);
        }
    }

    return no;
}

No* inserirRec(Musica *music, No *no) {
    
    comparisons++;
    if (no == NULL) {
        no = new_no(music);
    } else if (strcmp(music->id, no->elemento.id) < 0) {
        comparisons = comparisons + 1;
        no->esq = inserirRec(music, no->esq);
    } else if (strcmp(music->id, no->elemento.id) > 0) {
        comparisons = comparisons + 2;
        no->dir = inserirRec(music, no->dir);
    } else {
        comparisons = comparisons + 2;
        printf("\nErro ao inserir\n");
    }

    return balancear(no);
}

void inserir(ArvoreAVL *arvore, Musica *music) {
    arvore->raiz = inserirRec(music, arvore->raiz);
}

// Funcao de pesquisar
bool pesquisarRec(char id[], No* no) {
    bool resp;

    comparisons++;
    if (no == NULL) {
        resp = false;
    } else if (strcmp(id, no->elemento.id) == 0) {
        comparisons = comparisons + 1;
        resp = true;
    } else if (strcmp(id, no->elemento.id) < 0) {
        comparisons = comparisons + 2;
        printf("esq ");
        resp = pesquisarRec(id, no->esq);
    } else {
        comparisons = comparisons + 2;
        printf("dir ");
        resp = pesquisarRec(id, no->dir);
    }

    return resp;
}

bool pesquisar(ArvoreAVL *arvore, char id[]) {
    printf("raiz ");
    return pesquisarRec(id, arvore->raiz);
}

// Metodo caminhapre
void caminharPreRec(No *no) {
    if (no != NULL) {
        printf("\n%s ", no->elemento.id);
        caminharPreRec(no->esq);
        caminharPreRec(no->dir);
    }
}

void caminharPre(ArvoreAVL *arvore) {
    caminharPreRec(arvore->raiz);
}

// Metodo para remover
void antecessor(No *i, No *j) {
    if (j->dir != NULL) {
        antecessor(i, j->dir);
    } else {
        No *dell = j;
        i->elemento = j->elemento;
        j = j->esq;
        free(dell);
    }
}

void removerRec(char id[], No *no) {
    if (no == NULL) {
        printf("\nErro\n");
    } else if (strcmp(id, no->elemento.id) < 0) {
        removerRec(id, no->esq);
    } else if (strcmp(id, no->elemento.id) > 0) {
        removerRec(id, no->dir);
    } else if (no->dir == NULL) {
        No* dell = no;
        no = no->esq;
        free(dell);
    } else if (no->esq == NULL) {
        No* dell = no;
        no = no->dir;
        free(dell);
    } else {
        antecessor(no, no->esq);
    }
}

void remover(ArvoreAVL *arvore, char id[]) {
    removerRec(id, arvore->raiz);
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
    FILE* arquivo = fopen("matricula_avl.txt", "w");

    double resultado = ((fim - inicio) / (double)CLOCKS_PER_SEC);

    fprintf(arquivo, "Matricula: 716417\tTempo: %lfs\tComparacoes: %d\tMovimentos: %d", resultado, comparisons, moves);

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
void searchIdAndReturnThreeAVL(Musica *musica, ArvoreAVL *arvore, char id[][30], int numEntrada) {
    bool achou = false;

    for (int k = 0; k < numEntrada; k++) {
        for (int j = 0; j < FILE_LENGTH && achou == false; j++) {
            if (strcmp(musica[j].id, id[k]) == 0) {
                inserir(arvore, &musica[j]);
                achou = true;
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
    char entrada3[MAX_CHARS][30];
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

    //Declarando a arvore AVL
    ArvoreAVL *arvore;
    arvore = (ArvoreAVL*)malloc(sizeof(ArvoreAVL));

    //Construtor da fila circular flexivel
    arvore = new_ArvoreAVL(arvore);

    //Procurar os ids desejados e adicionar na arvore
    searchIdAndReturnThreeAVL(musica, arvore, entrada, i);

    //Fazer a pesquisa e printar a resposta e o caminho percorrido
    for (int k = 0; k < j; k++) {
        printf("%s\n", entrada2[k]);
        if (pesquisar(arvore, entrada2[k]) == true) {
            printf("SIM\n");
        } else {
            printf("NAO\n");
        }
    }

    //Finalizando o cronometro
    fim = clock();

    //Criar o log e liberar espaco de memoria
    createLog(inicio, fim);
    free(musica);
    free(arvore);

    return 0;
}
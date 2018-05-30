#include <stdio.h>
#include <string.h>
#include <stdlib.h>
//não estava conseguindo fazer em java
int zer = 0, deletado = 1, inserido = 2;

typedef struct entradahsh {
  int flag;
  int hsh;
  char s[20];
} entradahsh;

typedef struct tabelahsh {
  int tam;
  entradahsh ent[101];
} tabelahsh;

int funcaoDahsh(char *s) { //funcao para conversao
  long sum = 0;
  long i = 1;
  while(*s != '\0') {
    sum += (*s) * i;
    ++i;
    ++s;
  }
  return (19 * sum) % 101;
}

int encontraNaTabela(tabelahsh *h, char *st) {
  int hsh = funcaoDahsh(st);
  int j;
  for(j = 0; j < 20; ++j) {
    int loc = (hsh + 23 * j + j * j) % 101;
    if(h->ent[loc].flag == zer) {
        return 0;
    }
    if(h->ent[loc].flag == deletado) {
        continue;
    }
    if(h->ent[loc].hsh == hsh && (strcmp(h->ent[loc].s, st) == 0)) {
      return 1;
    }
  }
  return 0;
}

void insereNaTabela(tabelahsh *h, char *st) {
  int hsh = funcaoDahsh(st);
  int j;
  if (encontraNaTabela(h, st) == 1) return;
  for(j = 0; j < 20; ++j) {
    int loc = (hsh + 23 * j + j * j) % 101;
    if(h->ent[loc].flag == zer || h->ent[loc].flag == deletado) {
      (h->tam)++;
      h->ent[loc].flag = inserido;
      h->ent[loc].hsh = hsh;
      strcpy(h->ent[loc].s, st);
      break;
    }
  }
  return;
}

void deletaNaTabela(tabelahsh *h, char *st) {
  int hsh = funcaoDahsh(st);
  int j;
  for(j = 0; j < 20; ++j) {
    int loc = (hsh + 23 * j + j * j) % 101;
    if(h->ent[loc].flag == zer) {
            return;
    }
    if(h->ent[loc].flag == deletado) {
        continue;
    }
    if(h->ent[loc].hsh == hsh && (strcmp(h->ent[loc].s, st) == 0)) {
      h->ent[loc].flag = deletado;
      (h->tam)--;
    }
  }
}

int main() {
  int nCasos, i;
  scanf("%d", &nCasos);
  for(i = 0; i < nCasos; i++) {
    tabelahsh hsh_table;

    int i, j;
    for(i = 0; i < 101; ++i) {
      hsh_table.ent[i].flag = zer;
    }
    hsh_table.tam = 0;
    int nOpe;
    scanf("%d", &nOpe);
    char st[50];
    for(i = 0; i < nOpe; ++i) {
      scanf("%s", st);
      if(st[0] == 'A'){ //se a primeira letra da entrada for A
        //Para Adicionar
        insereNaTabela(&hsh_table, st + 4);
      }
      else{
        //Para Deletar
        deletaNaTabela(&hsh_table, st + 4);
      }
    }
    printf("%d\n", hsh_table.tam);
    for(i = 0; i < 101; ++i) {
      if(hsh_table.ent[i].flag == inserido)
        printf("%d:%s\n", i, hsh_table.ent[i].s);
      }
  }
  return 0;
}
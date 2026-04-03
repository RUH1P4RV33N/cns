#include<stdio.h>
#include<string.h>

char E[10]="", Ep[10]="+e", T[10]="", Tp[10]="*e", F[10]="(i";

void addall(char *to, char *from){
    for(int i=0; from[i]; i++)
        if(!strchr(to, from[i])){
            int l=strlen(to);
            to[l]=from[i]; to[l+1]='\0';
        }
}

int main(){
    addall(T, F);   // T = F
    addall(E, T);   // E = T

    printf("FIRST(F)  = { %c %c }\n", F[0], F[1]);
    printf("FIRST(T') = { %c %c }\n", Tp[0], Tp[1]);
    printf("FIRST(T)  = { %c %c }\n", T[0], T[1]);
    printf("FIRST(E') = { %c %c }\n", Ep[0], Ep[1]);
    printf("FIRST(E)  = { %c %c }\n", E[0], E[1]);

    return 0;
}
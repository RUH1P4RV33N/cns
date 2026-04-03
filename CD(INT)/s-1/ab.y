%{
#include <stdio.h>
#include <stdlib.h>

int yylex(void);
int yyerror(const char *s);
%}

%%

S : A B     { printf("Valid: a's followed by b's\n"); }
  | A       { printf("Valid: only a's\n"); }
  ;

A : 'a' A
  | 'a'
  ;

B : 'b' B
  | 'b'
  ;

%%

int yyerror(const char *s) {
    printf("Invalid Input\n");
    return 0;
}

int main(void) {
    printf("Enter input (a's followed optionally by b's): \n");
    yyparse();
    return 0;
}
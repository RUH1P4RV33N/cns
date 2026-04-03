%{
#include <stdio.h>
int yylex(void);
int yyerror(const char *s);
%}
%token NUM INVALID

%%
input  : expr            { printf("Valid arithmetic expression"); }
       ;
expr   : expr '+' term
       | expr '-' term
       | term
       ;
term   : term '*' factor
       | term '/' factor
       | factor
       ;
factor : '(' expr ')'
       | NUM
       ;
%%
int main(void) {
    yyparse();
    return 0;
}
int yyerror(const char *s) {
    printf("Invalid expression\n");
    return 0;
}
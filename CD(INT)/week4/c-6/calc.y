%{
#include <stdio.h>
#include <stdlib.h>
int yylex(void);
int yyerror(const char *s);
%}

%union {
    double dval;
}
%token <dval> NUM
%type  <dval> expr term factor

%%
input  : expr  { printf("Result = %g\n", $1); }
       ;
expr   : expr '+' term  { $$ = $1 + $3; }
       | expr '-' term  { $$ = $1 - $3; }
       | term           { $$ = $1; }
       ;
term   : term '*' factor  { $$ = $1 * $3; }
       | term '/' factor  {
             if ($3 == 0) { printf("Error: Division by zero\n"); $$ = 0; }
             else $$ = $1 / $3;
         }
       | factor           { $$ = $1; }
       ;
factor : '(' expr ')'  { $$ = $2; }
       | NUM            { $$ = $1; }
       ;
%%
int main(void) {
    printf("Enter expression: ");
    yyparse();
    return 0;
}
int yyerror(const char *s) {
    printf("Error: %s\n", s);
    return 0;
}
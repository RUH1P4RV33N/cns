%{
#include <stdio.h>
int yylex(void);
int yyerror(const char *s);
%}

%token VAR

%%
s : VAR '\n'     { puts("Valid variable"); };
%%

int main(void) { return yyparse(); }
int yyerror(const char *s) { puts("Invalid variable"); return 0; }
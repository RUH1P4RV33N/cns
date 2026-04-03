%{
#include <stdio.h>
%}
%%
[a-zA-Z][a-zA-Z0-9]*   { printf("Valid variable: %s\n", yytext); }
[0-9]+[a-zA-Z0-9]*     { printf("Invalid variable (starts with digit): %s\n", yytext); }
[ \t\n]                 ;
.                       { printf("Invalid token: %s\n", yytext); }
%%
int yywrap(void) { return 1; }
int main(void) {
    yylex();
    return 0;
}
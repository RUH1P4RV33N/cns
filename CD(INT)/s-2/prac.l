%{
#include <stdio.h>
%}

/* Definitions */
identifier    [a-zA-Z_][a-zA-Z0-9_]*
number        [0-9]+(\.[0-9]+)?
operator      "=="|"="|"<="|">="|"+"|"-"|"*"|"/"|"<"|">"
singlecomment "//"[^\n]*
multicomment  "/*"([^*]|\*+[^*/]|\n)*"*/"

%%

{identifier}     { printf("Identifier: %s\n", yytext); }
{number}         { printf("Constant: %s\n", yytext); }
{singlecomment}  { printf("Single-line Comment: %s\n", yytext); }
{multicomment}   { printf("Multi-line Comment: %s\n", yytext); }
{operator}       { printf("Operator: %s\n", yytext); }
[ \t\n]+         { /* skip whitespace */ }
.                { printf("Unknown Token: %s\n", yytext); }

%%

int main() {
    printf("Enter C code (Ctrl+Z then Enter to end on Windows):\n");
    yylex();
    return 0;
}

int yywrap() {
    return 1;
}
%{
#include "calc.tab.h"
#include <stdlib.h>
%}
%%
[0-9]+(\.[0-9]+)?   { yylval.dval = atof(yytext); return NUM; }
[+\-*/()]           { return yytext[0]; }
[ \t\n]             ;
.                   ;
%%
int yywrap(void) { return 1; }
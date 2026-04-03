%{
#include "y.tab.h"
%}

%%
[0-9]+      { return NUM; }
[+\-*/()]   { return yytext[0]; }
[ \t]       ;
"\n"        { return '\n'; }
.           { return INVALID; }
%%

int yywrap(void) { return 1; }
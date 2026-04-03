%{
#include "y.tab.h"
%}

%%
[A-Za-z][A-Za-z0-9]*   { return VAR; }
\n                     { return '\n'; }
[ \t]                  ;
.                      { return yytext[0]; }
%%

int yywrap(void) { return 1; }
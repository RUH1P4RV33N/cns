%{
#include "ab.tab.h"
%}

%%

a   return 'a';
b   return 'b';
\n  return 0;   // Signals end of input
.   ;           // Ignore any other characters

%%

int yywrap() { return 1; }

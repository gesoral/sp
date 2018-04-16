#| prog8.l |#

%{
#include<stdio.h>
#include "y.tab.h"
%}
%%
int|float|char return BUILTIN;
"," return COMMA;
";" return SC;
[a-zA-Z]+[a-zA-Z0-9]* return ID;
\n return 0;
%%


#| prog8.y
 |#


//YACC Program
%{
#include<stdio.h>
void yyerror(char*);
%}
%token ID BUILTIN SC NL COMMA
%%
start :BUILTIN varlist SC {printf("valid varible declaration\n");}
|
varlist :varlist COMMA ID
|
ID;

%%
void yyerror(char *str)
{
printf("%s \n",str);
}
int yywrap()
{
return 0;
}
int main(void)
{
yyparse();
return 0;
}


#| how to run:

lex prog8.l
yacc -d prog8.y
cc -c lex.yy.c y.tab.c
cc -o parser lex.yy.o y.tab.o -ll
./parser |#
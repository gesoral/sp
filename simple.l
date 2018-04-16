%option noyywrap
%{
char test='s';
%}
%%
(""[aA][nN][dD]"")|(""[oO][rR]"")|(""[bB][uU][tT]"") {test='c';}
. {;}
\n return 0;
%%
int main()
{
yylex();
if(test=='s')
 printf("\n Its a simple sentence\n");
else if(test=='c')
 printf("\n This is compound sentence\n");

 return 0;
}

#| how to run:

lex program9.l 
gcc lex.yy.c
./a.out
 |#
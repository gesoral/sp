#| program7.l |#

%{
#include<stdio.h>
int ch=0, bl=0, ln=0, wr=0;
%}
%%
[\n] {ln++;wr++;}
[\t] {bl++;wr++;}
[" "] {bl++;wr++;}
[^\n\t] {ch++;}
%%


int yywrap(void)
{
	return 1;
}


int main()
{
FILE *fp=fopen("input.txt","r"); 
char file[10];

yyin=fp;
yylex();
printf("\nTotal No. of Characters are=%d\nTotal No. of Blank Spaces=%d\nTotalNo.of Lines=%d\nTotalNo.ofWords=%d\n",ch,bl,ln,wr);
return 0;
}

#|  input.txt

gescoe te computer
god is great
gescoe te computer
god is great
gescoe te computer
god is great 
gescoe te computer 
god is great |#

#| how to run :

lex program7.l 
gcc lex.yy.c
 ./a.out |#
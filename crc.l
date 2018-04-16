#| program6.l |#

%{
#include<stdio.h>
%}

%%
float|int|char|double|long|void|include|typedef printf("%s IS A KEYWORD\n",yytext);
["|(|)|{|}|#|;|,|%|&] printf("%s IS A SPECIAL SYMBOL\n",yytext);
["]+[a-zA-Z0-9]+["] printf("%s IS A MESSAGE\n", yytext);
[a-zA-Z] printf("%s IS A STRING CONSTANT\n", yytext);
[+|-|*|/] printf("%s IS A ARITHMATIC OPERATOR\n", yytext);
[a-zA-Z]*.h printf("%s IS A HEADER FILE\n", yytext);
[a-zA-Z]+[a-zA-Z0-9]* printf("%s IS AN IDENTIFIER\n", yytext);
[0-9]+ printf("%s IS A CONSANT\n", yytext);
= printf("%s IS AN ASSIGNMENT OPERATOR \n", yytext);
[<|>|<=|>=|<>] printf("%s IS A RELATIONAL OPERATOR\n", yytext);
[&&|!=|==] printf("%s IS A LOGICAL OPERATOR\n", yytext);
%%

int yywrap(void)
{
	return 1;
}

int main()
{
	FILE *fp = fopen("crc.cpp","r");
	printf("file");
	yyin = fp;
	yylex();
	yywrap(); 
	return 0;
}


#| crc.cpp
#include <iostream.h>
int main()
{
    int i,j,k,l;
     
    //Get Frame
    int fs;
    cout<<"\n Enter Size of data: ";
    cin>>fs;
     
    int f[20];
     
    cout<<" Enter data:";
    for(i=0;i<fs;i++)
    {
        cin>>f[i];
    }
return 0;
}
 |#

#| How to run:
gescoe@gescoe-OptiPlex-3020:~/Desktop/FINAL SPOS$ lex program6.l 
gescoe@gescoe-OptiPlex-3020:~/Desktop/FINAL SPOS$ gcc lex.yy.c
gescoe@gescoe-OptiPlex-3020:~/Desktop/FINAL SPOS$ ./a.out

 |#
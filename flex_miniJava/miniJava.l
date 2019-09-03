DIGITO	[0-9]
LETRA	[a-zA-Z]
PALAVRAS_RESERVADAS (public|class|\{|static|void|main|String|return|int|boolean|if|else|while|System.out.println|length|true|false|this|new)

MISC (\(|\[|\]|\)|\{|\}|\;|\,|\.|!)
ID	{LETRA}({LETRA}|{DIGITO}|_)*
OP 	(&&|<|[+]|-|[*]|=)	
COMMENT (\/\*)(.)*(\*\/)|(\/\/)(.)*

%%

{DIGITO}+				{printf("Inteiro: %s\n",yytext);}
{MISC}                  {printf("Misc: %s\n",yytext);} 
{OP}					{printf("Operador Binario: %s\n",yytext);}
{PALAVRAS_RESERVADAS}	{printf("Palavra Reservada: %s\n",yytext);}
{ID}					{printf("Identificador: %s\n",yytext);}
{COMMENT}				{printf("Comentario: %s\n",yytext);}

%%

//{DIGITO}+"."{DIGITO}+	{printf("Real: %s\n",yytext);} 
//([class]| [{] | [static] | [void] | [main] | [String] | [(] | [[] | ] | ) | { | } | ; | , | return | int | boolean | if | else | while | System.out.println | length | . | true | false | this | new | !)
// COMMENT (/\*)(.)*(\*/)|(//)(.)*
int yywrap();

int main(){
	yylex();
	return 0;
}

int yywrap(){
	return 1;
}

package codigo;
import static codigo.Tokens.*; //Podria ser una tabla Hash

%%
%class Lexer
%type Tokens

//EXPRESIONES REGULARES
Lm=[a-z]
LM=[A-Z]
D=[0-9]
Igual=['==']
espacio=[ ,\t,\r]+
%{
    public String lexeme;
%}
%%

//PALABRAS RESERVADAS
entero {lexeme=yytext(); return Entero;}
decimal {lexeme=yytext(); return Decimal;}
texto {lexeme=yytext(); return Texto;}
caracter {lexeme=yytext(); return Caracter;}
logico {lexeme=yytext(); return Logico;}
break {lexeme=yytext(); return Break;}
case {lexeme=yytext(); return Case;}
default {lexeme=yytext(); return Default;}
switch {lexeme=yytext(); return Swhitch;}
if {lexeme=yytext(); return If;}
imprimir {lexeme=yytext(); return Imprimir;}
for {lexeme=yytext(); return For;}
{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}
"\n" {return Line;}

      //TABLA DE SIMBOLOS
"!" {lexeme=yytext(); return Negacion;}
"+" {lexeme=yytext(); return Suma;}
"-" {lexeme=yytext(); return Resta;}
"*" {lexeme=yytext(); return Multiplicacion;}
"/" {lexeme=yytext(); return Division;}
"<" {lexeme=yytext(); return Menor;}
">" {lexeme=yytext(); return Mayor;}
">=" {lexeme=yytext(); return MayorIgual;}
"<=" {lexeme=yytext(); return MenorIgual;}
"<>" {lexeme=yytext(); return Diferente;}
"&&" {lexeme=yytext(); return Y;}
"||" {return O;}
"=" {lexeme=yytext(); return Asignacion;}
";" {lexeme=yytext(); return PuntoComa;}
":" {lexeme=yytext(); return DosPuntos;}
"." {lexeme=yytext(); return Punto;}
"//" {lexeme=yytext(); return DobleBarra;}
"(" {lexeme=yytext(); return ParentesisA;}
")" {lexeme=yytext(); return ParentesisC;}
"{" {lexeme=yytext(); return LlavesA;}
"}" {lexeme=yytext(); return LlavesC;}
"[" {lexeme=yytext(); return CorchetesA;}
"]" {lexeme=yytext(); return CorchetesC;}
"%" {lexeme=yytext(); return Porcentaje;}
"Inicio" {lexeme=yytext(); return Inicio;}


      //PATRONES
(({LM}+ | {Lm}+)* {D}+)+ {lexeme=yytext(); return Identificador;}
("(-"{D}+")")|{D}+ {lexeme=yytext(); return Numero;}
("(-"{D}+"."+{D}+")") | {D}+"."{D}+ {lexeme=yytext(); return NumeroDecimal;}
{Igual} {lexeme=yytext(); return Igual;}
("'"(({LM}+ | {Lm}+)+ | (({LM}+ | {Lm}+){D}+)+)+"'") {lexeme=yytext(); return Cadena;}

 . {lexeme=yytext(); return ERROR;}//ERROR EN CASO NO SE ENCUENTRE NINGUNA DE LAS REGLAS ANTERIORES
package codigo;
import java_cup.runtime.Symbol;
import java_cup.sym;
//Podria ser una tabla Hash

%%
%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char

//EXPRESIONES REGULARES
Lm=[a-z]
LM=[A-Z]
D=[0-9]
Igual=['==']
Comillas=['""']
espacio=[ ,\t,\r,\n]+
%{
    private Symbol symbol(int type, Object value){ //Para manejo de Errores
        return  new Symbol(type, yyline, yycolumn, value);
    }

    private Symbol symbol(int type){ //Para manejo de Errores
            return  new Symbol(type, yyline, yycolumn);
        }
%}
%%

//PALABRAS RESERVADAS
entero {return new Symbol(sym.Entero, yychar, yyline, yytext());}
decimal {return new Symbol(sym.Decimal, yychar, yyline, yytext());}
texto {return new Symbol(sym.Texto, yychar, yyline, yytext());}
caracter {return new Symbol(sym.Caracter, yychar, yyline, yytext());}
logico {return new Symbol(sym.Logico, yychar, yyline, yytext());}
break {return new Symbol(sym.Break, yychar, yyline, yytext());}
case {return new Symbol(sym.Case, yychar, yyline, yytext());}
default {return new Symbol(sym.Default, yychar, yyline, yytext());}
switch {return new Symbol(sym.Switch, yychar, yyline, yytext());}
if {return new Symbol(sym.If, yychar, yyline, yytext());}
imprimir {return new Symbol(sym.Imprimir, yychar, yyline, yytext());}
for {return new Symbol(sym.For, yychar, yyline, yytext());}
{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}

      //TABLA DE SIMBOLOS
"!" {return new Symbol(sym.Negacion, yychar, yyline, yytext());}
"+" {return new Symbol(sym.Suma, yychar, yyline, yytext());}
"-" {return new Symbol(sym.Resta, yychar, yyline, yytext());}
"*" {return new Symbol(sym.Multiplicacion, yychar, yyline, yytext());}
"/" {return new Symbol(sym.Division, yychar, yyline, yytext());}
"<" {return new Symbol(sym.Menor, yychar, yyline, yytext());}
">" {return new Symbol(sym.Mayor, yychar, yyline, yytext());}
">=" {return new Symbol(sym.MayorIgual, yychar, yyline, yytext());}
"<=" {return new Symbol(sym.MenorIgual, yychar, yyline, yytext());}
"<>" {return new Symbol(sym.Diferente, yychar, yyline, yytext());}
"&&" {return new Symbol(sym.Y, yychar, yyline, yytext());}
"||" {return new Symbol(sym.O, yychar, yyline, yytext());}
"=" {return new Symbol(sym.Asignacion, yychar, yyline, yytext());}
";" {return new Symbol(sym.PuntoComa, yychar, yyline, yytext());}
":" {return new Symbol(sym.DosPuntos, yychar, yyline, yytext());}
"." {return new Symbol(sym.Punto, yychar, yyline, yytext());}
"//" {return new Symbol(sym.DobleBarra, yychar, yyline, yytext());}
"(" {return new Symbol(sym.ParentesisA, yychar, yyline, yytext());}
")" {return new Symbol(sym.ParentesisC, yychar, yyline, yytext());}
"{" {return new Symbol(sym.LlavesA, yychar, yyline, yytext());}
"}" {return new Symbol(sym.LlavesC, yychar, yyline, yytext());}
"[" {return new Symbol(sym.CorchetesA, yychar, yyline, yytext());}
"]" {return new Symbol(sym.CorchetesC, yychar, yyline, yytext());}
"%" {return new Symbol(sym.Porcentaje, yychar, yyline, yytext());}
"Inicio" {return new Symbol(sym.Inicio, yychar, yyline, yytext());}


      //PATRONES
(({LM}+ | {Lm}+)* {D}+)+ {return new Symbol(sym.Identificador, yychar, yyline, yytext());}
("(-"{D}+")")|{D}+ {return new Symbol(sym.Numero, yychar, yyline, yytext());}
("(-"{D}+"."+{D}+")") | {D}+"."{D}+ {return new Symbol(sym.NumeroDecimal, yychar, yyline, yytext());}
{Igual} {return new Symbol(sym.Igual, yychar, yyline, yytext());}
("'"(({LM}+ | {Lm}+)+ | (({LM}+ | {Lm}+){D}+)+)+"'") {return new Symbol(sym.Cadena, yychar, yyline, yytext());}
 . {return ERROR;}//ERROR EN CASO NO SE ENCUENTRE NINGUNA DE LAS REGLAS ANTERIORES
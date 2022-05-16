package codigo;
import java_cup.runtime.Symbol;
%%
%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char

//EXPRESIONES REGULARES
Lm=[a-z]+
LM=[A-Z]+
D=[0-9]
Igual=[==]
espacio=[ ,\t,\r\n]+
%{
    private Symbol symbol(int type, Object value){
      return new Symbol(type, yyline, yycolumn, value);
    }

        private Symbol symbol(int type){
          return new Symbol(type, yyline, yycolumn);
        }
%}
%%

//PALABRAS RESERVADAS
(entero) {return new Symbol(codigo.sym.Entero, yychar, yyline, yytext());}
(decimal) {return new Symbol(codigo.sym.Decimal, yychar, yyline, yytext());}
(texto) {return new Symbol(codigo.sym.Texto, yychar, yyline, yytext());}
(caracter) {return new Symbol(codigo.sym.Caracter, yychar, yyline, yytext());}
(logico) {return new Symbol(codigo.sym.Logico, yychar, yyline, yytext());}
(break) {return new Symbol(codigo.sym.Break, yychar, yyline, yytext());}
(case) {return new Symbol(codigo.sym.Case, yychar, yyline, yytext());}
(default) {return new Symbol(codigo.sym.Default, yychar, yyline, yytext());}
(switch) {return new Symbol(codigo.sym.Switch, yychar, yyline, yytext());}
(if) {return new Symbol(codigo.sym.If, yychar, yyline, yytext());}
(imprimir) {return new Symbol(codigo.sym.Imprimir, yychar, yyline, yytext());}
(for) {return new Symbol(codigo.sym.For, yychar, yyline, yytext());}
{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}

      //TABLA DE SIMBOLOS
"!" {return new Symbol(codigo.sym.Negacion, yychar, yyline, yytext());}
"+" {return new Symbol(codigo.sym.Suma, yychar, yyline, yytext());}
"-" {return new Symbol(codigo.sym.Resta, yychar, yyline, yytext());}
"*" {return new Symbol(codigo.sym.Multiplicacion, yychar, yyline, yytext());}
"/" {return new Symbol(codigo.sym.Division, yychar, yyline, yytext());}
"<" {return new Symbol(codigo.sym.Menor, yychar, yyline, yytext());}
">" {return new Symbol(codigo.sym.Mayor, yychar, yyline, yytext());}
">=" {return new Symbol(codigo.sym.MayorIgual, yychar, yyline, yytext());}
"<=" {return new Symbol(codigo.sym.MenorIgual, yychar, yyline, yytext());}
"<>" {return new Symbol(codigo.sym.Diferente, yychar, yyline, yytext());}
"==" {return new Symbol(codigo.sym.Igual, yychar, yyline, yytext());}
"&&" {return new Symbol(codigo.sym.And, yychar, yyline, yytext());}
"||" {return new Symbol(codigo.sym.Or, yychar, yyline, yytext());}
"=" {return new Symbol(codigo.sym.Asignacion, yychar, yyline, yytext());}
";" {return new Symbol(codigo.sym.PuntoComa, yychar, yyline, yytext());}
":" {return new Symbol(codigo.sym.DosPuntos, yychar, yyline, yytext());}
"." {return new Symbol(codigo.sym.Punto, yychar, yyline, yytext());}
"(" {return new Symbol(codigo.sym.ParentesisA, yychar, yyline, yytext());}
")" {return new Symbol(codigo.sym.ParentesisC, yychar, yyline, yytext());}
"{" {return new Symbol(codigo.sym.LlavesA, yychar, yyline, yytext());}
"}" {return new Symbol(codigo.sym.LlavesC, yychar, yyline, yytext());}
"[" {return new Symbol(codigo.sym.CorchetesA, yychar, yyline, yytext());}
"]" {return new Symbol(codigo.sym.CorchetesC, yychar, yyline, yytext());}
"%" {return new Symbol(codigo.sym.Porcentaje, yychar, yyline, yytext());}
"inicio" {return new Symbol(codigo.sym.Inicio, yychar, yyline, yytext());}


      //PATRONES
//(({LM}+ | {Lm}+)* {D}+)+ {return Identificador;}
(({LM} | {Lm}) | (({LM} | {Lm}) | {D}))* {return new Symbol(codigo.sym.Identificador, yychar, yyline, yytext());}
("(-"{D}+")")|{D}+ {return new Symbol(codigo.sym.Numero, yychar, yyline, yytext());}
("(-"{D}+"."+{D}+")") | {D}+"."{D}+ {return new Symbol(codigo.sym.NumeroDecimal, yychar, yyline, yytext());}
("'"(({LM}+ | {Lm}+)+ | (({LM}+ | {Lm}+){D}+)+)+"'") {return new Symbol(codigo.sym.Cadena, yychar, yyline, yytext());}
 . {return new Symbol(sym.ERROR, yychar, yyline, yytext());}//ERROR EN CASO NO SE ENCUENTRE NINGUNA DE LAS REGLAS ANTERIORES
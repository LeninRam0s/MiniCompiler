package codigo;
import static codigo.Tokens.*;

%%
%class Lexer
%type Tokens
//EXPRESIONES REGULARES
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ ,\t,\r,\n]+

%{
    public String lexeme;
%}
%%
//PALABRAS RESERVADAS
int |
for |
if  |
print |
else |
while {lexeme=yytext(); return Reservadas;}

      //TABLA DE SIMBOLOS
{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}
"=" {return Igual;}
"+" {return Suma;}
"-" {return Resta;}
"*" {return Multiplicacion;}
"/" {return Division;}
">" {return MayorQ;}
"<" {return MenorQ;}
">=" {return MayorIgualQ;}
"<=" {return MenorIgualQ;}
"<>" {return DistintoQ;}
":=" {return Asignacion;}
"(" {return ParentesisA;}
")" {return ParentesisC;}
"{" {return LlavesA;}
"}" {return LlavesC;}
"[" {return CorchetesA;}
"]" {return CorchetesC;}
";" {return PuntoComa;}
":" {return DosPuntos;}
"," {return Coma;}
"." {return Punto;}
"%" {return Porcentaje;}




      //PATRONES
{L}({L}|{D})* {lexeme=yytext(); return Identificador;}
("(-"{D}+")")|{D}+ {lexeme=yytext(); return Numero;}
 . {return ERROR;}//ERROR EN CASO NO SE ENCUENTRE NINGUNA DE LAS REGLAS ANTERIORES
// Define a grammar called BNF_Compiler
grammar bnf;
program : (if_T)*;
//numero | id | while_T | print | for_T | if_T | else_T | tDato | operacion

tDato: ((reservadas id ASIGNACION cadena) | (reservadas id ASIGNACION numero) | (reservadas id ASIGNACION decimal))?  PUNTOCOMA;
//declaraciones: (reservadas id operadores numero);
imprimir: IMPRIMIR simbolos COMILLAS cadena+;
cadena: simbolos (cadena+ | WS+ | cadena+)+  COMILLAS;

ignore: WS;
id  : ((LM+ Lm+)*(D+))+; // match keyword hello followed by an identifier
numero: D;
decimal: D+ (PUNTO D+)+;

equivalente: EQUIVALENTE PARENTESIS_A (cadena | id)? COMA (cadena | id)? PARENTESIS_C ;


while_T: WHILE (simbolos (id | numero | decimal)+ operadores (id | numero | decimal)+  PARENTESIS_C LLAVES_A program? LLAVES_C PUNTOCOMA);
for_T: FOR simbolos ENTERO id ASIGNACION (id | numero) PUNTOCOMA id operadores numero PUNTOCOMA id operadores+ simbolos simbolos program? simbolos PUNTOCOMA;
if_T: reservadas simbolos ((numero operadores numero)+ | equivalente) simbolos simbolos (program | simbolos)? simbolos (program | LLAVES_C)?  PUNTOCOMA;
print: PRINT PARENTESIS_A cadena PARENTESIS_C PUNTOCOMA;
else_T: ELSE LLAVES_A (print | program)? LLAVES_C;
operacion: resta;

mult: numero MULT numero;
suma: (SUMA | mult | numero)+ SUMA numero;
resta: (mult | suma)+ RESTA division;
division:(resta | PARENTESIS_A | numero)+ DIV numero PARENTESIS_C;


//OPERADORES
NEGACION: '!';
SUMA:'+';
RESTA:'-';
MULT:'*';
DIV:'/';
MENOR:'<';
MAYOR:'>';
MAYOR_IGUAL:'>=';
MENOR_IGUAL: '<=';
DIFERENTE: '<>';
Y: '&&';
O: '||';
ASIGNACION: '=';
IGUAL: '==';
operadores: (NEGACION|SUMA|RESTA|MULT|DIV|MAYOR|MENOR|MAYOR_IGUAL|MENOR_IGUAL|DIFERENTE|Y|O|ASIGNACION|IGUAL)+;

//SIMBOLOS
LLAVES_A:'{';
LLAVES_C:'}';
CORCHETE_A:'[';
CORCHETE_C:']';
PARENTESIS_A:'(';
PARENTESIS_C:')';
COMA: ',';
PUNTO: '.';
PUNTOCOMA: ';';
DOSPUNTOS: ':';
COMILLAS: '"';
simbolos: (LLAVES_A|LLAVES_C|PARENTESIS_A|PARENTESIS_C|CORCHETE_A|CORCHETE_C|PUNTO|DOSPUNTOS|PUNTOCOMA|COMILLAS|COMA)+;
//ESPACIO: ' ';

//PALABRAS RESERVADAS
IF:'If';
ELSE: 'Else';
FOR:'For';
IMPRIMIR: 'Imprimir';
ENTERO: 'Entero';
TEXTO: 'Texto';
DECIMAL: 'Decimal';
WHILE: 'While';

reservadas: (IF|ELSE|FOR|IMPRIMIR|ENTERO|TEXTO|DECIMAL|WHILE)+;
//IDENTIFICADOR // match lower-case identifiers
D: [0-9]+;
CADENA: COMILLAS+ LM+ Lm+;
LM: [A-Z]+;
Lm: [a-z]+;

WS : [ \t\r\n//]+ -> skip ; // skip spaces, tabs, newlines
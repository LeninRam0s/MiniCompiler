package codigo;

import java.io.File;

public class Principal {


    public static void main(String[] args) {
        String ruta = "I:/PROYECTOS JAVA/AnalizadorLexico/src/Codigo/Lexer.flex";
        generarLexer(ruta);
    }

    public static  void generarLexer(String ruta){ //metodo para crear analizador lexico
        File archivo = new File(ruta);
        JFlex.Main.generate(archivo);
    }



}

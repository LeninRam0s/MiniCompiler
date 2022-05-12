package codigo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FrmPrincipal {

    private JTextField txtEntrada;
    private JButton btnAnalizar;
    private JTextArea txtResultado;
    private JPanel PanelPrincipal;


    public FrmPrincipal() {

        btnAnalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File archivo = new File("archivo.lx");
                PrintWriter escribir;
                try {
                    escribir = new PrintWriter(archivo);//Se copiara en un archivo para analizarlo
                    escribir.print(txtEntrada.getText()); //Lo que escribamos en el Compilador
                    escribir.close();;//Cerramos el archivo
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }

                try {
                    Reader lector = new BufferedReader(new FileReader("archivo.lx")); //Leeremos el Archivo
                    Lexer lexer = new Lexer(lector); //Pasamos el archivo a lexer para analizarlo
                    String resultado = "";//resultado de toda la cadena
                    while (true){ //Analizar el archivo hasta encontrar el ultimo texto
                        Tokens tokens = lexer.yylex();
                        if (tokens == null){
                            resultado += "Final Analisis Lexico";
                            txtResultado.setText(resultado);//Pasamos al form la cadena del resultado

                            return; //para salir del while infinito
                        }
                        switch (tokens){
                            case ERROR:
                                resultado+= lexer.yytext() +"\t\t\t|  ERROR TOKEN N/D\n";
                                break;
                            case Entero:
                            case Decimal:
                            case Texto:
                            case Caracter:
                            case Logico:
                            case Break:
                            case Case:
                            case Default:
                            case Swhitch:
                            case If:
                            case Imprimir:
                            case For:
                            case Line:
                            case Negacion:
                            case Suma:
                            case Resta:
                            case Multiplicacion:
                            case Division:
                            case Menor:
                            case Mayor:
                            case MayorIgual:
                            case MenorIgual:
                            case Diferente:
                            case Y:
                            case O:
                            case Asignacion:
                            case PuntoComa:
                            case DosPuntos:
                            case Punto:
                            case DobleBarra:
                            case ParentesisA:
                            case ParentesisC:
                            case LlavesA:
                            case LlavesC:
                            case CorchetesA:
                            case CorchetesC:
                            case Porcentaje:
                            case Identificador:
                            case Numero:
                            case NumeroDecimal:
                            case Igual:
                            case Cadena:
                                resultado+= lexer.yytext() +"\t\t\t| "+ tokens.name() +"\t|\t\t";
                            default:
                                resultado += "Token: " +tokens+"\n";
                                break;
                        }
                    }
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }







    public static void main(String[] args) throws Exception {

        JFrame frame = new JFrame("MiniCompiler - V0.1");
        frame.setContentPane(new FrmPrincipal().PanelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        //Generar Clase Lexer
        String rutaLexer = "I:/PROYECTOS JAVA/MiniCompiler/AnalizadorLexico/src/Codigo/Lexer.flex";
        String rutaCup = "I:/PROYECTOS JAVA/MiniCompiler/AnalizadorLexico/src/Codigo/LexerCup.flex";
        String rutac = "I:/PROYECTOS JAVA/MiniCompiler/AnalizadorLexico/src/Codigo/Sintax.cup";
        String[] rutaSintax = {"-parser", "Sintax",rutac};

        generarAnalisis(rutaLexer, rutaCup, rutaSintax);
    }

    public static  void generarAnalisis(String rutaLexer, String rutaCup, String[] rutaSintax) throws Exception { //metodo para crear analizador lexico - Clase Lexer
        File archivo;
        archivo = new File(rutaLexer);
        JFlex.Main.generate(archivo);

        archivo = new File(rutaCup);
        JFlex.Main.generate(archivo);

        java_cup.Main.main(rutaSintax);

        String rutaActualSym = "I:/PROYECTOS JAVA/MiniCompiler/AnalizadorLexico/sym.java";
        String rutaDestinoSym = "I:/PROYECTOS JAVA/MiniCompiler/AnalizadorLexico/src/Codigo/sym.java";
        String rutaActualSintax = "I:/PROYECTOS JAVA/MiniCompiler/AnalizadorLexico/Sintax.java";
        String rutaDestinoSintax = "I:/PROYECTOS JAVA/MiniCompiler/AnalizadorLexico/src/Codigo/Sintax.java";

        //Si existe el archivo de simbolo borrarlo
        Path pathSym = Paths.get(rutaDestinoSym);
        if (Files.exists(pathSym)){
            Files.delete(pathSym);
        }

        Files.move(Paths.get(rutaActualSym),
                   Paths.get(rutaDestinoSym));

        //Si existe el archivo sintactico borrarlo
        Path pathSintax = Paths.get(rutaDestinoSintax);
        if (Files.exists(pathSintax)){
            Files.delete(pathSintax);
        }

        Files.move(Paths.get(rutaActualSintax),
                Paths.get(rutaDestinoSintax));
    }
}


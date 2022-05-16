package codigo;

import java_cup.runtime.Symbol;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class FrmPrincipal {

    private JButton btnAnalizar;
    private JTextArea txtResultado;
    private JPanel PanelPrincipal;
    private JButton btnArchivo;
    private JTextArea txtEntrada;
    private JTextArea txtSintactico;
    private JButton btnLimpiar;

    public FrmPrincipal() {

        btnAnalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int cont = 1;

                String expr = (String) txtEntrada.getText();
                Lexer lexer = new Lexer(new StringReader(expr));
                String resultado = "LINEA " + cont + "\t\t\tSIMBOLO\n";
                while (true) {
                    Tokens token = null;
                    try {
                        token = lexer.yylex();

                        if (token == null) {
                            txtResultado.setText(resultado);
                            return;
                        }
                        switch (token){
                            case Line:
                                cont++;
                                resultado += "Linea " + cont + "\n";
                                break;
                            case Entero:
                            case Decimal:
                            case Texto:
                            case Caracter:
                            case Logico:
                            case Break:
                            case Case:
                            case Default:
                            case Switch:
                            case If:
                            case Imprimir:
                            case For:
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
                            case Igual:
                            case And:
                            case Or:
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
                            case Inicio:
                            case Identificador:
                            case Numero:
                            case NumeroDecimal:
                            case Cadena:
                                resultado += token.name()+"\t\t" + lexer.lexeme + "\n";
                                break;

                            case ERROR:
                                resultado+= token.name()+ " TOKEN N/D\n";
                                break;
                            default:
                                // resultado += "Token: " +token+"\n";
                                //resultado += "< "+lexer.lexeme+" >\n";
                                resultado += token.name()+"\t\t" + lexer.lexeme + "\n";
                                break;
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }

            }
        });

        //----------------------------------------------------------
        btnArchivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.showOpenDialog(null);
                File archivo = new File(chooser.getSelectedFile().getAbsolutePath());//Contenido del Arvhivo

                try {
                    String ST = new String(Files.readAllBytes(archivo.toPath())); //Contiene todos los caracteres del archivo
                    txtEntrada.setText(ST); //Agregamos el contenido al txtResultado
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtResultado.setText(null);
                txtSintactico.setText(null);
            }
        });
        btnAnalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String st = txtResultado.getText();

                Sintax s = new Sintax(new codigo.LexerCup(new StringReader(st)));
                try {
                    s.parse();
                    txtSintactico.setText("Analisis Realizado Con Exito!");
                    txtSintactico.setForeground(new Color(25, 111, 61));

                } catch (Exception Ex) {
                    Symbol sym = s.getS();
                    txtSintactico.setText("Error de Sintaxis Linea: " + (sym.right +1) +"Columna: "+(sym.left + 1)+", Texto \""+ sym.value + "\"");
                    txtSintactico.setForeground(Color.PINK);
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
        String rutaLexer = "I:/PROYECTOS JAVA/MiniCompiler/Analizador/src/Codigo/Lexer.flex"; //ruta1
        String rutaCup = "I:/PROYECTOS JAVA/MiniCompiler/Analizador/src/Codigo/LexerCup.flex"; //ruta2
        String rutac = "I:/PROYECTOS JAVA/MiniCompiler/Analizador/src/Codigo/Sintax.cup";
        String[] rutaSintax = {"-parser", "Sintax",rutac}; //rutaS
        generarAnalisis(rutaLexer, rutaCup, rutaSintax);
    }

    public static  void generarAnalisis(String rutaLexer, String rutaCup, String[] rutaSintax) throws Exception { //metodo para crear analizador lexico - Clase Lexer
        File archivo;
        archivo = new File(rutaLexer);
        JFlex.Main.generate(archivo);//Crea archivo Lexer

        archivo = new File(rutaCup);
        JFlex.Main.generate(archivo);//Crea archivo LexerCup

        java_cup.Main.main(rutaSintax); //Crea archivo SintaxCup

        String rutaActualSym = "I:/PROYECTOS JAVA/MiniCompiler/Analizador/sym.java"; //Ruta Origen
        String rutaDestinoSym = "I:/PROYECTOS JAVA/MiniCompiler/Analizador/src/Codigo/sym.java"; //Ruta Destino

                //Si existe el archivo de simbolo borrarlo
        Path rutaSym = Paths.get(rutaDestinoSym); //RutaDestino
        if (Files.exists(rutaSym)){
            Files.delete(rutaSym);
        }

        Files.move(Paths.get(rutaActualSym),//Ruta Origen
                   Paths.get(rutaDestinoSym)); //Ruta Destino

        String rutaActualSintax = "I:/PROYECTOS JAVA/MiniCompiler/Analizador/Sintax.java";
        String rutaDestinoSintax = "I:/PROYECTOS JAVA/MiniCompiler/Analizador/src/Codigo/Sintax.java";

        //Si existe el archivo sintactico borrarlo
        Path rutaSin = Paths.get(rutaDestinoSintax); //Ruta Destino
        if (Files.exists(rutaSin)){
            Files.delete(rutaSin);
        }

        Files.move(Paths.get(rutaActualSintax), //Ruta Origen
                Paths.get(rutaDestinoSintax)); //Ruta Destino
    }
}


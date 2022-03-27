package codigo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class FrmPrincipal {
    private JTextField txtEntrada;
    private JButton btnAnalizar;
    private JTextArea txtResultado;
    private JPanel PanelPrincipal;

    public FrmPrincipal() {

        btnAnalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File archivo = new File("archivo.txt");
                PrintWriter escribir;
                try {
                    escribir = new PrintWriter(archivo);//Se copiara en un archivo para analizarlo
                    escribir.print(txtEntrada.getText()); //Lo que escribamos en el Compilador
                    escribir.close();;//Cerramos el archivo
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }

                try {
                    Reader lector = new BufferedReader(new FileReader("archivo.txt")); //Leeremos el Archivo
                    Lexer lexer = new Lexer(lector); //Pasamos el archivo a lexer para analizarlo
                    String resultado = "";//resultado de toda la cadena
                    while (true){ //Analizar el archivo hasta encontrar el ultimo texto
                        Tokens tokens = lexer.yylex();
                        if (tokens == null){
                            resultado += "Final";
                            txtResultado.setText(resultado);//Pasamos al form la cadena del resultado
                            return; //para salir del while infinito
                        }
                        switch (tokens){
                            case ERROR:
                                resultado+= lexer.yytext() +"\t\t|  ERROR LEXEMA N/D\n";
                                break;
                            case Suma:
                            case Resta:
                            case Multiplicacion:
                            case Division:
                            case Identificador:
                            case Numero:
                            case Cadena:
                            case Asignacion:
                            case ParentesisA:
                            case ParentesisC:
                            case LlavesA:
                            case LlavesC:
                            case CorchetesA:
                            case CorchetesC:
                            case PuntoComa:
                            case DosPuntos:
                            case Coma:
                            case Punto:
                            case Reservadas:
                            case Igual:
                            case MenorIgualQ:
                            case MayorIgualQ:
                            case MayorQ:
                            case MenorQ:
                            case DistintoQ:
                            case Porcentaje:
                                resultado+= lexer.yytext() +"\t\t|  "+ tokens.name() +"\n";
                                break;

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

    public static void main(String[] args) {
        JFrame frame = new JFrame("FrmPrincipal");
        frame.setContentPane(new FrmPrincipal().PanelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        //Generar Clase Lexer
        String ruta = "I:/PROYECTOS JAVA/AnalizadorLexico/src/Codigo/Lexer.flex";
        generarLexer(ruta);
    }

    public static  void generarLexer(String ruta){ //metodo para crear analizador lexico - Clase Lexer
        File archivo = new File(ruta);
        JFlex.Main.generate(archivo);
    }



}

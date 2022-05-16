/* The following code was generated by JFlex 1.4.3 on 15/05/22 19:56 */

package codigo;
import static codigo.Tokens.*; //Podria ser una tabla Hash


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 15/05/22 19:56 from the specification file
 * <tt>I:/PROYECTOS JAVA/MiniCompiler/Analizador/src/Codigo/Lexer.flex</tt>
 */
class Lexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\4\1\33\2\0\1\4\22\0\1\4\1\34\3\0\1\55"+
    "\1\42\1\57\1\47\1\50\1\37\1\35\1\4\1\36\1\46\1\32"+
    "\12\2\1\45\1\44\1\40\1\3\1\41\2\0\10\1\1\56\21\1"+
    "\1\53\1\0\1\54\3\0\1\16\1\22\1\13\1\12\1\5\1\25"+
    "\1\21\1\30\1\14\1\1\1\23\1\17\1\15\1\6\1\11\1\31"+
    "\1\1\1\10\1\24\1\7\1\26\1\1\1\27\1\20\2\1\1\51"+
    "\1\43\1\52\uff82\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\1\1\2\2\1\1\3\1\4\11\1\1\5\1\6"+
    "\1\7\1\10\1\11\1\12\1\13\1\14\2\2\1\15"+
    "\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25"+
    "\1\26\1\1\1\2\1\0\1\27\5\1\1\30\4\1"+
    "\1\4\1\31\1\32\1\33\1\34\1\35\1\0\1\1"+
    "\1\0\1\36\12\1\1\37\1\0\1\1\1\40\5\1"+
    "\1\41\4\1\1\0\1\42\2\1\1\43\5\1\1\44"+
    "\1\1\1\0\1\1\1\45\4\1\1\46\1\47\1\36"+
    "\1\50\1\51\1\52\2\1\1\53\1\54";

  private static int [] zzUnpackAction() {
    int [] result = new int[112];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\60\0\140\0\220\0\300\0\360\0\u0120\0\u0150"+
    "\0\u0180\0\u01b0\0\u01e0\0\u0210\0\u0240\0\u0270\0\u02a0\0\u02d0"+
    "\0\60\0\60\0\60\0\60\0\60\0\u0300\0\u0330\0\u0360"+
    "\0\u0390\0\60\0\60\0\60\0\u03c0\0\60\0\60\0\60"+
    "\0\60\0\60\0\60\0\u03f0\0\u0420\0\u0450\0\60\0\u0480"+
    "\0\u04b0\0\u04e0\0\u0510\0\u0540\0\140\0\u0570\0\u05a0\0\u05d0"+
    "\0\u0600\0\u0630\0\60\0\60\0\60\0\60\0\60\0\u0660"+
    "\0\u0690\0\u06c0\0\u0450\0\u06f0\0\u0720\0\u0750\0\u0780\0\u07b0"+
    "\0\u07e0\0\u0810\0\u0840\0\u0870\0\u08a0\0\140\0\u08d0\0\u0900"+
    "\0\60\0\u0930\0\u0960\0\u0990\0\u09c0\0\u09f0\0\140\0\u0a20"+
    "\0\u0a50\0\u0a80\0\u0ab0\0\u0ae0\0\60\0\u0b10\0\u0b40\0\140"+
    "\0\u0b70\0\u0ba0\0\u0bd0\0\u0c00\0\u0c30\0\140\0\u0c60\0\u0c90"+
    "\0\u0cc0\0\140\0\u0cf0\0\u0d20\0\u0d50\0\u0d80\0\140\0\140"+
    "\0\60\0\140\0\140\0\140\0\u0db0\0\u0de0\0\140\0\140";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[112];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\6\1\7\1\3\1\10"+
    "\2\3\1\11\1\12\1\13\2\3\1\14\2\3\1\15"+
    "\1\3\1\16\1\17\4\3\1\20\1\21\1\22\1\23"+
    "\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33"+
    "\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43"+
    "\1\44\1\45\61\0\2\3\2\0\25\3\24\0\1\3"+
    "\2\0\1\3\1\4\2\0\25\3\14\0\1\46\7\0"+
    "\1\3\4\0\1\47\60\0\1\6\54\0\2\3\2\0"+
    "\1\3\1\50\23\3\24\0\1\3\2\0\2\3\2\0"+
    "\1\51\24\3\24\0\1\3\2\0\2\3\2\0\1\52"+
    "\24\3\24\0\1\3\2\0\2\3\2\0\11\3\1\53"+
    "\13\3\24\0\1\3\2\0\2\3\2\0\10\3\1\54"+
    "\7\3\1\55\4\3\24\0\1\3\2\0\2\3\2\0"+
    "\4\3\1\56\20\3\24\0\1\3\2\0\2\3\2\0"+
    "\3\3\1\57\21\3\24\0\1\3\2\0\2\3\2\0"+
    "\22\3\1\60\2\3\24\0\1\3\2\0\2\3\2\0"+
    "\4\3\1\61\20\3\24\0\1\3\33\0\1\62\30\0"+
    "\1\63\35\0\1\64\21\0\1\65\116\0\1\66\60\0"+
    "\1\67\52\0\1\70\22\0\2\3\2\0\1\3\1\71"+
    "\23\3\24\0\1\3\2\0\1\72\3\0\25\72\24\0"+
    "\1\72\3\0\1\73\56\0\2\3\2\0\2\3\1\74"+
    "\22\3\24\0\1\3\2\0\2\3\2\0\13\3\1\75"+
    "\11\3\24\0\1\3\2\0\2\3\2\0\6\3\1\76"+
    "\11\3\1\77\4\3\24\0\1\3\2\0\2\3\2\0"+
    "\3\3\1\100\13\3\1\101\5\3\24\0\1\3\2\0"+
    "\2\3\2\0\24\3\1\102\24\0\1\3\2\0\2\3"+
    "\2\0\14\3\1\103\10\3\24\0\1\3\2\0\2\3"+
    "\2\0\1\104\24\3\24\0\1\3\2\0\2\3\2\0"+
    "\7\3\1\105\15\3\24\0\1\3\2\0\2\3\2\0"+
    "\3\3\1\106\21\3\24\0\1\3\1\0\33\62\1\0"+
    "\24\62\2\0\1\107\56\0\2\3\2\0\7\3\1\110"+
    "\15\3\24\0\1\3\2\0\2\72\2\0\25\72\24\0"+
    "\1\72\1\111\1\0\2\3\2\0\1\112\24\3\24\0"+
    "\1\3\2\0\2\3\2\0\2\3\1\113\22\3\24\0"+
    "\1\3\2\0\2\3\2\0\7\3\1\114\15\3\24\0"+
    "\1\3\2\0\2\3\2\0\11\3\1\115\13\3\24\0"+
    "\1\3\2\0\2\3\2\0\11\3\1\116\13\3\24\0"+
    "\1\3\2\0\2\3\2\0\1\117\24\3\24\0\1\3"+
    "\2\0\2\3\2\0\3\3\1\120\21\3\24\0\1\3"+
    "\2\0\2\3\2\0\7\3\1\121\15\3\24\0\1\3"+
    "\2\0\2\3\2\0\11\3\1\122\13\3\24\0\1\3"+
    "\2\0\2\3\2\0\2\3\1\123\22\3\24\0\1\3"+
    "\3\0\1\107\43\0\1\124\1\0\1\125\10\0\2\3"+
    "\2\0\6\3\1\126\16\3\24\0\1\3\2\0\2\3"+
    "\2\0\3\3\1\127\21\3\24\0\1\3\2\0\2\3"+
    "\2\0\4\3\1\130\20\3\24\0\1\3\2\0\2\3"+
    "\2\0\10\3\1\131\14\3\24\0\1\3\2\0\2\3"+
    "\2\0\21\3\1\132\3\3\24\0\1\3\2\0\2\3"+
    "\2\0\6\3\1\133\16\3\24\0\1\3\2\0\2\3"+
    "\2\0\7\3\1\134\15\3\24\0\1\3\2\0\2\3"+
    "\2\0\6\3\1\135\16\3\24\0\1\3\2\0\2\3"+
    "\2\0\16\3\1\136\6\3\24\0\1\3\2\0\2\3"+
    "\2\0\6\3\1\137\16\3\24\0\1\3\3\0\1\140"+
    "\43\0\1\124\12\0\2\3\2\0\7\3\1\141\15\3"+
    "\24\0\1\3\2\0\2\3\2\0\4\3\1\142\20\3"+
    "\24\0\1\3\2\0\2\3\2\0\11\3\1\143\13\3"+
    "\24\0\1\3\2\0\2\3\2\0\12\3\1\144\12\3"+
    "\24\0\1\3\2\0\2\3\2\0\2\3\1\145\22\3"+
    "\24\0\1\3\2\0\2\3\2\0\10\3\1\146\14\3"+
    "\24\0\1\3\2\0\2\3\2\0\4\3\1\147\20\3"+
    "\24\0\1\3\2\0\2\3\2\0\23\3\1\150\1\3"+
    "\24\0\1\3\3\0\1\140\45\0\1\151\10\0\2\3"+
    "\2\0\4\3\1\152\20\3\24\0\1\3\2\0\2\3"+
    "\2\0\12\3\1\153\12\3\24\0\1\3\2\0\2\3"+
    "\2\0\2\3\1\154\22\3\24\0\1\3\2\0\2\3"+
    "\2\0\1\155\24\3\24\0\1\3\2\0\2\3\2\0"+
    "\7\3\1\156\15\3\24\0\1\3\2\0\2\3\2\0"+
    "\3\3\1\157\21\3\24\0\1\3\2\0\2\3\2\0"+
    "\3\3\1\160\21\3\24\0\1\3\1\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[3600];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\1\1\11\16\1\5\11\4\1\3\11\1\1\6\11"+
    "\2\1\1\0\1\11\13\1\5\11\1\0\1\1\1\0"+
    "\14\1\1\0\1\1\1\11\12\1\1\0\1\11\12\1"+
    "\1\0\10\1\1\11\7\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[112];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
    public String lexeme;


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Lexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  Lexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 126) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public Tokens yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 36: 
          { lexeme=yytext(); return Break;
          }
        case 45: break;
        case 1: 
          { lexeme=yytext(); return Identificador;
          }
        case 46: break;
        case 11: 
          { lexeme=yytext(); return Menor;
          }
        case 47: break;
        case 27: 
          { lexeme=yytext(); return MayorIgual;
          }
        case 48: break;
        case 26: 
          { lexeme=yytext(); return Diferente;
          }
        case 49: break;
        case 40: 
          { lexeme=yytext(); return Inicio;
          }
        case 50: break;
        case 14: 
          { lexeme=yytext(); return DosPuntos;
          }
        case 51: break;
        case 44: 
          { lexeme=yytext(); return Imprimir;
          }
        case 52: break;
        case 33: 
          { lexeme=yytext(); return Case;
          }
        case 53: break;
        case 35: 
          { lexeme=yytext(); return Texto;
          }
        case 54: break;
        case 18: 
          { lexeme=yytext(); return LlavesA;
          }
        case 55: break;
        case 17: 
          { lexeme=yytext(); return ParentesisC;
          }
        case 56: break;
        case 25: 
          { lexeme=yytext(); return MenorIgual;
          }
        case 57: break;
        case 31: 
          { lexeme=yytext(); return For;
          }
        case 58: break;
        case 21: 
          { lexeme=yytext(); return CorchetesC;
          }
        case 59: break;
        case 38: 
          { lexeme=yytext(); return Logico;
          }
        case 60: break;
        case 29: 
          { lexeme=yytext(); return Or;
          }
        case 61: break;
        case 5: 
          { lexeme=yytext(); return Division;
          }
        case 62: break;
        case 3: 
          { lexeme=yytext(); return Asignacion;
          }
        case 63: break;
        case 34: 
          { lexeme=yytext(); return Numero;
          }
        case 64: break;
        case 41: 
          { lexeme=yytext(); return Decimal;
          }
        case 65: break;
        case 7: 
          { lexeme=yytext(); return Negacion;
          }
        case 66: break;
        case 30: 
          { lexeme=yytext(); return NumeroDecimal;
          }
        case 67: break;
        case 19: 
          { lexeme=yytext(); return LlavesC;
          }
        case 68: break;
        case 32: 
          { lexeme=yytext(); return Cadena;
          }
        case 69: break;
        case 6: 
          { lexeme=yytext(); return Line;
          }
        case 70: break;
        case 42: 
          { lexeme=yytext(); return Default;
          }
        case 71: break;
        case 15: 
          { lexeme=yytext(); return Punto;
          }
        case 72: break;
        case 13: 
          { lexeme=yytext(); return PuntoComa;
          }
        case 73: break;
        case 9: 
          { lexeme=yytext(); return Resta;
          }
        case 74: break;
        case 12: 
          { lexeme=yytext(); return Mayor;
          }
        case 75: break;
        case 39: 
          { lexeme=yytext(); return Switch;
          }
        case 76: break;
        case 10: 
          { lexeme=yytext(); return Multiplicacion;
          }
        case 77: break;
        case 16: 
          { lexeme=yytext(); return ParentesisA;
          }
        case 78: break;
        case 2: 
          { return ERROR;
          }
        case 79: break;
        case 37: 
          { lexeme=yytext(); return Entero;
          }
        case 80: break;
        case 28: 
          { lexeme=yytext(); return And;
          }
        case 81: break;
        case 43: 
          { lexeme=yytext(); return Caracter;
          }
        case 82: break;
        case 22: 
          { lexeme=yytext(); return Porcentaje;
          }
        case 83: break;
        case 23: 
          { lexeme=yytext(); return Igual;
          }
        case 84: break;
        case 20: 
          { lexeme=yytext(); return CorchetesA;
          }
        case 85: break;
        case 4: 
          { /*Ignore*/
          }
        case 86: break;
        case 24: 
          { lexeme=yytext(); return If;
          }
        case 87: break;
        case 8: 
          { lexeme=yytext(); return Suma;
          }
        case 88: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            return null;
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}

/* Generated By:JavaCC: Do not edit this line. Karloff.java */
import java.io.*;
public class Karloff implements KarloffConstants {

  public static void main(String args[]) throws ParseException,IOException {
    Karloff parser = new Karloff(new FileInputStream(args[0]));
    parser.Karloff();
  }

  static final public void Karloff() throws ParseException {
    Main();
    SeqFunc();
    jj_consume_token(0);
  }

  static final public void VarDecl() throws ParseException {
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case NEWVAR:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      jj_consume_token(NEWVAR);
      jj_consume_token(TIPO);
      jj_consume_token(TOKEN_ID);
      jj_consume_token(PV);
    }
  }

  static final public void SeqCommands() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IF:
    case WHILE:
    case REPEAT:
    case RETURN:
    case SYSTEMOUTPUT:
    case TOKEN_ID:
      Command();
      SeqCommands();
      break;
    default:
      jj_la1[1] = jj_gen;
      ;
    }
  }

  static final public void Atrib() throws ParseException {
    jj_consume_token(TOKEN_ID);
    jj_consume_token(34);
    Exp();
    jj_consume_token(PV);
  }

  static final public void ChamadaFunc() throws ParseException {
    jj_consume_token(TOKEN_ID);
    jj_consume_token(OPENPAR);
    ListaExp();
    jj_consume_token(CLOSEPAR);
    jj_consume_token(PV);
  }

  static final public void IfThen() throws ParseException {
    jj_consume_token(IF);
    jj_consume_token(OPENPAR);
    Exp();
    jj_consume_token(CLOSEPAR);
    jj_consume_token(THEN);
    jj_consume_token(ACHAVES);
    SeqCommands();
    jj_consume_token(FCHAVES);
    jj_consume_token(PV);
  }

  static final public void While() throws ParseException {
    jj_consume_token(WHILE);
    jj_consume_token(OPENPAR);
    Exp();
    jj_consume_token(CLOSEPAR);
    jj_consume_token(ACHAVES);
    SeqCommands();
    jj_consume_token(FCHAVES);
    jj_consume_token(PV);
  }

  static final public void Repeat() throws ParseException {
    jj_consume_token(REPEAT);
    jj_consume_token(ACHAVES);
    SeqCommands();
    jj_consume_token(FCHAVES);
    jj_consume_token(UNTIL);
    jj_consume_token(OPENPAR);
    Exp();
    jj_consume_token(CLOSEPAR);
    jj_consume_token(PV);
  }

  static final public void Output() throws ParseException {
    jj_consume_token(SYSTEMOUTPUT);
    jj_consume_token(OPENPAR);
    Exp();
    jj_consume_token(CLOSEPAR);
    jj_consume_token(PV);
  }

  static final public void ListaExp() throws ParseException {
    Exp();
    ListaExp1();
  }

  static final public void ListaExp1() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 35:
      jj_consume_token(35);
      ListaExp();
      break;
    default:
      jj_la1[2] = jj_gen;
      ;
    }
  }

  static final public void Exp() throws ParseException {
    Fator();
    Exp1();
  }

  static final public void Exp1() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case OP:
      jj_consume_token(OP);
      Exp();
      break;
    default:
      jj_la1[3] = jj_gen;
      ;
    }
  }

  static final public void Return() throws ParseException {
    jj_consume_token(RETURN);
    Exp();
    jj_consume_token(PV);
  }

  static final public void Command() throws ParseException {
    if (jj_2_1(2)) {
      Atrib();
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case TOKEN_ID:
        ChamadaFunc();
        break;
      case IF:
        IfThen();
        break;
      case WHILE:
        While();
        break;
      case REPEAT:
        Repeat();
        break;
      case RETURN:
        Return();
        break;
      case SYSTEMOUTPUT:
        Output();
        break;
      default:
        jj_la1[4] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  static final public void Fator() throws ParseException {
    if (jj_2_2(2)) {
      jj_consume_token(TOKEN_ID);
      jj_consume_token(OPENPAR);
      ListaExp();
      jj_consume_token(CLOSEPAR);
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case TOKEN_ID:
        jj_consume_token(TOKEN_ID);
        break;
      case NUM:
        jj_consume_token(NUM);
        break;
      case TRUE:
        jj_consume_token(TRUE);
        break;
      case FALSE:
        jj_consume_token(FALSE);
        break;
      default:
        jj_la1[5] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  static final public void Arg() throws ParseException {
    jj_consume_token(TIPO);
    jj_consume_token(TOKEN_ID);
  }

  static final public void ListaArgs() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case TIPO:
      Arg();
      ListaArgs1();
      break;
    default:
      jj_la1[6] = jj_gen;
      ;
    }
  }

  static final public void ListaArgs1() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 35:
      jj_consume_token(35);
      ListaArgs();
      break;
    default:
      jj_la1[7] = jj_gen;
      ;
    }
  }

  static final public void Func() throws ParseException {
    jj_consume_token(FUNC);
    jj_consume_token(TIPO);
    jj_consume_token(TOKEN_ID);
    jj_consume_token(OPENPAR);
    ListaArgs();
    jj_consume_token(CLOSEPAR);
    jj_consume_token(ACHAVES);
    VarDecl();
    SeqCommands();
    jj_consume_token(FCHAVES);
  }

  static final public void SeqFunc() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case FUNC:
      Func();
      SeqFunc();
      break;
    default:
      jj_la1[8] = jj_gen;
      ;
    }
  }

  static final public void Main() throws ParseException {
    jj_consume_token(VOID);
    jj_consume_token(MAIN);
    jj_consume_token(ACHAVES);
    VarDecl();
    SeqCommands();
    jj_consume_token(FCHAVES);
  }

  static private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  static private boolean jj_2_2(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_2(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  static private boolean jj_3_2() {
    if (jj_scan_token(TOKEN_ID)) return true;
    if (jj_scan_token(OPENPAR)) return true;
    return false;
  }

  static private boolean jj_3_1() {
    if (jj_3R_2()) return true;
    return false;
  }

  static private boolean jj_3R_2() {
    if (jj_scan_token(TOKEN_ID)) return true;
    if (jj_scan_token(34)) return true;
    return false;
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public KarloffTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private Token jj_scanpos, jj_lastpos;
  static private int jj_la;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[9];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x200,0x801b4000,0x0,0x0,0x801b4000,0x84600000,0x800,0x0,0x800000,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x8,0x2,0x0,0x0,0x0,0x8,0x0,};
   }
  static final private JJCalls[] jj_2_rtns = new JJCalls[2];
  static private boolean jj_rescan = false;
  static private int jj_gc = 0;

  /** Constructor with InputStream. */
  public Karloff(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Karloff(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new KarloffTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 9; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 9; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public Karloff(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new KarloffTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 9; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 9; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public Karloff(KarloffTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 9; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(KarloffTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 9; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  static final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  static private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;
  static private int[] jj_lasttokens = new int[100];
  static private int jj_endpos;

  static private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      boolean exists = false;
      for (java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext();) {
        exists = true;
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              exists = false;
              break;
            }
          }
          if (exists) break;
        }
      }
      if (!exists) jj_expentries.add(jj_expentry);
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[36];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 9; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 36; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

  static private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 2; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
            case 1: jj_3_2(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  static private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}

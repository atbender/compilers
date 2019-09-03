import java.io.*;

enum TokenType{ NUM,SOMA, MULT,APar,FPar, DIV, SUB, EOF}

class Token{
  String lexema;
  TokenType token;

 Token (String l, TokenType t)
 	{ lexema=l;token = t;}	

}

class AnaliseLexica {

	//BufferedReader arquivo;
	PushbackReader arquivo;

	AnaliseLexica(String a) throws Exception
	{
		
	 	this.arquivo = new PushbackReader(new FileReader(a));
		
	}

	Token getNextToken() throws Exception
	{	
		Token token;
		int eof = -1;
		char currchar;
		int currchar1;

			do{
				currchar1 =  arquivo.read();
				currchar = (char) currchar1;
			} while (currchar == '\n' || currchar == ' ' || currchar =='\t' || currchar == '\r');
			
			if(currchar1 != eof && currchar1 !=10) {
								
				if (currchar >= '0' && currchar <= '9') {
					String number = "";
					while (currchar >= '0' && currchar <= '9') {
						number = number + String.valueOf(currchar);
						currchar1 = arquivo.read();
						currchar = (char) currchar1;


						
					}
					// recoloca token lido
					arquivo.unread(currchar);
					return (new Token (number, TokenType.NUM));
				}

				else {
					switch (currchar){
						case '(':
							return (new Token (String.valueOf(currchar),TokenType.APar));
						case ')':
							return (new Token (String.valueOf(currchar),TokenType.FPar));
						case '+':
							return (new Token (String.valueOf(currchar),TokenType.SOMA));
						case '*':
							return (new Token (String.valueOf(currchar),TokenType.MULT));
						case '/':
							return (new Token (String.valueOf(currchar),TokenType.DIV));
						case '-':
							return (new Token (String.valueOf(currchar),TokenType.SUB));
						
						default: throw (new Exception("Caractere inválido: " + ((int) currchar)));
					}
				}
			}

			arquivo.close();
			
		return (new Token(String.valueOf(currchar),TokenType.EOF));
		
	}
}

class CodeGen{
	public boolean isInterp;

	CodeGen(boolean isInterp) {
		this.isInterp = isInterp;
	}
	
	String geraCodigo (ArvoreSintatica arv) {
		if(this.isInterp == true) {
			return (String.valueOf(geraCodigo2_int(arv)));
		}
		else {
			return (geraCodigo2(arv) + "PRINT");
		}
	}

	int geraCodigo2_int(ArvoreSintatica arv) {
		if (arv instanceof Div)
			return (geraCodigo2_int(((Div) arv).arg1) / geraCodigo2_int(((Div) arv).arg2));

		if (arv instanceof Sub)
			return (geraCodigo2_int(((Sub) arv).arg1) - geraCodigo2_int(((Sub) arv).arg2));

		if (arv instanceof Mult)
			return (geraCodigo2_int(((Mult) arv).arg1) * geraCodigo2_int(((Mult) arv).arg2));

		if (arv instanceof Soma)
			return (geraCodigo2_int(((Soma) arv).arg1) + geraCodigo2_int(((Soma) arv).arg2));

		if (arv instanceof Num)
			return ((Num) arv).num;

		return 0;
	}

	String geraCodigo2 (ArvoreSintatica arv) {

		if (arv instanceof Div)
			return (geraCodigo2(((Div) arv).arg1) + geraCodigo2(((Div) arv).arg2) + "DIV\n");

		if (arv instanceof Sub)
			return (geraCodigo2(((Sub) arv).arg1) + geraCodigo2(((Sub) arv).arg2) + "SUB\n");

		if (arv instanceof Mult)
			return (geraCodigo2(((Mult) arv).arg1) + geraCodigo2(((Mult) arv).arg2) + "MULT\n");

		if (arv instanceof Soma)
			return (geraCodigo2(((Soma) arv).arg1) + geraCodigo2(((Soma) arv).arg2) + "SUM\n");

		if (arv instanceof Num)
			return ("PUSH "  + ((Num) arv).num + "\n");

		return "";

	

	
	}
}

package br.com.andreglaucio.aglang.ast;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import br.com.andreglaucio.aglang.datastructure.AGLSymbol;
import br.com.andreglaucio.aglang.datastructure.AGLSymbolTable;

public class AGLProgram {
	private AGLSymbolTable varTable;
	private ArrayList<AbstractCommand> comandos;
	private String programName;
	
	public void generateTarget() {
		StringBuilder str = new StringBuilder();
		str.append("import java.util.Scanner;\n ");
		str.append("public class MainClass{ \n");
		str.append("  public static void main(String args[]){\n ");
		str.append("      Scanner _key = new Scanner(System.in);\n");
		for (AGLSymbol symbol: varTable.getAll()) {
				str.append(symbol.generateJavaCode()+"\n");
		}
		for (AbstractCommand command: comandos) {
			str.append(command.generateJavaCode()+"\n");
		}
		str.append("  }");
		str.append("}");
		
		try {
			FileWriter fr = new FileWriter(new File("MainClass.java"));
			fr.write(str.toString());
			fr.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public AGLSymbolTable getVartable() {
		return varTable;
	}



	public void setVarTable(AGLSymbolTable vartable) {
		this.varTable = vartable;
	}



	public ArrayList<AbstractCommand> getComandos() {
		return comandos;
	}



	public void setComandos(ArrayList<AbstractCommand> comandos) {
		this.comandos = comandos;
	}



	public String getProgramName() {
		return programName;
	}



	public void setProgramName(String programName) {
		this.programName = programName;
	}
}

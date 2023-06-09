// Generated from AGLang.opl by ANTLR 4.7.1
package br.com.andreglaucio.aglang.parser;

	import br.com.andreglaucio.aglang.datastructure.*;
	import br.com.andreglaucio.aglang.exceptions.AGLSemanticException;
	import br.com.andreglaucio.aglang.ast.*;
	import java.util.ArrayList;
	import java.util.Stack;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AGLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, AP=9, 
		FP=10, SC=11, OP=12, ATTR=13, VIR=14, ACH=15, FCH=16, OPREL=17, ID=18, 
		NUMBER=19, WS=20;
	public static final int
		RULE_program = 0, RULE_declaracao = 1, RULE_declaracao_var = 2, RULE_tipo = 3, 
		RULE_bloco = 4, RULE_cmd = 5, RULE_cmdEntrada = 6, RULE_cmdSaida = 7, 
		RULE_cmdAtribui = 8, RULE_cmdDecisao = 9, RULE_expr = 10, RULE_termo = 11;
	public static final String[] ruleNames = {
		"program", "declaracao", "declaracao_var", "tipo", "bloco", "cmd", "cmdEntrada", 
		"cmdSaida", "cmdAtribui", "cmdDecisao", "expr", "termo"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'INICIO'", "'FIM;'", "'numero'", "'texto'", "'leia'", "'escreva'", 
		"'se'", "'senao'", "'('", "')'", "';'", null, "'='", "','", "'{'", "'}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, "AP", "FP", "SC", 
		"OP", "ATTR", "VIR", "ACH", "FCH", "OPREL", "ID", "NUMBER", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "AGLang.opl"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


		private int _tipo;
		private String _varName;
		private String _varValue;
		private AGLSymbolTable symbolTable = new AGLSymbolTable();
		private AGLSymbol symbol;
		private AGLProgram program = new AGLProgram();
		private ArrayList<AbstractCommand> curThread;
		private Stack<ArrayList<AbstractCommand>> stack = new Stack<ArrayList<AbstractCommand>>();
		private String _readID;
		private String _writeID;
		private String _exprID;
		private String _exprContent;
		private String _exprDecision;
		private ArrayList<AbstractCommand> listaTrue;
		private ArrayList<AbstractCommand> listaFalse;
		
		// Método para verificar se um ID existe na tabela de símbolos
		public void verificaID(String id){
			if (!symbolTable.exists(id)){
				throw new AGLSemanticException("Símbolo '"+id+"' não declarado");
			}
		}
		
		// Método para exibir os comandos do programa
		public void exibeComandos(){
			for (AbstractCommand c: program.getComandos()){
				System.out.println(c);
			}
		}
		
		// Método para gerar o código alvo do programa
		public void generateCode(){
			program.generateTarget();
		}	

	public AGLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public DeclaracaoContext declaracao() {
			return getRuleContext(DeclaracaoContext.class,0);
		}
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AGLangListener ) ((AGLangListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AGLangListener ) ((AGLangListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			match(T__0);
			setState(25);
			declaracao();
			setState(26);
			bloco();
			setState(27);
			match(T__1);
			 
					  	// Define a tabela de símbolos e os comandos do programa principal
					  	program.setVarTable(symbolTable);
			           	program.setComandos(stack.pop());
			          
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaracaoContext extends ParserRuleContext {
		public List<Declaracao_varContext> declaracao_var() {
			return getRuleContexts(Declaracao_varContext.class);
		}
		public Declaracao_varContext declaracao_var(int i) {
			return getRuleContext(Declaracao_varContext.class,i);
		}
		public DeclaracaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AGLangListener ) ((AGLangListener)listener).enterDeclaracao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AGLangListener ) ((AGLangListener)listener).exitDeclaracao(this);
		}
	}

	public final DeclaracaoContext declaracao() throws RecognitionException {
		DeclaracaoContext _localctx = new DeclaracaoContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaracao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(30);
				declaracao_var();
				}
				}
				setState(33); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__2 || _la==T__3 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Declaracao_varContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(AGLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AGLangParser.ID, i);
		}
		public TerminalNode SC() { return getToken(AGLangParser.SC, 0); }
		public List<TerminalNode> VIR() { return getTokens(AGLangParser.VIR); }
		public TerminalNode VIR(int i) {
			return getToken(AGLangParser.VIR, i);
		}
		public Declaracao_varContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracao_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AGLangListener ) ((AGLangListener)listener).enterDeclaracao_var(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AGLangListener ) ((AGLangListener)listener).exitDeclaracao_var(this);
		}
	}

	public final Declaracao_varContext declaracao_var() throws RecognitionException {
		Declaracao_varContext _localctx = new Declaracao_varContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaracao_var);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			tipo();
			setState(36);
			match(ID);

								 // Obter o nome e tipo da variável a ser declarada
								 _varName = _input.LT(-1).getText();
								 _varValue = null;
								 
								 // Cria um objeto da variável
								 symbol = new AGLVariable(_varName, _tipo, _varValue);
								 
								 // Verifica se o símbolo já existe na tabela de símbolos
					 			 if (!symbolTable.exists(_varName)){
					 			 		// Adiciona o símbolo na tabela de símbolos
						 				symbolTable.add(symbol);
					 			 }
					 			 else {
					 			 	// Lança uma exceção se o símbolo já foi declarado
					 				throw new AGLSemanticException("Simbolo '"+_varName+"' ja foi declarado");
					 			 }
							
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIR) {
				{
				{
				setState(38);
				match(VIR);
				setState(39);
				match(ID);

									  	 		// Obter o nome e tipo da variável a ser declarada
										  	 	_varName = _input.LT(-1).getText();
										 		_varValue = null;
										 		
										 		// Cria um objeto da variável
										 		symbol = new AGLVariable(_varName, _tipo, _varValue);
										 		
										 		// Verifica se o símbolo já existe na tabela de símbolos
										 		if (!symbolTable.exists(_varName)){
										 			// Adiciona o símbolo na tabela de símbolos
						                   			symbolTable.add(symbol);
						                  		}
						                  		else{
						                  			// Lança uma exceção se o símbolo já foi declarado
						                  			throw new AGLSemanticException("Simbolo '"+_varName+"' ja foi declarado");
						                  		}
									  	 	
				}
				}
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(46);
			match(SC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TipoContext extends ParserRuleContext {
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AGLangListener ) ((AGLangListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AGLangListener ) ((AGLangListener)listener).exitTipo(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_tipo);
		try {
			setState(52);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(48);
				match(T__2);
				 _tipo = AGLVariable.NUMBER; 
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(50);
				match(T__3);
				 _tipo = AGLVariable.TEXT; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlocoContext extends ParserRuleContext {
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public BlocoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloco; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AGLangListener ) ((AGLangListener)listener).enterBloco(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AGLangListener ) ((AGLangListener)listener).exitBloco(this);
		}
	}

	public final BlocoContext bloco() throws RecognitionException {
		BlocoContext _localctx = new BlocoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_bloco);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 
						  curThread = new ArrayList<AbstractCommand>(); // Cria uma nova thread de comandos
						  stack.push(curThread);						// Adiciona a thread à pilha de threads
						
			setState(56); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(55);
				cmd();
				}
				}
				setState(58); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << ID))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdContext extends ParserRuleContext {
		public CmdEntradaContext cmdEntrada() {
			return getRuleContext(CmdEntradaContext.class,0);
		}
		public CmdSaidaContext cmdSaida() {
			return getRuleContext(CmdSaidaContext.class,0);
		}
		public CmdAtribuiContext cmdAtribui() {
			return getRuleContext(CmdAtribuiContext.class,0);
		}
		public CmdDecisaoContext cmdDecisao() {
			return getRuleContext(CmdDecisaoContext.class,0);
		}
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AGLangListener ) ((AGLangListener)listener).enterCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AGLangListener ) ((AGLangListener)listener).exitCmd(this);
		}
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cmd);
		try {
			setState(64);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(60);
				cmdEntrada();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(61);
				cmdSaida();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(62);
				cmdAtribui();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 4);
				{
				setState(63);
				cmdDecisao();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdEntradaContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(AGLangParser.AP, 0); }
		public TerminalNode ID() { return getToken(AGLangParser.ID, 0); }
		public TerminalNode FP() { return getToken(AGLangParser.FP, 0); }
		public TerminalNode SC() { return getToken(AGLangParser.SC, 0); }
		public CmdEntradaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdEntrada; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AGLangListener ) ((AGLangListener)listener).enterCmdEntrada(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AGLangListener ) ((AGLangListener)listener).exitCmdEntrada(this);
		}
	}

	public final CmdEntradaContext cmdEntrada() throws RecognitionException {
		CmdEntradaContext _localctx = new CmdEntradaContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmdEntrada);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(T__4);
			setState(67);
			match(AP);
			setState(68);
			match(ID);
			 verificaID(_input.LT(-1).getText()); 
								 	  _readID = _input.LT(-1).getText();
								 	
			setState(70);
			match(FP);
			setState(71);
			match(SC);

								 	// Obtém a variável correspondente ao ID
								 	AGLVariable var = (AGLVariable)symbolTable.get(_readID);
								 	
								 	// Cria um comando de leitura e adiciona à thread atual
								 	CommandLeitura cmd = new CommandLeitura(_readID, var);
								 	stack.peek().add(cmd);
								 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdSaidaContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(AGLangParser.AP, 0); }
		public TerminalNode ID() { return getToken(AGLangParser.ID, 0); }
		public TerminalNode FP() { return getToken(AGLangParser.FP, 0); }
		public TerminalNode SC() { return getToken(AGLangParser.SC, 0); }
		public CmdSaidaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdSaida; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AGLangListener ) ((AGLangListener)listener).enterCmdSaida(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AGLangListener ) ((AGLangListener)listener).exitCmdSaida(this);
		}
	}

	public final CmdSaidaContext cmdSaida() throws RecognitionException {
		CmdSaidaContext _localctx = new CmdSaidaContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmdSaida);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(T__5);
			setState(75);
			match(AP);
			setState(76);
			match(ID);

										// Verifica se o ID foi declarado 
										verificaID(_input.LT(-1).getText()); 
										_writeID = _input.LT(-1).getText();
										
			setState(78);
			match(FP);
			setState(79);
			match(SC);

										// Cria um comando de escrita e adiciona à thread atual
										CommandEscrita cmd = new CommandEscrita(_writeID);
			               	  			stack.peek().add(cmd);
									
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdAtribuiContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(AGLangParser.ID, 0); }
		public TerminalNode ATTR() { return getToken(AGLangParser.ATTR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SC() { return getToken(AGLangParser.SC, 0); }
		public CmdAtribuiContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdAtribui; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AGLangListener ) ((AGLangListener)listener).enterCmdAtribui(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AGLangListener ) ((AGLangListener)listener).exitCmdAtribui(this);
		}
	}

	public final CmdAtribuiContext cmdAtribui() throws RecognitionException {
		CmdAtribuiContext _localctx = new CmdAtribuiContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmdAtribui);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(ID);

								// Verifica se o ID foi declarado
								verificaID(_input.LT(-1).getText()); 
							   	_exprID = _input.LT(-1).getText();
							 
			setState(84);
			match(ATTR);
			 _exprContent = ""; 
			setState(86);
			expr();
			setState(87);
			match(SC);

						  		// Cria um comando de atribuição e adiciona à thread atual
						  		CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent);
						  		stack.peek().add(cmd);
						  	 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdDecisaoContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(AGLangParser.AP, 0); }
		public List<TerminalNode> ID() { return getTokens(AGLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AGLangParser.ID, i);
		}
		public TerminalNode OPREL() { return getToken(AGLangParser.OPREL, 0); }
		public TerminalNode FP() { return getToken(AGLangParser.FP, 0); }
		public List<TerminalNode> ACH() { return getTokens(AGLangParser.ACH); }
		public TerminalNode ACH(int i) {
			return getToken(AGLangParser.ACH, i);
		}
		public List<TerminalNode> FCH() { return getTokens(AGLangParser.FCH); }
		public TerminalNode FCH(int i) {
			return getToken(AGLangParser.FCH, i);
		}
		public TerminalNode NUMBER() { return getToken(AGLangParser.NUMBER, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdDecisaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdDecisao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AGLangListener ) ((AGLangListener)listener).enterCmdDecisao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AGLangListener ) ((AGLangListener)listener).exitCmdDecisao(this);
		}
	}

	public final CmdDecisaoContext cmdDecisao() throws RecognitionException {
		CmdDecisaoContext _localctx = new CmdDecisaoContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cmdDecisao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(T__6);
			setState(91);
			match(AP);
			setState(92);
			match(ID);
			 _exprDecision = _input.LT(-1).getText(); 
			setState(94);
			match(OPREL);
			 _exprDecision += _input.LT(-1).getText(); 
			setState(96);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==NUMBER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			 _exprDecision += _input.LT(-1).getText(); 
			setState(98);
			match(FP);
			setState(99);
			match(ACH);

							     // Cria uma nova thread para o bloco de comandos do 'se' e a adiciona à pilha
							   	 curThread = new ArrayList<AbstractCommand>();
							   	 stack.push(curThread);
							   
			setState(102); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(101);
				cmd();
				}
				}
				setState(104); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << ID))) != 0) );
			setState(106);
			match(FCH);

							   		// Obtém a thread do bloco de comandos do 'se'
							   		listaTrue = stack.pop();			
							   
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(108);
				match(T__7);
				setState(109);
				match(ACH);

							 				// Cria uma nova thread para o bloco de comandos do 'senao' e a adiciona à pilha
							 				curThread = new ArrayList<AbstractCommand>();
							 				stack.push(curThread);
							 			
				{
				setState(112); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(111);
					cmd();
					}
					}
					setState(114); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << ID))) != 0) );
				}
				setState(116);
				match(FCH);

							 				// Obtém a thread do bloco de comandos do 'senao'
							 				listaFalse = stack.pop();
							 				
							 				// Cria um comando de decisão e adiciona à thread atual
									 		CommandDecisao cmd = new CommandDecisao(_exprDecision, listaTrue, listaFalse);
						                   	stack.peek().add(cmd);
									 	
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public List<TerminalNode> OP() { return getTokens(AGLangParser.OP); }
		public TerminalNode OP(int i) {
			return getToken(AGLangParser.OP, i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AGLangListener ) ((AGLangListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AGLangListener ) ((AGLangListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			termo();
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(122);
				match(OP);
				 _exprContent += _input.LT(-1).getText(); 
				setState(124);
				termo();
				}
				}
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(AGLangParser.ID, 0); }
		public TerminalNode NUMBER() { return getToken(AGLangParser.NUMBER, 0); }
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AGLangListener ) ((AGLangListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AGLangListener ) ((AGLangListener)listener).exitTermo(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_termo);
		try {
			setState(134);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(130);
				match(ID);
				 verificaID(_input.LT(-1).getText()); 
								   _exprContent += _input.LT(-1).getText();
								 
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(132);
				match(NUMBER);

									   _exprContent += _input.LT(-1).getText();
									 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\26\u008b\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\2\3\2\3\2\3\3\6\3\"\n\3\r\3\16\3#"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\7\4,\n\4\f\4\16\4/\13\4\3\4\3\4\3\5\3\5\3\5\3"+
		"\5\5\5\67\n\5\3\6\3\6\6\6;\n\6\r\6\16\6<\3\7\3\7\3\7\3\7\5\7C\n\7\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\6\13i\n\13\r\13\16\13j\3\13\3\13\3\13\3\13\3\13\3\13\6\13"+
		"s\n\13\r\13\16\13t\3\13\3\13\3\13\5\13z\n\13\3\f\3\f\3\f\3\f\7\f\u0080"+
		"\n\f\f\f\16\f\u0083\13\f\3\r\3\r\3\r\3\r\5\r\u0089\n\r\3\r\2\2\16\2\4"+
		"\6\b\n\f\16\20\22\24\26\30\2\3\3\2\24\25\2\u008a\2\32\3\2\2\2\4!\3\2\2"+
		"\2\6%\3\2\2\2\b\66\3\2\2\2\n8\3\2\2\2\fB\3\2\2\2\16D\3\2\2\2\20L\3\2\2"+
		"\2\22T\3\2\2\2\24\\\3\2\2\2\26{\3\2\2\2\30\u0088\3\2\2\2\32\33\7\3\2\2"+
		"\33\34\5\4\3\2\34\35\5\n\6\2\35\36\7\4\2\2\36\37\b\2\1\2\37\3\3\2\2\2"+
		" \"\5\6\4\2! \3\2\2\2\"#\3\2\2\2#!\3\2\2\2#$\3\2\2\2$\5\3\2\2\2%&\5\b"+
		"\5\2&\'\7\24\2\2\'-\b\4\1\2()\7\20\2\2)*\7\24\2\2*,\b\4\1\2+(\3\2\2\2"+
		",/\3\2\2\2-+\3\2\2\2-.\3\2\2\2.\60\3\2\2\2/-\3\2\2\2\60\61\7\r\2\2\61"+
		"\7\3\2\2\2\62\63\7\5\2\2\63\67\b\5\1\2\64\65\7\6\2\2\65\67\b\5\1\2\66"+
		"\62\3\2\2\2\66\64\3\2\2\2\67\t\3\2\2\28:\b\6\1\29;\5\f\7\2:9\3\2\2\2;"+
		"<\3\2\2\2<:\3\2\2\2<=\3\2\2\2=\13\3\2\2\2>C\5\16\b\2?C\5\20\t\2@C\5\22"+
		"\n\2AC\5\24\13\2B>\3\2\2\2B?\3\2\2\2B@\3\2\2\2BA\3\2\2\2C\r\3\2\2\2DE"+
		"\7\7\2\2EF\7\13\2\2FG\7\24\2\2GH\b\b\1\2HI\7\f\2\2IJ\7\r\2\2JK\b\b\1\2"+
		"K\17\3\2\2\2LM\7\b\2\2MN\7\13\2\2NO\7\24\2\2OP\b\t\1\2PQ\7\f\2\2QR\7\r"+
		"\2\2RS\b\t\1\2S\21\3\2\2\2TU\7\24\2\2UV\b\n\1\2VW\7\17\2\2WX\b\n\1\2X"+
		"Y\5\26\f\2YZ\7\r\2\2Z[\b\n\1\2[\23\3\2\2\2\\]\7\t\2\2]^\7\13\2\2^_\7\24"+
		"\2\2_`\b\13\1\2`a\7\23\2\2ab\b\13\1\2bc\t\2\2\2cd\b\13\1\2de\7\f\2\2e"+
		"f\7\21\2\2fh\b\13\1\2gi\5\f\7\2hg\3\2\2\2ij\3\2\2\2jh\3\2\2\2jk\3\2\2"+
		"\2kl\3\2\2\2lm\7\22\2\2my\b\13\1\2no\7\n\2\2op\7\21\2\2pr\b\13\1\2qs\5"+
		"\f\7\2rq\3\2\2\2st\3\2\2\2tr\3\2\2\2tu\3\2\2\2uv\3\2\2\2vw\7\22\2\2wx"+
		"\b\13\1\2xz\3\2\2\2yn\3\2\2\2yz\3\2\2\2z\25\3\2\2\2{\u0081\5\30\r\2|}"+
		"\7\16\2\2}~\b\f\1\2~\u0080\5\30\r\2\177|\3\2\2\2\u0080\u0083\3\2\2\2\u0081"+
		"\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\27\3\2\2\2\u0083\u0081\3\2\2\2"+
		"\u0084\u0085\7\24\2\2\u0085\u0089\b\r\1\2\u0086\u0087\7\25\2\2\u0087\u0089"+
		"\b\r\1\2\u0088\u0084\3\2\2\2\u0088\u0086\3\2\2\2\u0089\31\3\2\2\2\f#-"+
		"\66<Bjty\u0081\u0088";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
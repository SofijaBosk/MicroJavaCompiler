package rs.ac.bg.etf.pp1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import java_cup.runtime.Symbol;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import rs.ac.bg.etf.pp1.ast.Program;
import rs.ac.bg.etf.pp1.util.Log4JUtils;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;

public class MJCodeGenerationTest {

	static {
		DOMConfigurator.configure(Log4JUtils.instance().findLoggerConfigFile());
		Log4JUtils.instance().prepareLogFile(Logger.getRootLogger());
	}
	
	public static void main(String[] args) throws Exception {
		
		Logger log = Logger.getLogger(MJParserTest.class);
		
		Reader br = null;
		try {
			//File sourceCode = new File("test/test2.mj");
			//File sourceCode = new File("test/testovi/test301.mj");
			String filename="test_asm";
			File sourceCode = new File("test/"+filename+".mj");
			//File sourceCode = new File("test/testovi/test302.mj");
			log.info("Compiling source file: " + sourceCode.getAbsolutePath());
			
			br = new BufferedReader(new FileReader(sourceCode));
			Yylex lexer = new Yylex(br);
			
			MJParser p = new MJParser(lexer);
	        Symbol s = p.parse();  //pocetak parsiranja
	        
	        Program prog = (Program)(s.value); 
	        //Tab.init();
	        SystemTableEx.init();
	        // ispis sintaksnog stabla
			log.info(prog.toString(""));
			log.info("===================================");

			// ispis prepoznatih programskih konstrukcija
			SemanticPass v = new SemanticPass();
			prog.traverseBottomUp(v); 
	      
			//log.info(" Print count calls = " + v.printCallCount);

//			log.info(" Deklarisanih lokalnih promenljivih ima = " + v.varDeclCount);
//			log.info(" Globalne promenljive = " + v.globalVarCnt);
//			log.info(" Globalni nizovi = " + v.globalArrayCnt);
//			log.info(" Lokalne promenjive u main = " + v.mainLocalVarCnt);
//			log.info(" Lokalne promenjive u nVars = " + v.nVars);
			System.out.println("==================SINTAKSNA ANALIZA====================");
			log.info(" Methods in the program = " + v.methodCnt);
			log.info(" Global variables = " + v.globalVarCnt);
			log.info(" Global arrays = " + v.globalArrayCnt);
			log.info(" Global constants = " + v.globalConstCnt);
			log.info(" Local variables in main = " + v.mainLocalVarCnt);
			log.info(" Statements in main  = " + v.statementCnt);
			log.info(" Function calls in main = " + v.mainFuncCallCnt);
			
			/* 
				1 methods in the program
				0 global variables
				1 global constants
				1 global arrays
				3 local variables in main
				13 statements in main
				2 function calls in main
			 */
			
			int dataSize=v.globalVarCnt+v.namespaceCnt;
			
			Tab.dump();
			
			if(!p.errorDetected && v.passed()){
				File objFile = new File("test/"+filename+".obj");
	        	log.info("Generating bytecode file: " + objFile.getAbsolutePath());
	        	if (objFile.exists())
	        		objFile.delete();
	        	
				//Code generation...
	        	System.out.println("Data size"+dataSize);
				CodeGenerator codeGenerator = new CodeGenerator();
				prog.traverseBottomUp(codeGenerator);
				Code.dataSize = dataSize;
				Code.mainPc = codeGenerator.getMainPc();
				Code.write(new FileOutputStream(objFile));
				log.info("Parsiranje uspesno zavrseno!");
			}else{
				log.error("Parsiranje NIJE uspesno zavrseno!");
			}
		} 
		finally {
			if (br != null) try { br.close(); } catch (IOException e1) { log.error(e1.getMessage(), e1); }
		}

	}
	
	
}



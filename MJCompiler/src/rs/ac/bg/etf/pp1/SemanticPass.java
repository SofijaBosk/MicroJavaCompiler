package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;

public class SemanticPass extends VisitorAdaptor {

	int i=0;
	int printCallCount = 0;
	int varDeclCount = 0;
	Obj currentMethod = null;
	boolean returnFound = false;
	boolean errorDetected = false;
	
	int globalArrayCnt = 0;
	int globalVarCnt = 0;
	int mainLocalVarCnt = 0;
	
	int nVars;
	
	Logger log = Logger.getLogger(getClass());
	
	public void tester()
	{
        System.out.println("=====================State "+(i++)+"=========================");
	}

	public void report_error(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message); 
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.info(msg.toString());
	}
	
	private void insertVar(String name,Struct type, int line) {
		
		if(Tab.currentScope().findSymbol(name) != null)
		{
			report_error("Greska na " + line + "(" + name + ") vec deklarisano",null);
			return;
		}
          
		int kind;
		
//        if (currentMethod.equals(Tab.noObj)) {
//            kind = Obj.Fld;
//        } else {
            kind = Obj.Var;
//        }
        
        
        Obj tempObj = Tab.insert(kind, name, type);

        if (tempObj.getKind() == Obj.Var) {
            if (tempObj.getType().getKind() == Struct.Array) {
                if (tempObj.getLevel() == 0) {
                    globalArrayCnt++;
                }
            } else {
                if (tempObj.getLevel() == 0) {
                    globalVarCnt++;
                }
//                 else if ("main".equalsIgnoreCase(currentMethod.getName())) {
//                    mainLocalVarCnt++;
//                }
            }
        }
        	        
	}
	
	public void visit(VarDecl_ID varDecl){
		varDeclCount++;
		report_info("Deklarisana promenljiva "+ varDecl.getVarName(), varDecl);
		//Obj varNode = Tab.insert(Obj.Var, varDecl.getVarName(), Tab.noType);
		
		insertVar(varDecl.getVarName(),Tab.noType,varDecl.getLine());
		//varDecl.getType().struct
	}
	public void visit(VarDecl_SQ varDecl){
		varDeclCount++;
		report_info("Deklarisana promenljiva "+ varDecl.getVarName(), varDecl);
		//Obj varNode = Tab.insert(Obj.Var, varDecl.getVarName(), Tab.noType);
		insertVar(varDecl.getVarName(),new Struct(Struct.Array, Tab.noType),varDecl.getLine());
	}
	
    public void visit(PrintStmt print) {
		printCallCount++;
	}
    
    public void visit(ProgName progName){
    	progName.obj = Tab.insert(Obj.Prog, progName.getProgName(), Tab.noType);
    	//progName.obj - obj koju je insert napravio i stavio u tabelu simbola    	
    	Tab.openScope();
    	 System.out.println("Deklarisan program"+progName.getProgName());
    }
    
    public void visit(Program program){
    	nVars = Tab.currentScope.getnVars();
    	Tab.chainLocalSymbols(program.getProgName().obj);
    	Tab.closeScope();
    }
    
//    public void visit(Type type){
//    	Obj typeNode = Tab.find(type.getTypeName());
//    	//Proveravamo da li se radi o tipu ili ne
//    	if(typeNode == Tab.noObj){
//    		report_error("Nije pronadjen tip " + type.getTypeName() + " u tabeli simbola! ", null);
//    		type.struct = Tab.noType;
//    	}else{//nadjeno u tabeli
//    		if(Obj.Type == typeNode.getKind()){
//    			type.struct = typeNode.getType();
//    		}else{
//    			report_error("Greska: Ime " + type.getTypeName() + " ne predstavlja tip!", type);
//    			type.struct = Tab.noType;
//    		}
//    	}
//    }
    
    public void visit(MethodTypeName methodTypeName){
    	boolean a=true;
    	Object methObj = Tab.currentScope().findSymbol(methodTypeName.getMethName());
		if(methObj==null) a=false;
    	report_info("Obradjuje se funkcija " + methodTypeName.getMethName(), methodTypeName);
    	System.out.println("aaaaaaaa"+(a?"da":"ne"));
    	currentMethod = Tab.insert(Obj.Meth, methodTypeName.getMethName(), methodTypeName.getReturnMethod().obj.getType());
    	methodTypeName.obj = currentMethod;
    	Tab.openScope(); //otvaramo scope unutar metode
		report_info("Obradjuje se funkcija " + methodTypeName.getMethName(), methodTypeName);
    }
    
    public void visit(ReturnMethod_Type returnMethod){
    	returnMethod.obj =Tab.noObj; //returnMethod.getType();
    }
    
    public void visit(ReturnMethod_Void returnMethod){    	
    	returnMethod.obj = Tab.noObj;
    }
    
    public void visit(DesignatorHelper_Scope designator){
    	Obj obj = Tab.find(designator.getName());
    	if(obj == Tab.noObj){
			report_error("Greska na liniji " + designator.getLine()+ " : ime "+designator.getName()+" nije deklarisano! ", null);
    	}
    	designator.obj = obj;
    }
    
    public void visit(DesignatorHelper_None designator){
    	Obj obj = Tab.find(designator.getName());
    	if(obj == Tab.noObj){
			report_error("Greska na liniji " + designator.getLine()+ " : ime "+designator.getName()+" nije deklarisano! ", null);
    	}
    	designator.obj = obj;
    }
    
    
    public void visit(FuncCall funcCall){
    	Obj func = funcCall.getDesignator().obj;
    	if(Obj.Meth == func.getKind()){
			report_info("Pronadjen poziv funkcije " + func.getName() + " na liniji " + funcCall.getLine(), null);
			funcCall.struct = func.getType();
    	}else{
			report_error("Greska na liniji " + funcCall.getLine()+" : ime " + func.getName() + " nije funkcija!", null);
			funcCall.struct = Tab.noType;
    	}
    }
    
   public void visit(Term_Factor term){
    	term.struct = term.getFactor().struct;
    }
    
    public void visit(TermExpr termExpr){
    	termExpr.struct = termExpr.getTerm().struct;
    }
    
    public void visit(AddExpr addExpr){
    	Struct te = addExpr.getExpr().struct;
    	Struct t = addExpr.getTerm().struct;
    	if(te.equals(t) && te == Tab.intType){
    		addExpr.struct = te;
    	}else{
			report_error("Greska na liniji "+ addExpr.getLine()+" : nekompatibilni tipovi u izrazu za sabiranje.", null);
			addExpr.struct = Tab.noType;
    	}
    }
    
    public void visit(ConstFactor cnst){
    	cnst.struct = Tab.intType;
    }
    
    public void visit(VarFactor var){
    	var.struct = var.getDesignator().obj.getType();
    }
    
    public void visit(ReturnExpr returnExpr){
    	returnFound = true;
    	Struct currMethType = currentMethod.getType();
    	if(!currMethType.compatibleWith(returnExpr.getExpr().struct)){
			report_error("Greska na liniji " + returnExpr.getLine() + " : " + "tip izraza u return naredbi ne slaze se sa tipom povratne vrednosti funkcije " + currentMethod.getName(), null);
    	}
    }
    
    public void visit(Assignment assignment){
    	if(!assignment.getExpr().struct.assignableTo(assignment.getDesignator().obj.getType()))
    		report_error("Greska na liniji " + assignment.getLine() + " : " + "nekompatibilni tipovi u dodeli vrednosti! ", null);
    }
    
    
    public boolean passed(){
    	return !errorDetected;
    }
    
}

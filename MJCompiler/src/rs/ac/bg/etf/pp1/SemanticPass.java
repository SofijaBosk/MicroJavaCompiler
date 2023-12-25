package rs.ac.bg.etf.pp1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;

public class SemanticPass extends VisitorAdaptor {

	int i=0;
	int printCallCount = 0;
	int varDeclCount = 0;
	Obj currentMethod = Tab.noObj;;
	boolean returnFound = false;
	boolean errorDetected = false;
	
	private Obj currType = Tab.noObj;
	
	int globalArrayCnt = 0;
	int globalVarCnt = 0;
	int mainLocalVarCnt = 0;	
	int methodCnt=0;
	
	int globalConstCnt=0;
	int mainFuncCallCnt=0;
	
	int nVars;
	
	private Stack<ArrayList<Struct>> ActParList;
	private ArrayList<Obj> currentMethFormPars;
	
	Logger log = Logger.getLogger(getClass());
	
	public SemanticPass() {
		ActParList = new Stack<>();
		ActParList.push(new ArrayList<Struct>());
		currentMethFormPars = null;
	}
	
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
		
        //if (currentMethod.equals(Tab.noObj)) {
        //    kind = Obj.Fld;
        //} else {
            kind = Obj.Var;
        //}
        
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
                 else if ("main".equalsIgnoreCase(currentMethod.getName())) {
                    mainLocalVarCnt++;
                }
            }
        }
        	        
	}
	
//	public void visit(VarDecl varDecl){
//		currType=varDecl.getType().obj;
//	}
	
	
	//Treba nam dummy funkcija inace prvi var ce biti noType
  public void visit(TypeDummy typeDummy) {
	  currType = typeDummy.getType().obj;
  }
	
	public void visit(SingleVarDecl varDecl){
		currType = new Obj(1, "vardecl", Tab.intType);
	}
	public void visit(MultipleVarDecl varDecl){
		currType = new Obj(1, "vardecl", Tab.intType);
	}
	
	
	public void visit(VarDecl_ID varDecl){
		varDeclCount++;
		report_info("Deklarisana promenljiva "+ varDecl.getVarName(), varDecl);
		//Obj varNode = Tab.insert(Obj.Var, varDecl.getVarName(), Tab.noType);
		
		insertVar(varDecl.getVarName(),currType.getType(),varDecl.getLine());
		//varDecl.getType().struct
	}
	public void visit(VarDecl_SQ varDecl){
		varDeclCount++;
		report_info("Deklarisana promenljiva "+ varDecl.getVarName(), varDecl);
		//Obj varNode = Tab.insert(Obj.Var, varDecl.getVarName(), Tab.noType);
		insertVar(varDecl.getVarName(),new Struct(Struct.Array, currType.getType()),varDecl.getLine());
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
    
    public void visit(Type_ID type){
    	Obj typeNode = Tab.find(type.getTypeName());
    	//type.obj = typeNode;
    	//Proveravamo da li se radi o tipu ili ne
    	if(typeNode == Tab.noObj){
    		report_error("Nije pronadjen tip " + type.getTypeName() + " u tabeli simbola! ", null);
    		type.obj = Tab.noObj;
    	}else{//nadjeno u tabeli
    		if(Obj.Type == typeNode.getKind()){
    			type.obj = typeNode;
    		}else{
    			report_error("Greska: Ime " + type.getTypeName() + " ne predstavlja tip!", type);
    			type.obj = Tab.noObj;
    		}
    	}
    }
    
    

    
    public void visit(MethodTypeName methodTypeName){
    	Object methObj = Tab.currentScope().findSymbol(methodTypeName.getMethName());
    	report_info("Obradjuje se funkcija " + methodTypeName.getMethName(), methodTypeName);
    	currentMethod = Tab.insert(Obj.Meth, methodTypeName.getMethName(), methodTypeName.getReturnMethod().obj.getType());
    	methodTypeName.obj = currentMethod;
    	Tab.openScope(); //otvaramo scope unutar metode
 }
    
    public void visit(ReturnMethod_Type returnMethod){
    	returnMethod.obj = returnMethod.getType().obj;
    }
    
    public void visit(ReturnMethod_Void returnMethod){    	
    	returnMethod.obj = Tab.noObj;
    }
    
    
    public void visit(FormPars fpars){    	
    	currentMethFormPars = new ArrayList<>();
    }
    
    public void visit(MethodDecl methodDecl) {
        methodCnt++;
        
        if (!returnFound && !currentMethod.getType().equals(Tab.noType)) {
            report_error("Greska na " + methodDecl.getLine() + "(" + currentMethod.getName() + ") nema return iskaz",null);
        }

        Tab.chainLocalSymbols(currentMethod);
        Tab.closeScope();

        currentMethod = Tab.noObj;
        returnFound = false;
        
    }
    
    public void visit(FormParsDummy formParsDummy) {
        currentMethFormPars = new ArrayList<>();
    }
    
    
    public void visit(MethodParams methodDecl){  
    	String methName=methodDecl.getMethodTypeName().getMethName();
        Obj tempObj = Tab.currentScope().findSymbol(methName);
        
        if (tempObj == null) { // new Method Decl     
            currentMethod = Tab.insert(Obj.Meth, methName, methodDecl.getMethodTypeName().obj.getType());
            Tab.openScope();
            
            int fpCnt = 1;
            for (Obj methFormPar : currentMethFormPars) {
                Obj temp = Tab.insert(methFormPar.getKind(), methFormPar.getName(), methFormPar.getType());
                temp.setFpPos(fpCnt++);
            }

            currentMethod.setLevel(currentMethFormPars.size());
        } else {
            report_error("Greska (" + methName + ") vec deklarisano",methodDecl);
        }
    
        if (currentMethod.equals(Tab.noObj)) {
            currentMethod = new Obj(Obj.Meth, "methodErrorDummy", methodDecl.getMethodTypeName().obj.getType());
            Tab.openScope();

            int fpCnt = 1;
            for (Obj methFormPar : currentMethFormPars) {
                Obj temp = Tab.insert(methFormPar.getKind(), methFormPar.getName(), methFormPar.getType());
                temp.setFpPos(fpCnt);
            }

            currentMethod.setLevel(currentMethFormPars.size());
        }

        methodDecl.obj = currentMethod;
        currentMethFormPars = null;     
        
    }
    	
    
    
    
    public void visit(FormParDecl_Single fpars){
    	
    	Obj formParObj = new Obj(Obj.Var, fpars.getName(),fpars.getType().obj.getType());
        currentMethFormPars.add(formParObj);
    }
    
    public void visit(FormParDecl_Array fpars){
    	
    	Obj formParObj = new Obj(Obj.Var, fpars.getName(),new Struct(Struct.Array, fpars.getType().obj.getType()));
        currentMethFormPars.add(formParObj);        
    } 
    
    public void visit(ReturnExpr returnExpr){
    	returnFound = true;
    	Struct currMethType = currentMethod.getType();
    	if(!currMethType.compatibleWith(returnExpr.getExpr().struct)){
			report_error("Greska na liniji " + returnExpr.getLine() + " : " + "tip izraza u return naredbi ne slaze se sa tipom povratne vrednosti funkcije " + currentMethod.getName(), null);
    	}
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
    	if(te.equals(t)) { //&& te == Tab.intType){
    		addExpr.struct = te;
    	}else{
			report_error("Nekompatibilni tipovi u izrazu za sabiranje", addExpr);
			addExpr.struct = Tab.noType;
    	}
    	
    	addExpr.struct = addExpr.getExpr().struct;
    }
    
    public void visit(ConstFactor cnst){
    	cnst.struct = Tab.intType;
    }
        
   
    public void visit(IntegerConst constDecl) {
    	constDecl.obj = new Obj(Obj.Con, "", Tab.intType, constDecl.getIntConstValue().intValue(), Obj.NO_VALUE);
    	Obj tempObj = constDecl.obj;
            if (Tab.currentScope().findSymbol(constDecl.getIntConstName()) == null) {
                Obj temp = Tab.insert(tempObj.getKind(), constDecl.getIntConstName(), tempObj.getType());
                temp.setAdr(tempObj.getAdr());

                if (temp.getLevel() == 0) {
                    globalConstCnt++;
                }
            }
	}
    
    
//TO DO : BOOL TYPE (Extend Tab?)   
    public void visit(BooleanConst constDecl) { 
    	//Boolean.valueOf((Boolean)constDecl.getBooleanConstValue()) ? 1 : 0
    	constDecl.obj = new Obj(Obj.Con, "", SystemTableEx.boolType,constDecl.getBooleanConstValue()=="true"?1:0, Obj.NO_VALUE);
    	Obj tempObj = constDecl.obj;
            if (Tab.currentScope().findSymbol(constDecl.getBooleanConstName()) == null) {
                Obj temp = Tab.insert(tempObj.getKind(), constDecl.getBooleanConstName(), tempObj.getType());
                temp.setAdr(tempObj.getAdr());

                if (temp.getLevel() == 0) {
                    globalConstCnt++;
                }
            }
	}
    
    public void visit(CharacterConst constDecl) {
    	constDecl.obj = new Obj(Obj.Con, "", Tab.charType, constDecl.getCharConstValue().charValue(), Obj.NO_VALUE);
    	Obj tempObj = constDecl.obj;
            if (Tab.currentScope().findSymbol(constDecl.getCharConstName()) == null) {
                Obj temp = Tab.insert(tempObj.getKind(), constDecl.getCharConstName(), tempObj.getType());
                temp.setAdr(tempObj.getAdr());

                if (temp.getLevel() == 0) {
                    globalConstCnt++;
                }
            }
	}
    
    /*DesignatorStatement*/
    public void visit(Assignment assignment) {
        Obj desigObj = assignment.getDesignator().obj;
        int kind = desigObj.getKind();

        if (kind != Obj.Var && kind != Obj.Elem && kind != Obj.Fld) {
            report_error("Greska na " + assignment.getLine() + ": neispravna leva strana dodele",assignment);
        }
        else if(!(desigObj.getType().equals(assignment.getExpr().struct))){
        	report_error("Nekompatibilni tipovi u dodeli vrednosti ", assignment);
        }
        
    }
    
    public void visit(DesignatorStatement_INC ds){
    	Obj desigObj = ds.getDesignator().obj;
        int kind = desigObj.getKind();

        if (kind != Obj.Var && kind != Obj.Elem && kind != Obj.Fld ) {
            report_error("Greska (" + desigObj.getName() + ") nije promenljiva",ds);
        } else if (!desigObj.getType().equals(Tab.intType)) {
            report_error("Greska (" + desigObj.getName() + ") nije int",ds);
        }
    }
    
    public void visit(DesignatorStatement_DEC ds){
    	Obj desigObj = ds.getDesignator().obj;
        int kind = desigObj.getKind();

        if (kind != Obj.Var && kind != Obj.Elem && kind != Obj.Fld ) {
            report_error("Greska (" + desigObj.getName() + ") nije promenljiva",ds);
        } else if (!desigObj.getType().equals(Tab.intType)) {
            report_error("Greska (" + desigObj.getName() + ") nije int",ds);
        }
    }
    
    public void visit(Designator_Ident desg){
    	desg.obj = desg.getDesignatorHelper().obj;
    }
    
    public void visit(ActPars_Single actPars) {
    	ActParList.peek().add(actPars.getExpr().struct);
    }
    
    public void visit(ActPars_List actPars) {
    	ActParList.peek().add(actPars.getExpr().struct);
    }
    
    
    public void visit(FunctionCall func){
        if ("main".equalsIgnoreCase(currentMethod.getName())) {
            mainFuncCallCnt++;
        }

        Obj desigObj = func.getDesignator().obj;
        ArrayList<Struct> currentActParTypes = ActParList.pop();

        if (desigObj.getKind() != Obj.Meth) {
            report_error("Greska na " + func.getLine() + "(" + desigObj.getName() + ") nije funkcija",null);
            func.struct = Tab.noType;
        } else {
            int numOfFPs = desigObj.getLevel();
            if (numOfFPs != currentActParTypes.size()) {
                report_error("Greska neispravan broj parametara funkcije",func);
            } else {
                ArrayList<Obj> methLocalParams = new ArrayList<>(desigObj.getLocalSymbols());
                if (desigObj.equals(currentMethod)) {
                    // specijalni slucaj: rekurzija, lokalni simboli metode su jos u trenutnom scope-u
                    methLocalParams = new ArrayList<>(Tab.currentScope().values());
                }

                if ("len".equals(desigObj.getName())) {
                    Struct arr = currentActParTypes.get(0);
                    if (arr.getKind() != Struct.Array || (!arr.getElemType().equals(Tab.intType) && !arr.getElemType().equals(Tab.charType))) {
                        report_error("Greska neispravni argumenti metode len(arr)",func);
                    }
                } else {
                    int offset = 0;

                    for (int i = 0; i < numOfFPs; i++) {
                        Obj formPar = methLocalParams.get(offset + i);
                        Struct actParType = currentActParTypes.get(i);
                        if (!actParType.assignableTo(formPar.getType())) {
                            report_error("Greska (" + desigObj.getName() + ") poziv nema ispravne parametre",func);
                            break;
                        }
                    }
                }
            }

            func.struct = desigObj.getType();
        }
    }
    
    
    
   
    
    public void visit(VarFactor var){
    	var.struct = var.getDesignator().obj.getType();
    }
    
    
    public boolean passed(){
    	return !errorDetected;
    }
    
}

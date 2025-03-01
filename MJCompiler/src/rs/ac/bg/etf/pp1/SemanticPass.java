package rs.ac.bg.etf.pp1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import javax.swing.text.TabExpander;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;
import rs.etf.pp1.symboltable.structure.SymbolDataStructure;


public class SemanticPass extends VisitorAdaptor {

	int i=0;
	int printCallCount = 0;
	int varDeclCount = 0;
	Obj currentMethod = Tab.noObj;
	Obj currentDesignator = Tab.noObj;
	int currentNamespaceID = 0;
	boolean returnFound = false;
	boolean errorDetected = false;
	Obj prog;
	
	private Obj currType = Tab.noObj;
	static public ArrayList<ArrayList<String>> namespaceList=new ArrayList<ArrayList<String>>();
	public Map<Obj, Obj> namespaceMap = new HashMap<>();
	int globalArrayCnt = 0;
	int globalVarCnt = 0;
	int mainLocalVarCnt = 0;	
	int methodCnt=0;
	int namespaceCnt=0;
	int statementCnt=0;
	private String currentNamespace = "";
	
	int globalConstCnt=0;
	int mainFuncCallCnt=0;
	
	int nVars=0;
	
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
		
		if(Tab.currentScope().findSymbol(name) != null /*&& !namespaceList.get(currentNamespaceID).contains(name)*/)
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
                    //nVars++;
                }
                 else if ("main".equalsIgnoreCase(currentMethod.getName())) {
                    mainLocalVarCnt++;
                    //nVars++;
                }
                
            }
            
//            System.out.println(namespaceList.get(currentNamespaceID).get(0).toString());
//            System.out.println(currentMethod.getName());
           
        }
        if (namespaceList.get(currentNamespaceID).get(0).toString().equalsIgnoreCase(currentMethod.getName())) {
        	namespaceList.get(currentNamespaceID).add(name);
        	System.out.println(namespaceList.get(currentNamespaceID).get(1));
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
		report_info("Deklarisana promenljiva "+ namespaceHelper(varDecl.getVarName(),currentNamespace), varDecl);
		//Obj varNode = Tab.insert(Obj.Var, varDecl.getVarName(), Tab.noType);
		
		insertVar(namespaceHelper(varDecl.getVarName(),currentNamespace),currType.getType(),varDecl.getLine());
		//varDecl.getType().struct
	}
	public void visit(VarDecl_SQ varDecl){
		varDeclCount++;
		report_info("Deklarisana promenljiva "+ namespaceHelper(varDecl.getVarName(),currentNamespace), varDecl);
		//Obj varNode = Tab.insert(Obj.Var, varDecl.getVarName(), Tab.noType);
		insertVar(namespaceHelper(varDecl.getVarName(),currentNamespace),new Struct(Struct.Array, currType.getType()),varDecl.getLine());
	}

    
    public void visit(ProgName progName){
    	progName.obj = Tab.insert(Obj.Prog, progName.getProgName(), Tab.noType);
    	//progName.obj - obj koju je insert napravio i stavio u tabelu simbola    	
    	Tab.openScope();
    	 System.out.println("Deklarisan program"+progName.getProgName());
    	 prog=progName.obj;
    }
    
    public void visit(Program program){
    	nVars = Tab.currentScope.getnVars();
    	Tab.chainLocalSymbols(program.getProgName().obj);
    	Tab.closeScope();
    }
    
    public void visit(NamespaceName nsName){
//    	Object methObj = Tab.currentScope().findSymbol(nsName.getName());
//    	report_info("Obradjuje se funkcija " + nsName.getName(), nsName);
//    	currentMethod = Tab.insert(Obj.Var, nsName.getName(), Tab.noType);
//    	nsName.obj = currentMethod;
    	//Tab.openScope(); //otvaramo scope unutar metode
    	ArrayList<String> ns=new ArrayList<>();
    	ns.add(0,nsName.getName());
    	namespaceList.add(ns);
    	
    	System.out.println(namespaceList.indexOf(ns));
    	System.out.println(namespaceList.get(namespaceList.indexOf(ns)).get(0));
    	
//    	nsName.obj = Tab.insert(Obj.Type, nsName.getName(), Tab.noType);
//    	//progName.obj - obj koju je insert napravio i stavio u tabelu simbola    	
//    	Tab.openScope();
////    	 System.out.println("Deklarisan namespace"+nsName.getName());
    	
    	//currentMethod=Tab.insert(Obj.Meth, nsName.getName(), Tab.noType);
    	currentNamespaceID = namespaceCnt;
    	namespaceCnt++;	
    	
    	Obj namespaceFind = Tab.currentScope.findSymbol(nsName.getName());

        if (namespaceFind != null)
            report_error("Namespace " + nsName.getName() + " already exist", nsName);
        else
        	nsName.obj = Tab.insert(Obj.Type, nsName.getName(), Tab.noType);

        currentNamespace = nsName.getName();
    	
    }
    
    public void visit(NamespaceProg nsProgram){
//    	Tab.chainLocalSymbols(currentMethod);
//    	//Tab.chainLocalSymbols(prog);
//       Tab.closeScope();
 
       	//namespaceList.get(currentNamespaceID).add(name);
      
    	
    	currentNamespace = "";

        //currentMethod = Tab.noObj;
    	
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
    
    
    public void visit(Type_NS type){
    	System.out.println("ALO BRE");
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
    	if(!currMethType.compatibleWith(returnExpr.getExpr().obj.getType())){
			report_error("Greska na liniji " + returnExpr.getLine() + " : " + "tip izraza u return naredbi ne slaze se sa tipom povratne vrednosti funkcije " + currentMethod.getName(), null);
    	}
    }
    
    public void visit(ReturnNoExpr returnExpr){
    	Struct currMethType = currentMethod.getType();
    	if(!currMethType.compatibleWith(Tab.noType)){
			report_error("Greska na liniji " + returnExpr.getLine() + " : " + "tip izraza u return naredbi ne slaze se sa tipom povratne vrednosti funkcije " + currentMethod.getName(), null);
    	}
    }
    
   
    
    public void visit(FuncCall funcCall){
    	funcCall.struct=funcCall.getFunctionCall().struct;
    }
    
//    public void visit(FuncCall funcCall){
//    	Obj func = funcCall.getDesignator().obj;
//    	if(Obj.Meth == func.getKind()){
//			report_info("Pronadjen poziv funkcije " + func.getName() + " na liniji " + funcCall.getLine(), null);
//			funcCall.struct = func.getType();
//    	}else{
//			report_error("Greska na liniji " + funcCall.getLine()+" : ime " + func.getName() + " nije funkcija!", null);
//			funcCall.struct = Tab.noType;
//    	}
//    }
    
    
   public void visit(Term_Factor term){
    	term.struct = term.getFactor().struct;
    }
    
    public void visit(TermExpr termExpr){
    	if(!(termExpr.getTerm().struct ==null))
    	{
    		termExpr.obj = new Obj( termExpr.getTerm().struct.getKind(), "",termExpr.getTerm().struct);

    	}
    	else {
    		termExpr.obj = new Obj( Struct.None, "",termExpr.getTerm().struct);
    	}
    	

    	//termExpr.obj=Tab.noObj;
    	
    }
    
    public void visit(ParenExprFactor term){
    	term.struct = term.getExpr().obj.getType();

    }
    
    public void visit(AddExpr addExpr){
    	Obj te = addExpr.getExpr().obj;
    	Struct t = addExpr.getTerm().struct;
    	if(te.getType().equals(t) && te.getType() == Tab.intType){
    		addExpr.obj = te;
    	}else{
			report_error("Nekompatibilni tipovi u izrazu za sabiranje", addExpr);
			addExpr.obj = Tab.noObj ;
    	}
    	
    	addExpr.obj = addExpr.getExpr().obj;
    }
    
    public void visit (Term_Mulop term) {
    	Struct te = term.getTerm().struct;
    	Struct t = term.getFactor().struct;
    	if(te.equals(t) && te == Tab.intType){
    		term.struct = te;
    	}else{
			report_error("Nekompatibilni tipovi u izrazu za mnozenje", term);
			term.struct = Tab.noType;
    	}
    	
    	term.struct = term.getTerm().struct;
    }
    
    
    public void visit(ConstFactor cnst){
    	
    	cnst.struct = cnst.getConstValue().obj.getType();
    }
    
    public String namespaceHelper(String name, String namespace) {
    	if(namespace=="") return name;
    	else return namespace+"::"+name;
    }
        
   
    public void visit(IntegerConst constDecl) {
    	constDecl.obj = new Obj(Obj.Con, "", Tab.intType, constDecl.getIntConstValue().intValue(), Obj.NO_VALUE);
    	//Obj typeNode = Tab.currentScope.findSymbol(prepareSymbol(visitor.getName(), currNamespace));
    	Obj tempObj = constDecl.obj;
            if (Tab.currentScope().findSymbol(namespaceHelper(constDecl.getIntConstName(),currentNamespace)) == null) {
                Obj temp = Tab.insert(tempObj.getKind(), namespaceHelper(constDecl.getIntConstName(),currentNamespace), tempObj.getType());
                temp.setAdr(tempObj.getAdr());

                if (temp.getLevel() == 0) {
                    globalConstCnt++;
                    //nVars++;
                }
                report_info("Deklarisana konstanta "+namespaceHelper(constDecl.getIntConstName(),currentNamespace), constDecl);
                
                if (namespaceList.get(currentNamespaceID).get(0).toString().equalsIgnoreCase(currentMethod.getName())) {
                	namespaceList.get(currentNamespaceID).add(constDecl.getIntConstName());
                	//System.out.println(namespaceList.get(currentNamespaceID).get(0));
                }
            }
	}
    
    
//TO DO : BOOL TYPE (Extend Tab?)   
    public void visit(BooleanConst constDecl) { 
    	//Boolean.valueOf((Boolean)constDecl.getBooleanConstValue()) ? 1 : 0
    	constDecl.obj = new Obj(Obj.Con, "", SystemTableEx.boolType,Boolean.valueOf(constDecl.getBooleanConstValue()) ? 1 : 0/*constDecl.getBooleanConstValue()=="true"?1:0*/, Obj.NO_VALUE);
    	Obj tempObj = constDecl.obj;
            if (Tab.currentScope().findSymbol(constDecl.getBooleanConstName()) == null) {
                Obj temp = Tab.insert(tempObj.getKind(), constDecl.getBooleanConstName(), tempObj.getType());
                temp.setAdr(tempObj.getAdr());

                if (temp.getLevel() == 0) {
                    globalConstCnt++;
                    //nVars++;
                }
            }
            System.out.println("BoolType "+constDecl.getBooleanConstValue() +"  "+SystemTableEx.boolType);
	}
    
    
    public void visit(ConstValue_Bool constDecl) { 
    	constDecl.obj = new Obj(Obj.Con, "", SystemTableEx.boolType, Boolean.valueOf(constDecl.getB1()) ? 1 : 0, Obj.NO_VALUE);
	}
    
    
    
    public void visit(CharacterConst constDecl) {
    	constDecl.obj = new Obj(Obj.Con, "", Tab.charType, constDecl.getCharConstValue().charValue(), Obj.NO_VALUE);
    	Obj tempObj = constDecl.obj;
            if (Tab.currentScope().findSymbol(constDecl.getCharConstName()) == null) {
                Obj temp = Tab.insert(tempObj.getKind(), constDecl.getCharConstName(), tempObj.getType());
                temp.setAdr(tempObj.getAdr());

                if (temp.getLevel() == 0) {
                    globalConstCnt++;
                    //nVars++;
                }
                //System.out.println(namespaceList.get(currentNamespaceID).get(0));
                if (namespaceList.get(currentNamespaceID).get(0).toString().equalsIgnoreCase(currentMethod.getName())) {
                	namespaceList.get(currentNamespaceID).add(constDecl.getCharConstName());
                	//System.out.println(namespaceList.get(currentNamespaceID).get(2));
                }
            }
	}
    
    /*DesignatorStatement*/
    public void visit(Assignment assignment) {
        Obj desigObj = assignment.getDesignator().obj;
        int kind = desigObj.getKind();
        assignment.obj= new Obj(Obj.Elem, assignment.getDesignator().obj.getName() + "_elem",  assignment.getDesignator().obj.getType());
        //System.out.println(assignment.getDesignator().obj.getName() + " tip "+assignment.getDesignator().obj.getType());
        
        
        
        if (kind != Obj.Var && kind != Obj.Elem && kind != Obj.Fld) {
            report_error("Greska na " + assignment.getLine() + ": neispravna leva strana dodele",assignment);
        }  
        else if(!(desigObj.getType().compatibleWith(assignment.getExpr().obj.getType())) && !(assignment.getDesignator().obj.getType().compatibleWith(SystemTableEx.boolType))){
        	report_error("Nekompatibilni tipovi u dodeli vrednosti", assignment);
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
    
    public void visit(Statements ds){
    	 if ("main".equalsIgnoreCase(currentMethod.getName())) {
    		 statementCnt++;
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
    
    
    public void visit(ActPars_Single actPars) {
    	ActParList.peek().add(actPars.getExpr().obj.getType());
    }
    
    public void visit(ActPars_List actPars) {
    	ActParList.peek().add(actPars.getExpr().obj.getType());
    }
    
    
    public void visit(FunctionCall func){
        if ("main".equalsIgnoreCase(currentMethod.getName())) {
            mainFuncCallCnt++;
        }
        if(func.getActParsIE() instanceof ActParsIE_ActPars)
        {
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
        else
        {
        	 func.struct = func.getDesignator().obj.getType();
        }
    }
    
    public void visit(ReadStmt stmt){
    	 if ("main".equalsIgnoreCase(currentMethod.getName())) {
             mainFuncCallCnt++;
         }

         Obj desigObj = stmt.getDesignator().obj;
         int kind = desigObj.getKind();

         if (kind != Obj.Var && kind != Obj.Elem && kind != Obj.Fld) {
             report_error("Greska parametar read funkcije nije promenljiva",stmt);
         } else if (!desigObj.getType().equals(Tab.intType) && !desigObj.getType().equals(Tab.charType)) {
             report_error("Greska parametar read funkcije je nepravilnog tipa",stmt);
         }
         
    }
    
    public void visit(PrintStmt stmt) {
    	printCallCount++;    
        if ("main".equalsIgnoreCase(currentMethod.getName())) {
            mainFuncCallCnt++;
        }

        Struct type = stmt.getExpr().obj.getType();

        if (!type.equals(Tab.intType) && !type.equals(Tab.charType)) {
            report_error("Greska parametar print funkcije je nepravilnog tipa",stmt);
        }
    }
    
    
    public void visit(CondFact_Expr condFact_expr) {
        condFact_expr.struct = condFact_expr.getExpr().obj.getType();
    }

    public void visit(CondFact_Relop condFact_relop) {
        if (!condFact_relop.getExpr().obj.getType().compatibleWith(condFact_relop.getExpr1().obj.getType())) {
            report_error("Greska tipovi relacionog izraza nisu kompatibilni",condFact_relop);
        } else {
            if (!(condFact_relop.getRelop() instanceof Relop_EQ || condFact_relop.getRelop() instanceof Relop_NEQ)) {
                report_error("Greska relacioni izraz sa referentnim tipovima moze koristiti samo '==' i '!=' operatore",condFact_relop);
            }
        }

        condFact_relop.struct = SystemTableEx.boolType;
    }
  
    public void visit(TermExpr_Minus term){
    	if(!term.getTerm().struct.compatibleWith(Tab.intType)) {
    		report_error("Greska term mora biti tipa int", term);
    	}
    	term.obj =new Obj( term.getTerm().struct.getKind(), "",term.getTerm().struct);
    }
    
    
    
    public void visit(NewFactor factor) {
        Obj typeObj = factor.getType().obj;
        if (typeObj.getType().equals(Tab.nullType)) {
            report_error("Greska tip u new iskazu ne predstavlja klasu",factor);
        }

        factor.struct = factor.getType().obj.getType();
    }
    
    public void visit(NewFactor_Expr factor) {
       if(!factor.getExpr().obj.getType().equals(Tab.intType))
	   {
    	   report_error("Greska expr u new iskazu mora biti integer",factor);
	   }
       
       factor.struct = new Struct(Struct.Array, factor.getType().obj.getType());       
    }
    
    public void visit(VarFactor var){
    	var.struct = var.getDesignator().obj.getType();
    	//System.out.println(var.getDesignator().obj.getType());
    }
    
    
    
	public void visit(Designator_Ident desg){
		//desg.obj = desg.getDesignatorHelper().obj;
    	Obj obj=Tab.noObj;
//		if (desg.getDesignatorHelper() instanceof DesignatorHelper_Scope)
//		{
//			Obj objNS= Tab.find(((DesignatorHelper_Scope)desg.getDesignatorHelper()).getName());
//	    	//System.out.println("OBJEKAT:" +objNS.getName());
//			for(int i=0;i<namespaceList.size();i++)
//			{
//				if(((DesignatorHelper_Scope)desg.getDesignatorHelper()).getNamespace().equalsIgnoreCase(namespaceList.get(i).get(0)))
//				{
//					obj = objNS;
//					//System.out.println("OBJEKAT NAMESPACE-a:" +namespaceList.get(i).get(0));
//				}
//			}
//			if(obj.equals(Tab.noObj))
//			{
//				report_error("Nije deklarisana promenjiva"+ ((DesignatorHelper_Scope)desg.getDesignatorHelper()).getName() +" unutar namespace-a "+((DesignatorHelper_Scope)desg.getDesignatorHelper()).getNamespace(), desg);
//			}
//		}
	
		if (desg.getDesignatorHelper() instanceof DesignatorHelper_Scope)
		{
			String name=namespaceHelper(((DesignatorHelper_Scope)desg.getDesignatorHelper()).getName(),((DesignatorHelper_Scope)desg.getDesignatorHelper()).getNamespace());
			Obj objNS= Tab.find(name);
	    	
			if (objNS == Tab.noObj)
	            report_error("Namespace " + ((DesignatorHelper_Scope)desg.getDesignatorHelper()).getNamespace() + " ne postoji", desg);
	        else {
	            Obj idFind = Tab.find(name);
	            if (idFind == null)
	                report_error("Symbol " + name + " ne postoji", desg);
	            else
	                obj = idFind;
	        }
			
		}
		else if (desg.getDesignatorHelper() instanceof DesignatorHelper_None)
		{
			
			String name = ((DesignatorHelper_None)desg.getDesignatorHelper()).getName();

	        if (currentNamespace != null)
	            if (Tab.currentScope().findSymbol(name) == null)
	                name = namespaceHelper(name, currentNamespace);

	        Obj idFind = Tab.find(name);
	        if (idFind == Tab.noObj)
	            report_error("Symbol " + name + " does not exist", desg);
	        else
	            obj = idFind;
			
			
//			Obj objNS= Tab.find(name);
//			for(int i=0;i<namespaceList.size();i++)
//			{
//				//System.out.println(namespaceList.get(i).get(1));
//				boolean p= namespaceList.get(i).contains(((DesignatorHelper_None)desg.getDesignatorHelper()).getName());
//				if(p) {
//					//System.out.println(namespaceList.get(i).toString());
//					
//					report_error("Deklarisana u Namespace-u "+ ((DesignatorHelper_None)desg.getDesignatorHelper()).getName()+" ali nije navedeno u irazu" , desg);
//				}
//			}
	    	//System.out.println("OBJEKAT:" +objNS.getName());
			
			//obj = Tab.find(((DesignatorHelper_None)desg.getDesignatorHelper()).getName());
			currentDesignator=obj;
		}
		
		desg.obj=obj;
		currentDesignator=obj;
		
	    if (desg.obj.equals(Tab.noObj)) {
	        report_error("Greska (" +desg.getDesignatorHelper().obj.getName() + ") nije nadjeno",desg);
	    }
	 }

	public void visit(DesignatorHelper_Expr desg){
//		if(currentDesignator.equals(null) || currentDesignator.getType().getKind() != Struct.Array)
//		{
//			report_error("Greska "+ currentDesignator.getName()+ " nije niz",desg);
//		}
		
		//desg.obj = new Obj(Obj.Elem, "expr" + "_elem", desg.getExpr().struct); Ne moze ovako jer ce uvek tip da bude int!!!!
		
		desg.obj = new Obj(Obj.Elem, "expr" + "_elem", desg.getDesignator().obj.getType().getElemType());
		//System.out.println("DesignatorHelper_Expr "+ desg.getDesignator().obj.getName()+"  " + desg.getDesignator().obj.getType()+"   " + desg.getExpr().struct);
		
		currentDesignator=Tab.noObj;
	}

	public void visit(DesignatorHelper_Dot desg) {
		if(currentDesignator.equals(null) || currentDesignator.getType().getKind() != Struct.Array)
		{
			report_error("Greska "+ currentDesignator.getName()+ " nije niz",desg);
		}
		
		desg.obj = new Obj(Obj.Elem, currentDesignator.getName() + "_elem", currentDesignator.getType().getElemType());
	
		currentDesignator=Tab.noObj;
	}
	
	
    public void visit(DesignatorHelper_Scope designator){
    	//Obj obj=Tab.noObj;
    	
    	String name=namespaceHelper(((DesignatorHelper_Scope)designator).getName(),((DesignatorHelper_Scope)designator).getNamespace());
		
    	Obj objNS= Tab.find(name);

		designator.obj = objNS;
 
//    	for(int i=0;i<namespaceList.size();i++) 
//    	{
//    		System.out.println(namespaceList.get(0)); 
//    	}
    	
//    	boolean b=false;
//    	Obj obj=Tab.noObj;
//    	for(int i=0;i<nsLocalParams.size();i++) 
//    	{
//    		if(nsLocalParams.get(i).getName().equals(designator.getName())) {b=true;obj=nsLocalParams.get(i);}
//    		//System.out.println(nsLocalParams.get(i).getName());
//    	}

    	//System.out.println(b);
    	//System.out.println(obj.getName());
//    	if(!b){
//			report_error("Greska na liniji " + designator.getLine()+ " : ime "+designator.getName()+" nije deklarisano! ", null);
//    	}
    	
    }
    
    public void visit(DesignatorHelper_None designator){
    	Obj obj = Tab.find(designator.getName());
    	if(obj == Tab.noObj){
			report_error("Greska na liniji " + designator.getLine()+ " : ime "+designator.getName()+" nije deklarisano! ", null);
    	}
    	designator.obj = obj;
    	//System.out.println("DesignatorHelper_None "+designator.getName());
    }
    
    
    public void visit(ConstValue_Char ch){
    	ch.obj = new Obj(Obj.Con, "", Tab.charType, ch.getC1(), Obj.NO_VALUE); 
    }
    public void visit(ConstValue_Num ch){
    	ch.obj = new Obj(Obj.Con, "", Tab.intType, ch.getN1(), Obj.NO_VALUE);
    }
     
    
    public boolean passed(){
    	return !errorDetected;
    }
    
}

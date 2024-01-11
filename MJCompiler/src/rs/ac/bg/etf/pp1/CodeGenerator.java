package rs.ac.bg.etf.pp1;

import java.util.Stack;

import rs.ac.bg.etf.pp1.CounterVisitor.FormParamCounter;
import rs.ac.bg.etf.pp1.CounterVisitor.VarCounter;
import rs.ac.bg.etf.pp1.ast.AddExpr;
import rs.ac.bg.etf.pp1.ast.Assignment;
import rs.ac.bg.etf.pp1.ast.ConstFactor;
import rs.ac.bg.etf.pp1.ast.ConstValue_Char;
import rs.ac.bg.etf.pp1.ast.ConstValue_Num;
import rs.ac.bg.etf.pp1.ast.Designator;
import rs.ac.bg.etf.pp1.ast.DesignatorHelper_Expr;
import rs.ac.bg.etf.pp1.ast.DesignatorHelper_None;
import rs.ac.bg.etf.pp1.ast.DesignatorHelper_Scope;
import rs.ac.bg.etf.pp1.ast.DesignatorStatement_DEC;
import rs.ac.bg.etf.pp1.ast.DesignatorStatement_FunctionCall;
import rs.ac.bg.etf.pp1.ast.DesignatorStatement_INC;
import rs.ac.bg.etf.pp1.ast.Designator_Ident;
import rs.ac.bg.etf.pp1.ast.FormParDecl_Single;
import rs.ac.bg.etf.pp1.ast.FormalParamDecl;
import rs.ac.bg.etf.pp1.ast.FunctionCall;
import rs.ac.bg.etf.pp1.ast.MethodDecl;
import rs.ac.bg.etf.pp1.ast.MethodTypeName;
import rs.ac.bg.etf.pp1.ast.Mulop_DIV;
import rs.ac.bg.etf.pp1.ast.Mulop_MUL;
import rs.ac.bg.etf.pp1.ast.NewFactor;
import rs.ac.bg.etf.pp1.ast.NewFactor_Expr;
import rs.ac.bg.etf.pp1.ast.PrintStmt;
import rs.ac.bg.etf.pp1.ast.ReadStmt;
import rs.ac.bg.etf.pp1.ast.ReturnExpr;
import rs.ac.bg.etf.pp1.ast.ReturnNoExpr;
import rs.ac.bg.etf.pp1.ast.SyntaxNode;
import rs.ac.bg.etf.pp1.ast.TermExpr;
import rs.ac.bg.etf.pp1.ast.Term_Factor;
import rs.ac.bg.etf.pp1.ast.Term_Mulop;
import rs.ac.bg.etf.pp1.ast.VarDecl;
import rs.ac.bg.etf.pp1.ast.VarFactor;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class CodeGenerator extends VisitorAdaptor {
	
	private int varCount;
	
	private int paramCnt;
	
	Obj niz=Tab.noObj;
	
	Stack<Obj> stack=new Stack<>();
	
	private int mainPc;
	
	private static final int WORD = 4;
	
	public int getMainPc() {
		return mainPc;
	}
	
	@Override
	public void visit(MethodTypeName methodTypeName) {		
		 Obj methObj = methodTypeName.obj;
	        if ("main".equalsIgnoreCase(methObj.getName())) {
	            mainPc = Code.pc;
	        }

			Code.put(Code.enter);
	        Code.put(methObj.getLocalSymbols().size());
			Code.put(methObj.getLevel());
			
		
//		if ("main".equalsIgnoreCase(methodTypeName.getMethName())) {
//			mainPc = Code.pc;
//		}
//		methodTypeName.obj.setAdr(Code.pc);
//		
//		// Collect arguments and local variables.
//		SyntaxNode methodNode = methodTypeName.getParent();
//		VarCounter varCnt = new VarCounter();
//		methodNode.traverseTopDown(varCnt);
//		FormParamCounter fpCnt = new FormParamCounter();
//		methodNode.traverseTopDown(fpCnt);
//		
//		// Generate the entry.
//		Code.put(Code.enter);
//		Code.put(fpCnt.getCountVar());
//		Code.put(varCnt.getCountVar() + fpCnt.getCountVar());
	}
	
	@Override
	public void visit(VarDecl VarDecl) {
		varCount++;
	}

	@Override
	public void visit(FormParDecl_Single FormalParam) {
		paramCnt++;
	}	
	
	@Override
	public void visit(MethodDecl MethodDecl) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	@Override
	public void visit(ReturnExpr ReturnExpr) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	@Override
	public void visit(ReturnNoExpr ReturnNoExpr) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	@Override
	public void visit(Assignment Assignment) {
		Code.store(Assignment.getDesignator().obj);
	}
	
	@Override
	public void visit(ConstValue_Num cnst) {		
		//Code.load(new Obj(Obj.Con, "$", cnst.struct, cnst.getN1(), 0));
		niz=cnst.obj;
		//cnst.obj.setAdr(WORD);
		//stack.push(cnst.obj);
	}
	
	@Override
	public void visit(ConstValue_Char cnst) {	
		niz=cnst.obj;
		//stack.push(cnst.obj);
	}
	
	 public void visit(ConstFactor term) {
		 Code.load(term.getConstValue().obj);
		 niz=term.getConstValue().obj;
		 stack.push(term.getConstValue().obj);
		}
	
	public void visit(VarFactor dsgn) {
		Code.load(dsgn.getDesignator().obj); //bitno da se stavi load kod VarFactor-a da bi mogla da se ucita promenjiva		
	}
	
	
	@Override
	public void visit(Designator Designator) {
		SyntaxNode parent = Designator.getParent();
		if (Assignment.class != parent.getClass() && FunctionCall.class != parent.getClass()) {
			Code.load(Designator.obj);
		}
	}
	
	@Override
	public void visit(FunctionCall FuncCall) {
		Obj functionObj = FuncCall.getDesignator().obj;
		int offset = functionObj.getAdr() - Code.pc; 
		Code.put(Code.call);
		Code.put2(offset);
		
		if(FuncCall.getDesignator().obj.getType() != Tab.noType){
			Code.put(Code.pop);
		}
	}
	
	@Override
	public void visit(PrintStmt printStmt) {	
		if (printStmt.getExpr().obj.getType().equals(Tab.charType)) {
            Code.put(Code.const_1);
            Code.put(Code.bprint);
        } else {
            Code.put(Code.const_5); // TODO: sta za bool?
            Code.put(Code.print);
        }
	}
	
	@Override
	public void visit(AddExpr AddExpr) {
		Code.put(Code.add);
	}
	
	@Override
	public void visit(DesignatorStatement_INC stmt) {		
		Code.load(stmt.getDesignator().obj);
		Code.put(Code.const_1);
		Code.put(Code.add);
		Code.store(stmt.getDesignator().obj);
		
	}
	
	@Override
	public void visit(DesignatorStatement_DEC stmt) {
		Code.load(stmt.getDesignator().obj);
		Code.put(Code.const_1);
		Code.put(Code.sub);
		Code.store(stmt.getDesignator().obj);
	}
	
	@Override
	public void visit(Term_Mulop term) {
		Code.put(Code.mul);
	}
	
	@Override
	public void visit(Mulop_DIV term) {
		Code.put(Code.div);
	}
	
	
	
	
//	 public void visit(Mulop_MUL mulop_mul) {
//			Code.put(Code.mul);
//	 }
	
	
	
	public void visit(NewFactor factor) {
        Obj classType = factor.getType().obj;
	    int s = WORD * (classType.getType().getNumberOfFields());
	    Code.put(Code.new_);
	    Code.put2(s);

	    Code.put(Code.dup);
	    Code.loadConst(classType.getAdr());
        Code.put(Code.putfield);
        Code.put2(0);
    }
	
	
	public void visit(NewFactor_Expr factor) {
		Code.put(Code.newarray);
        Code.put(factor.struct.getElemType().equals(Tab.charType) ? 0 : 1);
    }
		
	
	public void visit(Designator_Ident dsgn) {		
		if(dsgn.getParent() instanceof DesignatorHelper_Expr)
		{
			Code.load(dsgn.getDesignatorHelper().obj);
		}
   
	    }
	
   public void visit(DesignatorHelper_Expr dsgn) {

	  
	  // Code.load(dsgn.getDesignator().obj);
	  // Code.put(Code.dup2);
	  
	   //Code.put(Code.aload);
	   //Obj value=Tab.find(dsgn.getExpr().obj.getName());
	   //ConstFactor c=(ConstFactor)value;
	   //Code.load(stack.pop());

	  
    }
   
//   public void visit(TermExpr term) {
//	   //Code.load(dsgn.getExpr())
//	   //Code.load(dsgn.getDesignator().obj); 
//	   //term.getTerm()
//    }
   
   
//   public void visit(Term_Factor term) {
//	   //Code.load(dsgn.getExpr())
//	  // Code.load(term.getFactor()); 
//	   term.getFactor();
//    }

   public void visit(ReadStmt readstmt) {
	    Obj obj = readstmt.getDesignator().obj;
       if (obj.getType().equals(Tab.charType)) {
           Code.put(Code.bread);
       } else {
           Code.put(Code.read);
       }
       Code.store(obj);
   }
   
   
   public void visit(DesignatorStatement_FunctionCall stmt) {
	    if (!stmt.getFunctionCall().struct.equals(Tab.noType)) {
           // sklanjamo nepotrebnu vrednost sa esteka
           Code.put(Code.pop);
       }
   }
   
}

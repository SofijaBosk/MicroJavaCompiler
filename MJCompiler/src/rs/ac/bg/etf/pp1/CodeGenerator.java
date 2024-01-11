package rs.ac.bg.etf.pp1;

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
import rs.ac.bg.etf.pp1.ast.DesignatorStatement_DEC;
import rs.ac.bg.etf.pp1.ast.DesignatorStatement_INC;
import rs.ac.bg.etf.pp1.ast.Designator_Ident;
import rs.ac.bg.etf.pp1.ast.FormParDecl_Single;
import rs.ac.bg.etf.pp1.ast.FormalParamDecl;
import rs.ac.bg.etf.pp1.ast.FunctionCall;
import rs.ac.bg.etf.pp1.ast.MethodDecl;
import rs.ac.bg.etf.pp1.ast.MethodTypeName;
import rs.ac.bg.etf.pp1.ast.Mulop_MUL;
import rs.ac.bg.etf.pp1.ast.NewFactor;
import rs.ac.bg.etf.pp1.ast.NewFactor_Expr;
import rs.ac.bg.etf.pp1.ast.PrintStmt;
import rs.ac.bg.etf.pp1.ast.ReturnExpr;
import rs.ac.bg.etf.pp1.ast.ReturnNoExpr;
import rs.ac.bg.etf.pp1.ast.SyntaxNode;
import rs.ac.bg.etf.pp1.ast.TermExpr;
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
	        Code.put(0);
			Code.put(methObj.getLevel());
		
			System.out.println("Prvi:"+varCount);
			System.out.println("Drugi:"+methObj.getLocalSymbols().size());
			
		
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
//		Obj con = Tab.insert(Obj.Con, "$", cnst.struct);
//		con.setLevel(0);
//		con.setAdr(cnst.getN1());
//		
//		Code.load(con);
		
		Code.load(new Obj(Obj.Con, "$", cnst.struct, cnst.getN1(), 0));
	}
	
	@Override
	public void visit(ConstValue_Char cnst) {	
		Code.load(new Obj(Obj.Con, "$", cnst.struct, cnst.getC1(), 0));
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
		if (printStmt.getExpr().struct.equals(Tab.charType)) {
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
		Code.put(Code.add);
		Code.store(stmt.getDesignator().obj);
	}
	
	@Override
	public void visit(Term_Mulop term) {
//		Code.load(new Obj(Obj.Var, , term.getTerm().struct));
//		Code.load(new Obj(Obj.Var, "$", term.getFactor().struct));
//		Code.put(Code.mul);
//		//Code.store(stmt.getDesignator().obj);
		Code.put(Code.mul);
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
		
	
   public void visit(DesignatorHelper_Expr dsgn) {
	   //Code.load(dsgn.getExpr())
	   
	   //Code.load(dsgn.getDesignator().obj); 
	   
	   int field= Code.get(Code.pop);
	   Code.put(Code.pop);
	   Code.load(dsgn.getDesignator().obj);
	   Code.put(Code.const_n+field);
	   /*if (dsgn.obj.getType().getKind()==Struct.Array) {
    	   int field= Code.get(Code.pop);
    	   Code.put(Code.pop);
    	   Code.load(dsgn.getDesignator().obj);
    	   Code.put(Code.const_n+field);
    	   Code.put(Code.astore);
    	   System.out.println("lalalal");
    	   //Code.put(Code.load_n);
   			}
	    */
    }
   
//   public void visit(TermExpr term) {
//	   //Code.load(dsgn.getExpr())
//	   Code.load(dsgn.getDesignator().obj);  
//    }
   
   
   
   public void visit(Designator_Ident dsgn) {
	  // System.out.println("Designator: "+dsgn.getDesignatorHelper().obj.getName()+" type "+dsgn.obj.getType());
//       if (dsgn.obj.getType().getKind()==Struct.Array) {
//    	   int field= Code.get(Code.pop);
//    	   Code.put(Code.pop);
//    	   Code.load(dsgn.getDesignatorHelper().obj);
//    	   Code.put(Code.const_n+field);
//    	   Code.put(Code.astore);
//    	   //System.out.println("lalalal");
//    	  // Code.put(Code.load_n);
//       }     
   }
   
   
   
}

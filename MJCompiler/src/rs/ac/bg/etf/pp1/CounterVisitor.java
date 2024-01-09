package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.FormParDecl_Single;
import rs.ac.bg.etf.pp1.ast.VarDecl;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;

public class CounterVisitor extends VisitorAdaptor {
	
	protected int countVar;
	
	public CounterVisitor() {
		countVar=0;
	}
	
	public int getCountVar() {
		return countVar;
	}
	
	public static class FormParamCounter extends CounterVisitor {

		@Override
		public void visit(FormParDecl_Single formPar) {
			countVar++;
		}		
	}
	
	public static class VarCounter extends CounterVisitor {		
		@Override
		public void visit(VarDecl VarDecl) {
			countVar++;
		}
	}
}
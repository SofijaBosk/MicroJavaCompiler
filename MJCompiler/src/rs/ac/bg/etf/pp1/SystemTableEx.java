package rs.ac.bg.etf.pp1;

import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;


public class SystemTableEx extends Tab{
	
		public static final Struct boolType = new Struct(Struct.Bool);
		
		public static void init()
		{
			Tab.init(); 
			//Tab.insert(Obj.Type, "bool", SystemTableEx.boolType);
			Tab.currentScope.addToLocals(new Obj(Obj.Type, "bool", boolType));
			
		}
	

}



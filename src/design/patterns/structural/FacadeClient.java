package design.patterns.structural;

public class FacadeClient{
	public static void main(String args[]) {
		Facade f = new Facade();
		f.codGen();
	}
}

class Facade {
	public void codGen() {
		CodeGeneration cg = new CodeGeneration(
				new PhysicalPlan(
						new ResovledLogicalPlan(
								new UnResolvedLogicalPlan(new AbstractSyntaxTree()))));
		cg.generateCode();
	}
}
class AbstractSyntaxTree{
	
}

class UnResolvedLogicalPlan{
	AbstractSyntaxTree ast;
	public UnResolvedLogicalPlan(AbstractSyntaxTree ast) {
		this.ast = ast;
	}
}
class ResovledLogicalPlan{
	UnResolvedLogicalPlan ulp;
	public ResovledLogicalPlan(UnResolvedLogicalPlan ulp) {
		this.ulp = ulp;
	}
}
class PhysicalPlan{
	ResovledLogicalPlan rlp;
	public PhysicalPlan(ResovledLogicalPlan rlp){
		this.rlp = rlp;
	}
}
class CodeGeneration{
	PhysicalPlan pp;
	public CodeGeneration(PhysicalPlan pp){
		this.pp = pp;
	}
	public void generateCode() {
		System.out.println("generating code for spark sql");
	}
}
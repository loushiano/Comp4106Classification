 package comp4106Ass3;

public class Classification {
	private DependenceTree tree;
	private Class[] classes;
	
	public Classification(){
		tree=new DependenceTree();
		classes = new Class[3];
		for(int i=0;i<3;i++){
			classes[i]=new Class("w"+i);
		}
		
		
	}
}

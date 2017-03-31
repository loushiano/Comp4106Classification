package comp4106Ass3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class Class {
private String name;
private Feature[] features;
private double[] probabs;
private HashMap<Node,double[]> depProbas;


public Class(String name){
	this.name=name;
	features = new Feature[10];
	probabs= new double[10];
	depProbas= new HashMap<Node,double[]>();
}
public String getName(){
	return name;
}
public Feature[] getFeatures(){
	return features;

}
public void setProbabs(){
	Random r= new Random();
	for(int i=0;i<10;i++){
		probabs[i]=r.nextDouble();
		System.out.println(probabs[i]);
	}
	
}

public void generateRandsIndependent(){
	Random r= new Random();
	int count=0;
	for(int i=0;i<20000;i++){
		double num=r.nextDouble();
		if(features[i/2000]==null){
			features[i/2000]= new Feature("x"+(i+1)/2000);
		}
		features[i/2000].addANum(num,i%2000);
		int binary=(int)Math.ceil(num-probabs[i/2000]);
			features[i/2000].addABinInd(binary, i%2000);
			if(binary==0){
				count++;
			}
			
			features[i/2000].setProbInd(count/(i%2000+1));
		
	}
	
}
	
public void generateRnadsDependent(DependenceTree tree){
	
		for(Node n:tree.getDepTree()){
			int count=0;
			for(int i=0;i<2000;i++){
				int binary=(int)Math.ceil(n.getFeature().getRandNums()[i]-n.getProbability(i));
				n.getFeature().addBinDep(binary, i);
				if(binary==0){
					count++;
				}
				
				
			
		}
			n.getFeature().setProbDep(count/2000);
			}
		
		
	}
public static void main(String args[]){
	Class c= new Class("x1");
	ArrayList<Edge> edges=new ArrayList<Edge>();
	Edge e=new Edge(null,null);
	Edge e1=new Edge(null,null);
	Edge e2=new Edge(null,null);
	Edge e3=new Edge(null,null);
	e.setWeight(0.00145);
	e1.setWeight(0.00146);
	e2.setWeight(0.00451);
	e3.setWeight(0.00187);
	edges.add(e);
	edges.add(e1);
	edges.add(e2);
	edges.add(e3);
	Collections.sort(edges);
	for(int i=0;i<4;i++){
		System.out.println(edges.get(i).getWeight()+" ");
	}
	System.out.println(1999%2000+" "+3000%2000+" "+3999%2000);
}


}

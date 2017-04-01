package comp4106Ass3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class Class {
private String name;
private Feature[] features;
private double[] probabs;
private HashMap<Feature,double[]> iP;
private HashMap<Class,Integer> counters;


public Class(String name){
	this.name=name;
	features = new Feature[10];
	probabs= new double[10];
	iP=new HashMap<Feature,double[]>();
	counters= new HashMap<Class,Integer>();
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
		
		features[i/2000].getData(this).addANum(num,i%2000);
		int binary=(int)Math.ceil(num-probabs[i/2000]);
			features[i/2000].getData(this).addABinInd(binary, i%2000);
			if(binary==0){
				count++;
			}
			
			features[i/2000].getData(this).setProbInd(count/(i%2000+1));
		
	}
	
}
	
public void generateRnadsDependent(DependenceTree tree){
	
		for(Node n:tree.getDepTree()){
			int count=0;
			for(int i=0;i<2000;i++){
				int binary=(int)Math.ceil(n.getFeature().getData(this).getRandNums()[i]-n.getProbability(i,this));
				n.getFeature().getData(this).addBinDep(binary, i);
				if(binary==0){
					count++;
				}
				
				
			
		}
			n.getFeature().getData(this).setProbDep(count/2000);
			}
		
		
	}
public static void main(String args[]){
	//Class c= new Class("x1");
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
public void putProbabilityOfFeature(Feature feature, double p, double i) {
	double[] ps=new double[2];
	ps[0]=i;ps[1]=p;
	iP.put(feature, ps);
	
}
public void setFeatures(Feature[] features2) {
	features=features2;
	
}
public double calculateProbabilityOfSample(int j) {
	double count=1;
	for(Feature f:features){
			count*=iP.get(f)[f.getData(this).getBinaries()[j]];
		}
	return count;
	
}
public void addCount(int count) {
	counters.put(this,count);
}
public void addCounterCount(int counterCount,Class c) {
	counters.put(c, counterCount);
	
}
public void printTestings() {
	//still need to implement this but its so easy so no one gives a fuck about u know what i mean, hahahah
	
}


}

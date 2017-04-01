 package comp4106Ass3;

import java.util.HashMap;

public class Classification {
	private DependenceTree tree;
	private Class[] classes;
	private Feature[] features;
	private HashMap<Feature,double[]> probas;
	
	public Classification(){
		tree=new DependenceTree();
		classes = new Class[3];
		for(int i=0;i<3;i++){
			classes[i]=new Class("w"+i);
		}
		for(int i=0;i<10;i++){
			features[i]=new Feature("x"+i,classes);
		}
		for(int i=0;i<3;i++){
			classes[i].setFeatures(features);
			classes[i].generateRandsIndependent();
		}
		tree.connectAllNode(features);
		tree.createTheDependeceTree();
		for(int i=0;i<3;i++){
			classes[i].generateRnadsDependent(tree);
		}
		probas=new HashMap<Feature,double[]>();
		for(int i=0;i<10;i++){
			probas.put(features[i], new double[2]);
		}
		
		
	}
	public void trainingAndTestingInd(){
		//getProbabilityOfClassOneOfOnesAndZerosOfFeaureOne...10
		//same for class two
		//same for class three..
		//the for each sample of class one find the probab...then eat my ass 
		//ok this will take fucking a lot of time. hmm what should i do then...
		//i should make soemthing thats really efficient and easy to work with..
		//other wise am fucked man... okay lets see what we can do bro ...
		for(int i=0;i<5;i++){
		
			putProbasofSamples(i);
			testSamplesOfThreeClasses(i);
			outputTheresultingCofusionMatrix();
			
			
		
		}
		outputTheresultingCofusionMatrix();
		
		
	}
	 
	public void trainingAndTestingDep(){
		
	}
	private void outputTheresultingCofusionMatrix() {
		
			for(Class c:classes){
				c.printTestings();
			}
		
	}
	private void testSamplesOfThreeClasses(int i) {
			
			for(Class c:classes){
				int count =0;
				int counterCount=0;
				for(int j=i*400;j<i*400+400;j++){
					double p=c.calculateProbabilityOfSample(j);
					Object k[]=getProbabilityOfSampleInOtherClasses(c,j);
					double p1=(double)k[1];
					double p2=(double)k[3];
					Class c1=isGreater(c,p,p1,p2,k);
					if(c1.equals(c)){
						count++;
						c.addCount(count);
					}else{
						
						c.addCounterCount(counterCount,c1);
					}
					
					
				}
				
			}
			
		
		
	}
	private Class isGreater(Class c,double p, double p1, double p2,Object[] k) {
		if(p>p1 && p>p2){
			return c;
		}else if(p1>p && p1>p2){
			return (Class)k[0];
		}else {
			return (Class)k[2];
		}
	}
	private Object[] getProbabilityOfSampleInOtherClasses(Class c, int j) {
		
		Object[] bs=new Object[4];
			int i=0;
		for(Class c1:classes){
			if(!c1.equals(c)){
				bs[i]=c1;
				bs[i+1]=c1.calculateProbabilityOfSample(j);
				i++;
			}
		
		}
		return bs;
		
	}
	private void putProbasofSamples(int i) {
		for(int j=0;j<10;j++){
			for(Class c:classes){
			double p=features[i].getData(c).getProbabilityOfOneInTrainingSamples(i);
			c.putProbabilityOfFeature(features[i],p,1-p);
			}
		}
		
	}
	
}

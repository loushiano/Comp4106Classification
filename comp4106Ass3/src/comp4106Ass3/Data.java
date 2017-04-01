package comp4106Ass3;

public class Data {
	private double[] randNums;
	private int[] binNums;
	private double probOfZero;
	private double probOfOne;
	private int[] binNumsDep;
	private double probOfZeroDep;
	private double probOfOneDep;
	public Data(){
		
		randNums=new double[2000];
		binNums=new int[2000];
		binNumsDep=new int[2000];
	}
	public double[] getRandNums() {
		return randNums;
	}
	public void setRandNums(double[] randNums) {
		this.randNums = randNums;
	}
	public void addANum(double i,int index){
		randNums[index]=i;
	}
	public void addABinInd(int i,int index){
		binNums[index]=i;
	}
	public void addBinDep(int i,int index){
		binNumsDep[index]=i;
	}
	public int[] getDepBinaries(){
		return binNumsDep;
	}
	
	public double getProbOfZero(){
		return probOfZero;
	}
	public double getProbOfOne(){
		return 1-getProbOfZero();
	}
	public void setProbInd(double i){
		probOfZero=i;
		probOfOne=1-i;
	}
	public double getProbInd(int i){
		if(i==0){
			return probOfZero;
		}
		return probOfOne;
	}
	public double getProbDep(int i){
		if(i==0){
			return probOfZeroDep;
		}
		return probOfOneDep;
	}
	public void setProbDep(int i){
		probOfZeroDep=i;
		probOfOneDep=1-i;
	}
	
	public int[] getBinaries(){
		return binNums;
	}
	public int getProbabilityOfOneInTrainingSamples(int i) {
		int count =0;
		for(int j=0;j<i*400;j++){
			if(binNums[j]==1){
				count++;
			}
		}
		for(int j=i*400+400;j<2000;j++)
		{
			if(binNums[j]==1){
				count++;
			}
		}
		
		
		
		return count/1600;
	}

}

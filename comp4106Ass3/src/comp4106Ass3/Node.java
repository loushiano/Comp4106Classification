package comp4106Ass3;

import java.util.ArrayList;
import java.util.Random;

public class Node {
	private Feature feature;
	private ArrayList<Node> neighbours;
	private ArrayList<Node> dependents;
	private Node dependingOn;
	private double[] probas;
	public Feature getFeature() {
		return feature;
	}
	public void setFeature(Feature feature) {
		this.feature = feature;
	}
	public ArrayList<Node> getNeighbours() {
		return neighbours;
	}
	public void setNeighbours(ArrayList<Node> neighbours) {
		this.neighbours = neighbours;
	}
	public void addNeighbor(Node n){
		neighbours.add(n);
	}
	public ArrayList<Node> getDependents() {
		return dependents;
	}
	public void addDependent(Node dependent) {
		dependents.add(dependent);
	}
	public Node(Feature f){
		feature=f;
		neighbours= new ArrayList<Node>();
		dependents=new ArrayList<Node>();
		dependingOn=null;
		probas=new double[2];
		Random r=new Random();
		probas[0]=r.nextDouble();
		probas[1]=r.nextDouble();
	}
	public Node getDependingOn(){
		return dependingOn;
	}
	public void setDependinOn(Node n){
		dependingOn=n;
	}
	public double getProbability(int index){
		if(dependingOn==null){
			return probas[0];
		}else{
			if(dependingOn.getFeature().getDepBinaries()[index]==0){
				return probas[0];
			}
		
		}
		return probas[1];
	}

}

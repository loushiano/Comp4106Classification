package comp4106Ass3;

import java.util.ArrayList;
import java.util.Collections;

public class DependenceTree {
		private ArrayList<Node> nodes,depTree;
		private Node head;
		private ArrayList<Edge> edges;
		
		
	public DependenceTree(){
		edges = new ArrayList<Edge>();
		nodes=new ArrayList<Node>();
		depTree=new ArrayList<Node>();
	}
	public void connectAllNode(Feature[] f){
		for(int i=0;i<10;i++){
			Node n=new Node(f[i]);
			nodes.add(n);
			
		}
		for(int i=0;i<10;i++){
			Node a= nodes.get(i);
		for(Node n:nodes){
			if(!a.equals(n)&& !n.getNeighbours().contains(a)){
				a.addNeighbor(n);
				Edge e = new Edge(a,n);
				edges.add(e);
			}
		}
		}
	}
	public void createTheDependeceTree(){
		
		for(Node n:nodes){
			for(int i=0;i<3;i++){
				if(n.getNeighbours().get(i).getDependingOn()==null){
					n.addDependent(n.getNeighbours().get(i));
					
					n.getNeighbours().get(i).setDependinOn(n);
					depTree.add(n);
				}
			}
		}
		
	}
	public double calcualteWeight(Feature f1,Feature f2){
		int[] oneBinary=f1.getBinaries();
		int[] twoBinary=f2.getBinaries();
			
			double weight=0;
			int k=0;
			for(int j=0;j<4;j++){
			int count=0;
			if(j%2==0 && j!=0){
				 k++;
			 }
		for(int i=0;i<2000;i++){
			if(oneBinary[i]==k%2 && twoBinary[i]==j%2){
				count++;
			}
		}
			
		 weight+=(count/2000)*Math.log((count/2000)/(f1.getProbDep(k%2)*f2.getProbDep(j%2)));
		 
	}
		return weight;
	}
	public void setSpanningTree(){
		
		Collections.sort(edges);
		ArrayList<Edge> maximumEdges =new ArrayList<Edge>();
		for(int i=0;i<9;i++){
			maximumEdges.add(edges.get(i));
		}
		int i=0;
			for(Node n:nodes){
				n.getDependents().clear();
				n.setDependinOn(null);
			}
			
			for(Edge e:maximumEdges){
				for(Node n:nodes){
				if(e.getNodes().contains(n)){
					Node other = otherOne(e.getNodes(),n);
					if(other.getDependingOn()==null){
						n.addDependent(other);
						
						other.setDependinOn(n);
						
					}
				}
			}
		}
	}
	private Node otherOne(ArrayList<Node> nodes2,Node n) {
		if(n.equals(nodes.get(0))){
			return nodes.get(1);
		}
		return nodes.get(0);
	}
	public ArrayList<Node> getDepTree() {
		return depTree;
	}
	public void setDepTree(ArrayList<Node> depTree) {
		this.depTree = depTree;
	}
		
}

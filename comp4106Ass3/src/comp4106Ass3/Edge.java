package comp4106Ass3;

import java.util.ArrayList;

public class Edge implements Comparable<Edge> {
	private double weight;
	private Node leftNode;
	private Node rightNode;
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public Node getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}
	public Node getRightNode() {
		return rightNode;
	}
	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}
	
	public Edge(Node one,Node two){
		leftNode=one;
		rightNode=two;
	}
	public ArrayList<Node> getNodes(){
		ArrayList<Node> nodes = new ArrayList<Node>();
		nodes.add(leftNode);
		nodes.add(rightNode);
		return nodes;
	}
	@Override
	public int compareTo(Edge e) {
		
		return (int)((e.weight-weight)*1000000);
	}
}

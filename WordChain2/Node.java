package WordChain;

import java.util.ArrayList;
import java.util.HashMap;

public class Node {
	
	private ArrayList<String> list = new ArrayList<String>();
	HashMap <Node, ArrayList<String>> nodeMap = new HashMap<Node, ArrayList<String>>();
	
	
	private String word;
	private boolean visited;
	private int index;
	
	public Node(String word) {
		this.word = word;
	}
	
	public int getIndex() {
		return index;
	}
	
	public int getIndex(Node node) {
		return index;
	}
	
	public Node getList(int index){
		return this;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void setVisited (boolean visitedo) {
		this.visited = visitedo;
	}
	
	public boolean getVisited () {
		return this.visited;
	}
	
	public Node getNode(Node node){
		return this;
	}
	
	public Node getName (Node node) {
		return this;
	}
	
	public String getWord (Node key) {
		return this.word;
	}
	
	public String getName () {
		return word;
	}
	
	public void listTransfer (ArrayList<String> list) {
		this.list = list;
	}
	
}

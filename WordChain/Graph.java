package WordChain;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
	private ArrayList<String> list = new ArrayList<String>();
	LinkedList<Integer>[] adjList;
	HashMap<Integer, ArrayList<String>> nodeMap = new HashMap<Integer, ArrayList<String>>();

	Node node = null;

	public void listTransfer(ArrayList<String> list) {
		this.list = list;

		adjList = new LinkedList[list.size()];
		for (int i = 0; i < list.size(); i++) {
			adjList[i] = new LinkedList<>();
		}

	}

	public void wordIterator() {
		for (int i = 0; i < list.size(); i++) {
			ArrayList<String> list2 = new ArrayList<String>();

			for (int j = 0; j < list.size(); j++) {
				if (i != j && (list.get(j).indexOf(list.get(i).charAt(1)) >= 0)
						&& (list.get(j).indexOf(list.get(i).charAt(2)) >= 0)
						&& (list.get(j).indexOf(list.get(i).charAt(3)) >= 0)
						&& ((list.get(j).indexOf(list.get(i).charAt(4)) >= 0))) {
					System.out.println(list.get(i) + " " + list.get(j));
					list2.add(list.get(j));
					System.out.println("Adding edge " + i + " with " + j);
					addEdge(i, j);
				}
			}

			if (!nodeMap.containsKey(i)) {
				nodeMap.put(i, list2);
			}
		}

		nodeMap.forEach((key, value) -> System.out.println(key + ":" + value));
		System.out.println("Antal noder :"+nodeMap.size());

	}

	public void addEdge(int start, int destination) {
		adjList[start].addFirst(destination);
	}

	public void BFS() {
		int count = 0;
		boolean[] visited = new boolean[list.size()];
		Queue<Integer> queue = new LinkedList<>();
		System.out.println("BFS: ");

		for (int i = 0; i < list.size(); i++) {
			if (!visited[i]) {

				queue.add(i);
				
				while(!queue.isEmpty()){
					
					int vertex = queue.remove();
					ArrayList<String> test52 = nodeMap.get(vertex);
					visited[vertex] = true;
					System.out.println();
					System.out.println(nodeMap.get(vertex) + " visited ->");
					
					nodeMap.get(vertex).size();
					int wtf = 0;
					for (int j = 0; j < test52.size(); j++) {

						
                        int adjVertex = adjList[vertex].get(j);
                        while(!visited[adjVertex]) {
                            visited[adjVertex] = true;
                            queue.add(adjVertex);
    						String testing23 = test52.get(j);
    						System.out.print("--" +testing23);

                        }
                    }
					
				}

			}
		}
	}
}

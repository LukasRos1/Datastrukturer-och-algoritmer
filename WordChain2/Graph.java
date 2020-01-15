package WordChain;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


public class Graph {
	private ArrayList<String> list = new ArrayList<String>();
	HashMap<String, ArrayList<String>> nodeMap = new HashMap<String, ArrayList<String>>();
	int E = 0; // edges
	Node node = null;

	public Graph(ArrayList<String> list) {
		this.list = list;
		findPairs();
	}

	public void findPairs() {
		for (int i = 0; i < list.size(); i++) {
			String firstWord = list.get(i);
			
			ArrayList<String> adjNodes = new ArrayList<String>();
			nodeMap.put(firstWord, adjNodes);

			for (int j = 0; j < list.size(); j++) {
				String secondWord = list.get(j);
				if (i != j && (secondWord.indexOf(firstWord.charAt(1)) >= 0)
						&& (secondWord.indexOf(firstWord.charAt(2)) >= 0)
						&& (secondWord.indexOf(firstWord.charAt(3)) >= 0)
						&& (secondWord.indexOf(firstWord.charAt(4)) >= 0)) {

					addEdge(firstWord, secondWord);
					E++;

				}
			}
		}

		nodeMap.forEach((key, value) -> System.out.println(key + ":" + value));
		System.out.println("Antal noder i grafen: " + nodeMap.size());
		System.out.println("Antal bågar i grafen: " + E);
	}

	public void addEdge(String start, String goal) {
		nodeMap.computeIfAbsent(start, k -> new ArrayList<>()).add(goal);
	}

	public Integer BFS(String start, String goal) {
		HashMap<String, Integer> nodesPath = new HashMap<>();
		nodeMap.forEach((key, value) -> nodesPath.put(key, -1));
		nodesPath.put(start, 0);

		HashMap<String, Boolean> visitedMap = new HashMap<String, Boolean>();
		
		Queue<String> queue = new LinkedList<>();

		queue.add(start);
		visitedMap.put(start, true);
		
		while (!queue.isEmpty()) {
			String node = queue.remove();
			ArrayList<String> adjList = nodeMap.get(node);
			int adjNodes = adjList.size();

			for (int j = 0; j < adjNodes; j++) {
				if(visitedMap.get(adjList.get(j))==null){
					nodesPath.put(adjList.get(j), nodesPath.get(node) + 1);
					queue.add(adjList.get(j));
					visitedMap.put(adjList.get(j), true);
				}
			}
		}
		return nodesPath.get(goal);
	}

}

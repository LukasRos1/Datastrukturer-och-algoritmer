package WordChain;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import grafuppgift.BreadthFirstDirectedPaths;
import grafuppgift.Digraph;

public class appMain {
	
	private static void test(Digraph graph, String testfile, ArrayList<String> words) throws IOException {
		BufferedReader r = 
			    new BufferedReader(new InputStreamReader(new FileInputStream(testfile)));
			while (true) {
			    String line = r.readLine();
			    if (line == null) { break; }
			    assert line.length() == 11; // indatakoll, om man kör med assertions på
			    String start = line.substring(0, 5);
			    String goal = line.substring(6, 11);
			    // ... sök väg från start till goal här
			}
	}
	
	public static void main(String[] args) throws IOException {
		String filename = "words-13-data.txt";
		String testfile = "words-13-test.txt";
		
		BufferedReader r =
			    new BufferedReader(new InputStreamReader(new FileInputStream("words-13-data.txt")));
			ArrayList<String> words = new ArrayList<String>();
			while (true) {
			    String word = r.readLine();
			    if (word == null) { break; }
			    assert word.length() == 5;  // indatakoll, om man kör med assertions på
			    words.add(word);
			}
			
			
			
			Graph graph = new Graph();
			graph.listTransfer(words);
			graph.wordIterator();
			
			test();
			
			graph.BFS();
	}
}

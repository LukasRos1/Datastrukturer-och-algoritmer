package WordChain;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class appMain {
	
	
	public static void main(String[] args) throws IOException {
		
		
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
			graph.BFS();
	}
}

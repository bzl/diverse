package inf247;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class freqan {

	public static void main(String[] args) {
		//ArrayList<String> ciphers = readFromFile("ciphers");
		ArrayList<String> ciphers = new ArrayList<String>();
		ciphers.add("abbaclkdsfgjlkjglkdjgsdfgoipucoxipvbuoiwerowpieyr iouycvbuoiiufasuewrluiweh iuhsdaiuf hsiludhrfiaushi lausfecusa");

		HashMap<String, Integer> cache = new HashMap<String, Integer>();
		int start = 0;
		int inc = 1;
		int stop = inc;

		for(int i = 0; i<ciphers.size(); i++){
			String current = ciphers.remove(0);
			do{
				if(cache.containsKey(current.substring(start, stop))){
					cache.put(current.substring(start, stop), cache.get(current.substring(start, stop))+1);
				} else {
					cache.put(current.substring(start, stop), 1);	
				}

				start += inc;
				stop += inc;
			} while(stop <= current.length());
		}

		System.out.println("Unsorted HashMap: " + cache);
		//		TreeMap<String, Integer> sortedHashMap = new TreeMap<String, Integer>(cache);     
		SortedSet<Integer> sorted = new TreeSet<Integer>(cache.values());

		Iterator<String> keySetIterator = cache.keySet().iterator();

		//dette er ikke helt slikt det skal være

		//		System.out.println("Sorted HashMap: " + sortedHashMap); 
		System.out.println("Sorted HashMap: " + sorted); 

		//		for (String string : sortedHashMap.keySet()) {
		//			System.out.printf("\'%s\', %.3f", string, ((float)sortedHashMap.get(string)/sortedHashMap.size()));
		//		}

	}

	private static ArrayList<String> readFromFile(String filsti) {
		ArrayList<String> returnlist = new ArrayList<String>();
		try {
			BufferedReader reader;

			reader = Files.newBufferedReader(FileSystems.getDefault().getPath(".", filsti), Charset.defaultCharset() );

			String line = null;
			while ( (line = reader.readLine()) != null ) { 
				returnlist.add(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return returnlist;	
	}
}

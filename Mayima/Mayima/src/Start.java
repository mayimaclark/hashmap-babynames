import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Start {
	
	private static HashMap<String, Integer>[] boys = new HashMap[10];
	private static HashMap<String, Integer>[] girls = new HashMap[10];
	private static String name = "";
	private static int number = 0;
	private static int x = 0;
	private static Scanner user_input;
	
	
	public static void main(String[] args) throws FileNotFoundException {
		
		initiate();
		
		for(int year = 2001; year < 2011; year++) {
			
			File file = new File("babynamesranking" + year + ".txt");
			
			names(file);
		}
		
		// sort maps by values
		for(int i = 0; i < boys.length; i++) {
			boys[i] = sortByValue(boys[i]);
			girls[i] = sortByValue(girls[i]);
		}
		
		
		// testing on the boys and girls arrays -- display all
		
		// display all girls -- for testing
		for(int i = 0; i < girls.length; i++) {
			
			System.out.println("-------------------------------------------");
			System.out.println("Year " + (2001+i) + " girls names");
			System.out.println("-------------------------------------------");
			
			for(String x: girls[i].keySet()) {
				System.out.println(x + ": " + girls[i].get(x));
			}
			System.out.println("\n");
		}
		
		// display all boys  -- for testing
		for(int x = 0; x < boys.length; x++) {
			
			System.out.println("-------------------------------------------");
			System.out.println("Year " + (2001+x) + " boys names");
			System.out.println("-------------------------------------------");
			
			for(String y: boys[x].keySet()) {
				System.out.println(y + ": " + boys[x].get(y));
			}
			System.out.println("\n");
		}
		
	}
		

	public static void initiate() {
		
		for(int i = 0; i < boys.length; i++) {
			
			boys[i] = new HashMap<>();
			girls[i] = new HashMap<>();

		}
	}
	
	public static void names(File file) throws FileNotFoundException {
		
		user_input = new Scanner(file);
		
		String name = ""; int number = 0;
		
		while(user_input.hasNext()) {
			
		
			user_input.next();
			name = user_input.next();
			number = user_input.nextInt();
	
			// add a boy
			boys[x].put(name, number);
			
			name = user_input.next();
			number = user_input.nextInt();
			
			// add a girl
			girls[x].put(name, number);
		}
		
		x++;
	}
	
	public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> mMap) {	 
		List list = new LinkedList(mMap.entrySet());
	 
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((HashMap.Entry) (o1)).getValue())
							.compareTo(((HashMap.Entry) (o2)).getValue());
			}
		});
	 
		HashMap sortedMap = new LinkedHashMap();
		for (Iterator it = list.iterator(); it.hasNext();) {
			HashMap.Entry entry = (HashMap.Entry) it.next();
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}
}
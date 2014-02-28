import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {

	static BufferedReader stdin = new BufferedReader(
			new InputStreamReader(System.in));
	static StringTokenizer st = new StringTokenizer("");

	static Character[][] map;
	static Boolean[][] visited;
	static ArrayList<Double> scores;

	static int beach;
	static int land;

	static int size;
	static boolean more = true;
	static boolean first = true;

	public static void main(String[] args) {
		do{
			readMap();
			if (size > 0) {
				
			for(int i = 0; i < size; i++){
				for(int j = 0; j < size; j++){
					if(map[i][j] == 'X' && visited[i][j] == false){
						beach = 0;
						land = 0;
						bfs(i, j);
						scores.add((double) beach / (double) land);
					}
				}	
			}
			double biggest = 0.0;
			double smallest = 0.0;

			if(scores.size()>0){
				biggest = scores.get(0);
				smallest = scores.get(0);
				for(double num : scores){
					if (num<smallest)
						smallest=num;

					if(num>biggest)
						biggest=num;
				}
			}
			if(!first)
				System.out.println();
			
			System.out.printf("%.3f %.3f", biggest, smallest);
			first=false;
			}
			
		} while(more);

	}

	private static void bfs(int i, int j) {
		land++;
		visited[i][j] = true;
		//up (i-1)
		if((i-1) < 0){
			beach++;
		} else if(map[i-1][j].equals('.')){
			beach++;
		} else if(visited[i-1][j]){
			//do nothing
		} else {
			bfs(i-1, j);	
		}
		//right (j+1)
		if((j+1) > (size-1)){
			beach++;
		} else if(map[i][j+1].equals('.')){
			beach++;
		} else if(visited[i][j+1]){
			//do nothing
		} else {
			bfs(i, j+1);	
		}

		//down (i+1)
		if((i+1) > (size-1)){
			beach++;
		} else if(map[i+1][j].equals('.')){
			beach++;
		} else if(visited[i+1][j]){
			//do nothing
		} else{
			bfs(i+1, j);
		}
		//left (j-1)
		if((j-1) < 0){
			beach++;
		} else if(map[i][j-1].equals('.')){
			beach++;
		} else if(visited[i][j-1]){
			//do nothing
		} else{
			bfs(i, j-1);
		}
	}

	private static void readMap() {
		try {


			String currentLine = readString();
			size = Integer.parseInt(currentLine);
			
			if (size == 0){
				more = false;
				return;
			}

			map = new Character[size][size];
			visited = new Boolean[size][size];
			scores = new ArrayList<Double>();

			for(int i = 0; i < size; i++){
				currentLine = readString();
				for(int j = 0; j < size; j++){
					map[i][j] = currentLine.charAt(j);
					visited[i][j] = false;
				}	
			}


		} catch (Exception e) {
//empy
		}

	}

	// Read next input-token as string.
	private static String readString() throws Exception {
		while (!st.hasMoreTokens()) {
			st = new StringTokenizer(stdin.readLine());
		}
		return st.nextToken();
	}

}

/*
ID: chaoliy1
LANG: JAVA
TASK: castle 
 */
import java.io.*;
import java.util.*;

class castle {
	
	public static int M;
	public static int N;
	public static int counter = 1;
	public static int[][] castle;
	public static HashMap<Integer,Integer>hash = new HashMap<Integer,Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("castle.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"castle.out")));
		String[] tmp_n = f.readLine().split(" ");
		N = Integer.parseInt(tmp_n[0]);
		M = Integer.parseInt(tmp_n[1]);
		castle = new int[M][N];
		for(int i=0;i<M;i++){
			String[] tmp = f.readLine().split(" ");
			for(int j=0;j<N;j++){
				castle[i][j] = Integer.parseInt(tmp[j]);
			}
		}
		
		for(int i=0;i<M;i++)
			for(int j=0;j<N;j++)
				if(castle[i][j]>=0){
					flood(i,j);
					counter++;
				}
		int max_room = Integer.MIN_VALUE;
		for(int k:hash.keySet())
			max_room = Math.max(max_room, hash.get(k));
		
		out.println(hash.size());
		out.println(max_room);
		
//		for(int i=0;i<M;i++){
//			for(int j=0;j<N;j++)
//				System.out.print(castle[i][j] + ", ");
//			System.out.println();
//		}
			
		
		int max = Integer.MIN_VALUE;
		int row =-1, col=-1;
		char d = 'X';
		for(int j=0;j<N;j++)
			for(int i=M-1;i>-1;i--){
				if(j<N-1 && castle[i][j] != castle[i][j+1]){
					int val = hash.get(castle[i][j]) + hash.get(castle[i][j+1]);
					if(val > max){
						row = i;
						col = j;
						d = 'E';
						max = val;
					}
					
				}
				if(i>0 && castle[i][j] != castle[i-1][j]){
					int val = hash.get(castle[i][j]) + hash.get(castle[i-1][j]);
					if(val > max){
						row = i;
						col = j;
						d = 'N';
						max = val;
					}
					
				}
			}
			
		out.println(max);
		out.println(Integer.toString(row+1) + " "+ Integer.toString(col+1) + " "+d);
		out.close();
	}
	
	public static void flood(int x, int y){
		if(castle[x][y]<0) return;
		int wall = castle[x][y];
		castle[x][y] = -counter;

		//count max room
		if(!hash.containsKey(-counter))
			hash.put(-counter, 0);
		hash.put(-counter, hash.get(-counter)+1);
		
		if(x>0 && ((wall&2)==0)) //flood up
			flood(x-1,y);
		if(x<M-1 && ((wall&8)==0)) //flood down
			flood(x+1,y);
		if(y>0 && ((wall&1)==0)) //flood west
			flood(x,y-1);
		if(y<N-1 && ((wall&4)==0))
			flood(x,y+1);
	}
	
}
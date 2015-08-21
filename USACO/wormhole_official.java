/*
ID: chaoliy1
LANG: JAVA
TASK: wormhole 
 */
import java.io.*;
import java.util.*;

class wormhole{
	
	public static int[] xcord, ycord = null;
	public static int[] pair, nextRight = null; 
	public static int ret, N =0;
	
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("wormhole.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wormhole.out")));
        N = Integer.parseInt(f.readLine());
        xcord = new int[N+1];
        ycord = new int[N+1];
        pair = new int[N+1];
        nextRight = new int[N+1];

        for(int i=1;i<=N;i++){
        	String[] coord = f.readLine().split(" ");
        	xcord[i] = Integer.parseInt(coord[0]);
        	ycord[i] = Integer.parseInt(coord[1]);
        }
        
        for(int i=1;i<=N;i++)
        	for(int j=1;j<=N;j++)
        	      if (xcord[j] > xcord[i] && ycord[i] == ycord[j]) // j right of i...
        	    		if (nextRight[i] == 0 ||xcord[j]-xcord[i] < xcord[nextRight[i]]-xcord[i])
        	    		  nextRight[i] = j;
        ret = solve();
        System.out.println(ret);
        out.println(ret);
        out.close();
    } 
    
    public static boolean cycle_exist(){
    	for(int i=1;i<=N; i++){
    		int pos = i;
    		for(int count=0;count<N;count++)
    			pos = nextRight[pair[pos]];
    		if(pos!=0) return true;
    	}
    	return false;
    }
    
    public static int solve(){
    	int i=0, total =0;
    	for(i=1;i<=N;i++)
    		if(pair[i] == 0) break;

    	if(i>N){
    		if(cycle_exist()) return 1;
    		else return 0;
    	}
    	
    	for(int j = i+1; j<=N; j++){
    		if(pair[j] == 0){
    			pair[i] = j;
    			pair[j] = i;
    			total += solve();
    			pair[i] = 0;
    			pair[j] = 0;
    		}
    	}
    	return total;
    }

}

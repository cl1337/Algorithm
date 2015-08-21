/*
ID: chaoliy1
LANG: JAVA
TASK: wormhole 
 */
import java.io.*;
import java.util.*;

class wormhole{
	
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("wormhole.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wormhole.out")));
        String tmpN = f.readLine();
        int N = Integer.parseInt(tmpN);
        int[] ret = {0};
        int[] xcord = new int[N];
        int[] ycord = new int[N];
        int[] relation = new int[N];
        for(int i=0;i<N;i++)
        	relation[i] = -1;

        for(int i=0;i<N;i++){
        	String tmpStr = f.readLine();
        	String[] coord = tmpStr.split(" ");
        	xcord[i] = Integer.parseInt(coord[0]);
        	ycord[i] = Integer.parseInt(coord[1]);
        }
        
        recur(0, relation, ret, xcord, ycord);


        out.println(Integer.toString(ret[0]));
        out.close();
    } 
    
    public static void recur(int idx, int[]relation, int[] ret, int []xcord, int[] ycord){
    	if(idx == relation.length){
    		ret[0] += checker(relation, xcord, ycord)?1:0;
    	}else if(relation[idx]<0){
    		for(int i=0;i<relation.length;i++){
    			if(relation[i]<0 && i!=idx){
    				relation[idx] = i;
    				relation[i] = idx;
    				recur(idx+1, relation, ret, xcord, ycord);
    				relation[idx] = -1;
    				relation[i] = -1;
    			}
    		}
    	}else{
    		recur(idx+1, relation, ret, xcord, ycord);
    	}
    }
    
    
    public static boolean checker(int[] relation, int [] xcord, int[] ycord){
    	int n = relation.length;
    	for(int i=0;i<n;i++){
    		int curr = i;
    	 for(int count =0;count<n&&curr>=0;count++){
    		 curr = next(relation[curr], relation, xcord, ycord);
    	 }	
    	 	if(curr>=0) return true;
    	}
    	return false;
    }
    
    
    public static int next(int idx, int[] relation, int[] xcord, int[] ycord){
    	int lmin = Integer.MAX_VALUE;
    	int ret = -1;
    	for(int i=0;i<relation.length;i++){
    		if( xcord[idx] < xcord[i] && ycord[idx] == ycord[i] ){
    			if(xcord[i]<lmin){
    				lmin = xcord[i];
    				ret = i;
    			}
    		}
    	}
    	return ret;
    }
}

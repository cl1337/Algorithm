/*
ID: chaoliy1
LANG: JAVA
TASK: holstein 
 */
import java.io.*;
import java.util.*;

class holstein {
	
	public static int[] need;
	public static int[][] aval;
	public static int N, kind;
	public static int total = Integer.MAX_VALUE;
	public static int total_kind = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("holstein.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("holstein.out")));
        N = Integer.parseInt(f.readLine());
        need = new int[N];
        String[] tmp = f.readLine().split(" ");
        for(int i=0;i<N;i++)
            need[i] = Integer.parseInt(tmp[i]);
        kind = Integer.parseInt(f.readLine());
        aval = new int[kind][N];
        for(int i=0;i<kind;i++){
        	Scanner fi = new Scanner(f.readLine());
        	for(int j=0;j<N;j++)
        		aval[i][j] = fi.nextInt();
        }
        boolean[] ret = new boolean[kind];
        dfs(0,new int[N], new boolean[kind],ret);
        String res = "";
        int count =0;
        for(int i=0;i<ret.length;i++){
        	if(!ret[i]) continue;
        	res += Integer.toString(i+1) + " ";
        	count ++;
        }
        res = Integer.toString(count) + " "+res;
        	

        out.println(res.trim());
        out.close();
    }
	
	public static void dfs(int idx, int[] supply, boolean[] pick, boolean[] ret){
		if(idx==kind){//reach end
			//check meet
			int local_total = 0;
			int local_total_kind =0;
			for(boolean val:pick)
				if(val)
					local_total_kind++;
			
			for(int i=0;i<N;i++){
				if(supply[i]<need[i]) return;
				local_total += supply[i];
			}

			if(local_total_kind>= total_kind) return;
			total_kind = local_total_kind;
			if(local_total>=total) return;
			total = local_total;
			for(int i=0;i<ret.length;i++)
				ret[i] = pick[i];
		}else{
			pick[idx] = false;
			dfs(idx+1, supply, pick,ret);
			//change want
			for(int i=0;i<N;i++)
				supply[i] += aval[idx][i];
			pick[idx] = true;
			dfs(idx+1, supply, pick, ret);
			//change want back
			for(int i=0;i<N;i++)
				supply[i] -= aval[idx][i];
		}
	}
}

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
	public static HashSet<Integer>hash;

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
        hash=new HashSet<Integer>();
        
        int node = bfs();
        int count = 1;
        
        LinkedList<Integer> res = new LinkedList<Integer>();
        while(node>0){
        	if((node&1)>0){
        		res.add(count);
        	}
        	node >>= 1;
        	count ++;
        }
		String tmp_ret = Integer.toString(res.size());

        for(Integer x:res)
			tmp_ret += " "+ Integer.toString(x);
		out.println(tmp_ret.trim());
        out.close();
    }
	
	public static int bfs(){
		int ret_node = 0;
		LinkedList<Integer>q = new LinkedList<Integer>();
		q.offer(0);
		int level=0, curr_node = 0;
		while(level<kind){
			LinkedList<Integer>oldq = q;
			q = new LinkedList<Integer>();
			while(!oldq.isEmpty()){
				curr_node = oldq.poll();
				if(!hash.contains(curr_node)){
					int val =meet(curr_node);
					if(val>0&&total>val){
						ret_node = curr_node;
						total = val;
					}
				}
				q.offer(curr_node);
				curr_node |= (1<<level);
				if(!hash.contains(curr_node)){
					int val =meet(curr_node);
					if(val>0&&total>val){
						ret_node = curr_node;
						total = val;
					}
				}
				q.offer(curr_node);				
			}
			if(total<Integer.MAX_VALUE) return ret_node;
			level ++;
		}
		return -1;
	}

	
	public static int meet(int node){
		int level = 0;
		int[] curr = new int[N];
		int tmp_total = 0;
		hash.add(node);
		while(node>0){
			if((node&1)>0){
				for(int i=0;i<N;i++){
					curr[i] += aval[level][i];
					tmp_total += curr[i];
				}
			}
			node >>= 1;
			level ++;
		}
		for(int i=0;i<N;i++)
			if(curr[i]<need[i])
				return -1;
		return tmp_total;
	}
	
}

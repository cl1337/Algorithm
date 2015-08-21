/*
ID: chaoliy1
LANG: JAVA
TASK: numtri 
 */
import java.io.*;
import java.util.*;

class numtri {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("numtri.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"numtri.out")));
        int N = Integer.parseInt(f.readLine());
        ArrayList<ArrayList<Integer>> tree = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<N;i++){
            String [] input = f.readLine().split(" ");            
            ArrayList<Integer> curr = new ArrayList<Integer>();
            for(String s: input)
                curr.add(Integer.parseInt(s));
            tree.add(curr);
        }

        /* for(ArrayList<Integer> x: tree){ */
        /*     for(Integer y:x) */
        /*         System.out.print(Integer.toString(y) + ", "); */
        /*     System.out.println(); */
        /* } */
        int [] candidates = new int[tree.get(tree.size()-1).size()];
        for(int i=0;i<tree.size();i++){
            ArrayList<Integer> curr = tree.get(i);
            for(int j=curr.size()-1;j>-1;j--){
                if(j==0){
                    candidates[j] += curr.get(j); 
                }else{
                    candidates[j] = Math.max(candidates[j], candidates[j-1])+curr.get(j);
                } 
                /* for(int x: candidates) */
                /*     System.out.print(x + ", "); */
                /* System.out.println(); */
            }
        }

        int ret = Integer.MIN_VALUE;
        for(int x: candidates)
            ret = Math.max(ret, x);
        System.out.println(ret);
            
		out.println(ret);
		out.close();
	}
}

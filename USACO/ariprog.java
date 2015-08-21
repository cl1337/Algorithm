/*
ID: chaoliy1
LANG: JAVA
TASK: ariprog 
 */
import java.io.*;
import java.util.*;

class ariprog{
	
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("ariprog.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")));
        int N = Integer.parseInt(f.readLine());
        int M = Integer.parseInt(f.readLine());
        
        long start = System.nanoTime();
        
        Set<Integer> table = new HashSet<Integer>();
        ArrayList<Integer>list = new ArrayList<Integer>();
        for(int num1=0;num1<=M;num1++)
        	for(int num2=0;num2<=M;num2++){
        		int val = num1*num1 + num2*num2;
        		if(!table.contains(val)){
        			list.add(val);
        			table.add(val);
        		}
        	}
        Collections.sort(list);
        
        long mid1 = System.nanoTime();
        int lim = list.get(list.size()-1);
        
        ArrayList<int[]> ret = new ArrayList<int[]>();
        for(int i=0;i<list.size()-1;i++){
        	int base = list.get(i);
        	for(int j=i+1;j<list.size();j++){
        		int inc = list.get(j)-base;
        		if(base + inc*(N-1)>lim)
        			break;
        		int curr =0;
        		for(;curr<N;curr++){
        			if(!table.contains(base+curr*inc))
        				break;
        		}
        		if(curr==N)
        			ret.add(new int[]{base, inc});
        	}
        }
        
        
        long mid2 = System.nanoTime();

        Collections.sort(ret, new Comparator<int[]>(){
        	public int compare(int[] a, int[] b){
        		if(a[1] != b[1])
        			return a[1] - b[1];
        		else
        			return a[0] - b[0];
        	}
        });

        System.out.println("table time: "+ (mid1-start) + ", looking time: "+ (mid2-mid1));
        System.out.println("result size: "+ret.size());
        for(int[]x:ret){
        	System.out.println(x[0] + ", "+  x[1]);
        	out.println(x[0] + " " + x[1]);
        }
        if(ret.size()<1)
        	out.println("NONE");
        out.close();
    }
    

}
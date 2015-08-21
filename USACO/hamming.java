/*
ID: chaoliy1
LANG: JAVA
TASK: hamming 
 */
import java.io.*;
import java.util.*;

class hamming {
	
	public static ArrayList<Integer>ret;
	public static int N, B, D;

	public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("hamming.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hamming.out")));
        String [] tmp = f.readLine().split(" ");
        N = Integer.parseInt(tmp[0]);
        B = Integer.parseInt(tmp[1]);
        D = Integer.parseInt(tmp[2]);
        ret = new ArrayList<Integer>();
        ret.add(0);
        int idx = 1;
        for(int i=1;i<(int)Math.pow(2.0, (double)(B))&&idx<N;i++){
        	if(bits(i)){
        		ret.add(i);
        		idx++;
        	}
        }
        String tmpstr = "";
        for(int i=0;i<ret.size();i++){
        	if(i%10==0&&i>0){
        		out.println(tmpstr.trim());
        		tmpstr = "";
        	}        	
        	tmpstr += Integer.toString(ret.get(i)) + " ";
        }
        out.println(tmpstr.trim());
        out.close();
    }
	public static boolean bits(int val){
		for(int x: ret){
			int count = val^x;
			int num =0;
			while(count>0){
				if((count&1)>0) num++;
				count >>=1;
			}
			if(num<D)
				return false;
		}
		return true;
	}
}

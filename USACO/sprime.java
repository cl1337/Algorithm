/*
ID: chaoliy1
LANG: JAVA
TASK: sprime 
 */
import java.io.*;
import java.util.*;

class sprime{


	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("sprime.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"sprime.out")));
		int N = Integer.parseInt(f.readLine());
		ArrayList<Integer>ret = new ArrayList<Integer>();
		recur(new char[N],0,ret);
		for(int x:ret)
			out.println(x);
        /* out.println(Integer.toString(i)); */
		out.close();
	}
	
	public static boolean isPrime(int x){
		for(int i =2;i<=Math.sqrt(x);i++)
			if(x%i==0)
				return false;
		return true;
	}
	
	public static void recur(char[]tmp, int idx, ArrayList<Integer>ret){
		if(idx==tmp.length){
			int val = Integer.parseInt(new String(tmp));
			if(isPrime(val))
               ret.add(val);
		}else{
			for(char c = '0';c<='9';c++){
				if(idx==0&&c!='2'&&c!='3'&&c!='5'&&c!='7'&&c!='9')
					continue;
				tmp[idx] = c;
				if(idx>0&&!isPrime(Integer.parseInt(new String(Arrays.copyOfRange(tmp, 0, idx)))))
					continue;
				recur(tmp, idx+1, ret);
			}
		}
		
	}
}

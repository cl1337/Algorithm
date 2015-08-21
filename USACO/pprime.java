/*
ID: chaoliy1
LANG: JAVA
TASK: pprime 
 */
import java.io.*;
import java.util.*;

class pprime{

    public static int min = 0, max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("pprime.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"pprime.out")));
        String [] tmp = f.readLine().split(" ");
        min = Integer.parseInt(tmp[0]);
        max = Integer.parseInt(tmp[1]);

        ArrayList<Integer>palindromes = palindromeGen();
        for(Integer x:palindromes)
            out.println(x);
        /* out.println(Integer.toString(i)); */
		out.close();
	}

    public static ArrayList<Integer>palindromeGen(){
        ArrayList<Integer>palindromes = new ArrayList<Integer>();
        int curr = 10;
        int d1 = 1;
        while(min/curr>0){
            d1 ++;
            curr *= 10;
        }

        curr = 10;
        int d2 = 1;
        while(max/curr>0){
            d2 ++;
            curr *= 10;
        }
        for(int d = d1; d<=d2; d++){
            if(d == 2){
                palindromes.add(11); 
            }else if(d%2>0){
                char[] tmp = new char[d];
                for(int i=0;i<tmp.length;i++)
                    tmp[i] = '0';
                recur(0,palindromes,tmp);
            }
        }

        return palindromes;
    }

    public static boolean isPrime(int x){
        int lim = (int)(Math.sqrt(x))+1;
        for(int i =2;i<= lim;i++)
            if(x%i==0) return false;
        return true;
    }

    public static void recur(int idx, ArrayList<Integer>ret, char[] tmp){
        if(idx==tmp.length){
            int val = Integer.parseInt(new String(tmp));
            if(isPrime(val)&&val<=max&&val>=min)
                ret.add(val);
        }else{
            for(char c = '0';c<='9';c++){
                 if(tmp.length>1&&idx==0&&(c!='1'&&c!='3'&&c!='5'&&c!='7'&&c!='9')|| 
                    idx>tmp.length/2&& c!=tmp[tmp.length-idx-1]||
                    Integer.parseInt(new String(tmp)) > max 
                    )
                 continue;
                tmp[idx] = c;
                recur(idx+1,ret,tmp);
                tmp[idx] = '0';
            }
        }
    }
}

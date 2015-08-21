/*
ID: chaoliy1
LANG: JAVA
TASK: frac1 
 */
import java.io.*;
import java.util.*;

class frac1{
	
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("frac1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("frac1.out")));
        int N = Integer.parseInt(f.readLine());
        LinkedList<Double> arr = new LinkedList<Double>();
        HashMap<Double,String> hash = new HashMap<Double,String>();
        for(int i =1;i<=N;i++)
            for(int j=1;j<i;j++){
                double val = (double)(j)/(double)(i); 
                if(hash.containsKey(val))
                    continue;
                arr.add(val);
                //max common divider
                int m = i, n = j;
                while(m%n>0){
                    int tmp1 = Math.max(n, m%n);
                    int tmp2 = Math.min(n, m%n);
                    m = tmp1;
                    n = tmp2;
                }

                /* int max_cd = mCD(i,j); */
                int max_cd = n;
                hash.put(val, Integer.toString(j/max_cd) + "/" + Integer.toString(i/max_cd));
            }
        Collections.sort(arr);
        out.println("0/1");
        for(Double k:arr)
            out.println(hash.get(k));
        out.println("1/1");
        out.close();
    }

    public static int mCD(int m, int n){
        if(m<n)
            return mCD(n,m);
        if(m%n==0)
            return n;
        else
            return mCD(n, m%n);
    }
}

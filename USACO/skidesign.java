/*
ID: chaoliy1
LANG: JAVA
TASK: skidesign 
 */
import java.io.*;
import java.util.*;

class skidesign{
	
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("skidesign.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));
        String tmpN = f.readLine();
        int N = Integer.parseInt(tmpN);
        int [] arr = new int[N];
        int maxHill = 0;
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(f.readLine());
            maxHill = (arr[i]>maxHill)?arr[i]:maxHill;
        }
        int ret = Integer.MAX_VALUE;
        for(int i=0;i<maxHill;i++){
        	int val =0;
        	for(int j=0;j<N;j++){
        		if(arr[j] < i) val += (i-arr[j])*(i-arr[j]);
        		if(arr[j]>i+17) val += (arr[j]-i-17)*(arr[j]-i-17);
        	}
        	ret = ret>val?val:ret;
        }

        System.out.println(ret);
        out.println(ret);
        out.close();
    }
}

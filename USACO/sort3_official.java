/*
ID: chaoliy1
LANG: JAVA
TASK: sort3 
 */
import java.io.*;
import java.util.*;

public class sort3_official {
	public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("sort3.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sort3.out")));
        int N = Integer.parseInt(f.readLine());
        int [] arr = new int[N];
        int [] sc = new int[4];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(f.readLine());
            sc[arr[i]] ++;
        }
        
        int s12 =0,s13=0,s21=0,s31=0,s23=0,s32=0;
        for(int i=0;i<sc[1];i++){
        	if (arr[i] == 2) s12 ++;
        	if (arr[i] == 3) s13 ++;
        }
        
        for(int i=sc[1];i<sc[1]+sc[2];i++){
        	if(arr[i] == 1) s21 ++;
        	if(arr[i] == 3) s23 ++;
        }
        
        for(int i= sc[1] + sc[2]; i<sc[1] + sc[2] + sc[3]; i++){
        	if(arr[i] == 1) s31++;
        	if(arr[i] == 2) s32 ++;
        }
        
        int val = Math.min(s12, s21) + Math.min(s13, s31) + Math.min(s23, s32) + 2*(Math.max(s21, s12) - Math.min(s12,s21));
        System.out.println(val);

	}
}

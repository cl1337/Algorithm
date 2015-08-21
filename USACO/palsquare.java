/*
ID: chaoliy1
LANG: JAVA
TASK: palsquare 
 */
import java.io.*;
import java.util.*;

class palsquare{
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("palsquare.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
        String str = f.readLine();
        int base = Integer.parseInt(str);
        for(int i=1;i<=300;i++){
        	int sq = i*i;
        	if(panlindrome(Bbase(sq,base))){
        		out.println(Bbase(i, base) + " " + Bbase(sq, base));
        	}
        }
        out.close();
    } 
    
    public static boolean panlindrome(String str){
    	char [] arr = str.toCharArray();
    	int n = arr.length;
    	int i=0, j = n-1;
    	while(i<j){
    		if(arr[i++]!=arr[j--]) return false;
    	}
    	return true;
    }
    
    public static String Bbase(int origin, int base){
    	String ret = "";
    	while(origin>0){
    		int residue = origin%base;
    		if(residue < 10)
    			ret = (char)(origin%base + '0') + ret;
    		else{
    			ret = (char)('A'+residue-10) + ret;
    		}
    		origin = origin / base;
    	}
    	return ret;
    }
}

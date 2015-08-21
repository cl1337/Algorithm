/*
ID: chaoliy1
LANG: JAVA
TASK: dualpal 
 */
import java.io.*;
import java.util.*;

class dualpal{
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("dualpal.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
        String str = f.readLine();
        String [] nums = str.split(" ");
        int how_many = Integer.parseInt(nums[0]);
        int larger_than = Integer.parseInt(nums[1])+1;
        while(how_many>0){
        	if(larger_than == 98){
        		int a = 1;
        		
        	}
        	int dual = 0;
        	for(int base = 2; base<=10; base++){
        		if(panlindrome(Bbase(larger_than, base)))
        			dual++;
        		if(dual==2)
        			break;
        	}
        	if(dual==2){
        		how_many --;
        		out.println(Integer.toString(larger_than));
        	}
        	larger_than ++;
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

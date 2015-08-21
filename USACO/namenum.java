/*
ID: chaoliy1
LANG: JAVA
TASK: namenum 
 */
import java.io.*;
import java.util.*;

class namenum{
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader fd = new BufferedReader(new FileReader("dict.txt"));
    	HashSet<String> dict = new HashSet<String>();
    	String str = "";
    	while((str = fd.readLine()) != null && str.length()>0){
    		dict.add(str);
    	}
    	
        BufferedReader f = new BufferedReader(new FileReader("namenum.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
        String numstr = f.readLine();
        char[] num = numstr.toCharArray();
        char[] tmp = new char[num.length];
        ArrayList<String>ret = new ArrayList<String>();
        
        char[][] map = {
        		{},
        		{},
        		{'A','B','C'},
        		{'D','E','F'},
        		{'G','H','I'},
        		{'J','K','L'},
        		{'M','N','O'},
        		{'P','R','S'},
        		{'T','U','V'},
        		{'W','X','Y'}
        };
        recur(ret,map,num,tmp,0,dict);

		for(String s:ret)
			out.println(s);
		if(ret.size()==0)
			out.println("NONE");
        out.close();
    } 
    
    public static void recur(ArrayList<String> ret, char[][]map, 
    		char[] num, char[] tmp, int index, HashSet<String>dict){
    	if(index == num.length){
    		String ans = new String(tmp);
    		if(dict.contains(ans)){
    			ret.add(ans);
    		}
    	}else{
    		int i = (int)(num[index] - '0');
    		for(char c: map[i]){
    			tmp[index] = c;
    			recur(ret, map, num, tmp, index+1, dict);
    		}
    	}
    }
}

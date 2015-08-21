/*
ID: chaoliy1
LANG: JAVA
TASK: pprime 
 */
import java.io.*;
import java.util.*;

class pprime{

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("pprime.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"pprime.out")));
        String [] tmp = f.readLine().split(" ");
        int min = Integer.parseInt(tmp[0]);
        int max = Integer.parseInt(tmp[1]);

        ArrayList<Integer>ret = new ArrayList<Integer>();
        int curr = 2;
        ret.add(curr);
        while(curr<max){
            curr++;
            int i=0;
            for(;i<ret.size();i++){
                if(curr%ret.get(i)==0)
                    break;
            }
            if(i==ret.size())
                ret.add(curr);
        }

        for(int i:ret)
            if(i>= min && checkPalindrome(i))
                out.println(Integer.toString(i));
		out.close();
	}

    public static boolean checkPalindrome(int num){
        if(num<10) return true;
        int curr = 10;
        while(num/curr>0){
            curr *=10;
        }
        curr /= 10;
        while(num>0){
            if(num/curr != num%10)
                return false;
            num %= curr;
            num/=10;
            curr /=100;
        }
        return true;
    }
}

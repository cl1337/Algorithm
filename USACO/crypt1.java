/*
ID: chaoliy1
LANG: JAVA
TASK: crypt1 
 */
import java.io.*;
import java.util.*;

class crypt1{
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("crypt1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));
        f.readLine();
        String tmpN = f.readLine();
        String [] tmparr = tmpN.split(" ");
        HashSet<Integer> set = new HashSet<Integer>();
        ArrayList<Integer> arr = new ArrayList<Integer>();

        for(int i=0;i<tmparr.length;i++){
            int x = Integer.parseInt(tmparr[i]);
            set.add(x);
            arr.add(x);
        }
        

        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        combination(arr, new ArrayList<Integer>(), ret, 0);
        int ret_val = 0;
        for(ArrayList<Integer> one_set: ret){
            int num1 = 0;
            int [] num2 = new int[2];
            for(int i=0;i<3;i++){
                num1 = num1*10 + one_set.get(i);
            }
            num2[0] = one_set.get(3);
            num2[1] = one_set.get(4);
            ret_val += accumulator(num1, num2, set);
            int valid = accumulator(num1, num2, set);
            if(valid == 1)
            System.out.println("num1 = " + num1 + "; num2 =" + num2[0] + "" + num2[1] + " is "+ accumulator(num1, num2, set));
        }


        out.println(Integer.toString(ret_val));
        out.close();
    } 


    public static int accumulator(int num1, int [] num2, HashSet<Integer>set){
        //num1 = abc
        //num2 = [d,e] 
        int phase_1 = num1 * num2[1];
        int phase_2 = num1 * num2[0];
        int total = phase_1 + phase_2 * 10;
        if( validator(phase_1, set, 3) && validator(phase_2, set,3 ) && validator(total, set,4))
            return 1;
        else return 0;
    }

    public static boolean validator(int num, HashSet<Integer>set, int digit){
        while(num>0){
            if(!set.contains(num%10))
                return false;
            num /= 10;
            digit --;
        }
        return digit == 0;
    }

    public static void combination(
            ArrayList<Integer> arr,
            ArrayList<Integer> tmp,
            ArrayList<ArrayList<Integer>> ret,
            int index
        ){
       if(tmp.size() == 5){
            ret.add(new ArrayList<Integer>(tmp)); 
       }else{
            for(int i=index;i<arr.size();i++){
                tmp.add(arr.get(i));
                combination(arr,tmp,ret,index);
                if(tmp.size()>0)
                    tmp.remove(tmp.size()-1);
            }   
       } 
    }


}

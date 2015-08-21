/*
ID: chaoliy1
LANG: JAVA
TASK: combo 
 */
import java.io.*;
import java.util.*;

class combo{
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("combo.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));
        String tmpN = f.readLine();
        int N = Integer.parseInt(tmpN);

        String pre_set1 = f.readLine();
        String [] tmp_pre_set1 = pre_set1.split(" ");
        int [] pre_set = {Integer.parseInt(tmp_pre_set1[0]),
            Integer.parseInt(tmp_pre_set1[1]),
            Integer.parseInt(tmp_pre_set1[2])
        };
        
        String pre_set2 = f.readLine();
        String [] tmp_pre_set2 = pre_set2.split(" ");
        int[] master  = {Integer.parseInt(tmp_pre_set2[0]),
            Integer.parseInt(tmp_pre_set2[1]),
            Integer.parseInt(tmp_pre_set2[2])
        };

        /* ArrayList<ArrayList<Integer>>arrls = new ArrayList<ArrayList<Integer>>(); */
        /* permu(arrls, new ArrayList<Integer>(), N, 0); */
        /* int ret = 0; */
        /* for(ArrayList<Integer>tup: arrls){ */
        /*     if(verify(tup, N, pre_set, master)) */
        /*         ret += 1; */
        /* } */
        int[] ret = new int[1];
        permu(new int [3], N, 0, ret, pre_set, master);

        out.println(Integer.toString(ret[0]));
        out.close();
    } 

    /* public static void permu(ArrayList<ArrayList<Integer>>ret, */
    /*         ArrayList<Integer>tmp, int N, int index){ */
    /*     if(index == 3){ */
    /*         ret.add(new ArrayList<Integer>(tmp));  */
    /*     }else{ */
    /*         for(int i=1;i<=N;i++){ */
    /*             tmp.add(i); */
    /*             permu(ret, tmp, N, index+1); */
    /*             if(tmp.size()>0) */
    /*                 tmp.remove(tmp.size()-1); */
    /*         } */
    /*     } */
    /*  */
    /* } */

    public static void permu(int [] tmp, int N, int index, 
            int []ret, int [] pre_set, int []master){
        if(index == 3){
            if((withinrange(tmp[0], pre_set[0], N)&&
               withinrange(tmp[1], pre_set[1], N)&&
               withinrange(tmp[2], pre_set[2], N)) ||

            (withinrange(tmp[0], master[0], N)&&
               withinrange(tmp[1], master[1], N)&&
               withinrange(tmp[2], master[2], N)))

                ret[0] ++;
        }else{
            for(int i=1;i<=N;i++){
                tmp[index] = i;
                permu(tmp, N, index +1, ret, pre_set, master);
            }
        }
    }


    /* public static boolean verify(ArrayList<Integer>arr, int N, int [] pre_set, int [] master){ */
    /*     if(withinrange(arr.get(0), pre_set[0], N)&& */
    /*        withinrange(arr.get(1), pre_set[1], N)&& */
    /*        withinrange(arr.get(2), pre_set[2], N)) */
    /*         return true; */
    /*  */
    /*     if(withinrange(arr.get(0), master[0], N)&& */
    /*        withinrange(arr.get(1), master[1], N)&& */
    /*        withinrange(arr.get(2), master[2], N)) */
    /*         return true; */
    /*     return false; */
    /* } */

    public static boolean withinrange(int a, int b, int N){
        return  (Math.abs(a-b)<=2 || N - Math.abs( a - b) <= 2);
    }

}

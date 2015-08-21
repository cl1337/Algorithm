/*
ID: chaoliy1
LANG: JAVA
TASK: milk 
 */
import java.io.*;
import java.util.*;

class milk{
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("milk.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
        String tmpN = f.readLine();
        String [] tmpNarr = tmpN.split(" ");
        int total = Integer.parseInt(tmpNarr[0]);
        int farms_N = Integer.parseInt(tmpNarr[1]);
        int [][] farms = new int[farms_N][2];

        for(int i =0;i<farms_N;i++){
            String str = f.readLine();
            String[] str_arr = str.split(" ");
            farms[i][0] = Integer.parseInt(str_arr[0]); // price
            farms[i][1] = Integer.parseInt(str_arr[1]); // amount
        }

        Arrays.sort(farms, new Comparator<int[]>(){
            public int compare(int[] a, int []b){
                return a[0] - b[0];
            }
        });

        int index = 0;
        int ret = 0;
        while(total>0){
            int quanti = Math.min(total, farms[index][1]); 
            ret += quanti*farms[index][0];
            total -= quanti;
            index ++;
        }

        out.println(Integer.toString(ret));
        out.close();
    } 

    /* public static void debug_print(int[][] farm, PrintWriter out){ */
    /*    for(int i=0;i<farm.length;i++) */
    /*       out.println(farm[i][0]);  */
    /* } */
}

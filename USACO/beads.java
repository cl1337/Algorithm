/*
ID: chaoliy1
LANG: JAVA
TASK: beads
 */
import java.io.*;
import java.util.*;

class beads{
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("beads.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
        String tmpN = f.readLine();
        int N = Integer.parseInt(tmpN);
        String tmpA = f.readLine();
        int ret = 0;
        char [] arr= (tmpA + tmpA).toCharArray();
        int [] bl = new int[2*N+1], br = new int[2*N+1], rl = new int[2*N+1], rr = new int[2*N+1];
        for(int i=1;i<=2*N;i++){
            if(arr[i-1] == 'r'){
                rl[i] = rl[i-1] +1;
                bl[i] = 0;
            }else if(arr[i-1] == 'b'){
                rl[i] = 0;
                bl[i] = bl[i-1] +1;
            }else{
                rl[i] = rl[i-1]+1;
                bl[i] = bl[i-1]+1;
            }
        }

        for(int i=2*N-1; i>=0; i--){
            if(arr[i] == 'r'){
                rr[i] = rr[i+1] +1;
                br[i] = 0; 
            }else if(arr[i] == 'b'){
                rr[i] = 0;
                br[i] = br[i+1] +1;
            }else{
                br[i] = br[i+1] +1;
                rr[i] = rr[i+1] +1;
            }
        }

        for(int i=0;i<2*N;i++){
            ret = Math.max(ret, Math.max(bl[i], rl[i])+Math.max(br[i], rr[i]));
        }
        ret = Math.min(ret, N);

        out.println(Integer.toString(ret));
        out.close();
    } 
}

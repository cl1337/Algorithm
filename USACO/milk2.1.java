/*
ID: chaoliy1
LANG: JAVA
TASK: milk2 
 */
import java.io.*;
import java.util.*;

class milk2{
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
        String tmpN = f.readLine();
        int N = Integer.parseInt(tmpN);
        work[] arr = new work[N];
        for(int i=0;i<N;i++){
            String[] str = f.readLine().split(" ");
            arr[i] = new work(Integer.parseInt(str[0]),Integer.parseInt(str[1]));
        }
        Arrays.sort(arr, comp);
        int max_duration = arr[0].end - arr[0].start;
        int max_idle = 0;
        int last_start = arr[0].start;
        int last_end = arr[0].end;
        for(int i=0;i<N; i++){
            if(arr[i].start > last_end){
                max_duration = Math.max(max_duration, last_end - last_start);
                max_idle = Math.max(max_idle, arr[i].start - last_end);
                last_start = arr[i].start;
            }
            last_end = Math.max(last_end, arr[i].end);
        }
        out.println(Integer.toString(max_duration)+ " "+ Integer.toString(max_idle));
        out.close();
    } 

    public static Comparator<work> comp = new Comparator<work>(){
        public int compare(work w1, work w2){
            return w1.start - w2.start;
        }  
    };
}

class work{
    public int start = 0;
    public int end = 0;
    public work(int s, int e){
        this.start = s;
        this.end = e; 
    }
}

/*
ID: chaoliy1
LANG: JAVA
TASK: barn1 
 */
import java.io.*;
import java.util.*;

class barn1{
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("barn1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
        String tmpN = f.readLine();
        String [] tmpN_arr = tmpN.split(" ");

        int lumber_num = Integer.parseInt(tmpN_arr[0]);
        int stall_total_num = Integer.parseInt(tmpN_arr[1]);
        int cow_stall_num = Integer.parseInt(tmpN_arr[2]);

        int [] seq = new int[cow_stall_num];
        PriorityQueue<gap> pq = new PriorityQueue<gap>(1, new Comparator<gap>(){
            public int compare(gap a, gap b){
                return a.val - b.val;
            }
        });

        for(int i=0;i<cow_stall_num;i++){
            String str = f.readLine();
            seq[i] = Integer.parseInt(str);
        }

        Arrays.sort(seq);
        
        if(lumber_num == 1){ //special case 1 only one lumber
            out.println(seq[seq.length-1] - seq[0]+1);
            out.close();
            return;
        }else if(lumber_num>seq.length){//special case 2 lumber more than occupied stalls
            out.println(seq.length);
            out.close();
            return;
        }
        
        int last = seq[0];
        for(int i=1;i<cow_stall_num;i++){
            int dist = seq[i] - last;
            last = seq[i];
            if(pq.size() < lumber_num-1)
                pq.offer(new gap(dist, seq[i]));
            else if(pq.peek().val < dist){
                pq.poll();
                pq.offer(new gap(dist, seq[i]));
            }
        }

        ArrayList<gap> arr = new ArrayList<gap>();
        while(!pq.isEmpty())
            arr.add(pq.poll());
        Collections.sort(arr, new Comparator<gap>(){
            public int compare(gap a, gap b){
                return a.start - b.start;
            }
        });


        int ret = 0;
        for(int i=0;i<lumber_num;i++){
            if (i==0){
              ret += arr.get(0).start - arr.get(0).val - seq[0] +1; 
            }else if(i == lumber_num-1){
              ret += seq[cow_stall_num-1] - arr.get(i-1).start +1;
            }else{
              ret += arr.get(i).start - arr.get(i).val - arr.get(i-1).start+1;
            }
        }

        out.println(Integer.toString(ret));
        out.close();
    } 

}

class gap{
    public int val = 0;
    public int start = 0;
    public gap(int val, int start){
        this.val = val;
        this.start=  start;
    }
}

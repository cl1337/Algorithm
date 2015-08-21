/*
ID: chaoliy1
LANG: JAVA
TASK: sort3 
 */
import java.io.*;
import java.util.*;

class sort3 {

	public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("sort3.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sort3.out")));
        int N = Integer.parseInt(f.readLine());
        int [] arr = new int[N];
        for(int i=0;i<N;i++)
            arr[i] = Integer.parseInt(f.readLine());
        int[] brr = arr.clone();
        ThreeWaySort(brr,1,2,3);

        int [][] circle = new int[3][3];
        for(int i=0;i<N;i++){
            if(arr[i] != brr[i]){
                circle[brr[i]-1][arr[i]-1] += 1;
            }
        }
        int ret = 0;
        boolean flag = false;

        for(int [] x:circle){
            for(int y:x)
                System.out.print(y + ", ");
            System.out.println();
        }

        while(true){
            if(flag){break;}
            flag = true;
            for(int i=0;i<3;i++)
                for(int j=0;j<3;j++){
                    if(circle[i][j] == 0 || i==j) continue;
                    flag = false;
                    if(circle[j][i]>0){
                    	int route = Math.min(circle[i][j], circle[j][i]);
                    	circle[i][j] -= route;
                    	circle[j][i] -= route;
                    	ret += route;
                    }else{
                     circle[i][j] --;
                    int head = i, curr = j, route = 0, k=0;
                    while(k<3&&curr!=head){
                        if(circle[curr][k] == 0 || curr == k){
                            k++;
                        }else{
                            circle[curr][k] --;
                            curr = k;
                            route ++;
                            k =0;
                        }
                    }
                    ret += route;                   	
                    }

                }
        }


        out.println(ret);
        out.close();
    }

	public static void ThreeWaySort(int[] arr, int l, int mid, int r) {
		int ls = 0, eq = 0, lt = arr.length - 1;
		int tmp = 0;
		while (eq < lt) {
			if (arr[eq] == l) {
				// swap(ls++, eq++);
				tmp = arr[ls];
				arr[ls++] = arr[eq];
				arr[eq++] = tmp;
			} else if (arr[eq] == mid) {
				eq++;
			} else {
				// swap(eq, lt--);
				tmp = arr[eq];
				arr[eq] = arr[lt];
				arr[lt--] = tmp;
			}
		}
	}
}

import java.io.*;
import java.util.*;

class testDriver{
    public static void main(String[] args){
        int [][] circle = {{0,6,8},{7,0,3},{7,4,0}};
        int ret = 0;
        boolean flag = false;
        while(true){
            if(flag){break;}
            flag = true;
            for(int i=0;i<3;i++)
                for(int j=0;j<3;j++){
                    if(circle[i][j] == 0 || i==j) continue;
                    flag = false;
                    circle[i][j] --;
                    int head = i, curr = j, route = 0, k=0;
                    while(k<3&&curr!=head){
                        if(circle[curr][k] == 0){
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
        System.out.println(ret);
    }

    public static int ThreeWaySort(int[] arr, int l, int mid, int r){
        int ls = 0, eq = 0, lt=arr.length-1;
        int tmp = 0, ret = 0;
        while(eq<lt){
            if(arr[eq] == l){
                if(ls != eq)
                    ret ++;
                //swap(ls++, eq++);
               tmp = arr[ls];
               arr[ls++] = arr[eq];
               arr[eq++] = tmp; 
            }else if(arr[eq] == mid){
                eq ++;
            }else{
                //swap(eq, lt--);
                if(arr[eq]!=arr[lt])
                    ret ++;
                tmp = arr[eq];
                arr[eq] = arr[lt];
                arr[lt--] = tmp;

            }
        }
        return ret;
    }
}

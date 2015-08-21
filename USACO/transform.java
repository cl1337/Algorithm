/*
ID: chaoliy1
LANG: JAVA
TASK: transform 
 */
import java.io.*;
import java.util.*;

class transform{
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("transform.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
        String tmpN = f.readLine();
        int N = Integer.parseInt(tmpN);
        char[][] origin = new char[N][N];
        char[][] tmp= new char[N][N];
        char[][] after = new char[N][N];
        int ret = 0;

        for(int i=0;i<N;i++){
            String str = f.readLine();
            origin[i] = str.toCharArray();
        }
        for(int i=0;i<N;i++){
            String str = f.readLine();
            after[i] = str.toCharArray();
        }


        //check 1 90 rotate
       tmp = deepcopy(origin);
       rotate(tmp, true);
       if(check(tmp, after)){
           ret = 1;
            out.println(Integer.toString(ret));
            out.close();
            return;}

        //check 3 270 rotate
       tmp = deepcopy(origin);
       rotate(tmp, false);
       if(check(tmp, after)){
           ret = 3;
            out.println(Integer.toString(ret));
            out.close();
            return;}

       //check 2 180 rotate
       tmp = deepcopy(origin);
       rotate(tmp, true);
       rotate(tmp, true);
       if(check(tmp, after)){
           ret = 2;
            out.println(Integer.toString(ret));
            out.close();
            return;}

       //check 4 reflection
       tmp = deepcopy(origin);
       reflect(tmp, false);
       if(check(tmp, after)){
           ret = 4;
            out.println(Integer.toString(ret));
            out.close();
            return;}

       //check 5 combination
       tmp = deepcopy(origin);
       reflect(tmp, false);

       char[][]tmp2 = deepcopy(tmp);
       rotate(tmp2, true);
       if(check(tmp2, after)){
           ret = 5;
            out.println(Integer.toString(ret));
            out.close();
            return;}

       tmp2 = deepcopy(tmp);
       rotate(tmp2, false);
       if(check(tmp2, after)){
           ret = 5;
            out.println(Integer.toString(ret));
            out.close();
            return;}

       tmp2 = deepcopy(tmp);
       rotate(tmp2, true);
       rotate(tmp2, true);
       if(check(tmp2, after)){
           ret = 5;
            out.println(Integer.toString(ret));
            out.close();
            return;}




        //check 6 no change
        tmp = deepcopy(origin);
        if(check(tmp, after)){
           ret = 6;
            out.println(Integer.toString(ret));
            out.close();
            return;}

        ret = 7;
        out.println(Integer.toString(ret));
        out.close();
    } 

    public static char[][] deepcopy(char[][]origin){
        char[][] ret = new char[origin.length][];
        for(int i=0;i<origin.length;i++)
            ret[i] = Arrays.copyOf(origin[i], origin[i].length);
        return ret;
    }

public static void rotate(char[][] origin, boolean d){
int n = origin.length;
int level = n/2;
if(d){//rotate 90
for(int l =0;l<level;l++){
for(int i=0;i<n-2*l-1;i++){
char tmp = origin[l][i+l];
origin[l][i+l] = origin[n-1-l-i][l];
origin[n-1-l-i][l] = origin[n-1-l][n-1-l-i];
origin[n-1-l][n-1-l-i] = origin[l+i][n-1-l];
origin[l+i][n-1-l] = tmp;
}
}
}else{//rotate 270
for(int l =0;l<level;l++){
for(int i=0;i<n-2*l-1;i++){
char tmp = origin[l][i+l];
origin[l][i+l] = origin[l+i][n-1-l];
origin[l+i][n-1-l] = origin[n-l-1][n-1-l-i];
origin[n-l-1][n-1-l-i] = origin[n-1-l-i][l];
origin[n-1-l-i][l] = tmp;
}
}
}
}
    public static void reflect(char[][] rotate, boolean v){
        int n = rotate.length;
        int level = n/2;
        if(v){//reflect vertically
            for(int i=0;i<level;i++){
                char[] tmp = rotate[i];
                rotate[i] = rotate[n-1-i];
                rotate[n-1-i] = tmp;
            }
        }else{// reflect horizontally
            for(int i=0;i<n;i++)
                for(int j=0;j<n/2;j++){
                    char tmp = rotate[i][j];
                    rotate[i][j] = rotate[i][n-1-j];
                    rotate[i][n-1-j] = tmp;
                }
        }
    }

    public static boolean check(char[][]rotate, char[][]origin){
        int n = rotate.length;
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                if(rotate[i][j]!=origin[i][j])
                    return false;
        return true;
    }
}

/*
ID: chaoliy1
LANG: JAVA
TASK: milk3 
 */
import java.io.*;
import java.util.*;

class milk3 {
	static int[] arr = new int[3];
	static Set<Integer> ret= new HashSet<Integer>();

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("milk3.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"milk3.out")));
		arr = new int[3];
		int i = 0;
		for (String s : f.readLine().split(" "))
			arr[i++] = Integer.parseInt(s);
		boolean[][] dup = new boolean[arr[0] + 1][arr[1] + 1];
		dfs(arr, new int[] { 0, 0, arr[2] }, dup);
		String res = "";
		ArrayList<Integer>dumb = new ArrayList<Integer>();
		for (int x : ret)
			dumb.add(x);
		Collections.sort(dumb);
		for (int x : dumb)
			res += Integer.toString(x) + " ";
		System.out.println(res);
		out.println(res.trim());
		out.close();
	}

	public static void dfs(int[] capa, int[] contain, boolean[][] dup) {
		if (dup[contain[0]][contain[1]])
			return;
		if (contain[0] == 0)
			ret.add(contain[2]);
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++) {
				if (i == j || contain[i] == 0 || contain[j] == capa[j])
					continue;
				int curr_src = contain[i];
				int curr_dst = contain[j];
				int src_i = contain[0];
				int src_j = contain[1];
				dup[contain[0]][contain[1]] = true;
				
				if (contain[i] <= capa[j] - contain[j]) {
					contain[j] += contain[i];
					contain[i] = 0;
				} else {
					contain[i] -= (capa[j] - contain[j]);
					contain[j] = capa[j];
				}
				dfs(capa, contain, dup);
				
				contain[i] = curr_src;
				contain[j] = curr_dst;
				dup[src_i][src_j] = false;
			}
	}
}

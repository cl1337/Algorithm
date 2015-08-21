/*
ID: chaoliy1
LANG: JAVA
TASK: castle 
 */
import java.io.*;
import java.util.*;

class castle {

	public static int next = 1;
	public static int max = Integer.MIN_VALUE;
	public static HashMap<Integer, Integer> spaces = new HashMap<Integer, Integer>();
	public static int res[] = { Integer.MIN_VALUE, Integer.MAX_VALUE, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("castle.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"castle.out")));
		String[] tmp = f.readLine().split(" ");
		int n = Integer.parseInt(tmp[0]);
		int m = Integer.parseInt(tmp[1]);
		int[][] arr = new int[m][n];
		int[][] component = new int[m][n];
		for (int i = 0; i < m; i++) {
			tmp = f.readLine().split(" ");
			for (int j = 0; j < n; j++)
				arr[i][j] = Integer.parseInt(tmp[j]);
		}

		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++) {
				dfs(i, j, component, arr);
			}
		int max_room = Integer.MIN_VALUE;
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++) {
				if (!spaces.containsKey(component[i][j]))
					spaces.put(component[i][j], 0);
				int count = spaces.get(component[i][j])+1;
				spaces.put(component[i][j], count);
				max_room = Math.max(max_room, count);
			}
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++) {
				dfs2(i, j, component, arr);
			}
		// debug
//		for (int i = 0; i < m; i++) {
//			for (int j = 0; j < n; j++)
//				System.out.print(component[i][j] + ", ");
//			System.out.println();
//		}
//
//		System.out.println(max);
//		System.out.println(res[0] + ", " + res[1] + ", " + res[2]);
		//debug

		out.println(spaces.size());
		out.println(max_room);
		out.println(max);
		char direction = res[2] == 1? 'N':'E';
		out.println(Integer.toString(res[0]+1)+" "+Integer.toString(res[1]+1)+" "+direction);
		out.close();
	}

	public static void dfs(int x, int y, int[][] component, int[][] arr) {
		int m = component.length;
		int n = component[0].length;
		// if is the first of neighbors
		if (component[x][y] == 0) {
			component[x][y] = next;
			next++;
		}

		// left
		if (y - 1 >= 0 && y - 1 < n && (((arr[x][y]) & 1) == 0)
				&& component[x][y - 1] == 0) {
			component[x][y - 1] = component[x][y];
			dfs(x, y - 1, component, arr);
		}
		// right
		if (y + 1 >= 0 && y + 1 < n && (((arr[x][y] >> 2) & 1) == 0)
				&& component[x][y + 1] == 0) {
			component[x][y + 1] = component[x][y];
			dfs(x, y + 1, component, arr);
		}
		// up
		if (x - 1 >= 0 && x - 1 < m && (((arr[x][y] >> 1) & 1) == 0)
				&& component[x - 1][y] == 0) {
			component[x - 1][y] = component[x][y];
			dfs(x - 1, y, component, arr);
		}
		// down
		if (x + 1 >= 0 && x + 1 < m && (((arr[x][y] >> 3) & 1) == 0)
				&& component[x + 1][y] == 0) {
			component[x + 1][y] = component[x][y];
			dfs(x + 1, y, component, arr);
		}
	}

	public static void dfs2(int x, int y, int[][] component, int[][] arr) {
		int m = component.length;
		int n = component[0].length;
		for (int i = -1; i < 2; i++)
			for (int j = -1; j < 2; j++) {
				if (x + i >= 0 && x + i < m && y + j >= 0 && y + j < n
						&& Math.abs(i) != Math.abs(j)
						&& component[x + i][y + j] != component[x][y]) {
					int val = spaces.get(component[x + i][y + j])
							+ spaces.get(component[x][y]);
					if (val >= max) {
						// east -> 2, north -> 1
//						if ((val>max)||(res[1] > Math.min(y, y + i)|| res[1] == Math.min(y, y + i)&& res[0] < Math.max(x, x + j))) {
						if ((val>max)||(res[1] > y|| res[1] == y&& res[0] < x)) {
							if (i != 0) {
								res[0] = x;//Math.max(x, x + i);
								res[1] = y;
								res[2] = 1;
							} else {
								res[0] = x;
								res[1] = y;//Math.min(y, y + j);
								res[2] = 2;
							}
							max = val;
							if(res[0]==49&&res[1] == 0){
								int ss = 1;
							}
						}
					}
				}
			}
	}

}

package algo_09_20195138;

public class Graph {
	int n; // Number of vertices
	int e; // Number of edges
	int[][] weight; 
	boolean visited[];

	public Graph(int noOfVertices) {
		this.n = noOfVertices;
		this.e = 0;
		weight = new int[this.n][this.n];
		visited = new boolean[n];
	}

	public void insertEdge(int i, int j) {
		weight[i][j] = 1;
		weight[j][i] = 1;
		e++;
	}

	public void removeEdge(int i, int j) {
		weight[i][j] = 0;
		weight[j][i] = 0;
		e--;
	}

	public int[] adjacency(int u) {
		int count = 0;
		int loop = 0;
		
		for (int i = 0; i < weight.length; i++) {
			if (weight[u][i] != 0) {
				count++;
			}
		}
		
		int arr[] = new int[count];
		for (int i = 0; i < weight.length; i++) {
			if (weight[u][i] != 0) {
				arr[loop++] = i;
			}
		}
		return arr;
	}
	
	public void bfs(int v) {
		System.out.println("BFS");
		for (int j = 0; j < n; j++) {
			visited[j] = false;
		}
		Queue q = new Queue();
		q.enqueue(v);

		while (!q.isEmpty()) {
			int j = (int) q.dequeue();
			if (visited[j] == false) {
				System.out.print(j + ", ");
				visited[j] = true;
			}
			for (int k : adjacency(j)) {
				if (visited[k] == false) {
					q.enqueue(k);
				}
			}
		}
	}
	
	public void dfs(int v) {
		System.out.println("DFS");
		for (int j = 0; j < n; j++) {
			visited[j] = false;
		}
		Stack stk = new Stack();
		stk.push(v);
		while (!stk.isEmpty()) {
			int j = (int) stk.pop();
			if (visited[j] == false) {
				System.out.print(j + ", ");
				visited[j] = true;
			}
			for (int k : adjacency(j)) {
				if (visited[k] == false) {
					stk.push(k);
				}
			}
		}
	}
}

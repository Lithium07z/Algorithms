package algo_11_20195138;

public class Wgraph { // Matrix
	int n; // Number of vertices
	int e; // Number of edges
	int weight[][];
	static final int INF = 9999;

	public Wgraph(int noOfVertices) {
		n = noOfVertices;
		e = 0;
		weight = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i != j) {
					weight[i][j] = INF;
				}
			}
		}
	}

	public Wgraph() {
		n = 0;
		e = 0;
	}

	public void insertEdge(int i, int j, int w) {
		weight[i][j] = w;
		e++;
	}

	public void removeEdge(int i, int j) {
		weight[i][j] = INF;
		e--;
	}

	public int[] shortestPath(int y) {
		boolean visited[] = new boolean[n];
		int dist[] = new int[n];

		for (int i = 0; i < n; i++) {
			visited[i] = false;
			dist[i] = INF;
		}
		dist[y] = 0;
		for (int i = 0; i < n; i++) {
			int minVertex = -1;
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < n; j++) {
				if ((!visited[j]) && (dist[j] < min)) {
					min = dist[j];
					minVertex = j;
				}
			}
			visited[minVertex] = true;
			for (int j = 0; j < n; j++) {
				int e = weight[minVertex][j];
				if (!visited[j]) {
					int currentDist = dist[j];
					int newDist = dist[minVertex] + e;
					if (newDist < currentDist) {
						dist[j] = newDist;
					}
				}
			}
		}
		return dist;
	}

	public int[] negativePath(int y) {
		int dist[] = new int[n];

		for (int i = 0; i < n; i++) {
			dist[i] = weight[y][i];
		}
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (dist[k] > dist[j] + weight[j][k]) {
						dist[k] = dist[j] + weight[j][k];
					}
				}
			}
		}
		return dist;
	}

	public int[][] allShortestPath() {
		int[][] distance = weight;
		int[][] distanceP = new int[n][n];
		int k, i, j;

		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++) {
				distanceP[i][j] = distance[i][j];
			}
		}

		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++) {
				for (k = 0; k < n; k++) {
					if (distanceP[j][k] > distanceP[j][i] + distanceP[i][k]) {
						distanceP[j][k] = distanceP[j][i] + distanceP[i][k];
					}
				}
			}
		}
		return distanceP;
	}
}
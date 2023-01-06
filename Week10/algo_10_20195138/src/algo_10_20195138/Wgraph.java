package algo_10_20195138;

public class Wgraph {
	int n; // Number of vertices
	int e; // Number of edges
	int weight[][];

	public Wgraph(int noOfVertices) {
		n = noOfVertices;
		e = 0;
		weight = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i != j) {
					weight[i][j] = 10000;
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
		weight[j][i] = w;
		e++;
	}

	public void removeEdege(int i, int j) {
		weight[i][j] = 10000;
		weight[j][i] = 10000;
		e--;
	}

	public Edge[] kruskal() { // Kruskal
		Edge[] T = new Edge[n - 1]; // return 값
		int Tptr = -1; // 간선 개수 확인
		int count = 0;

		MinHeap edgeList = new MinHeap(); // heap에 저장

		UnionFind uf = new UnionFind(n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (weight[i][j] != 0) { // 간선이 존재하면
					edgeList.insert(new Edge(i, j, weight[i][j])); // minHeap에 저장
					Tptr++; // 간선 개수 증가
				}
			}
		}
		
		for (int i = 0; i < Tptr; i++) {
			Edge temp = (Edge) edgeList.delete(); // minHeap에서 간선 추출
			if (!uf.find(temp.head, temp.tail)) { // 아직 집합에 없다면
				T[count++] = temp; // 최소신장트리에 추가
				uf.union(temp.head, temp.tail); // 집합에 추가
			}
			if (count >= T.length) {
				break;
			}
		}
		return T;
	}

	public Edge[] prim(int i) { // Prim
		Edge[] T = new Edge[n - 1];
		int Tptr = 0;

		MinHeap edgeList = new MinHeap();

		UnionFind uf = new UnionFind(n);

		for (int j = 0; j < n; j++) {
			if (weight[i][j] != 0) {
				edgeList.insert(new Edge(i, j, weight[i][j]));
			}
		}
		while (Tptr < T.length) {
			Edge temp = (Edge) edgeList.delete();
			if (!uf.find(temp.head, temp.tail)) {
				uf.union(temp.head, temp.tail);
				T[Tptr++] = temp;
				for (int j = 0; j < n; j++) {
					if (weight[temp.tail][j] != 0) {
						edgeList.insert(new Edge(temp.tail, j, weight[temp.tail][j]));
					}
				}
			}
		}
		return T;
	}
}

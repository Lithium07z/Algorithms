package algo_09_20195138;

class Node {
	int vertex;
	Node link;
	
	public Node(int vertex, Node link) {
		this.vertex = vertex;
		this.link = link;
	}
}

public class GraphList {
	int n; // Number of vertices;
	int e; // Number of edges;
	Node[] header;
	boolean[] visited;
	
	public GraphList(int noOfVertices) {
		n = noOfVertices;
		e = 0;
		header = new Node[n];
		visited = new boolean[n];
	}
	
	public void insertEdge(int i, int j) {
		Node node1 = new Node(j, null);
		node1.link = header[i];
		header[i] = node1;

		Node node2 = new Node(i, null);
		node2.link = header[j];
		header[j] = node2;
		e++;
	}
	
	public void removeEdge(int i, int j) {
		Node temp = header[i];
		while (true) {
			if (temp.link.vertex == j) {
				temp.link = temp.link.link;
				break;
			} else {
				temp = temp.link;
			}
		}
		
		temp = header[j];
		while (true) {
			if (temp.link.vertex == i) {
				temp.link = temp.link.link;
				break;
			} else {
				temp = temp.link;
			}
		}
		e--;
	}
	
	public int[] adjacency(int u) {
		Node temp = header[u];
		int count = 0;

		while (true) {
			if (temp == null) {
				temp = header[u];
				break;
			} else {
				temp = temp.link;
				count++;
			}
		}

		int arr[] = new int[count];
		
		for (int i = 0; i < count; i++) {
			arr[i] = temp.vertex;
			temp = temp.link;
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

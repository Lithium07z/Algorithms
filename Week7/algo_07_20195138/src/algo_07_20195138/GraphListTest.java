package algo_07_20195138;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node {
	int vertex;
	Node link;

	public Node() {
		this.vertex = 0;
		this.link = null;
	}

	public Node(int vertex, Node link) {
		this.vertex = vertex;
		this.link = link;
	}
}

class GraphList { // List
	int n; // Number of vertices
	int e; // Number of edges
	Node[] header;
	boolean[] visited;

	public GraphList(int noOfVertices) {
		this.n = noOfVertices;
		header = new Node[this.n];
		visited = new boolean[n];
//		O(N) 방식 때 초기화하는 법
//		for (int i = 0; i < header.length; i++) {
//			header[i] = new Node();
//		}
	}

	public void insertEdge(int i, int j) {
//  뒤에서부터 추가하는 방식 O(N)
//		Node temp = header[i];
//		while (true) {
//			if (temp.link == null) {
//				temp.link = new Node(j, null);
//				break;
//			}  else {
//				temp = temp.link;
//			}
//		}
//		e++;

		Node node1 = new Node(j, null);
		node1.link = header[i];
		header[i] = node1;

		Node node2 = new Node(i, null);
		node2.link = header[j];
		header[j] = node2;

		e++;
	}

	public void removeEdge(int i, int j) {
//  뒤에서부터 제거하는 방식 O(N) << 수정해야됨 i에서 j로의 간선이 아닌 뒤에서부터 지우는 알고리즘임
//		Node temp = header[i];
//		while (true) {
//			if (temp.link == null) {
//				temp = null;
//				break;
//			}  else {
//				temp = temp.link;
//			}
//		}
//		e--;

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
	}

	public int[] adjacency(int u) {
//	O(N) 일때 방식
//		int arr[] = new int[header.length];
//		Node temp = header[u].link;
//		int count = 0;
//		
//		while (true) {
//			if (temp == null) {
//				break;
//			}  else {
//				arr[temp.vertex] = temp.vertex;
//				temp = temp.link;
//			}
//		}
//		return arr;

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
		for (int j = 0; j < n; j++) {
			visited[j] = false;
		}
		Queue q = new LinkedList();
		q.add(v);

		while (!q.isEmpty()) {
			int j = (int) q.poll();
			if (visited[j] == false) {
				System.out.print(header[j].vertex + " ");
				visited[j] = true;
			}
			for (int k : adjacency(j)) {
				if (visited[k] == false) {
					q.add(k);
				}
			}
		}
	}

	public void dfs(int v) {
		for (int j = 0; j < n; j++) {
			visited[j] = false;
		}
		Stack stk = new Stack();
		stk.push(v);
		while (!stk.isEmpty()) {
			int j = (int) stk.pop();
			if (visited[j] == false) {
				System.out.print(header[j].vertex + " ");
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

class Graph { // List
	int n; // Number of vertices
	int e; // Number of edges
	int[][] adj; //

	public Graph(int noOfVertices) {
		this.n = noOfVertices;
		adj = new int[this.n][this.n];
	}

	public void insertEdge(int i, int j) {
		adj[i][j] = 1;
		adj[j][i] = 1;
		e++;
	}

	public void removeEdge(int i, int j) {
		adj[i][j] = 0;
		adj[j][i] = 0;
		e--;
	}

	public int[] adjacency(int u) {
		int arr[] = new int[adj.length];
		for (int i = 0; i < adj.length; i++) {
			if (adj[u][i] != 0) {
				arr[i] = 1;
			}
		}
		return arr;
	}
}

class GraphListTest {
	public static void main(String args[]) {
		GraphList gr = new GraphList(6);

		gr.insertEdge(0, 1);
		gr.insertEdge(0, 2);
		gr.insertEdge(1, 2);
		gr.insertEdge(1, 3);
		gr.insertEdge(2, 3);
		gr.insertEdge(2, 4);
		gr.insertEdge(3, 4);
		gr.insertEdge(3, 5);
		gr.insertEdge(4, 5);
		gr.insertEdge(1, 5);

		System.out.println();
		int[] adj;
		for (int i = 0; i < 6; i++) {

			adj = gr.adjacency(i);
			System.out.print(i + ": ");
			for (int e : adj) {
				System.out.print(e + " ");
			}
			System.out.println();
		}
		
		gr.bfs(1); System.out.println(); gr.dfs(1);
		 
		System.out.println();
		System.out.println("==================");

		gr = new GraphList(7);

		gr.insertEdge(0, 1);
		gr.insertEdge(0, 2);
		gr.insertEdge(0, 3);
		gr.insertEdge(1, 4);
		gr.insertEdge(2, 4);
		gr.insertEdge(2, 5);
		gr.insertEdge(3, 5);
		gr.insertEdge(4, 6);
		gr.insertEdge(5, 6);

		System.out.println();
//        int[] adj;
		for (int i = 0; i < 7; i++) {

			adj = gr.adjacency(i);
			System.out.print(i + ": ");
			for (int e : adj) {
				System.out.print(e + " ");
			}
			System.out.println();
		}

		gr.bfs(4); System.out.println(); gr.dfs(4);
	}
}

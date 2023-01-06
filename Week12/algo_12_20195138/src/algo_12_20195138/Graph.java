package algo_12_20195138;

class Node {
	int vertex;
	Node link;
	
	public Node() {
		
	}
	
	public Node(int vertex, Node link) {
		this.vertex = vertex;
		this.link = link;
	}
}

public class Graph {
	Node[] header;
	int n;
	int[] indegree; // 정점 i의 진입차수
	
	public Graph(int vertices) {
		n = vertices;
		header = new Node[n];
		indegree = new int[n];
	}
	
	public void topologicalSort() {
		int i, v, successor, j = 0;
		Queue zeroPredQ = new Queue(); // 선행자가 없는 정점들을 저장하는 큐
		int[] sortedList = new int[n]; // 위상 정렬 결과를 보관하는 리스트 
		
		for (i = 0; i < n; i++) {
			if (indegree[i] == 0) {
				zeroPredQ.enqueue(i);
			}
		}
		if (zeroPredQ.isEmpty()) {
			System.out.println("network has a cycle");
			return;
		}
		while (!zeroPredQ.isEmpty()) {
			// indegree가 0인 정점들을 큐에서 하나씩 삭제해 처리
			v = zeroPredQ.dequeue();
			// indegree가 0인 정점들을 결과 리스트에 삽입
			sortedList[j++] = v;
			if (header[v] == null) {
				continue; // 정점 v의 후속자가 없으면 밖의 while 루프로
			} else {
				successor = header[v].vertex;
				header[v] = header[v].link;
			} // 후속자가 있으면, 그 후속자를 successor로 설정
			while(true) {
				indegree[successor]--;
				if (indegree[successor] == 0) {
					zeroPredQ.enqueue(successor);
				}
				if (header[v] != null) {
					successor = header[v].vertex;
					header[v] = header[v].link;
				} else {
					break;
				}
			}	
		}
		System.out.println("Topological Order is : ");
		for (i = 0; i < sortedList.length; i++) {
			System.out.print(sortedList[i] + " ");
		}
	}
	
	public void insertEdge(int i, int j) {
		Node node = new Node(j, null);
		node.link = header[i];
		header[i] = node;
		
        indegree[j]++;
	}
}

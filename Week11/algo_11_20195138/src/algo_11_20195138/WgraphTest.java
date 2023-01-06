package algo_11_20195138;

public class WgraphTest {
	public static void main(String[] args) {
		Wgraph gr = new Wgraph(5);
		
		gr.insertEdge(0, 1, 2);
		gr.insertEdge(0, 2, 5);
		gr.insertEdge(0, 4, 3);
		gr.insertEdge(1, 3, 4);
		gr.insertEdge(1, 4, 10);
		gr.insertEdge(2, 3, 6);
		gr.insertEdge(2, 4, 2);
		gr.insertEdge(4, 2, 1);
		gr.insertEdge(4, 3, 2);
		
		int[] sp = gr.shortestPath(0);
		
		for (int i = 0; i < sp.length; i++) {
			System.out.println("O ->" + i + ": " + sp[i]);
		}
		
		System.out.println();
		
		gr = new Wgraph(6);
		
		gr.insertEdge(0, 1, 6);
		gr.insertEdge(0, 2, 5);
		gr.insertEdge(0, 3, 5);
		gr.insertEdge(1, 4, -1);
		gr.insertEdge(2, 1, -2);
		gr.insertEdge(2, 4, 1); 
		gr.insertEdge(3, 2, -3);
		gr.insertEdge(3, 5, -1); 
		gr.insertEdge(4, 5, 3);
		
		sp = gr.negativePath(0); 
		for (int i = 0; i < sp.length; i++) {
			System.out.println("O -> " + i + ": " + sp[i]);
		}
		
		System.out.println();
		
		gr = new Wgraph(6);
		
		gr.insertEdge(0, 1, 5);
		gr.insertEdge(0, 2, 4);
		gr.insertEdge(1, 2, 2);
		gr.insertEdge(1, 3, 7);
		gr.insertEdge(2, 3, 6);
		gr.insertEdge(2, 4, 11);
		gr.insertEdge(3, 4, 3); 
		gr.insertEdge(3, 5, 8); 
		gr.insertEdge(4, 5, 8);
		
		System.out.println();
		
		for (int i = 0; i < 6; i++) { 
			for (int j = 0; j < 6; j++) {
				System.out.print(gr.weight[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		int shPath[][] = gr.allShortestPath(); 
		for (int i = 0; i < 5; i++) { 
			for (int j = 0; j < 6; j++){
				System.out.print(shPath[i][j] + " ");
			}
			System.out.println();
		}

	}

}
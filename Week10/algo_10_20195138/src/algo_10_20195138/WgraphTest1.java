package algo_10_20195138;

class WgraphTest1 { 
	public static void main(String args[]) {

		Wgraph gr = new Wgraph(6);
		
		gr.insertEdge(0, 1, 5); 
		gr.insertEdge(0, 2, 4); 
		gr.insertEdge(1, 2, 2); 
		gr.insertEdge(1, 3, 7); 
		gr.insertEdge(2, 3, 6); 
		gr.insertEdge(2, 4, 11); 
		gr.insertEdge(3, 4, 3); 
		gr.insertEdge(3, 5, 8); 
		gr.insertEdge(4, 5, 8);
		
		System.out.println("Kruskal");
		
		Edge[] edgelist = gr.kruskal(); 
		for (int i = 0; i < edgelist.length; i++)
			System.out.print("(" + edgelist[i].tail + " " + edgelist[i].head + ") ");
		
		System.out.println(); 
		System.out.println("Prim");
		
		edgelist = gr.prim(0);
		for (int i = 0; i < edgelist.length; i++)
			System.out.print("(" + edgelist[i].tail + " " + edgelist[i].head + ") ");
		
		System.out.println("\n");
		System.out.println("정점 7개 graph");
		
		gr = new Wgraph(7);
		
		gr.insertEdge(0, 1, 5); 
		gr.insertEdge(0, 2, 4); 
		gr.insertEdge(0, 3, 4); 
		gr.insertEdge(1, 4, 2); 
		gr.insertEdge(2, 4, 7); 
		gr.insertEdge(2, 5, 6); 
		gr.insertEdge(3, 5, 11); 
		gr.insertEdge(4, 6, 3); 
		gr.insertEdge(5, 6, 8);
		
		System.out.println("Kruskal");
		
		Edge[] edgelist1 = gr.kruskal(); 
		for (int i = 0; i < edgelist1.length; i++)
			System.out.print("(" + edgelist1[i].tail + " " + edgelist1[i].head + ") ");
		
		System.out.println(); 
		System.out.println("Prim");
		
		edgelist1 = gr.prim(0);
		for (int i = 0; i < edgelist1.length; i++)
			System.out.print("(" + edgelist1[i].tail + " " + edgelist1[i].head + ") ");
	}


}

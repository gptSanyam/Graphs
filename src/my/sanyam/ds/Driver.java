package my.sanyam.ds;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "graph.txt";
		Graph g1 = new Graph(path);
		g1.printGraph();
		System.out.print("BFS traversal of graph is: ");
		g1.BFS(0);
		System.out.println();
		//g1.DFS(1);
	}

}

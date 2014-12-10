package my.sanyam.ds;
import java.util.*;
import java.io.*;


public class Graph {
	
	private int size;
	NodeList[] vertices;
	
	//
	
	Graph(String path){
		
		try{
			File file = new File(path);
			BufferedReader br = new BufferedReader(new FileReader(file));
			String st = br.readLine();
			int V = Integer.parseInt(st);
			
			size = V;
			vertices = new NodeList[V];	//create V node
			for(int i=0; i<V; i++){
				vertices[i] = new NodeList();
				vertices[i].vertex.val = i;
			}
			
			int vertex =0;
			while(st != null){
				
				st = br.readLine();
				if(st==null) break;
				String[] stArr = st.split(" ");
				
				for(int i=0; i<stArr.length; i++){
					if(i == vertex) continue; //avoid self loops
					int wt = Integer.parseInt(stArr[i]);
					if(wt > 0){	
						//insert in graph as a neighbor of node i
						Edges e = new Edges();
						e.neighbor = i;
						e.weight = wt;
						vertices[vertex].adj.add(e);
					}
					
				}
				vertex++;
			}
		
		}
		catch(IOException err){
			System.out.println("File not found");
			
		}
	}
	
	
	public int getSize(){
		return size;
	}
	
	public void printGraph(){
		for(int i=0; i<size; i++){
			System.out.println(vertices[i].adj);
		}
	}
	
	void BFS(int startNode){
		Queue<Integer> q1= new LinkedList<Integer>();
		q1.add(startNode);
		vertices[startNode].vertex.toGray();	//node found
		
		while(!q1.isEmpty()){
			int nT = q1.remove();
			//put all neighbors in the queue
			for(Edges t: vertices[nT].adj){
				if(vertices[t.neighbor].vertex.visitStatus == 'W'){
					q1.add(t.neighbor);
					vertices[t.neighbor].vertex.toGray();
				}
			}
			//change the status of the note to explored
			vertices[startNode].vertex.toBlack();
			System.out.print(nT+" ");
		}
	}
	
	void DFS(int startNode){
		Stack<Integer> s1 = new Stack<Integer>();
		s1.push(startNode);
		vertices[startNode].vertex.toGray();
		
		while(!s1.isEmpty()){
			int nT = s1.pop();
			for(Edges t: vertices[nT].adj){
				if(vertices[t.neighbor].vertex.visitStatus == 'W'){
					s1.add(t.neighbor);
					vertices[t.neighbor].vertex.toGray();
			}
			
		}
			vertices[startNode].vertex.toBlack();
			System.out.print(nT+" ");
	}
	}
}

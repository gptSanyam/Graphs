package my.sanyam.ds;

public class Node {
	int val;
	//int weight;
	char visitStatus='W';
	
	public void toGray(){
		visitStatus = 'G';
	}
	
	public void toBlack(){
		visitStatus = 'B';
	}
	
	public String toString(){
		return ((Integer)val).toString();
	}
}

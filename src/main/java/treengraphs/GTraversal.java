package treengraphs;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/*
  * You should be able to easily implement Breadth First Search: 
  * BFS involves searching a node and its siblings before going on to any children
 */
public class GTraversal {
	
	static void bfs(GraphNode node){
		Deque<GraphNode> queue = new LinkedList<GraphNode>();
		Set<GraphNode> visited = new HashSet<GraphNode>();
		
		queue.addFirst(node);
		visited.add(node);
		
		while(!queue.isEmpty()){
			GraphNode i = queue.removeLast();
			
			System.out.println(i.value);
			
			for(GraphNode j: i.links){
				if ( !visited.contains(j)){
					queue.addFirst(j);
					visited.add(j);
				}
			}
		}
	}

	static void dfs(GraphNode node){
		Deque<GraphNode> queue = new LinkedList<GraphNode>();
		Set<GraphNode> visited = new HashSet<GraphNode>();
		
		queue.addFirst(node);
		visited.add(node);
		
		while(!queue.isEmpty()){
			GraphNode i = queue.removeFirst();
			
			System.out.println(i.value);
			
			for(GraphNode j: i.links){
				if ( !visited.contains(j)){
					queue.addFirst(j);
					visited.add(j);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		GraphNode zero = new GraphNode();
		zero.value = 0;
		GraphNode one = new GraphNode();
		one.value = 1;
		GraphNode two = new GraphNode();
		two.value = 2;
		GraphNode three = new GraphNode();
		three.value = 3;
		GraphNode four = new GraphNode();
		four.value = 4;
		GraphNode five = new GraphNode();
		five.value = 5;
		GraphNode six = new GraphNode();
		six.value = 6;
		
		zero.links.add(one);
		one.links.add(six);
		zero.links.add(two);
		two.links.add(three);
		two.links.add(four);
		four.links.add(five);
		four.links.add(six);

		/*
		 					    0
		 					 /    \
		 					1      2
		 				   /     /  \
		 				  6     3    4
		 				            /  \
		 				           5    6
		 				           
			 */
		
		System.out.println("BFS");
		bfs(zero);
		System.out.println("DFS");
		dfs(zero);
	}
}

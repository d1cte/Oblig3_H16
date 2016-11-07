package Task2;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import org.hamcrest.Matcher;
import Task2.AbstractGraph.Tree;

public class AbstractGraphTest {
	private static Graph<Integer> graph;
	
	@BeforeClass
	public static void setUp() {
		Integer[] vertices = {0, 1, 2, 3, 4};
		
		int[][] edges = {
				{0, 1}, {0, 2}, {0, 3},
				{1, 0}, {1, 2}, {1, 4}, 
				{2, 0}, {2, 1}, {2, 3}, 
				{3, 0}, {3, 2}, 
				{4, 1}
		};
		
		graph = new UnweightedGraph<>(vertices, edges);
		
	}
	
	@Test
	public void dfsShouldReturnCorrectTree() {
		int[] expectedSearchOrder = {0, 1, 2, 3, 4};
		
		Tree searchTree = graph.dfs(0);
		List<Integer> searchOrder = searchTree.getSearchOrder();
		
		assertThat(searchOrder.toArray(), is(expectedSearchOrder));
	}
	
	@Test
	public void dfsUsingStackShouldReturnCorrectTree() {
		int[] expectedSearchOrder = {0, 1, 2, 3, 4};
		
		Tree searchTree = graph.dfsUsingStack(0);
		List<Integer> searchOrder = searchTree.getSearchOrder();
		
		assertThat(searchOrder.toArray(), is(expectedSearchOrder));
	}
}

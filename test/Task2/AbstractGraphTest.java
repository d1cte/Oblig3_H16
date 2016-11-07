package Task2;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import org.hamcrest.Matcher;
import Task2.AbstractGraph.Tree;

public class AbstractGraphTest {
	private static Graph<Integer> graph, graph2, graph3;
	
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
		
		int[][] edges2 = {
				{0, 1}, {0, 3},
				{1, 0}, {1, 2}, {1, 4}, 
				{2, 1}, {2, 3}, 
				{3, 0}, {3, 2}, 
				{4, 1}
		};
		
		int[][] edges3 = {
				{0, 1},
				{1, 0}, {1, 2}, {1, 3}, 
				{2, 1}, {2, 3}, 
				{3, 1}, {3, 2}
		};
		
		graph = new UnweightedGraph<>(vertices, edges);
		graph2 = new UnweightedGraph<>(vertices, edges2);
		graph3 = new UnweightedGraph<>(vertices, edges3);
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
	
	@Test
	public void dfsGetParentShouldReturnCorrectParent() {
		Tree searchTree = graph.dfs(0);
		assertThat(searchTree.getParent(0), is(-1)); 
		assertThat(searchTree.getParent(1), is(0));
		assertThat(searchTree.getParent(2), is(1));
		assertThat(searchTree.getParent(3), is(2));
		assertThat(searchTree.getParent(4), is(1));
	}
	
	@Test
	public void dfsUsingStackGetParentShouldReturnCorrectParent() {
		Tree searchTree = graph.dfsUsingStack(0);
		assertThat(searchTree.getParent(0), is(-1)); 
		assertThat(searchTree.getParent(1), is(0));
		assertThat(searchTree.getParent(2), is(1));
		assertThat(searchTree.getParent(3), is(2));
		assertThat(searchTree.getParent(4), is(1));
	}
	
	@Test
	public void getPathWithInputWithNoPathShouldReturnNull() {
		assertNull(graph3.getPath(3, 4));
	}
	
	@Test
	public void getPathShouldReturnCorrectPathBetweenNodes() {
		int[] expectedPath = {0, 1, 4};
		int[] expectedPath2 = {2, 1, 0};
		int[] expectedPath3 = {3, 1, 0};
		assertThat(graph.getPath(0, 4).toArray(), is(expectedPath));
		assertThat(graph2.getPath(2, 0).toArray(), is(expectedPath2));
		assertThat(graph3.getPath(3, 0).toArray(), is(expectedPath3));
	}
	
	@Test
	public void isConnectedShouldReturnTrue() {
		assertTrue(graph.isConnected());
		assertTrue(graph2.isConnected());
	}
	
	@Test
	public void isConnectedShouldReturnFalse() {
		assertFalse(graph3.isConnected());	
	}
}

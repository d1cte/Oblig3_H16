package Task1;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.hamcrest.Matcher;
import static org.hamcrest.CoreMatchers.*;


public class MyHashMapTest { 
	private MyHashMap<String, Integer> hashMap = new MyHashMap();
	
	@Before
	public void setUp() {
		hashMap.put("Adam", 21);
		hashMap.put("Beatrice", 25);
		hashMap.put("Sofia", 31);
	}
	
	@Test
	public void putShouldIncreaseSizeOfMyHashMap() {
		hashMap.put("Lisa", 18);
		assertThat(hashMap.size(), is(4));
	}
	
	@Test
	public void putShouldAllowDuplicateKeys() {
		hashMap.put("Adam", 18);
		assertThat(hashMap.size(), is(4));
		
		hashMap.put("Adam", 40);
		assertThat(hashMap.size(), is(5));
	}
	
	@Test
	public void getAllShouldReturnAllValuesAsosiatedWithKey() {
		LinkedList<Integer> values = hashMap.getAll("Adam");
		Integer[] expectedResult = {21};
		assertThat(values.toArray(), is(expectedResult));
		
		hashMap.put("Adam", 18);
		hashMap.put("Adam", 40);
		values = hashMap.getAll("Adam");
		Integer[] expectedResult2 = {21, 18, 40};
		assertThat(values.toArray(), is(expectedResult2));
	}
	
	@Test
	public void getAllWithNoKeyMatchShouldReturnNull() {
		assertNull(hashMap.getAll("Sara"));
	}
	
	@After
	public void reset() {
		hashMap.clear();
	}

}

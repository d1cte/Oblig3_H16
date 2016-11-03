package Task1;

import static org.junit.Assert.*;

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
	}
	
	@After
	public void reset() {
		hashMap.clear();
	}

}

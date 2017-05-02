package Test;

import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import Exceptions.ColaExcededSizeException;
import Exceptions.LlevateTuNullDeAquiException;
import Models.Cola;

public class ColaExamenTest<E> {
	private Cola<Integer> c;

	@Test
	public void AddSuccess() {
		for (int i = 9; i >= 0; i--) {
			assert (c.add(i));
		}
		for (int i = 0; i < 10; i++) {
			assert (c.get(i) == i);
		}

	}

	@Test
	public void AddFail() {
		for (int i = 0; i < 20; i++) {
			try {
				assert (c.add(i));
			} catch (ColaExcededSizeException e) {
				assert (c.size() == 10);
				assert (!c.contains(10));
			}
			
			try {
				c.add(null);
			} catch (LlevateTuNullDeAquiException e) {
				assert (!c.contains(null));
			}

		}

	}

	@Test
	public void AddAllSuccess() {
		ArrayList<Integer> colaAux = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			colaAux.add(i);
		}
		c.addAll(colaAux);
		for (int i = 0; i < 8; i++) {
			assert (c.get(i) == i);
		}
		assert (colaAux.size() == 8);

	}

	@Test
	public void AddAllFail() {
		ArrayList<Integer> colaAux = new ArrayList<>();
		for (int i = 0; i < 15; i++) {
			colaAux.add(i);
		}
		try {
			c.addAll(colaAux);
		} catch (ColaExcededSizeException e) {
			assert (c.size() == 0);
		}

	}

	/*
	 * @Test public void testClear() { fail("Not yet implemented"); }
	 * 
	 * @Test public void testRemoveInt() { fail("Not yet implemented"); }
	 * 
	 * @Test public void testAddAllIntCollectionOfQextendsE() {
	 * fail("Not yet implemented"); }
	 * 
	 * @Test public void testRemoveRange() { fail("Not yet implemented"); }
	 */

	@Before
	public void Setup() {
		c = new Cola<Integer>((Integer a, Integer b) -> a - b);
	}

}

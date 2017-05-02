package Test;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Exceptions.ColaExcededSizeException;
import Exceptions.ElementBlockedException;
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

	@Test
	public void removeSuccess() {
		for (int i = 0; i < 9; i++) {
			c.add(i);
		}
		for (int i = 8; i > 0; i--) {
			c.remove(i);

		}
		assert (c.size() == 1);
		Setup();
		for (int i = 8; i >= 0; i--) {
			c.add(i);
		}
		c.remove(1);
		assert (c.get(2) == 3);
	}

	@Test
	public void removeFail() {
		for (int i = 0; i < 9; i++) {
			c.add(i);
		}
		for (int i = 8; i >= 0; i--) {
			try {
				c.remove(i);
			} catch (ElementBlockedException e) {
				assert (c.size() == 1);
			}
		}
	}

	@Test
	public void clearFail() {
		for (int i = 0; i < 9; i++) {
			c.add(i);
		}
		int longitudAntigua = c.size();
		try {
			c.clear();
		} catch (ElementBlockedException e) {
			assert (c.size() == longitudAntigua);
		}
	}

	@Before
	public void Setup() {
		c = new Cola<Integer>((Integer a, Integer b) -> a - b);
	}

}

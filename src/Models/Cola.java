package Models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import Exceptions.ColaExcededSizeException;
import Exceptions.LlevateTuNullDeAquiException;

public class Cola<E> extends ArrayList<E> {
	private Comparator<E> comparador;
	private final int MAX_SIZE = 10;

	public Cola(Comparator<E> comparador) {
		super();
		this.comparador = comparador;
	}

	@Override
	public boolean add(E elemento) throws ColaExcededSizeException, LlevateTuNullDeAquiException {

		if (elemento != null) {
			if (super.size() < MAX_SIZE) {
				boolean esCorrecto = super.add(elemento);
				super.sort(comparador);
				return esCorrecto;
			} else {
				throw new ColaExcededSizeException("Lista llena!");
			}
		} else {
			throw new LlevateTuNullDeAquiException("Objeto nulo no valido");
		}

	}

	
	
	
}

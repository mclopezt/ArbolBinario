package ancestroArbolBinario;

import java.util.ArrayList;

public class Arbol {
	/**
	 * Representa el nodo raiz del arbol
	 */
	private Nodo nodoRaiz;

	/**
	 * Constructor de la clase
	 */
	public Arbol() {
		nodoRaiz = null;
	}

	/**
	 * Inserta los valores del arbol medicante un array
	 * 
	 * @param datosNuevos datos a insertar
	 */
	public void insertar(ArrayList<Integer> datosNuevos) {
		for (Integer datos : datosNuevos) {
			insertar(datos);
		}
	}

	/**
	 * Inserta un nuevo nodo en el arbol
	 * 
	 * @param dato El dato
	 */
	public void insertar(int dato) {
		/* Si el nodo raiz esta vacio, asigna el valor de la entrada dato como raiz */
		if (nodoRaiz == null) {
			nodoRaiz = new Nodo(dato);
		}
		/*
		 * Si ya el arbol tiene una raiz, llama al metod insertar que se encuentra en la
		 * clase Nodo
		 */
		else {
			nodoRaiz.insertar(dato);
		}
	}

	/**
	 * Recorrer un arbol en
	 * 
	 * @param n Raiz del arbol
	 */
	public void recorrer(Nodo n) {
		if (n != null) {
			n.visitar();
			recorrer(n.getNodoIzq());
			recorrer(n.getNodoDer());
		}
	}

	/**
	 * Metodo que retorna el comun ancestro de dos nodos
	 * 
	 * @param r      nodo raiz
	 * @param valorA nodo 1 a buscar ancestro
	 * @param valorB nodo 2 a buscar ancestro
	 * @return
	 */
	public int ancestroCercanoComun(Nodo r, int valorA, int valorB) {
		/*
		 * Se verifica que el nivel de los nodos que entran por parametro sea igual o
		 * diferentes de 0
		 */
		if (nivelNodo(r, valorA, 0) == nivelNodo(r, valorB, 0) && nivelNodo(r, valorA, 0) != 0
				&& nivelNodo(r, valorB, 0) != 0) {
			Nodo antecesorA = buscarNodoAncestro(r, valorA);
			Nodo antecesorB = buscarNodoAncestro(r, valorB);
			/*
			 * Se verifica si el antecesor de cada nodo es el mismo, si es asi es el nodo
			 * comun, de lo contrario se busca el antecesor de estos
			 */
			if (antecesorA == antecesorB) {
				return antecesorA.getDato();
			} else {
				return ancestroCercanoComun(r, antecesorA.getDato(), antecesorB.getDato());
			}
			/*
			 * Se verifica si el nivel del nodo A es mayor al del nodo B, el nodo A llama a
			 * su antecesor
			 */
		} else if (nivelNodo(r, valorA, 0) > nivelNodo(r, valorB, 0)) {
			return ancestroCercanoComun(r, buscarNodoAncestro(r, valorA).getDato(), valorB);
		}
		/*
		 * De lo contrario el nivel del nodo B es mayor al del nodo A, el nodo B llama a
		 * su antecesor
		 */
		else {
			return ancestroCercanoComun(r, valorA, buscarNodoAncestro(r, valorB).getDato());
		}
	}

	/**
	 * Busca el acestro de un nodo en el arbol
	 * 
	 * @param n     Raiz del arbol
	 * @param valor Dato a buscar
	 * @return Nodo que se esta buscando
	 */
	public Nodo buscarNodoAncestro(Nodo r, int valor) {
		/* Verifica si la raiz no es nula */
		if (r != null) {
			/*
			 * Verifica si el nodo derecho de la raiz no es nulo y si su valor es igual al
			 * valor buscado
			 */
			if (r.getNodoDer() != null && r.getNodoDer().getDato() == valor) {
				return r;
			}
			/*
			 * Verifica si el nodo izquierdo de la raiz no es nulo y si su valor es igual al
			 * valor buscado
			 */
			else if (r.getNodoIzq() != null && r.getNodoIzq().getDato() == valor) {
				return r;
			}
			/*
			 * Verifica si el valor buscado es mayor al valor del dato de la raiz, si es asi
			 * sigue buscando al lado derecho
			 */
			else if (valor > r.getDato()) {
				/* Verifica que el nodo derecho de la raiz no es nulo */
				if (r.getNodoDer() != null)
					return buscarNodoAncestro(r.getNodoDer(), valor);
			}
			/*
			 * Verifica si el valor buscado es menor al valor del dato de la raiz, si es asi
			 * sigue buscando al lado izquierda
			 */
			else if (valor < r.getDato()) {
				/* Verifica que el nodo izquierdo de la raiz no es nulo */
				if (r.getNodoIzq() != null)
					return buscarNodoAncestro(r.getNodoIzq(), valor);
			}
		}
		return null;
	}

	/**
	 * Indica el nivel de un nodo dado dentro del �rbol
	 * 
	 * @param r     Ra�z
	 * @param valor Nodo a encontrar su nivel
	 * @param nivel auxiliar
	 * @return Nivel del nodo
	 */
	public int nivelNodo(Nodo r, int valor, int nivel) {
		/* Vericia que la raiz no sea nula */
		if (r != null) {
			/*
			 * Si el valor de la raiz es igual al valor buscado, se retorna el valor de la
			 * variable nivel
			 */
			if (r.getDato() == valor) {
				return nivel;
			}
			/*
			 * Verifica si el valor buscado es mayor al valor del dato de la raiz, si es asi
			 * sigue buscando al lado derecha y se aumeta en 1 el nivel del nodo
			 */
			else if (valor > r.getDato()) {
				return nivelNodo(r.getNodoDer(), valor, nivel + 1);
			}
			/*
			 * Verifica si el valor buscado es menor al valor del dato de la raiz, si es asi
			 * sigue buscando al lado izquierda y se aumeta en 1 el nivel del nodo
			 */
			else if (valor < r.getDato()) {
				return nivelNodo(r.getNodoIzq(), valor, nivel + 1);
			}
		}

		return 0;
	}
	
	/**
	 * Obtiene el dato del nodo raiz
	 * @return nodoRaiz nodo raiz
	 */
	public Nodo getNodoRaiz() {
		return nodoRaiz;
	}
	

}
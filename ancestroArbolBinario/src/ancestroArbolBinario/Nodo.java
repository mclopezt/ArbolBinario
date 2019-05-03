package ancestroArbolBinario;

public class Nodo{
	/**
	 * Variable que contiene el nodo izquierdo
	 */
	private Nodo nodoIzq;
	/**
	 * Variable que contiene el peso del nodo
	 */
	private int dato;
	/**
	 * Variable que contiene el nodo derecho
	 */
	private Nodo nodoDer;
	/**
	 * Constructor de la clase Nodo
	 * @param dato dato que contiene el nodo
	 */
	public Nodo(int dato) {
		this.dato = dato;
		this.nodoDer = this.nodoIzq = null;
	}
	/**
	 * Inserta un nuevo nodo en el nodo actual, verificando en donde
	 * debe ir ubicado según su valor.
	 * @param datoNuevo El dato
	 */
	public void insertar(int datoNuevo){
		/* Verifica si el dato a ingresar es menor que el dato del nodo padre */
		if( datoNuevo < dato ){
			/*Verifica si en nodo padre no tiene ramas al lado izquierdo*/
			if(nodoIzq==null){
				nodoIzq = new Nodo(datoNuevo);
			}
			/*Si tiene ramas al lado izquierdo entonces pasa a evaluar ese nodo haciendo
			 * un llamado recursivo al metodo insertar en la clase Nodo*/
			else{
				nodoIzq.insertar(datoNuevo);
			}
			/*Verifica si el dato a ingresar es mayor que el dato del nodo padre*/
		}else if( datoNuevo>dato){
			/*Verifica si en nodo padre no tiene ramas al lado derecho*/
			if(nodoDer==null){
				nodoDer = new Nodo(datoNuevo);
			}
				/*Si tiene ramas al lado derecho entonces pasa a evaluar ese nodo haciendo
				 * un llamado recursivo al metodo insertar en la clase Nodo*/
			else{
				nodoDer.insertar(datoNuevo);
			}			
		}
	}
	/**
	 * Imprime el contenido del Nodo
	 */
	public String visitar(){
		return this.getDato()+"\t" ;
	}
	/**
	 * Obtiene el dato del nodo izquierdo
	 * @return nodoIzq nodo izquierdo
	 */
	public Nodo getNodoIzq() {
		return nodoIzq;
	}
	/**
	 * Fija el dato del nodo izquierdo
	 */
	public void setNodoIzq(Nodo nodoIzq) {
		this.nodoIzq = nodoIzq;
	}
	/**
	 * Obtiene el vlor del nodo 
	 * @return dato valor que tiene el nodo
	 */
	public int getDato() {
		return dato;
	}
	/**
	 * Fija el valor del nodo
	 */
	public void setDato(int dato) {
		this.dato = dato;
	}
	/**
	 * Obtiene el dato del nodo derecho
	 * @return nodo derecho
	 */
	public Nodo getNodoDer() {
		return nodoDer;
	}
	/**
	 * Fija el dato del nodo derecho
	 */
	public void setNodoDer(Nodo nodoDer) {
		this.nodoDer = nodoDer;
	}
}

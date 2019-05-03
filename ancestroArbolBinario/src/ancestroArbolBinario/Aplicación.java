package ancestroArbolBinario;

import java.util.ArrayList;

public class Aplicación {
	
	Arbol t = new Arbol();
	
	/**
	 * Metodo main para probar el codigo
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Arbol t = new Arbol();

		ArrayList<Integer> input = new ArrayList<Integer>();

		input.add(70);
		input.add(84);
		input.add(85);
		input.add(78);
		input.add(80);
		input.add(76);
		input.add(49);
		input.add(54);
		input.add(51);
		input.add(37);
		input.add(40);
		input.add(22);
		input.add(15);
		input.add(26);

		t.insertar(input);

		t.recorrer(t.getNodoRaiz());

		System.out.println();
		System.out.println(t.ancestroCercanoComun(t.getNodoRaiz(), 15, 76));
	}
}


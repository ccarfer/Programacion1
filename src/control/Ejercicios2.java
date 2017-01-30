package control;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import modelo.Persona;

public class Ejercicios2 {
	HashMap<String, Persona> mPersonas = new HashMap<String, Persona>();

	private ArrayList<String> cadenas;

	private ArrayList<Persona> personas; // lista del Menu

	private ArrayList<ArrayList<Persona>> matrizPersonas;

	private Scanner teclado = new Scanner(System.in);
	private boolean error = true;

	public String validaNif(String nif) {
		
		return nif;
	}

	public char validaSexo(String sexo) {
		return 'F';
	}

	public int validaFecha(String fecha) {
		return 0;
	}

	public void crearPersona() {
		do { // lectura por teclado y validación de los datos
			
			error = false;
			System.out.println("Introduzca datos de la persona (nif#nombre#sexo(m|f)#fecha), o q|Q para volver");
			String tecleado = teclado.nextLine();
			String[] campos = tecleado.split("#");	
			if (campos.length != 4) {
				System.out.println(" NUMERO DE PARAMETROS DEBE SER 4\n");
				error=true;
				continue;
			}
			if (validaNif(campos[0]).equals("") 
					|| validaSexo(campos[2]) == 0 ||
					validaFecha(campos[3]) == -1) // hay al menos un error en los datos 
			{
				error= true;
			System.out.println("HAY AL MENOS UN DATO ERRONEO");	
			}
			else // datos válidos
				crearPersonaInsertarLista(tecleado);
		} while (error);
		System.out.println("DATOS CORRECTOS, SE CREA EL OBJETO  Y SE AÑADE A LA LISTA...");
		// crear objeto persona con los datos validados
		// lo añadimos al final de la lista
	}

	private void crearPersonaInsertarLista(String tecleado) {			
	}

	
	
	
	
	
	public void pruebaMapaPersonas() {

		mPersonas.put("432598701H", new Persona("432598701H", "Pedro", 'M', 19980323));
		Persona p = new Persona();
		p.setNif("43567231M");
		p.setNombre("Damián");
		p.setSexo('M');
		p.setFecha(19991209);
		mPersonas.put(p.getNif(), p);
		mPersonas.put("45987123L", new Persona());
		mPersonas.put(p.getNif(), p);
	}

	public void recorrerMapa() {
		// obtenemos las claves del HM
		System.out.println("numero de elementos : " + mPersonas.size());
		Set<String> claves = mPersonas.keySet();

		for (String clave : claves)
			System.out.println(clave + " => " + mPersonas.get(clave).getNombre());
	}

	public void buscarEnMapa(String[] nifs) {

		for (String nif : nifs)
			if (mPersonas.containsKey(nif))
				System.out.println("existe nif " + nif);
			else
				System.out.println("NO existe nif " + nif);
	}

	public void insertarEnCadenas() {
		cadenas = new ArrayList<String>();
		cadenas.add("Paco");
		cadenas.add("Juan");
		cadenas.add("Maria");
		cadenas.add("Carlos");

	}

	public void insertarEnPersonas() {
		personas = new ArrayList<Persona>();
		// personas.add(null);
		Persona p1 = new Persona("432789651F", "Pedro", 'M', 19980123);
		personas.add(p1);
		personas.add(new Persona("42870135H", "Maria", 'F', 19801230));

		// insertar Juan entre Pedro y Maria
		personas.add(1, new Persona("43567123L", "Juan", 'M', 19830211));
		personas.add(new Persona("43456209N", "Alicia", 'F', 19841020));
		personas.sort(null);
		// borrar a Maria
		// personas.remove(2);
		// System.out.println(personas.get(9)); // excepcion indice fuera de
		// rango
		// Convertir un ArrayList a array
		// inicializar la matriz de personas
		matrizPersonas = new ArrayList<ArrayList<Persona>>();
		matrizPersonas.add(personas);
		matrizPersonas.add(personas);
		// matrizPersonas.add(null);
		matrizPersonas.add(personas);

		Object[] arrayPersonas = (Object[]) personas.toArray();
		for (Object persona : arrayPersonas) // bucle abreviado
		{
			// comprobar que persona es != null
			// if (persona != null)
			// System.out.println(((Persona) persona).getNombre());
		}

	}

	public void recorrerListaPersonas() {
		for (int i = 0; i < personas.size(); i++) // bucle básico
			System.out.println(personas.get(i).getNombre());
	}

	public void recorrerListaPersonas2() {
		for (Persona persona : personas)
			if (persona != null)
				System.out.println(persona.getNombre() + ", fNac : " + persona.getFecha());
	}

	public void recorrerListaPersonas3() { // con un iterador
		Iterator<Persona> iteradorLista = personas.iterator();
		while (iteradorLista.hasNext()) {
			Persona persona = (Persona) iteradorLista.next();
			// Procesar persona
			System.out.println(persona.getNombre());
		}
	}

	public void recorrerMatrizPersonas() {
		for (int i = 0; i < matrizPersonas.size(); i++) // bucle básico
			for (int j = 0; j < matrizPersonas.get(i).size(); j++) {
				try {
					System.out.print(matrizPersonas.get(i).get(j).getNombre() + ", ");
				} catch (NullPointerException e) {
					System.out.println("null");
				}
			}
	}

	public void convertirArrayEnArrayList() {
		Persona[] personas = { new Persona("43567123L", "Juan", 'M', 19830211),
				new Persona("42870135H", "Maria", 'F', 19801230), null };

		this.personas = new ArrayList<Persona>(Arrays.asList(personas));
		System.out.println("DEBUG");
	}

	public ArrayList<String> getCadenas() {
		return cadenas;
	}

	public void setCadenas(ArrayList<String> cadenas) {
		this.cadenas = cadenas;
	}
}

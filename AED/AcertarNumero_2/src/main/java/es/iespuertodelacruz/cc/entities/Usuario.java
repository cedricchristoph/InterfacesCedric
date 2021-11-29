package es.iespuertodelacruz.cc.entities;

import java.util.ArrayList;

public class Usuario {
	/**
	 * Variables de clase Usuario
	 */
	String id;
	String nombre;
	ArrayList<Numero> numeros;
	String directorio;
	
	/**
	 * Constructor de la clase Usuario
	 * @param id Identificador de usuario
	 * @param nombre Nombre del usuario
	 */
	public Usuario(String id, String nombre) {
		this.id = id;
		this.nombre = nombre;
		numeros = new ArrayList<Numero>();
	}
	
	public void addNumero(Numero numero) {
		numeros.add(numero);
	}
	
	public void clearNumeros() {
		numeros = new ArrayList<Numero>();
	}
	
	public void setDirectorioUsuario(String ruta) {
		directorio = ruta;
	}
	
	public void saveUserData() {
		FileManager manager = new FileManager(directorio + "/user.txt");
		manager.write(getId() + ";" + getNombre());
		manager = new FileManager(directorio + "/numeros.txt");
		String data = "";
		for (Numero numero : numeros) {
			data += numero.getMilis() + ";" + numero.getNumber() + "\n";
		}
		manager.write(data);
		System.out.println(directorio);
	}
	
	/**
	 * Getters & Setters 
	 */
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	
	public ArrayList<Numero> getNumeros() {
		return numeros;
	}
	public void setNumeros(ArrayList<Numero> numeros) {
		this.numeros = numeros;
	}
	@Override
	public String toString() {
		return nombre;
	}
}

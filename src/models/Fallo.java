package models;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Fallo {
	
	public int id;
	public String nombre; 
	public String descripcion; 
	public UUID ticket; 
	public boolean estado;
	
	public ArrayList<String> comentarios; 
	
	public Fallo(){}
	
	public Fallo(int id, String nombre, String descripcion)
	{
		this.id = id; 
		this.nombre = nombre; 
		this.descripcion = descripcion; 
		this.ticket = UUID.randomUUID();
		this.estado = true;
		this.comentarios = new ArrayList<String>();
	}
	
	@SuppressWarnings("resource")
	public void anyadirComentario()
	{
		System.out.println("Escribe el comentario: ");
		Scanner sc = new Scanner(System.in);
		String comentario = sc.nextLine();
		this.comentarios.add(comentario);
	}
	
	public void cerrarFallo()
	{
		this.estado = false;
	}
	

}

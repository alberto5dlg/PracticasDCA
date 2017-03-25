package models;

import java.util.ArrayList;
import java.util.Scanner;

public class LBT {

	public static int ids = 0; 
	public static ArrayList<Fallo> lista = new ArrayList<Fallo>();
	
	public static void main(String[] args) 
	{
		int seleccion = 0; 
		while(seleccion != 3)
		{
			seleccion = menu();
			switch(seleccion)
			{
			case 1: anyadirFallo(); break;
			case 2: listarFallos(); break; 
			}
		}

	}
	
	@SuppressWarnings("resource")
	public static int menu()
	{
		//limpiarPantalla();
		int seleccion = 0; 
		do{
			System.out.println("Practica DCA --  LBT");
			System.out.println("----------------------------------------");
			System.out.println("1- Añadir nuevo aviso de fallo");
			System.out.println("2- Listar avisos de fallos");
			System.out.println("3- Salir");
			System.out.println("Escoge una opcion: ");
			Scanner sc = new Scanner(System.in);
			seleccion = sc.nextInt();
		}while(seleccion <= 0 || seleccion >= 4);	
		return seleccion; 
	}
	
	@SuppressWarnings("resource")
	public static void anyadirFallo()
	{
		//limpiarPantalla();
		Scanner sc = new Scanner(System.in);
		System.out.println("Añadir aviso de fallo");
		System.out.println("-------------------");
		System.out.println("Nombre: ");
		String nNombre = sc.nextLine();
		System.out.println("Descripcion: ");
		String nDescripcion = sc.nextLine();
		Fallo fallo = new Fallo(ids,nNombre,nDescripcion);
		lista.add(fallo);
		ids++;
	}
	
	@SuppressWarnings("resource")
	public static void listarFallos()
	{
		//limpiarPantalla();
		int seleccionAviso = 0; 
		String abierto = "[Abierto]";
		String cerrado = "[Cerrado]";
		System.out.println("Lista de Avisos");
		System.out.println("-------------------");
		if(!lista.isEmpty())
		{
			for(int i = 0; i < lista.size(); ++i)
			{
				Fallo f = lista.get(i);
				if(!f.estado)
					System.out.println(f.id + " - " + f.nombre +" - " + cerrado);
				else 
					System.out.println(f.id + " - " + f.nombre +" - " + abierto);
				System.out.println("************************************************");
			}
			System.out.println("Selecciona un aviso: ");
			Scanner sc = new Scanner(System.in);
			seleccionAviso = sc.nextInt();
			if(seleccionAviso < lista.size())
				detallesFallo(seleccionAviso);
			else
			{
				System.out.println("No existe ese aviso");
				listarFallos();
			}
		}
		else 
			System.out.println("No hay avisos en la lista");
	}
	
	@SuppressWarnings("resource")
	public static void detallesFallo(int seleccion)
	{
		Fallo f = lista.get(seleccion);
		System.out.println(f.id + " - " + f.nombre);
		System.out.println(f.descripcion);
		System.out.println("Ticket: "+ f.ticket);
		if(f.comentarios.isEmpty() == false)
		{
			for(int i = 0; i < f.comentarios.size(); ++i)
			{
				System.out.println("Comentario "+ i+1 + ": " + f.comentarios.get(i));
				System.out.println();
			}
		}
		System.out.println("************************************************");
		if(f.estado)
		{
			System.out.println("1- Añadir Comentario");
			System.out.println("2- Cerrar Aviso");
			System.out.println("3- Salir");
			System.out.println("Escoge opcion: ");
			Scanner sc = new Scanner(System.in);
			int opcion = sc.nextInt();
			switch(opcion)
			{
				case 1: f.anyadirComentario();break;
				case 2: f.cerrarFallo();break;
				case 3: break;
				default: System.out.println("opcion incorrecta");detallesFallo(seleccion);break;
			}
		}
	}
	
	public static void limpiarPantalla()
	{
		for(int i = 0; i < 100; i++)
			System.out.println();
		System.out.println("hola MUndo");
	}

}

package main;

import entidades.Articulo;

public class prueba01 {
	public static void main(String[] args) {
		
		
		Articulo ar01 = new Articulo(2,"Juguete: HotWheel", 600);
		
		System.out.println("Cantidad Articulo: "+ ar01.getCantidad());
		System.out.println("Descripcion: "+ ar01.getDenominacion());
		System.out.println("Precio: "+ ar01.getPrecio());
		
		
		System.out.println("id: "+ ar01.getId());
		
	    
		
	}
}

package main;
import javax.persistence.EntityManager;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Articulo;
import entidades.Categoria;
import entidades.Cliente;
import entidades.DetalleFactura;
import entidades.Domicilio;
import entidades.Factura;
import entidades.Factura.FacturaBuilder;

public class PersistenceApp {
 public static void main(String[] args) {
	
	 EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceAppPU");
	 EntityManager em = emf.createEntityManager();
	 
	 try {
		em.getTransaction().begin(); //Generar transaction begin
		
		 /*
		//Creo nuevo cliente con su domicilio en la bd: 
		
		Cliente cliente = new Cliente("Juan","Toledo",40101770);// Creo cliente de prueba
		
		Domicilio domicilio = new Domicilio("San juan",2030);
		cliente.setDomicilio(domicilio);
	    domicilio.setCliente(cliente); //la bidireccionalidad no se ve reflejada en las tablas
	    
		em.persist(cliente); //Persiste cliente y domicilio en la bd
		
		
		
		//Comento el codigo anterior y Traigo registros guardados en la bd con metodo find e indico cual es la entidad que llamo
		Domicilio dom = em.find(Domicilio.class, 1L);
		Cliente cliente = em.find(Cliente.class, 1L);
		
		System.out.println("cliente de domicilio:" + dom.getCliente().getDni());
		System.out.println("Domicilio de cliente:" + cliente.getDomicilio().getNombreCalle());
		
		
		Factura factura1 = new Factura();
		
		factura1.setNumero(12);
		factura1.setFecha("10/08/2020");
		
		Domicilio dom=new Domicilio("San Martin,", 1222);
		
		Cliente cliente = new Cliente("Pablo","Muñoz",15245778);
		cliente.setDomicilio(dom);
		dom.setCliente(cliente);
		
		factura1.setCliente(cliente);
		Categoria perecederos = new Categoria("Perecederos");
		Categoria lacteos = new Categoria("Lacteos");
		Categoria limpieza = new Categoria("Limpieza");
		
		Articulo art1 = new Articulo(200,"Yogurt Ser",100);
		Articulo art2 = new Articulo(300,"detergente",120);
		
		art1.getCategorias().add(perecederos);
		art1.getCategorias().add(lacteos);
		lacteos.getArticulos().add(art1);
		perecederos.getArticulos().add(art1);
		
		art2.getCategorias().add(limpieza);
		limpieza.getArticulos().add(art2);
		
		DetalleFactura det1 = new DetalleFactura();
		
		det1.setArticulo(art1);
		det1.setCantidad(2);
		det1.setSubtotal(200);
		
		art1.getDetalle().add(det1);
		factura1.getDetalles().add(det1);
		det1.setFactura(factura1);
		
		DetalleFactura det2 = new DetalleFactura();
		
		det2.setArticulo(art2);
		det2.setCantidad(1);
		det2.setSubtotal(120);
		
		art2.getDetalle().add(det2);
		factura1.getDetalles().add(det2);
		det2.setFactura(factura1);
		
		factura1.setTotal(320);
		*/
		
		 Factura factura1 = em.find(Factura.class, 1L);
		 factura1.setNumero(85);
		 
		
		//em.persist(factura1);
		 em.merge(factura1);
		
		em.flush(); //limpiar conexion
		em.getTransaction().commit(); //Termino de hacer Persistencia en Bd
		
		
	 }catch(Exception e) {
		em.getTransaction().rollback(); //Si ocurre un error se vuelve al estado anterior
		 
	 }
	 
	 em.close(); //Cierro conexion
	 emf.close();
	 
	 
	 
	 //patron builder
	 //Creo Objetos con la cantidad de atributos que necesite en el momento sin la necesidad de varios constructores
	 Factura factura3 = Factura.builder().numero(15).fecha("20/9").build();
	 Factura factura2 = Factura.builder().total(200).build();
	 
	
	 
	 System.out.println(factura3.toString());
	 System.out.println(factura2.toString());
	 
 }
 

 
}

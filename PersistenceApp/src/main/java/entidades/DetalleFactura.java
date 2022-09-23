package entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Audited
@Entity
@Table(name = "detalle_factura")

public class DetalleFactura implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "cantidad")
	private int cantidad;
	@Column(name = "subtotal")
	private int subtotal;
	
	//@OneToMany bidireccional
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "fk_factura")
	private Factura factura;
	
	//@OneToMany bidireccional
		@ManyToOne(cascade=CascadeType.PERSIST)
		@JoinColumn(name = "fk_articulo")
		private Articulo articulo; //agregar a constructor?
	


	/*
	//Constructores
	public DetalleFactura() {
		
		// TODO Auto-generated constructor stub
	}

	public DetalleFactura(int cantidad, int subtotal) {
		super();
		this.cantidad = cantidad;
		this.subtotal = subtotal;
	}
	
	public DetalleFactura(int cantidad, int subtotal, Factura factura) {
		super();
		this.cantidad = cantidad;
		this.subtotal = subtotal;
		this.factura = factura;
	}

	//Getters & Setters:
	
	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}
	
	public Factura getFactura() {
		return factura;
	}

	
	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	*/
	
	
	
	

}

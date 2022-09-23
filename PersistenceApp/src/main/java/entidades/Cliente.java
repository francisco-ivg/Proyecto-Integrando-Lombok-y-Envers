package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "cliente")

public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Id autoincrementable
	private Long id;
	@Column(name = "nombre") //Etiqueta colum para indicar el nombre de la columna
	private String nombre;
	@Column(name = "apellido")
	private String apellido;
	@Column(name = "dni", unique = true) //unique se utiliza para que en la bd no se pueda ingresar 2 dni iguales
	private int dni;
	
	//one to one
	@OneToOne(cascade = CascadeType.ALL) // modifica domicilio y cliente
	@JoinColumn(name = "fk_domicilio")//Relacion unidireccional, contiene clave foranea de domicilio
	private Domicilio domicilio;
	
	
	//relacion inversa bidireccional onetomany con factura (un cliente puede tener muchas facturas)
	@OneToMany(mappedBy = "cliente")
	private List<Factura> facturas = new ArrayList<Factura>();
	
	
	
	
	/*
	
	//Constructores
	
	

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	public Cliente(String nombre, String apellido, int dni) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}
	

	public Cliente(String nombre, String apellido, int dni, Domicilio domicilio) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.domicilio = domicilio;
	}

	//met get and set
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	
	public Domicilio getDomicilio() {
		return domicilio;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	*/
	
}

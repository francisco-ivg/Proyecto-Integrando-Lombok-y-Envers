package entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "domicilio")
public class Domicilio implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre_calle")
	private String nombreCalle;
	
	@Column(name = "numero")
	 int numero;

	//Relacion inversa @OnetoOne
	@OneToOne(mappedBy="domicilio")
	private Cliente cliente;
	
	
	
	//Genero Get y Set de cliente y constructor

	/*
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
	public Domicilio(Long id, String nombreCalle, int numero, Cliente cliente) {
		super();
		this.id = id;
		this.nombreCalle = nombreCalle;
		this.numero = numero;
		this.cliente = cliente;
	}
	//Constructores

	public Domicilio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Domicilio(String nombreCalle, int numero) {
		super();
		this.nombreCalle = nombreCalle;
		this.numero = numero;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreCalle() {
		return nombreCalle;
	}

	public void setNombreCalle(String nombreCalle) {
		this.nombreCalle = nombreCalle;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	*/
	
	
}

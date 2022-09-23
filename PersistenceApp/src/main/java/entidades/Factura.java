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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "factura")

//Lombok

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Audited

public class Factura implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "fecha")
	private String fecha;
	
	
	@Column(name = "numero")
	 private int numero;
	@Column(name = "total")
	 private int total;
	
	//Relacion factura cliente
	@ManyToOne(cascade = CascadeType.PERSIST)//Persiste cliente nuevo, Modifica factura sin modificar cliente
	@JoinColumn(name = "fk_cliente") //Genero columna que contiene clave foranea
	 private Cliente cliente;
	
	//Relacion unidireccional con detalle factura, (afecta a factura y detalle factura)
	
	//@OneToMany(cascade=CascadeType.ALL, orphanRemoval = true)
	//private List<DetalleFactura> detalles = new ArrayList<DetalleFactura>();
	
	@OneToMany(mappedBy="factura",cascade=CascadeType.ALL, orphanRemoval = true)
	private List<DetalleFactura> detalles = new ArrayList<DetalleFactura>();
	
	

	
	
	
}

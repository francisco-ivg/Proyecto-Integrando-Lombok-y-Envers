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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "articulo")

//Lombook
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
@Audited //entidad auditada

public class Articulo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "cantidad")
	@NonNull private int cantidad; //Se Utiliza @NonNull para generar variable en constructor comun y no de error
	
	@Column(name = "denominacion")
	@NonNull private String denominacion;
	
	@Column(name = "precio")
	@NonNull private int precio;
	
	
	@OneToMany(mappedBy="articulo",cascade = CascadeType.PERSIST)
	@Builder.Default
	// @NotAudited // DettaleFactura no se va a auditar
	private List<DetalleFactura> detalle = new ArrayList<DetalleFactura>();
	
	//@ManytoMany entre articulo y categoria
	//Solo persiste categoria
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name="articulo_categoria",joinColumns = @JoinColumn(name="articulo_id"),inverseJoinColumns=@JoinColumn(name="categoria_id"))
	private List<Categoria> categorias = new ArrayList<Categoria>();
	
	
	
	
}

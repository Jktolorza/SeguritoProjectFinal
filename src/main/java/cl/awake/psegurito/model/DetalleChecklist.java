package cl.awake.psegurito.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="detallechecklist")
public class DetalleChecklist {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCE1")
    @SequenceGenerator(name="SEQUENCE1", sequenceName="ID_DETALLECHECKLIST_SEQ", allocationSize=1)
	private int id_detallechecklist;
	
	private String descripcion;
	private String estado;
	
	@JoinColumn(name="checklist_id_checklist")
	@ManyToOne
	private Checklist checklist;

	public DetalleChecklist() {
		super();
	}

	public DetalleChecklist(int id_detallechecklist, String descripcion, String estado, Checklist checklist) {
		super();
		this.id_detallechecklist = id_detallechecklist;
		this.descripcion = descripcion;
		this.estado = estado;
		this.checklist = checklist;
	}

	public DetalleChecklist(String descripcion, String estado, Checklist checklist) {
		super();
		this.descripcion = descripcion;
		this.estado = estado;
		this.checklist = checklist;
	}

	public DetalleChecklist(int id_detallechecklist) {
		super();
		this.id_detallechecklist = id_detallechecklist;
	}

	public int getId_detallechecklist() {
		return id_detallechecklist;
	}

	public void setId_detallechecklist(int id_detallechecklist) {
		this.id_detallechecklist = id_detallechecklist;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Checklist getChecklist() {
		return checklist;
	}

	public void setChecklist(Checklist checklist) {
		this.checklist = checklist;
	}

	@Override
	public String toString() {
		return "DetalleChecklist [id_detallechecklist=" + id_detallechecklist + ", descripcion=" + descripcion
				+ ", estado=" + estado + ", checklist=" + checklist + "]";
	}

	
	
	
	
}

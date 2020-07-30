package cl.awake.psegurito.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

@Entity
public class Checklist {

	@Id
	 @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCE1")
    @SequenceGenerator(name="SEQUENCE1", sequenceName="ID_CHECKLIST_SEQ", allocationSize=1)
	private int id_checklist;
	
	@JoinColumn(name="visita_id_visita")
	@ManyToOne
	private Visita visita;
	
	@Transient
	protected List <DetalleChecklist> items;

	
	public Checklist() {
		super();
	}

	public Checklist(int id_checklist, Visita visita, List<DetalleChecklist> items) {
		super();
		this.id_checklist = id_checklist;
		this.visita = visita;
		this.items = items;
	}

	public Checklist(Visita visita, List<DetalleChecklist> items) {
		super();
		this.visita = visita;
		this.items = items;
	}

	public int getId_checklist() {
		return id_checklist;
	}

	public void setId_checklist(int id_checklist) {
		this.id_checklist = id_checklist;
	}

	public Visita getCliente() {
		return visita;
	}

	public void setCliente(Visita visita) {
		this.visita = visita;
	}

	public List<DetalleChecklist> getItems() {
		return items;
	}

	public void setItems(List<DetalleChecklist> items) {
		this.items = items;
	}
	
	
	
}

package cl.awake.psegurito.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="visita")
public class Visita {
  //Variables//
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCE1")
    @SequenceGenerator(name="SEQUENCE1", sequenceName="ID_VISITA_SEQ", allocationSize=1)
        private int id_visita;
        
    @Temporal(value=TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
     private Date fechavisita;
    private int numerovisita;
    
    @JoinColumn(name="profesional_id_profesional")
    @ManyToOne
    private Profesional profesional;
    
    
    @JoinColumn(name="cliente_id_cliente")
    @ManyToOne
    private Cliente cliente;


    public Visita() {
    }


    public Visita(int id_visita, Date fechavisita, int numerovisita, Profesional profesional, Cliente cliente) {
        super();
        this.id_visita = id_visita;
        this.fechavisita = fechavisita;
        this.numerovisita =  numerovisita;
        this.profesional = profesional;
        this.cliente = cliente;
    }

    
    
    public int getNumerovisita() {
		return numerovisita;
	}


	public void setNumerovisita(int numerovisita) {
		this.numerovisita = numerovisita;
	}


	public int getId_visita() {
        return id_visita;
    }


    public void setId_visita(int id_visita) {
        this.id_visita = id_visita;
    }


    public Date getFechavisita() {
        return fechavisita;
    }


    public void setFechavisita(Date fechavisita) {
        this.fechavisita = fechavisita;
    }


    public Profesional getProfesional() {
        return profesional;
    }


    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }


    public Cliente getCliente() {
        return cliente;
    }


    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    
    
    
    
}

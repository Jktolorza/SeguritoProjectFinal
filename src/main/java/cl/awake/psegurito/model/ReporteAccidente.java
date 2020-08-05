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
@Table(name="reporteaccidente")
public class ReporteAccidente {
	
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCE1")
    @SequenceGenerator(name="SEQUENCE1", sequenceName="ID_REPORTEACCIDENTE_SEQ", allocationSize=1)
    private int id_reporteaccidente;
    @Temporal(value=TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha;
    private String direccion;
    private String labor;
    private String descripcion;
    @JoinColumn(name="cliente_id_cliente")
    @ManyToOne
    private Cliente cliente;
    
	@JoinColumn(name="profesional_id_profesional")
	@ManyToOne
	private Profesional profesional;
    
    
    public ReporteAccidente() {
		super();
	}
    public ReporteAccidente(int id_reporteaccidente) {
		super();
		this.id_reporteaccidente = id_reporteaccidente;
	}
	public ReporteAccidente(Date fecha, String direccion, String labor, String descripcion,Profesional profesional, Cliente cliente) {
		super();
		this.fecha = fecha;
		this.direccion = direccion;
		this.labor = labor;
		this.descripcion = descripcion;
		this.profesional = profesional;
		this.cliente = cliente;
	}
	public ReporteAccidente(int id_reporteaccidente, Date fecha, String direccion, String labor, String descripcion,Profesional profesional,
			Cliente cliente) {
		super();
		this.id_reporteaccidente = id_reporteaccidente;
		this.fecha = fecha;
		this.direccion = direccion;
		this.labor = labor;
		this.descripcion = descripcion;
		this.cliente = cliente;
		this.profesional = profesional;
	}
	
	
	public int getId_reporteaccidente() {
		return id_reporteaccidente;
	}
	public void setId_reporteaccidente(int id_reporteaccidente) {
		this.id_reporteaccidente = id_reporteaccidente;
	}
	public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getLabor() {
        return labor;
    }
    public void setLabor(String labor) {
        this.labor = labor;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
	public Profesional getProfesional() {
		return profesional;
	}

	public void setProfesional(Profesional profesional) {
		this.profesional = profesional;
	}
	@Override
	public String toString() {
		return "ReporteAccidente [id_reporteaccidente=" + id_reporteaccidente + ", fecha=" + fecha + ", direccion="
				+ direccion + ", labor=" + labor + ", descripcion=" + descripcion + ", cliente=" + cliente + "]";
	}    
}

package cl.awake.psegurito.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Factura {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCE1")
    @SequenceGenerator(name="SEQUENCE1", sequenceName="ID_FACTURA_SEQ", allocationSize=1)
	private int id_factura;
    @Column(name="fechacobro")
    @Temporal(value=TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechadecobro;
    @Temporal(value=TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaVencimiento;
	private int extras;
	private int impuestos;
	private int subtotal;
	private int total;
	@JoinColumn(name="cliente_id_cliente")
	@ManyToOne
	private Cliente cliente;
	@Transient
	protected List <DetalleFactura> items;
	@Transient
	private double iva = 0.19;
	
	//Contructores
	
	public Factura() {
		super();
	}
	
	public Factura(Date fechadecobro, Date fechaVencimiento, int extras, int impuestos, int subtotal, int total,
			Cliente cliente) {
		super();
		this.fechadecobro = fechadecobro;
		this.fechaVencimiento = fechaVencimiento;
		this.extras = extras;
		this.impuestos = impuestos;
		this.subtotal = subtotal;
		this.total = total;
		this.cliente = cliente; 

	}
	
	public Factura(int id_factura, Date fechadecobro, Date fechaVencimiento, int extras, int impuestos, int subtotal, int total,
			Cliente cliente) {
		super();
		this.id_factura = id_factura;
		this.fechadecobro = fechadecobro;
		this.fechaVencimiento = fechaVencimiento;
		this.extras = extras;
		this.impuestos = impuestos;
		this.subtotal = subtotal;
		this.total = total;
		this.cliente = cliente; 

	}
	
	
	public Factura(int id_factura, Date fechadecobro, Date fechaVencimiento, int extras, int impuestos,
			int subtotal, int total, Cliente cliente, List<DetalleFactura> items, double iva) {
		this.id_factura = id_factura;
		this.fechadecobro = fechadecobro;
		this.fechaVencimiento = fechaVencimiento;
		this.extras = extras;
		this.impuestos = impuestos;
		this.subtotal = subtotal;
		this.total = total;
		this.cliente = cliente;
		this.items = items;
		this.iva = iva;
	}
	
	public Factura(int id_factura) {
		super();
		this.id_factura = id_factura;
	}
	
	//Getters & Setters//
	
	public int getId_factura() {
		return id_factura;
	}

	public void setId_factura(int id_factura) {
		this.id_factura = id_factura;
	}



	public Date getFechadecobro() {
		return fechadecobro;
	}

	public void setFechadecobro(Date fechadecobro) {
		this.fechadecobro = fechadecobro;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public int getExtras() {
		return extras;
	}

	public void setExtras(int extras) {
		this.extras = extras;
	}

	public int getImpuestos() {
		return impuestos;
	}

	public void setImpuestos(int impuestos) {
		this.impuestos = impuestos;
	}

	public int getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public List<DetalleFactura> getItems() {
		return items;
	}

	public void setItems(List<DetalleFactura> items) {
		this.items = items;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	@Override
	public String toString() {
		return "Factura [id_factura=" + id_factura + ", fechadecobro=" + fechadecobro + ", fechaVencimiento="
				+ fechaVencimiento + ", extras=" + extras + ", impuestos=" + impuestos + ", subtotal=" + subtotal
				+ ", total=" + total + " ]";
	}
	
	
    public double calcularSubtotal() {
        double subtotal=0;
        for(DetalleFactura item : items ) {
            subtotal+=item.calcularTotal();
        }
        return subtotal;
    }
    
    public double calcularIVA()   { 
    	return (calcularSubtotal()+ this.extras) * iva;
    	}
    
    public double calcularTotal() { 
    	return calcularSubtotal() + calcularIVA()+this.extras; 
    	}


}
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
@Table(name="capacitacion")
public class Capacitacion {
         //Variables//
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCE1")
    @SequenceGenerator(name="SEQUENCE1", sequenceName="ID_CAPACITACION_SEQ", allocationSize=1)
        private int id_capacitacion;
    
    
    @Temporal(value=TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
        private Date fechayhora;
        private String tema;
        private String contenido;
        
        
        @JoinColumn(name="profesional_id_profesional")
        @ManyToOne
        private Profesional profesional;
        
        
        @JoinColumn(name="cliente_id_cliente")
        @ManyToOne
        private Cliente cliente;
        
        public Capacitacion() {
                
        }
        
        public Capacitacion(int id_capacitacion, Date fechayhora, String tema, String contenido,
                        Profesional profesional, Cliente cliente) {
                this.id_capacitacion = id_capacitacion;
                this.fechayhora = fechayhora;
                this.tema =tema;
                this.contenido = contenido;
                this.profesional = profesional;
                this.cliente = cliente;
        }

        public int getId_capacitacion() {
                return id_capacitacion;
        }

        public void setId_capacitacion(int id_capacitacion) {
                this.id_capacitacion = id_capacitacion;
        }

        public Date getFechayhora() {
                return fechayhora;
        }

        public void setFechayhora(Date fechayhora) {
                this.fechayhora = fechayhora;
        }

        public String getTema() {
                return tema;
        }

        public void setTema(String tema) {
                this.tema = tema;
        }

        public String getContenido() {
                return contenido;
        }

        public void setContenido(String contenido) {
                this.contenido = contenido;
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
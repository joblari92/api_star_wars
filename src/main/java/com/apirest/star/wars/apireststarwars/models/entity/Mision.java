package com.apirest.star.wars.apireststarwars.models.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity //Esta anotación creará la tabla en la base de datos
@Table(name="misiones") //Si no utilizasemos esta anotación la tabla llevaría el nombre de la clase
public class Mision implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //Indicamos que es clave primaria
	private Long id;
	
	@Column(name="inicio_mision") //Si queremos que el nombre de la columna sea distinto al de la variable
	@Temporal(TemporalType.TIMESTAMP)
	private Date inicioMision;
	
	@Column(name="nombre_nave")
	private String nave;
	
	private String capitan1;
	private String capitan2;
	private String planeta1;
	private String planeta2;
	private Integer tripulacion;
	private Boolean finalizada = false;
	private String log;
	private Integer duracion;
	
	@PrePersist
	public void prePersist() {
		inicioMision = new Date();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getStarMision() {
		return inicioMision;
	}
	public void setStarMision(Date starMision) {
		this.inicioMision = starMision;
	}
	public String getNave() {
		return nave;
	}
	public void setNave(String nave) {
		this.nave = nave;
	}
	public Integer getTripulacion() {
		return tripulacion;
	}
	public void setTripulacion(Integer tripulacion) {
		this.tripulacion = tripulacion;
	}
	public Boolean getFinalizada() {
		return finalizada;
	}
	public void setFinalizada(Boolean finalizada) {
		this.finalizada = finalizada;
	}	
	public String getCapitan1() {
		return capitan1;
	}

	public void setCapitan1(String capitan1) {
		this.capitan1 = capitan1;
	}

	public String getCapitan2() {
		return capitan2;
	}

	public void setCapitan2(String capitan2) {
		this.capitan2 = capitan2;
	}

	public String getPlaneta1() {
		return planeta1;
	}

	public void setPlaneta1(String planeta1) {
		this.planeta1 = planeta1;
	}

	public String getPlaneta2() {
		return planeta2;
	}

	public void setPlaneta2(String planeta2) {
		this.planeta2 = planeta2;
	}
	public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = log;
	}
	
	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}




	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}

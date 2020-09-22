package aws.mitocode.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "encuesta")
public class Encuesta implements Serializable {

	private static final long serialVersionUID = -1725563866279171711L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nombres", nullable = false)
	private String nombres;

	@Column(name = "apellidos", nullable = false)
	private String apellidos;
	
	@Column(name = "profesion", nullable = false)
	private String profesion;
	
	@Column(name = "lugartrabajo", nullable = false)
	private String lugartrabajo;
	
	@Column(name = "edad", nullable = false)
	private int edad;

	@Column(name = "eleccion", nullable = false)
	private String eleccion;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	public String getLugartrabajo() {
		return lugartrabajo;
	}

	public void setLugartrabajo(String lugartrabajo) {
		this.lugartrabajo = lugartrabajo;
	}

	public String getEleccion() {
		return eleccion;
	}

	public void setEleccion(String eleccion) {
		this.eleccion = eleccion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

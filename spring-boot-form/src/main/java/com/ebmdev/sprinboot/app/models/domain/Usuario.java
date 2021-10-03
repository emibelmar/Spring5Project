package com.ebmdev.sprinboot.app.models.domain;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.ebmdev.sprinboot.app.validation.IdRegex;
import com.ebmdev.sprinboot.app.validation.Requerido;

public class Usuario {

	// @Pattern(regexp = "[\\d]{2}[.,][\\d]{3}[.,][\\d]{3}[-][A-Z]{1}")
	@IdRegex
	private String id;

	@NotBlank
	@Size(min = 3, max = 8)
	private String username;

	@NotEmpty
	private String password;

	@NotEmpty
	@Email
	private String email;

	// @NotEmpty
	private String nombre;

	// @NotEmpty
	@Requerido
	private String apellido;

	@NotNull
	@Min(5)
	@Max(99)
	private Integer edad;

	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaNacimiento;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

}

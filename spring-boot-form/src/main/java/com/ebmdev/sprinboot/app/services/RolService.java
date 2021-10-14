package com.ebmdev.sprinboot.app.services;

import java.util.List;

import com.ebmdev.sprinboot.app.models.domain.Rol;

public interface RolService {

	public List<Rol> listar();

	public Rol obtenerPorId(Integer id);
}

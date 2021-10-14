package com.ebmdev.sprinboot.app.services;

import java.util.List;

import com.ebmdev.sprinboot.app.models.domain.Pais;

public interface PaisService {

	public List<Pais> listar();

	public Pais obtenerPorId(Integer id);
}

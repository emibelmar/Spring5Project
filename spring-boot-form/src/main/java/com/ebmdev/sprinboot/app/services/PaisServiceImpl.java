package com.ebmdev.sprinboot.app.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ebmdev.sprinboot.app.models.domain.Pais;

@Service
public class PaisServiceImpl implements PaisService {

	private List<Pais> paises;

	public PaisServiceImpl() {
		this.paises = Arrays.asList(new Pais(1, "ES", "España"), new Pais(2, "FR", "Francia"),
				new Pais(3, "IT", "Italia"), new Pais(4, "AL", "Alemania"), new Pais(5, "PL", "Polonia"));
	}

	@Override
	public List<Pais> listar() {
		return this.paises;
	}

	@Override
	public Pais obtenerPorId(Integer id) {
		Pais resultado = null;

		for (Pais p : this.paises) {
			if (p.getId() == id) {
				resultado = p;
				break;
			}
		}
		return resultado;
	}

}

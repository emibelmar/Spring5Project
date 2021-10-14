package com.ebmdev.sprinboot.app.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ebmdev.sprinboot.app.models.domain.Rol;

@Service
public class RolServiceImpl implements RolService {

	private List<Rol> roles;

	public RolServiceImpl() {
		this.roles = Arrays.asList(new Rol(1, "Admin", "ROLE_ADMIN"), new Rol(2, "Mod", "ROLE_MODERATOR"),
				new Rol(3, "Usuario", "ROLE_USER"));
	}

	@Override
	public List<Rol> listar() {
		return this.roles;
	}

	@Override
	public Rol obtenerPorId(Integer id) {
		Rol resultado = null;

		for (Rol r : this.roles) {
			if (r.getId() == id) {
				resultado = r;
				break;
			}
		}
		return resultado;
	}

}

package com.ebmdev.sprinboot.app.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ebmdev.sprinboot.app.services.RolService;

@Component
public class RolesPropertyEditor extends PropertyEditorSupport {

	@Autowired
	private RolService rolService;

	@Override
	public void setAsText(String id) throws IllegalArgumentException {
		try {
			setValue(rolService.obtenerPorId(Integer.parseInt(id)));
		} catch (Exception e) {
			setValue(null);
		}
	}
}

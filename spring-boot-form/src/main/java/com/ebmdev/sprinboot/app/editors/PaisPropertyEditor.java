package com.ebmdev.sprinboot.app.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ebmdev.sprinboot.app.services.PaisService;

@Component
public class PaisPropertyEditor extends PropertyEditorSupport {

	@Autowired
	private PaisService paisService;

	@Override
	public void setAsText(String id) throws IllegalArgumentException {
		try {
			setValue(paisService.obtenerPorId(Integer.parseInt(id)));
		} catch (Exception e) {
			setValue(null);
		}
	}

}

package com.ebmdev.sprinboot.app.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.ebmdev.sprinboot.app.editors.NombreMayusEditor;
import com.ebmdev.sprinboot.app.models.domain.Pais;
import com.ebmdev.sprinboot.app.models.domain.Usuario;
import com.ebmdev.sprinboot.app.validation.UsuarioValidador;

@Controller
@SessionAttributes("usuario")
public class FormController {

	@Autowired
	private UsuarioValidador usuarioValidator;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(usuarioValidator);

		// CustomEditor para la fecha
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, "fechaNacimiento", new CustomDateEditor(dateFormat, false));

		// CustomEditor para el nombre
		binder.registerCustomEditor(String.class, "nombre", new NombreMayusEditor());

		// CustomEditor para el nombre
		binder.registerCustomEditor(String.class, "apellido", new NombreMayusEditor());

	}

	@GetMapping("/form")
	public String form(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Emilio");
		usuario.setApellido("Beltran");
		usuario.setId("123.456.789-A");
		model.addAttribute("titulo", "Formulario usuarios");
		model.addAttribute("usuario", usuario);
		return "form";
	}

	@PostMapping("/form")
	public String procesar(@Valid Usuario usuario, BindingResult result, Model model, SessionStatus status) {
		if (result.hasErrors()) {
			return "form";
		}
		model.addAttribute("titulo", "Resultado form");
		model.addAttribute("usuario", usuario);
		status.setComplete();
		return "resultado";
	}

	@ModelAttribute("listaPaises")
	public List<Pais> listaPaises() {
		return Arrays.asList(new Pais(1, "ES", "España"), new Pais(2, "FR", "Francia"), new Pais(3, "IT", "Italia"),
				new Pais(4, "AL", "Alemania"), new Pais(5, "PL", "Polonia"));
	}

	@ModelAttribute("paises")
	public List<String> paises() {
		return Arrays.asList("España", "Francia", "Italia", "Alemania", "Polonia");
	}

	@ModelAttribute("paisesMap")
	public Map<String, String> paisesMap() {
		Map<String, String> paises = new HashMap<String, String>();
		paises.put("ES", "España");
		paises.put("FR", "Francia");
		paises.put("IT", "Italia");
		paises.put("AL", "Alemania");
		paises.put("PL", "Polonia");
		return paises;
	}
}

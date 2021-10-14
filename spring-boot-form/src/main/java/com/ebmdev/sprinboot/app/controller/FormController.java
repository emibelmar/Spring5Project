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
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.ebmdev.sprinboot.app.editors.NombreMayusEditor;
import com.ebmdev.sprinboot.app.editors.PaisPropertyEditor;
import com.ebmdev.sprinboot.app.editors.RolesPropertyEditor;
import com.ebmdev.sprinboot.app.models.domain.Pais;
import com.ebmdev.sprinboot.app.models.domain.Rol;
import com.ebmdev.sprinboot.app.models.domain.Usuario;
import com.ebmdev.sprinboot.app.services.PaisService;
import com.ebmdev.sprinboot.app.services.RolService;
import com.ebmdev.sprinboot.app.validation.UsuarioValidador;

@Controller
@SessionAttributes("usuario")
public class FormController {

	@Autowired
	private UsuarioValidador usuarioValidator;

	@Autowired
	private PaisService paisService;

	@Autowired
	private RolService rolService;

	@Autowired
	private PaisPropertyEditor paisPropertyEditor;

	@Autowired
	private RolesPropertyEditor rolesPropertyEditor;

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

		// CustomEditor para el pais
		binder.registerCustomEditor(Pais.class, "pais", paisPropertyEditor);

		// CustomEditor para el rol
		binder.registerCustomEditor(Rol.class, "roles", rolesPropertyEditor);
	}

	@GetMapping("/form")
	public String form(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Emilio");
		usuario.setApellido("Beltran");
		usuario.setId("12.345.678-A");
		usuario.setHabilitar(true);
		usuario.setValorSecreto("### valorSecreto ###");
		usuario.setPais(new Pais(1, "ES", "España"));
		usuario.setRoles(Arrays.asList(new Rol(3, "Usuario", "ROLE_USER")));
		model.addAttribute("titulo", "Formulario usuarios");
		model.addAttribute("usuario", usuario);
		return "form";
	}

	@PostMapping("/form")
	public String procesar(@Valid Usuario usuario, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Resultado form");

			return "form";
		}

		return "redirect:/ver";
	}

	@GetMapping("/ver")
	public String ver(@SessionAttribute(name = "usuario", required = false) Usuario usuario, Model model,
			SessionStatus status) {

		if (usuario == null) {
			return "redirect:/form";
		}
		model.addAttribute("titulo", "Resultado form");

		status.setComplete();
		return "resultado";
	}

	@ModelAttribute("listaPaises")
	public List<Pais> listaPaises() {
		return paisService.listar();
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

	@ModelAttribute("listaRolesString")
	public List<String> listaRolesString() {
		return Arrays.asList("ROLE_ADMIN", "ROLE_USER", "ROLE_MODERATOR");
	}

	@ModelAttribute("rolesMap")
	public Map<String, String> rolesMap() {
		Map<String, String> roles = new HashMap<String, String>();
		roles.put("ROLE_ADMIN", "Administrador");
		roles.put("ROLE_MODERATOR", "Moderador");
		roles.put("ROLE_USER", "Usuario");
		return roles;
	}

	@ModelAttribute("listaRoles")
	public List<Rol> listaRoles() {
		return rolService.listar();
	}

	@ModelAttribute("generos")
	public List<String> genero() {
		return Arrays.asList("Hombre", "Mujer");
	}

}

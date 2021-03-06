package com.ebmdev.sprinboot.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.ebmdev.sprinboot.app.models.domain.ItemFactura;
import com.ebmdev.sprinboot.app.models.domain.Producto;

@Configuration
public class AppConfig {

	@Bean("itemsFactura")
	public List<ItemFactura> registrarItemsFactura() {
		Producto producto1 = new Producto("Cámara", 100);
		Producto producto2 = new Producto("Móvil", 200);

		ItemFactura linea1 = new ItemFactura(producto1, 2);
		ItemFactura linea2 = new ItemFactura(producto2, 4);

		return Arrays.asList(linea1, linea2);
	}

	@Bean("itemsFacturaOficina")
	@Primary
	public List<ItemFactura> registrarItemsFacturaOficina() {
		Producto producto1 = new Producto("Monitor", 230);
		Producto producto2 = new Producto("Portatil", 800);
		Producto producto3 = new Producto("Impresora", 180);
		Producto producto4 = new Producto("Escritorio", 120);

		ItemFactura linea1 = new ItemFactura(producto1, 2);
		ItemFactura linea2 = new ItemFactura(producto2, 1);
		ItemFactura linea3 = new ItemFactura(producto3, 1);
		ItemFactura linea4 = new ItemFactura(producto4, 1);

		return Arrays.asList(linea1, linea2, linea3, linea4);
	}
}

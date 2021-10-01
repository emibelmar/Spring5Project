package com.ebmdev.sprinboot.app.models.services;

import org.springframework.stereotype.Service;

@Service("indexServiceImpl2")
public class IndexServiceImpl2 implements IndexService {

	@Override
	public String ejemplo() {
		return "ejecutando ejemplo() en IndexServiceImpl2...";
	}

}

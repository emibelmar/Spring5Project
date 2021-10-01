package com.ebmdev.sprinboot.app.models.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service("indexServiceImpl")
public class IndexServiceImpl implements IndexService {

	@Override
	public String ejemplo() {
		return "ejecutando ejemplo() en IndexServiceImpl...";
	}

}

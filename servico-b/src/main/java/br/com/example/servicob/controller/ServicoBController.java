package br.com.example.servicob.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.example.servicob.dto.ServicoADTO;

@RestController
@RequestMapping("/api/v1/b")
public class ServicoBController {
	Logger logger = LoggerFactory.getLogger(ServicoBController.class);
	
	@PostMapping
	public List<ServicoADTO> postSomething(@RequestBody List<ServicoADTO>request) {
		logger.info("POSTING: {}", request);
		return request;
	}

	@GetMapping("/hello")
	public String getSomething() {
		return "hello world";
	}
}

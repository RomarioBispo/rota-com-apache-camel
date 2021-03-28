package br.com.example.servicoa.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.example.servicoa.dto.ServicoADTO;

@RestController
@RequestMapping("/api/v1/a")
@CrossOrigin("*")
public class ServicoAController {
	
	@GetMapping
	public List<ServicoADTO> getAll() {
		ServicoADTO dto = new ServicoADTO();
		dto.setCampo1("campo1");
		dto.setCampo2("campo2");
		return List.of(dto, dto, dto);
	}

}

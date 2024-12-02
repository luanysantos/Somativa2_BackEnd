package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Agendamento;
import com.example.demo.services.AgendamentoService;

@RestController
@RequestMapping("/Agendamento")
public class AgendamentoController {

	private final AgendamentoService agendamentoService;

	@Autowired
	public AgendamentoController(AgendamentoService agendamentoService) {
		this.agendamentoService = agendamentoService;
	}

	@PostMapping("/criar")
	public Agendamento salvar(@RequestBody Agendamento agendamento) {
		return agendamentoService.salvarAgendamento(agendamento);
	}

	@GetMapping
	public List<Agendamento> buscarTodos() {
		return agendamentoService.buscarTodosAgendamentos();
	}

	@GetMapping("/{id}")
	public Agendamento buscarPorId(@PathVariable Long id) {
		return agendamentoService.buscarAgendamentoPorId(id);
	}

	@DeleteMapping("/{id}")
	public void deletarAgendamento(@PathVariable Long id) {
		agendamentoService.excluirAgendamento(id);
	}

	@PutMapping
	public ResponseEntity<Agendamento> atualizarAgendamento(@PathVariable Long id,
			@RequestBody Agendamento agendamento) {
		Agendamento agendamentoAtualizado = agendamentoService.atualizarAgendamento(id, agendamento);
		if (agendamentoAtualizado != null) {
			return ResponseEntity.ok(agendamentoAtualizado);
		} else {
			return null;
		}
	}
}


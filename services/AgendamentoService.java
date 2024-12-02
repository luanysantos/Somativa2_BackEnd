package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Agendamento;
import com.example.demo.repositories.AgendamentoRepository;

@Service
public class AgendamentoService {

	private final AgendamentoRepository agendamentoRepository;

	@Autowired
	public AgendamentoService(AgendamentoRepository agendamentoRepository) {
		this.agendamentoRepository = agendamentoRepository;
	}

	public Agendamento salvarAgendamento(Agendamento agendamento) {
		return agendamentoRepository.save(agendamento);
	}

	public Agendamento buscarAgendamentoPorId(Long id) {
		return agendamentoRepository.findById(id).orElse(null);
	}

	public List<Agendamento> buscarTodosAgendamentos() {
		return agendamentoRepository.findAll();
	}

	public void excluirAgendamento(Long id) {
		agendamentoRepository.deleteById(id);
	}

	public Agendamento atualizarAgendamento(Long id, Agendamento gendamentoAtualizado) {
		Optional<Agendamento> AgendamentoExistente = agendamentoRepository.findById(id);
		if (AgendamentoExistente.isPresent()) {
			Agendamento agendamento = AgendamentoExistente.get();
			agendamento.setDataHora(gendamentoAtualizado.getDataHora());
			agendamento.setStatus(gendamentoAtualizado.getStatus());
			return agendamentoRepository.save(agendamento);
		} else {
			return null;
		}
	}
}

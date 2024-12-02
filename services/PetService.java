package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Pet;
import com.example.demo.repositories.PetRepository;

@Service
public class PetService {

	private final PetRepository petRepository;

	@Autowired
	public PetService(PetRepository petRepository) {
		this.petRepository = petRepository;
	}

	public Pet salvarPet(Pet pet) {
		return petRepository.save(pet);
	}

	public Pet buscarPetPorId(Long id) {
		return petRepository.findById(id).orElse(null);
	}

	public List<Pet> buscarTodosPets() {
		return petRepository.findAll();
	}

	public void excluirPet(Long id) {
		petRepository.deleteById(id);
	}

	public Pet atualizarPet(Long id, Pet petAtualizado) {
		Optional<Pet> PetExistente = petRepository.findById(id);
		if (PetExistente.isPresent()) {
			Pet pet = PetExistente.get();
			pet.setNome(petAtualizado.getNome());
			pet.setRaca(petAtualizado.getRaca());
			pet.setTipo(petAtualizado.getTipo());
			pet.setIdade(petAtualizado.getIdade());
			return petRepository.save(pet);
		} else {
			return null;
		}
	}
}

package br.edu.ifrs.petbemestar;

import java.time.LocalDateTime;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import br.edu.ifrs.petbemestar.dominio.Agendamento;
import br.edu.ifrs.petbemestar.dominio.Animal;
import br.edu.ifrs.petbemestar.dominio.Dono;
import br.edu.ifrs.petbemestar.dominio.TipoServico;

public class Principal {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pet-bem-estar-pu");

		EntityManager em = emf.createEntityManager();

		try {

			em.getTransaction().begin();

			Dono dono = new Dono("Rosa", "51999999999");

			Animal animal1 = new Animal("Thor");
			Animal animal2 = new Animal("Mel");

			dono.adicionarAnimal(animal1);
			dono.adicionarAnimal(animal2);

			Agendamento agendamento1 = new Agendamento(LocalDateTime.of(2026, 9, 1, 10, 0), TipoServico.BANHO);

			Agendamento agendamento2 = new Agendamento(LocalDateTime.of(2026, 1, 2, 14, 0),
					TipoServico.CONSULTA_VETERINARIA);

			animal1.adicionarAgendamento(agendamento1);
			animal2.adicionarAgendamento(agendamento2);

			em.persist(dono);
			em.persist(animal1);
			em.persist(animal2);
			em.persist(agendamento1);
			em.persist(agendamento2);

			em.getTransaction().commit();

			System.out.println("Dados persistidos com sucesso!");
			System.out.println("Dono: " + dono.getNome());
			System.out.println("Animal 1: " + animal1.getNome());
			System.out.println("Animal 2: " + animal2.getNome());

		} finally {

			em.close();
			emf.close();

		}
	}
}
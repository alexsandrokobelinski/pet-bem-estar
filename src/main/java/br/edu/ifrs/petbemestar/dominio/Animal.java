package br.edu.ifrs.petbemestar.dominio;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne
    private Dono dono;

    @OneToMany(mappedBy = "animal")
    private List<Agendamento> agendamentos = new ArrayList<>();

    public Animal() {
    }

    public Animal(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Dono getDono() {
        return dono;
    }

    public void setDono(Dono dono) {
        this.dono = dono;
    }

    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public void adicionarAgendamento(Agendamento agendamento) {
        agendamentos.add(agendamento);
        agendamento.setAnimal(this);
    }
}
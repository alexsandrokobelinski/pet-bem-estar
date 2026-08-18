package br.edu.ifrs.petbemestar.dominio;

import java.time.LocalDateTime;

public class Agendamento {

    private Long id;
    private LocalDateTime dataHora;
    private TipoServico tipoServico;
    private SituacaoAgendamento situacao;

    private Animal animal;

    public Agendamento() {
    }

    public Agendamento(LocalDateTime dataHora, TipoServico tipoServico) {
        this.dataHora = dataHora;
        this.tipoServico = tipoServico;
        this.situacao = SituacaoAgendamento.MARCADO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public TipoServico getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(TipoServico tipoServico) {
        this.tipoServico = tipoServico;
    }

    public SituacaoAgendamento getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoAgendamento situacao) {
        this.situacao = situacao;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
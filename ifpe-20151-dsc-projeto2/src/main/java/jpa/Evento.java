package com.ifpe.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;

/**
 *
 * @author João Henrique 2
 */
@Entity
@Table(name = "EVENTO")
public class Evento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Future
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "INICIO", nullable = false)
    private Date inicio;

    @Future
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TERMINO", nullable = false)
    private Date termino;

    @Column(name = "LOCAL", nullable = false)
    private String local;

    @Column(name = "DESCRICAO", nullable = false)
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS_EVENTO", nullable = false)
    private StatusEvento status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getTermino() {
        return termino;
    }

    public void setTermino(Date termino) {
        this.termino = termino;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public StatusEvento getStatus() {
        return status;
    }

    public void setStatus(StatusEvento status) {
        this.status = status;
    }

}

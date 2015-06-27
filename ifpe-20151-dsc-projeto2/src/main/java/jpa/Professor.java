package jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "PROFESSOR")
@Access(AccessType.FIELD)
@DiscriminatorValue(value = "P")
@PrimaryKeyJoinColumn(name = "ID_USUARIO", referencedColumnName = "ID")
public class Professor extends Usuario implements Serializable {

    @Column(name = "SIAPE", length = 10, nullable = false, unique = true)
    private String siape;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "CARGO", nullable = false)
    private Cargo cargo;

    @Column(name = "LATTES", length = 255, nullable = true)
    private String lattes;

    @Column(name = "SITE", length = 255, nullable = true)
    private String site;

    @OneToMany(mappedBy = "professor", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Disciplina> disciplinas;

    @OneToMany(mappedBy = "orientador", fetch = FetchType.LAZY)
    private List<Aluno> orientandos;

    public String getSiape() {
        return siape;
    }

    public void setSiape(String siape) {
        this.siape = siape;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public String getLattes() {
        return lattes;
    }

    public void setLattes(String lattes) {
        this.lattes = lattes;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public List<Aluno> getOrientandos() {
        return orientandos;
    }

    public void addOrientando(Aluno aluno) {
        orientandos.add(aluno);
    }

}

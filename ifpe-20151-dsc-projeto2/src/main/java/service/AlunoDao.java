package service;

import jpa.Aluno;
import dao.Dao;
import java.util.List;

public class AlunoDao extends Dao {

    public void salvar(Aluno aluno) {
        entityManager.persist(aluno);
    }

    public List<Aluno> getAlunos() {
        return (List<Aluno>) super.get("Alunos");
    }
}

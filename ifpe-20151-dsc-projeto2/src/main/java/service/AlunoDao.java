package service;

import jpa.Aluno;
import dao.Dao;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class AlunoDao extends Dao {

    public void salvar(Aluno aluno) {
        entityManager.persist(aluno);
    }

    public List<Aluno> getAlunos() {
        return (List<Aluno>) super.get("Alunos");
    }
}

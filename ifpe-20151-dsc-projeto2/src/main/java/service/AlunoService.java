package service;

import jpa.Aluno;
import dao.DaoGenerico;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

/**
 *
 * @author MASC
 */
@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class AlunoService {
    @EJB
    private DaoGenerico daoGenerico;
    
    public void salvar(Aluno aluno) {
        daoGenerico.salvar(aluno);
    }

    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Aluno> getAlunos() {
        return (List<Aluno>) daoGenerico.get("Alunos");
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import jpa.Aluno;
import service.AlunoDao;

/**
 *
 * @author MASC
 */
@ManagedBean(name = "alunosPaginator")
@ViewScoped
public class AlunosPaginator {

    @EJB
    private AlunoDao alunoDao;

    private List<Aluno> alunos;

    public List<Aluno> getAlunos() {
        if (alunos == null) {
            alunos = alunoDao.getAlunos();
        }

        return alunos;
    }
}

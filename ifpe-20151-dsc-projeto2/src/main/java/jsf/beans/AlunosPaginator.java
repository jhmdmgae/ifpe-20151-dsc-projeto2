/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans;

import jpa.Aluno;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import service.AlunoService;

/**
 *
 * @author MASC
 */
@ManagedBean(name = "alunosPaginator")
@ViewScoped
public class AlunosPaginator {

    @EJB
    private AlunoService alunoService;

    private List<Aluno> alunos;

    public List<Aluno> getAlunos() {
        if (alunos == null) {
            alunos = alunoService.getAlunos();
        }

        return alunos;
    }
}

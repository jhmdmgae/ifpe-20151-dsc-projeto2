package jsf.beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import jpa.Professor;
import service.ProfessorDao;


@ManagedBean(name = "professorBean")
@SessionScoped
public class ProfessorBean {
    private Professor professor;
    
    @EJB
    private ProfessorDao professorDao;

    /**
     * Creates a new instance of ProfessorBean
     */
    public ProfessorBean() {
        iniciarCampos();
    }

    private void iniciarCampos() {
        this.professor = new Professor();
    }

    public Professor getProfessor() {
        return professor;
    }

    public void salvar() {
        professorDao.salvar(professor);
        iniciarCampos();
        JsfUtil.adicionarMessagem("Cadastro do professor realizado com sucesso!");
    }

}

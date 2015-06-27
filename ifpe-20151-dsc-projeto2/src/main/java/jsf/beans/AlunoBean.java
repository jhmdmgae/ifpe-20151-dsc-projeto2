package jsf.beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import jpa.Aluno;
import service.AlunoDao;


@ManagedBean(name = "alunoBean")
@SessionScoped
public class AlunoBean {
    private Aluno aluno;
    
    @EJB
    private AlunoDao alunoDao;

    /**
     * Creates a new instance of AlunoBean
     */
    public AlunoBean() {
        iniciarCampos();
    }

    private void iniciarCampos() {
        this.aluno = new Aluno();
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void salvar() {
        alunoDao.salvar(aluno);
        iniciarCampos();
        JsfUtil.adicionarMessagem("Cadastro do aluno realizado com sucesso!");
    }

}

package jsf.beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import jpa.Turma;
import service.TurmaDao;


@ManagedBean(name = "turmaBean")
@SessionScoped
public class TurmaBean {
    private Turma turma;
    
    @EJB
    private TurmaDao turmaDao;

    /**
     * Creates a new instance of TurmaBean
     */
    public TurmaBean() {
        iniciarCampos();
    }

    private void iniciarCampos() {
        this.turma = new Turma();
    }

    public Turma getTurma() {
        return turma;
    }

    public void salvar() {
        turmaDao.salvar(turma);
        iniciarCampos();
        JsfUtil.adicionarMessagem("Cadastro do turma realizado com sucesso!");
    }

}

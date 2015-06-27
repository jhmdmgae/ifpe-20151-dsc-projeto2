package jsf.beans;

import jpa.Aluno;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import service.AlunoService;


@ManagedBean(name = "alunoBean")
@SessionScoped
public class AlunoBean {
    private Aluno aluno;
    
    @EJB
    private AlunoService alunoService;

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
        alunoService.salvar(aluno);
        iniciarCampos();
        JsfUtil.adicionarMessagem("Cadastro do aluno realizado com sucesso!");
    }

}

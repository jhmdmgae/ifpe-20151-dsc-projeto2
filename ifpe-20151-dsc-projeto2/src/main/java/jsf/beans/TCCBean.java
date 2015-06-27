package jsf.beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import jpa.TCC;
import service.TCCDao;


@ManagedBean(name = "tccBean")
@SessionScoped
public class TCCBean {
    private TCC tcc;
    
    @EJB
    private TCCDao tccDao;

    /**
     * Creates a new instance of TCCBean
     */
    public TCCBean() {
        iniciarCampos();
    }

    private void iniciarCampos() {
        this.tcc = new TCC();
    }

    public TCC getTCC() {
        return tcc;
    }

    public void salvar() {
        tccDao.salvar(tcc);
        iniciarCampos();
        JsfUtil.adicionarMessagem("Cadastro do tcc realizado com sucesso!");
    }

}

package jsf.beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import jpa.Documento;
import service.DocumentoDao;


@ManagedBean(name = "documentoBean")
@SessionScoped
public class DocumentoBean {
    private Documento documento;
    
    @EJB
    private DocumentoDao documentoDao;

    /**
     * Creates a new instance of DocumentoBean
     */
    public DocumentoBean() {
        iniciarCampos();
    }

    private void iniciarCampos() {
        this.documento = new Documento();
    }

    public Documento getDocumento() {
        return documento;
    }

    public void salvar() {
        documentoDao.salvar(documento);
        iniciarCampos();
        JsfUtil.adicionarMessagem("Cadastro do documento realizado com sucesso!");
    }

}

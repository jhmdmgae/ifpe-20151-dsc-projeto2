package jsf.beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import jpa.Evento;
import service.EventoDao;


@ManagedBean(name = "eventoBean")
@SessionScoped
public class EventoBean {
    private Evento evento;
    
    @EJB
    private EventoDao eventoDao;

    /**
     * Creates a new instance of EventoBean
     */
    public EventoBean() {
        iniciarCampos();
    }

    private void iniciarCampos() {
        this.evento = new Evento();
    }

    public Evento getEvento() {
        return evento;
    }

    public void salvar() {
        eventoDao.salvar(evento);
        iniciarCampos();
        JsfUtil.adicionarMessagem("Cadastro do evento realizado com sucesso!");
    }

}

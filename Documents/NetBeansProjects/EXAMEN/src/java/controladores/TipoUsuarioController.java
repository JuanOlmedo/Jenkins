package controladores;

import controladores.util.MobilePageController;
import entidades.TipoUsuario;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "tipoUsuarioController")
@ViewScoped
public class TipoUsuarioController extends AbstractController<TipoUsuario> {

    @Inject
    private MobilePageController mobilePageController;

    public TipoUsuarioController() {
        // Inform the Abstract parent controller of the concrete TipoUsuario Entity
        super(TipoUsuario.class);
    }

    /**
     * Sets the "items" attribute with a collection of Usuario entities that are
     * retrieved from TipoUsuario?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Usuario page
     */
    public String navigateUsuarioCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Usuario_items", this.getSelected().getUsuarioCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/usuario/index";
    }

}

package controladores;

import controladores.util.MobilePageController;
import entidades.TipoBibliografia;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "tipoBibliografiaController")
@ViewScoped
public class TipoBibliografiaController extends AbstractController<TipoBibliografia> {

    @Inject
    private MobilePageController mobilePageController;

    public TipoBibliografiaController() {
        // Inform the Abstract parent controller of the concrete TipoBibliografia Entity
        super(TipoBibliografia.class);
    }

    /**
     * Sets the "items" attribute with a collection of Bibliografia entities
     * that are retrieved from TipoBibliografia?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for Bibliografia page
     */
    public String navigateBibliografiaCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Bibliografia_items", this.getSelected().getBibliografiaCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/bibliografia/index";
    }

}

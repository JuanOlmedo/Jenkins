package controladores;

import controladores.util.MobilePageController;
import entidades.Autor;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "autorController")
@ViewScoped
public class AutorController extends AbstractController<Autor> {

    @Inject
    private MobilePageController mobilePageController;

    public AutorController() {
        // Inform the Abstract parent controller of the concrete Autor Entity
        super(Autor.class);
    }

    /**
     * Sets the "items" attribute with a collection of Bibliografia entities
     * that are retrieved from Autor?cap_first and returns the navigation
     * outcome.
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

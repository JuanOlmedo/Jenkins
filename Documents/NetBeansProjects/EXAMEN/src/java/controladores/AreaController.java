package controladores;

import controladores.util.MobilePageController;
import entidades.Area;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "areaController")
@ViewScoped
public class AreaController extends AbstractController<Area> {

    @Inject
    private MobilePageController mobilePageController;

    public AreaController() {
        // Inform the Abstract parent controller of the concrete Area Entity
        super(Area.class);
    }

    /**
     * Sets the "items" attribute with a collection of Bibliografia entities
     * that are retrieved from Area?cap_first and returns the navigation
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

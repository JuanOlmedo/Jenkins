package controladores;

import controladores.util.MobilePageController;
import entidades.Facultad;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "facultadController")
@ViewScoped
public class FacultadController extends AbstractController<Facultad> {

    @Inject
    private MobilePageController mobilePageController;

    public FacultadController() {
        // Inform the Abstract parent controller of the concrete Facultad Entity
        super(Facultad.class);
    }

    /**
     * Sets the "items" attribute with a collection of DetalleBiblioFacu
     * entities that are retrieved from Facultad?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for DetalleBiblioFacu page
     */
    public String navigateDetalleBiblioFacuCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("DetalleBiblioFacu_items", this.getSelected().getDetalleBiblioFacuCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/detalleBiblioFacu/index";
    }

}

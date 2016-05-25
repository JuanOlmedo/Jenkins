package controladores;

import controladores.util.MobilePageController;
import entidades.Bibliografia;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "bibliografiaController")
@ViewScoped
public class BibliografiaController extends AbstractController<Bibliografia> {

    @Inject
    private AutorController autorAutorCodigoController;
    @Inject
    private AreaController areaAreaCodigoController;
    @Inject
    private TipoBibliografiaController tipoBibliografiaTibiCodigoController;
    @Inject
    private MobilePageController mobilePageController;

    public BibliografiaController() {
        // Inform the Abstract parent controller of the concrete Bibliografia Entity
        super(Bibliografia.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        autorAutorCodigoController.setSelected(null);
        areaAreaCodigoController.setSelected(null);
        tipoBibliografiaTibiCodigoController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of DetalleBiblioFacu
     * entities that are retrieved from Bibliografia?cap_first and returns the
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

    /**
     * Sets the "selected" attribute of the Autor controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareAutorAutorCodigo(ActionEvent event) {
        if (this.getSelected() != null && autorAutorCodigoController.getSelected() == null) {
            autorAutorCodigoController.setSelected(this.getSelected().getAutorAutorCodigo());
        }
    }

    /**
     * Sets the "selected" attribute of the Area controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareAreaAreaCodigo(ActionEvent event) {
        if (this.getSelected() != null && areaAreaCodigoController.getSelected() == null) {
            areaAreaCodigoController.setSelected(this.getSelected().getAreaAreaCodigo());
        }
    }

    /**
     * Sets the "selected" attribute of the TipoBibliografia controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareTipoBibliografiaTibiCodigo(ActionEvent event) {
        if (this.getSelected() != null && tipoBibliografiaTibiCodigoController.getSelected() == null) {
            tipoBibliografiaTibiCodigoController.setSelected(this.getSelected().getTipoBibliografiaTibiCodigo());
        }
    }
}

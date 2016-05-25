package controladores;

import controladores.util.MobilePageController;
import entidades.DetallePrestamo;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "detallePrestamoController")
@ViewScoped
public class DetallePrestamoController extends AbstractController<DetallePrestamo> {

    @Inject
    private DetalleBiblioFacuController detalleBiblioFacuDtbfCodigoController;
    @Inject
    private PrestamoController prestamoPresCodigoController;
    @Inject
    private MobilePageController mobilePageController;

    public DetallePrestamoController() {
        // Inform the Abstract parent controller of the concrete DetallePrestamo Entity
        super(DetallePrestamo.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        detalleBiblioFacuDtbfCodigoController.setSelected(null);
        prestamoPresCodigoController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the DetalleBiblioFacu controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareDetalleBiblioFacuDtbfCodigo(ActionEvent event) {
        if (this.getSelected() != null && detalleBiblioFacuDtbfCodigoController.getSelected() == null) {
            detalleBiblioFacuDtbfCodigoController.setSelected(this.getSelected().getDetalleBiblioFacuDtbfCodigo());
        }
    }

    /**
     * Sets the "selected" attribute of the Prestamo controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void preparePrestamoPresCodigo(ActionEvent event) {
        if (this.getSelected() != null && prestamoPresCodigoController.getSelected() == null) {
            prestamoPresCodigoController.setSelected(this.getSelected().getPrestamoPresCodigo());
        }
    }
}

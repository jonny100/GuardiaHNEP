package bbp;

import entity.InternacionTransitoria;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "internacionTransitoriaController")
@ViewScoped
public class InternacionTransitoriaController extends AbstractController<InternacionTransitoria> {

    @Inject
    private CamasController camasCollectionController;
    @Inject
    private PacienteController dniPacController;

    public InternacionTransitoriaController() {
        // Inform the Abstract parent controller of the concrete InternacionTransitoria?cap_first Entity
        super(InternacionTransitoria.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        dniPacController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Camas entities that are
     * retrieved from InternacionTransitoria?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for Camas page
     */
    public String navigateCamasCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Camas_items", this.getSelected().getCamasCollection());
        }
        return "/camas/index";
    }

    /**
     * Sets the "selected" attribute of the Paciente controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareDniPac(ActionEvent event) {
        if (this.getSelected() != null && dniPacController.getSelected() == null) {
            dniPacController.setSelected(this.getSelected().getDniPac());
        }
    }
}

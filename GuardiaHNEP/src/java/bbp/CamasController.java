package bbp;

import entity.Camas;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "camasController")
@ViewScoped
public class CamasController extends AbstractController<Camas> {

    @Inject
    private InternacionTransitoriaController internacionTransitoriaNumInternController;

    public CamasController() {
        // Inform the Abstract parent controller of the concrete Camas?cap_first Entity
        super(Camas.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        internacionTransitoriaNumInternController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the InternacionTransitoria controller in
     * order to display its data in a dialog. This is reusing existing the
     * existing View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareInternacionTransitoriaNumIntern(ActionEvent event) {
        if (this.getSelected() != null && internacionTransitoriaNumInternController.getSelected() == null) {
            internacionTransitoriaNumInternController.setSelected(this.getSelected().getInternacionTransitoriaNumIntern());
        }
    }
}

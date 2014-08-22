package bbp;

import entity.Diagnosticos;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "diagnosticosController")
@ViewScoped
public class DiagnosticosController extends AbstractController<Diagnosticos> {

    @Inject
    private HistClinicaController histClinicaCollectionController;

    public DiagnosticosController() {
        // Inform the Abstract parent controller of the concrete Diagnosticos?cap_first Entity
        super(Diagnosticos.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of HistClinica entities that
     * are retrieved from Diagnosticos?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for HistClinica page
     */
    public String navigateHistClinicaCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("HistClinica_items", this.getSelected().getHistClinicaCollection());
        }
        return "/histClinica/index";
    }

}

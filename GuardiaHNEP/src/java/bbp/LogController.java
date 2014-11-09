package bbp;

import entity.Log;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "logController")
@ViewScoped
public class LogController extends AbstractController<Log> {

    @Inject
    private HistClinicaController histClinicaCollectionController;

    public LogController() {
        // Inform the Abstract parent controller of the concrete Servicios?cap_first Entity
        super(Log.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of HistClinica entities that
     * are retrieved from Servicios?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for HistClinica page
     */
   

}
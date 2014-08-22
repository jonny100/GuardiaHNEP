package bbp;

import entity.Servicios;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "serviciosController")
@ViewScoped
public class ServiciosController extends AbstractController<Servicios> {

    @Inject
    private HistClinicaController histClinicaCollectionController;

    public ServiciosController() {
        // Inform the Abstract parent controller of the concrete Servicios?cap_first Entity
        super(Servicios.class);
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
    public String navigateHistClinicaCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("HistClinica_items", this.getSelected().getHistClinicaCollection());
        }
        return "/histClinica/index";
    }

}

package bbp;

import entity.Cargo;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "cargoController")
@ViewScoped
public class CargoController extends AbstractController<Cargo> {

    @Inject
    private MedicosController medicosCollectionController;

    public CargoController() {
        // Inform the Abstract parent controller of the concrete Cargo?cap_first Entity
        super(Cargo.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of Medicos entities that are
     * retrieved from Cargo?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Medicos page
     */
    public String navigateMedicosCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Medicos_items", this.getSelected().getMedicosCollection());
        }
        return "/medicos/index";
    }

}

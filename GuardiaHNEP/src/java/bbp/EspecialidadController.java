package bbp;

import entity.Especialidad;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "especialidadController")
@ViewScoped
public class EspecialidadController extends AbstractController<Especialidad> {

    @Inject
    private MedicosController medicosCollectionController;

    public EspecialidadController() {
        // Inform the Abstract parent controller of the concrete Especialidad?cap_first Entity
        super(Especialidad.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of Medicos entities that are
     * retrieved from Especialidad?cap_first and returns the navigation outcome.
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

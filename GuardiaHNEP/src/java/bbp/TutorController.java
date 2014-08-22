package bbp;

import entity.Tutor;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "tutorController")
@ViewScoped
public class TutorController extends AbstractController<Tutor> {

    @Inject
    private PacienteController pacienteCollectionController;

    public TutorController() {
        // Inform the Abstract parent controller of the concrete Tutor?cap_first Entity
        super(Tutor.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of Paciente entities that
     * are retrieved from Tutor?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Paciente page
     */
    public String navigatePacienteCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Paciente_items", this.getSelected().getPacienteCollection());
        }
        return "/paciente/index";
    }

}

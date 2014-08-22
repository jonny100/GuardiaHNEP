package bbp;

import entity.Paciente;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "pacienteController")
@ViewScoped
public class PacienteController extends AbstractController<Paciente> {

    @Inject
    private InternacionTransitoriaController internacionTransitoriaCollectionController;
    @Inject
    private HistClinicaController histClinicaCollectionController;
    @Inject
    private ObraSocialPorPacienteController obraSocialPorPacienteCollectionController;
    @Inject
    private AdministrarMedicamentosController administrarMedicamentosCollectionController;
    @Inject
    private TutorController tutorDNITutController;

    public PacienteController() {
        // Inform the Abstract parent controller of the concrete Paciente?cap_first Entity
        super(Paciente.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        tutorDNITutController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of InternacionTransitoria
     * entities that are retrieved from Paciente?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for InternacionTransitoria page
     */
    public String navigateInternacionTransitoriaCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("InternacionTransitoria_items", this.getSelected().getInternacionTransitoriaCollection());
        }
        return "/internacionTransitoria/index";
    }

    /**
     * Sets the "items" attribute with a collection of HistClinica entities that
     * are retrieved from Paciente?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for HistClinica page
     */
    public String navigateHistClinicaCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("HistClinica_items", this.getSelected().getHistClinicaCollection());
        }
        return "/histClinica/index";
    }

    /**
     * Sets the "items" attribute with a collection of ObraSocialPorPaciente
     * entities that are retrieved from Paciente?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for ObraSocialPorPaciente page
     */
    public String navigateObraSocialPorPacienteCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("ObraSocialPorPaciente_items", this.getSelected().getObraSocialPorPacienteCollection());
        }
        return "/obraSocialPorPaciente/index";
    }

    /**
     * Sets the "items" attribute with a collection of AdministrarMedicamentos
     * entities that are retrieved from Paciente?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for AdministrarMedicamentos page
     */
    public String navigateAdministrarMedicamentosCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("AdministrarMedicamentos_items", this.getSelected().getAdministrarMedicamentosCollection());
        }
        return "/administrarMedicamentos/index";
    }

    /**
     * Sets the "selected" attribute of the Tutor controller in order to display
     * its data in a dialog. This is reusing existing the existing View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareTutorDNITut(ActionEvent event) {
        if (this.getSelected() != null && tutorDNITutController.getSelected() == null) {
            tutorDNITutController.setSelected(this.getSelected().getTutorDNITut());
        }
    }
}

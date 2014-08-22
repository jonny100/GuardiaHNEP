package bbp;

import entity.HistClinica;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "histClinicaController")
@ViewScoped
public class HistClinicaController extends AbstractController<HistClinica> {

    @Inject
    private ServiciosController derivacionController;
    @Inject
    private PacienteController dniPacienteController;
    @Inject
    private DiagnosticosController codDiagnosticoController;
    @Inject
    private MedicosController medicosMatriculaMedController;
    @Inject
    private PatologiasController codPatologiaController;

    public HistClinicaController() {
        // Inform the Abstract parent controller of the concrete HistClinica?cap_first Entity
        super(HistClinica.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        derivacionController.setSelected(null);
        dniPacienteController.setSelected(null);
        codDiagnosticoController.setSelected(null);
        medicosMatriculaMedController.setSelected(null);
        codPatologiaController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Servicios controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareDerivacion(ActionEvent event) {
        if (this.getSelected() != null && derivacionController.getSelected() == null) {
            derivacionController.setSelected(this.getSelected().getDerivacion());
        }
    }

    /**
     * Sets the "selected" attribute of the Paciente controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareDniPaciente(ActionEvent event) {
        if (this.getSelected() != null && dniPacienteController.getSelected() == null) {
            dniPacienteController.setSelected(this.getSelected().getDniPaciente());
        }
    }

    /**
     * Sets the "selected" attribute of the Diagnosticos controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCodDiagnostico(ActionEvent event) {
        if (this.getSelected() != null && codDiagnosticoController.getSelected() == null) {
            codDiagnosticoController.setSelected(this.getSelected().getCodDiagnostico());
        }
    }

    /**
     * Sets the "selected" attribute of the Medicos controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareMedicosMatriculaMed(ActionEvent event) {
        if (this.getSelected() != null && medicosMatriculaMedController.getSelected() == null) {
            medicosMatriculaMedController.setSelected(this.getSelected().getMedicosMatriculaMed());
        }
    }

    /**
     * Sets the "selected" attribute of the Patologias controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCodPatologia(ActionEvent event) {
        if (this.getSelected() != null && codPatologiaController.getSelected() == null) {
            codPatologiaController.setSelected(this.getSelected().getCodPatologia());
        }
    }
}

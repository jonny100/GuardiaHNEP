package bbp;

import entity.AdministrarMedicamentos;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "administrarMedicamentosController")
@ViewScoped
public class AdministrarMedicamentosController extends AbstractController<AdministrarMedicamentos> {

    @Inject
    private EnfermeroController dniEnfermController;
    @Inject
    private PacienteController pacienteController;
    @Inject
    private MedicamentosController medicamentosController;

    public AdministrarMedicamentosController() {
        // Inform the Abstract parent controller of the concrete AdministrarMedicamentos?cap_first Entity
        super(AdministrarMedicamentos.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getAdministrarMedicamentosPK().setIdMedicamento(this.getSelected().getMedicamentos().getCodIdMedicamento());
        this.getSelected().getAdministrarMedicamentosPK().setDniPac(this.getSelected().getPaciente().getDNIPac());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setAdministrarMedicamentosPK(new entity.AdministrarMedicamentosPK());
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        dniEnfermController.setSelected(null);
        pacienteController.setSelected(null);
        medicamentosController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Enfermero controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareDniEnferm(ActionEvent event) {
        if (this.getSelected() != null && dniEnfermController.getSelected() == null) {
            dniEnfermController.setSelected(this.getSelected().getDniEnferm());
        }
    }

    /**
     * Sets the "selected" attribute of the Paciente controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void preparePaciente(ActionEvent event) {
        if (this.getSelected() != null && pacienteController.getSelected() == null) {
            pacienteController.setSelected(this.getSelected().getPaciente());
        }
    }

    /**
     * Sets the "selected" attribute of the Medicamentos controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareMedicamentos(ActionEvent event) {
        if (this.getSelected() != null && medicamentosController.getSelected() == null) {
            medicamentosController.setSelected(this.getSelected().getMedicamentos());
        }
    }
}

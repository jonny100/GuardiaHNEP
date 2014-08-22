package bbp;

import entity.ObraSocialPorPaciente;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "obraSocialPorPacienteController")
@ViewScoped
public class ObraSocialPorPacienteController extends AbstractController<ObraSocialPorPaciente> {

    @Inject
    private ObraSocialController obraSocialController;
    @Inject
    private PacienteController pacienteController;

    public ObraSocialPorPacienteController() {
        // Inform the Abstract parent controller of the concrete ObraSocialPorPaciente?cap_first Entity
        super(ObraSocialPorPaciente.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getObraSocialPorPacientePK().setPacienteDNIPac(this.getSelected().getPaciente().getDNIPac());
        this.getSelected().getObraSocialPorPacientePK().setObraSocialCodIdObraSocial(this.getSelected().getObraSocial().getCodIdObraSocial());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setObraSocialPorPacientePK(new entity.ObraSocialPorPacientePK());
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        obraSocialController.setSelected(null);
        pacienteController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the ObraSocial controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareObraSocial(ActionEvent event) {
        if (this.getSelected() != null && obraSocialController.getSelected() == null) {
            obraSocialController.setSelected(this.getSelected().getObraSocial());
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
}

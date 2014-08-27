package bbp;

import entity.GuardiasDiarias;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "guardiasDiariasController")
@ViewScoped
public class GuardiasDiariasController extends AbstractController<GuardiasDiarias> {

    @Inject
    private MedicosController medicosCollectionController;
    @Inject
    private EnfermeroController enfermeroCollectionController;
    @Inject
    private DiasController diasIddiasController;
    @Inject
    private MedicosController jefeServicioController;

    public GuardiasDiariasController() {
        // Inform the Abstract parent controller of the concrete GuardiasDiarias?cap_first Entity
        super(GuardiasDiarias.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        diasIddiasController.setSelected(null);
        jefeServicioController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Medicos entities that are
     * retrieved from GuardiasDiarias?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Medicos page
     */
    public String navigateMedicosCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Medicos_items", this.getSelected().getMedicosCollection());
        }
        return "/medicos/index";
    }

    /**
     * Sets the "items" attribute with a collection of Enfermero entities that
     * are retrieved from GuardiasDiarias?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Enfermero page
     */
    public String navigateEnfermeroCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Enfermero_items", this.getSelected().getEnfermeroCollection());
        }
        return "/enfermero/index";
    }

    /**
     * Sets the "selected" attribute of the Dias controller in order to display
     * its data in a dialog. This is reusing existing the existing View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareDiasIddias(ActionEvent event) {
        if (this.getSelected() != null && diasIddiasController.getSelected() == null) {
            diasIddiasController.setSelected(this.getSelected().getDiasIddias());
        }
    }

    /**
     * Sets the "selected" attribute of the Medicos controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareJefeServicio(ActionEvent event) {
        if (this.getSelected() != null && jefeServicioController.getSelected() == null) {
            jefeServicioController.setSelected(this.getSelected().getJefeServicio());
        }
    }
    
    public int obtenerHoraMinuto(Date dia) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(dia);
        return cal.get(Calendar.HOUR_OF_DAY);
    }
}

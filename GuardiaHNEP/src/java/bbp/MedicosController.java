package bbp;

import entity.Medicos;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "medicosController")
@ViewScoped
public class MedicosController extends AbstractController<Medicos> {

    @Inject
    private GuardiasDiariasController guardiasDiariasCollectionController;
    @Inject
    private CargoController cargoCollectionController;
    @Inject
    private GuardiasDiariasController guardiasDiariasCollection1Controller;
    @Inject
    private HistClinicaController histClinicaCollectionController;
    @Inject
    private EspecialidadController especialidadCodIdEspController;

    public MedicosController() {
        // Inform the Abstract parent controller of the concrete Medicos?cap_first Entity
        super(Medicos.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        especialidadCodIdEspController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of GuardiasDiarias entities
     * that are retrieved from Medicos?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for GuardiasDiarias page
     */
    public String navigateGuardiasDiariasCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("GuardiasDiarias_items", this.getSelected().getGuardiasDiariasCollection());
        }
        return "/guardiasDiarias/index";
    }

    /**
     * Sets the "items" attribute with a collection of Cargo entities that are
     * retrieved from Medicos?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Cargo page
     */
    public String navigateCargoCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Cargo_items", this.getSelected().getCargoCollection());
        }
        return "/cargo/index";
    }

    /**
     * Sets the "items" attribute with a collection of GuardiasDiarias entities
     * that are retrieved from Medicos?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for GuardiasDiarias page
     */
    public String navigateGuardiasDiariasCollection1() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("GuardiasDiarias_items", this.getSelected().getGuardiasDiariasCollection1());
        }
        return "/guardiasDiarias/index";
    }

    /**
     * Sets the "items" attribute with a collection of HistClinica entities that
     * are retrieved from Medicos?cap_first and returns the navigation outcome.
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
     * Sets the "selected" attribute of the Especialidad controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareEspecialidadCodIdEsp(ActionEvent event) {
        if (this.getSelected() != null && especialidadCodIdEspController.getSelected() == null) {
            especialidadCodIdEspController.setSelected(this.getSelected().getEspecialidadCodIdEsp());
        }
    }
}

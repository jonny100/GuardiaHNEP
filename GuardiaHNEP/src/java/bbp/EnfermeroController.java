package bbp;

import entity.Enfermero;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "enfermeroController")
@ViewScoped
public class EnfermeroController extends AbstractController<Enfermero> {

    @Inject
    private GuardiasDiariasController guardiasDiariasCollectionController;
    @Inject
    private AdministrarMedicamentosController administrarMedicamentosCollectionController;

    public EnfermeroController() {
        // Inform the Abstract parent controller of the concrete Enfermero?cap_first Entity
        super(Enfermero.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of GuardiasDiarias entities
     * that are retrieved from Enfermero?cap_first and returns the navigation
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
     * Sets the "items" attribute with a collection of AdministrarMedicamentos
     * entities that are retrieved from Enfermero?cap_first and returns the
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

}

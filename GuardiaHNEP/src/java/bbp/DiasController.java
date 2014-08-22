package bbp;

import entity.Dias;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "diasController")
@ViewScoped
public class DiasController extends AbstractController<Dias> {

    @Inject
    private GuardiasDiariasController guardiasDiariasCollectionController;

    public DiasController() {
        // Inform the Abstract parent controller of the concrete Dias?cap_first Entity
        super(Dias.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of GuardiasDiarias entities
     * that are retrieved from Dias?cap_first and returns the navigation
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

}

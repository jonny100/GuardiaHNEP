package bbp;

import entity.Medicamentos;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "medicamentosController")
@ViewScoped
public class MedicamentosController extends AbstractController<Medicamentos> {

    @Inject
    private AdministrarMedicamentosController administrarMedicamentosCollectionController;

    public MedicamentosController() {
        // Inform the Abstract parent controller of the concrete Medicamentos?cap_first Entity
        super(Medicamentos.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of AdministrarMedicamentos
     * entities that are retrieved from Medicamentos?cap_first and returns the
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

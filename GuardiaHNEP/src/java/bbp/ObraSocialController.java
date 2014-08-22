package bbp;

import entity.ObraSocial;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "obraSocialController")
@ViewScoped
public class ObraSocialController extends AbstractController<ObraSocial> {

    @Inject
    private ObraSocialPorPacienteController obraSocialPorPacienteCollectionController;

    public ObraSocialController() {
        // Inform the Abstract parent controller of the concrete ObraSocial?cap_first Entity
        super(ObraSocial.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of ObraSocialPorPaciente
     * entities that are retrieved from ObraSocial?cap_first and returns the
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

}

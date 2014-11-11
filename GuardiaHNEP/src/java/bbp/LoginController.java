package bbp;

import entity.Login;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import org.jboss.weld.context.RequestContext;

@Named(value = "loginController")
@ViewScoped
public class LoginController extends AbstractController<Login> {

    @EJB
    private sbp.LoginFacade ejbFacade;
    private List<Login> lst_l = new ArrayList();
    private String username;
    private String password;
    private static String user;

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        LoginController.user = user;
    }

    public LoginController() {
        // Inform the Abstract parent controller of the concrete Servicios?cap_first Entity
        super(Login.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of HistClinica entities that
     * are retrieved from Servicios?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for HistClinica page
     */
    
    public String controlLogin(){
        lst_l = ejbFacade.findAll();
        boolean ok = false;
        Iterator itera = lst_l.listIterator();
        while (itera.hasNext()) {
            Login l = (Login) itera.next();
            if(l.getUsername().equals(username) & l.getPassword().equals(password)){
                ok = true;
                user = username;
                break;
            }            
    }
        if(ok){
            return "home.xhtml?faces-redirect=true";
        }else{
            org.primefaces.context.RequestContext.getCurrentInstance().update("growl");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Usuario o Contraseña Incorrectos"));
            return "";
        }

}

    public List<Login> getLst_l() {
        return lst_l;
    }

    public void setLst_l(List<Login> lst_l) {
        this.lst_l = lst_l;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
}
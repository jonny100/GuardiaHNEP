package converter;

import entity.ObraSocialPorPaciente;
import sbp.ObraSocialPorPacienteFacade;
import bbp.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "obraSocialPorPacienteConverter")
public class ObraSocialPorPacienteConverter implements Converter {

    @Inject
    private ObraSocialPorPacienteFacade ejbFacade;

    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.ejbFacade.find(getKey(value));
    }

    entity.ObraSocialPorPacientePK getKey(String value) {
        entity.ObraSocialPorPacientePK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new entity.ObraSocialPorPacientePK();
        key.setPacienteDNIPac(Integer.parseInt(values[0]));
        key.setObraSocialCodIdObraSocial(Integer.parseInt(values[1]));
        return key;
    }

    String getStringKey(entity.ObraSocialPorPacientePK value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value.getPacienteDNIPac());
        sb.append(SEPARATOR);
        sb.append(value.getObraSocialCodIdObraSocial());
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof ObraSocialPorPaciente) {
            ObraSocialPorPaciente o = (ObraSocialPorPaciente) object;
            return getStringKey(o.getObraSocialPorPacientePK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ObraSocialPorPaciente.class.getName()});
            return null;
        }
    }

}

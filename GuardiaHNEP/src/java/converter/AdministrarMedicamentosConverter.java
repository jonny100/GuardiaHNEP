package converter;

import entity.AdministrarMedicamentos;
import sbp.AdministrarMedicamentosFacade;
import bbp.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "administrarMedicamentosConverter")
public class AdministrarMedicamentosConverter implements Converter {

    @Inject
    private AdministrarMedicamentosFacade ejbFacade;

    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.ejbFacade.find(getKey(value));
    }

    entity.AdministrarMedicamentosPK getKey(String value) {
        entity.AdministrarMedicamentosPK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new entity.AdministrarMedicamentosPK();
        key.setIdMedicamento(Integer.parseInt(values[0]));
        key.setDniPac(Integer.parseInt(values[1]));
        return key;
    }

    String getStringKey(entity.AdministrarMedicamentosPK value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value.getIdMedicamento());
        sb.append(SEPARATOR);
        sb.append(value.getDniPac());
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof AdministrarMedicamentos) {
            AdministrarMedicamentos o = (AdministrarMedicamentos) object;
            return getStringKey(o.getAdministrarMedicamentosPK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), AdministrarMedicamentos.class.getName()});
            return null;
        }
    }

}

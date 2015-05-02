package br.com.saaes.converter;


import br.com.saaes.app.util.JsfUtil;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.persistence.EmbeddedId;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 *
 * @author Jean
 */
public class GenericConvert implements Converter {

    private final Class<?> clazz;
    private final Class<?> clazzId;
    private EntityManager em;

    public GenericConvert(Class<?> clazz, Class<?> clazzId) {
        this.clazz = clazz;
        this.clazzId = clazzId;
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
      

            try {
                  if (value != null && !value.equals("")) {
                     return this.getEm().find(clazz, clazzId.getConstructor(String.class).newInstance(value));
                  }
            } catch (Throwable e) {
                throw  new IllegalArgumentException(" Erro "+e.getMessage());
            }
             return null;
        }
    

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        if (value != null && !value.equals("")) {
            for (Field field : clazz.getDeclaredFields()) {
                try {
                    Object id;//id a recuperar
                    if (field.isAnnotationPresent(Id.class) || field.isAnnotationPresent(EmbeddedId.class) || field.isAnnotationPresent(IdClass.class)) {
                        Field pField = field;
                        pField.setAccessible(true);

                        id = pField.get(value);
                        if (id != null) {
                            return id.toString();
                        }
                    }
                } catch (IllegalArgumentException | IllegalAccessException ex) {
                    Logger.getLogger(GenericConvert.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }

    public EntityManager getEm() {
        if(em == null){
         return  JsfUtil.getEm();
        }
        return em;
    }

    

    

}

package br.com.saaes.converter;

import br.com.saaes.modelo.T200ies;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.FacesConverter;

@RequestScoped
@ManagedBean
@FacesConverter(forClass = T200ies.class)

public class T200IesConverter extends GenericConvert {

    public T200IesConverter() {
        super(T200ies.class, Long.class);
    }

}

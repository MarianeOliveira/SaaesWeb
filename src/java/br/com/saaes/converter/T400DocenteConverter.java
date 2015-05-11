package br.com.saaes.converter;

import br.com.saaes.modelo.T400docente;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Jean
 */
@RequestScoped
@ManagedBean
@FacesConverter(forClass = T400docente.class)

public class T400DocenteConverter extends GenericConvert{

    public T400DocenteConverter() {
        super(T400docente.class, Long.class);
    }
}
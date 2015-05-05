package br.com.saaes.converter;

import br.com.saaes.modelo.T904vinculoempregaticio;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Jean
 */
@RequestScoped
@ManagedBean
@FacesConverter(forClass = T904vinculoempregaticio.class)

public class T904VinculoEmpregaticioConverter extends GenericConvert{

    public T904VinculoEmpregaticioConverter() {
        super(T904vinculoempregaticio.class, Integer.class);
    }
}
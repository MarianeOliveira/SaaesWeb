package br.com.saaes.converter;

import br.com.saaes.modelo.T903regimetrabalho;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Jean
 */
@RequestScoped
@ManagedBean
@FacesConverter(forClass = T903regimetrabalho.class)

public class T903RegimeTrabalhoConverter extends GenericConvert{

    public T903RegimeTrabalhoConverter() {
        super(T903regimetrabalho.class, Integer.class);
    }
}
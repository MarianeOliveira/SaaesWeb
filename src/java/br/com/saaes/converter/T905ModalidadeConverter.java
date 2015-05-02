package br.com.saaes.converter;

import br.com.saaes.modelo.T905modalidade;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Jean
 */
@RequestScoped
@ManagedBean
@FacesConverter(forClass = T905modalidade.class)

public class T905ModalidadeConverter extends GenericConvert{

    public T905ModalidadeConverter() {
        super(T905modalidade.class, Integer.class);
    }
}

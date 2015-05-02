package br.com.saaes.converter;

import br.com.saaes.modelo.T902titulacao;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Jean
 */
@RequestScoped
@ManagedBean
@FacesConverter(forClass = T902titulacao.class)

public class T902TitulacaoConverter extends GenericConvert{

    public T902TitulacaoConverter() {
        super(T902titulacao.class, Long.class);
    }
}
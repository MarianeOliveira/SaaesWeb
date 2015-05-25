package br.com.saaes.converter;

import br.com.saaes.modelo.T906tipoato;
import javax.faces.bean.ManagedBean;
import javax.faces.convert.FacesConverter;

@ManagedBean
@FacesConverter(forClass = T906tipoato.class)

public class T906TipoAtoConverter extends GenericConvert{

    public T906TipoAtoConverter() {
        super(T906tipoato.class, Integer.class);
    }
}

package br.com.saaes.converter;

import br.com.saaes.modelo.T300cursos;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.FacesConverter;


@RequestScoped
@ManagedBean
@FacesConverter(forClass = T300cursos.class)

public class T300CursoConverter extends GenericConvert{

    public T300CursoConverter() {
        super(T300cursos.class, Long.class);
    }
}
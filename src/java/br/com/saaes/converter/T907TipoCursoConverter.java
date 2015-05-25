package br.com.saaes.converter;

import br.com.saaes.modelo.T907tipocurso;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.FacesConverter;

@RequestScoped
@ManagedBean
@FacesConverter(forClass = T907tipocurso.class)

public class T907TipoCursoConverter extends GenericConvert{

    public T907TipoCursoConverter() {
        super(T907tipocurso.class, Integer.class);
    }
}
package br.com.saaes.converter;

import br.com.saaes.modelo.T901conceitos;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.FacesConverter;

@RequestScoped
@ManagedBean
@FacesConverter(forClass = T901conceitos.class)

public class T901ConceitosConverter extends GenericConvert{

    public T901ConceitosConverter() {
        super(T901conceitos.class, Integer.class);
    }
}
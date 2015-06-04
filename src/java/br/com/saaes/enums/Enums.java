/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.saaes.enums;

import java.lang.reflect.Field;

/**
 *
 * @author 
 */

public enum Enums {
    PARCIAL(2),
    INTEGRAL(1),
    HORISTA(3),
    
    GRADUACAO(1),
    ESPECIALISTA(2),
    MESTRE(3),
    DOUTOR(4),
    
    CLT(1),
    ESTATUTARIO(2),
    OUTRO(3),
    
    PRESENCIAL(1),
    SEMI_PRESENCIAL(2),
    A_DISTANCIA(3),
       
    AUTORIZACAO(1),
    RECONHECIMENTO(2),
    RENOVACAO(3),
    
    BACHARELADO(1),
    LICENCIATURA(2),
    TECNOLOGO(3),  
    
    MEDICINA(4)
    ;

    private final Integer id;
    
    private Enums(Integer value){
        try {
            this.id = value;
            final Field ordinalField = this.getClass().getSuperclass().getDeclaredField("ordinal");
            ordinalField.setAccessible(true);
            ordinalField.set(this, value);
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static Enums valueOf(Integer id){
        for( Enums e : Enums.values() ){
            if ( e.getId().equals(id))
                return e;
        }
        return null;
    }

    public Integer getId() {
        return id;
    }
    
    @Override
    public String toString(){
        return this.getId().toString();
    }

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.org.cjpb.demo.interprete.jackson;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 *
 * @author rodo
 */
@JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include=JsonTypeInfo.As.PROPERTY, property="type")
public interface IComponentValue2 {
    
    
}

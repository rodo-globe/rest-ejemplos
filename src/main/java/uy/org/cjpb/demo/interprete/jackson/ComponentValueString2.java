/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.org.cjpb.demo.interprete.jackson;

import uy.org.cjpb.demo.interprete.*;

/**
 *
 * @author rodo
 */
public class ComponentValueString2 implements IComponentValue2{
    
    private String value;

    public ComponentValueString2() {
        
    }
    
    public ComponentValueString2(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    
}

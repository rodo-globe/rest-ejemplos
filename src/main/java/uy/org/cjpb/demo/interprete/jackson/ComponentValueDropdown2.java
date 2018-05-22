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
public class ComponentValueDropdown2 implements IComponentValue2 {
    
    private int value;
    private String label;

    public ComponentValueDropdown2() {
        
    }

    
    public ComponentValueDropdown2(int value, String label) {
        this.value = value;
        this.label = label;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    
}

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
public class ComponentValueInt2 implements IComponentValue2{
    
    private int value;

    public ComponentValueInt2() {
        
    }

    
    public ComponentValueInt2(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
}

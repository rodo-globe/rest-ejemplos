/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.org.cjpb.demo.interprete;

/**
 *
 * @author rodo
 */
public class ComponentValueInt implements IComponentValue{
    
    private int value;

    public ComponentValueInt() {
        
    }

    
    public ComponentValueInt(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
}

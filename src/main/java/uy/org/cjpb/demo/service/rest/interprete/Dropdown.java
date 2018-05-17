/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.org.cjpb.demo.service.rest.interprete;

import uy.org.cjpb.demo.service.rest.interprete.Option;

/**
 *
 * @author rodo
 */
public class Dropdown implements IComponent{
    
    private String id;
    private Option[] options;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Option[] getOptions() {
        return options;
    }

    public void setOptions(Option[] options) {
        this.options = options;
    }
    
    
}

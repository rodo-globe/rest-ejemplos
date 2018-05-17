/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.org.cjpb.demo.service.rest;

/**
 *
 * @author rodo
 */
public class Input implements IComponent{

    public static String TYPE_STRING = "string";  
    public static String TYPE_NUMBER = "number";  
    
    private String id;
    private String dataType;

    public Input() {
        
    }
    
    public Input(String id, String dataType) {
        this.id = id;
        this.dataType = dataType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
    
    
}

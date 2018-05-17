/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.org.cjpb.demo.service.rest;

import uy.org.cjpb.demo.service.rest.interprete.ComponentValueString;
import uy.org.cjpb.demo.service.rest.interprete.IComponent;
import uy.org.cjpb.demo.service.rest.interprete.IComponentValue;
import uy.org.cjpb.demo.service.rest.interprete.Dropdown;
import uy.org.cjpb.demo.service.rest.interprete.ComponentValueInt;
import uy.org.cjpb.demo.service.rest.interprete.Input;
import uy.org.cjpb.demo.service.rest.interprete.ComponentValueDropdown;
import uy.org.cjpb.demo.service.rest.interprete.Option;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author rodo
 */
@Path("components")
public class InterpreterService {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<IComponent> getComponents(){
    
        List<IComponent> components = new ArrayList<>();
        
        Input i1 = new Input("name", Input.TYPE_STRING);
        Input i2 = new Input("surname", Input.TYPE_STRING);
        Dropdown d1 = loadCities("adress_city");
        Input i3 = new Input("address_street", Input.TYPE_STRING);
        Input i4 = new Input("age", Input.TYPE_NUMBER);
        
        components.add(i1);
        components.add(i2);
        components.add(d1);
        components.add(i3);
        components.add(i4);
        
        return components;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void processPageSubmit(List<IComponentValue> values){
    
        values.forEach( v -> {
        
            if(v instanceof ComponentValueInt){
                
                int value = ((ComponentValueInt) v).getValue();
                
                System.out.println(" I'm an int value " + value);
            }
            
            if(v instanceof ComponentValueString){
                
                String value = ((ComponentValueString) v).getValue();
                
                System.out.println(" I'm a string value " + value);
            }
            
            if(v instanceof ComponentValueDropdown){
                
                int value = ((ComponentValueDropdown) v).getValue();
                String label = ((ComponentValueDropdown) v).getLabel();
                
                System.out.println(" I'm a Dropdown !!!  int value " + value + " label " + label );
            }
        });
    } 
    
    
    private Dropdown loadCities(String id){
    
        Dropdown d1 = new Dropdown();
        d1.setId(id);
        
        Option o1 = new Option(1, "Montevideo");
        Option o2 = new Option(2, "Canelones");
        Option o3 = new Option(3, "Maldonado");
        Option o4 = new Option(3, "Rocha");
        
        Option[] options = {o1, o2, o3, o4};
        
        d1.setOptions(options);
        
        return d1;
    }
}

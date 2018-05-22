/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.org.cjpb.demo.service.rest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import uy.org.cjpb.demo.interprete.ComponentValueDropdown;
import uy.org.cjpb.demo.interprete.Option;
import uy.org.cjpb.demo.interprete.jackson.ComponentValueInt2;
import uy.org.cjpb.demo.interprete.jackson.ComponentValueString2;
import uy.org.cjpb.demo.interprete.jackson.Dropdown2;
import uy.org.cjpb.demo.interprete.jackson.IComponent2;
import uy.org.cjpb.demo.interprete.jackson.IComponentValue2;
import uy.org.cjpb.demo.interprete.jackson.Input2;

/**
 *
 * @author rodo
 */
@Path("components2")
public class InterpreterService2 {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<IComponent2> getComponents(){
    
        List<IComponent2> components = new ArrayList<>();
        
        Input2 i1 = new Input2("name", Input2.TYPE_STRING);
        i1.setFecha(LocalDate.now());
        Input2 i2 = new Input2("surname", Input2.TYPE_STRING);
        Dropdown2 d1 = loadCities("adress_city");
        Input2 i3 = new Input2("address_street", Input2.TYPE_STRING);
        Input2 i4 = new Input2("age", Input2.TYPE_NUMBER);
        
        components.add(i1);
        components.add(i2);
        components.add(d1);
        components.add(i3);
        components.add(i4);
        
        return components;
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void processPageSubmit(List<IComponentValue2> values){
    
        values.forEach( v -> {
        
            if(v instanceof ComponentValueInt2){
                
                int value = ((ComponentValueInt2) v).getValue();
                
                System.out.println(" I'm an int value " + value);
            }
            
            if(v instanceof ComponentValueString2){
                
                String value = ((ComponentValueString2) v).getValue();
                
                System.out.println(" I'm a string value " + value);
            }
            
            if(v instanceof ComponentValueDropdown){
                
                int value = ((ComponentValueDropdown) v).getValue();
                String label = ((ComponentValueDropdown) v).getLabel();
                
                System.out.println(" I'm a Dropdown !!!  int value " + value + " label " + label );
            }
        });
    } 
    
    
    private Dropdown2 loadCities(String id){
    
        Dropdown2 d1 = new Dropdown2();
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

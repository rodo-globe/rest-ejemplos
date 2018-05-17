/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.org.cjpb.demo.mbreader;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;
import uy.org.cjpb.demo.interprete.ComponentValueDropdown;
import uy.org.cjpb.demo.interprete.ComponentValueString;
import uy.org.cjpb.demo.interprete.IComponentValue;

/**
 *
 * @author rodo
 */
@Provider
@Consumes("application/json")
public class ValuesListReader implements MessageBodyReader<List<IComponentValue>>{

    @Override
    public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return true;
    }

    @Override
    public List<IComponentValue> readFrom(Class<List<IComponentValue>> type, Type genericType, Annotation[] annotations, MediaType mediaType, 
            MultivaluedMap<String, String> httpHeaders, InputStream entityStream) throws IOException, WebApplicationException {
        
        List<Object> components = null;
        List<IComponentValue> componentsList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        
        components = mapper.readValue(entityStream, List.class);
        
        components.forEach( c -> {
        
            LinkedHashMap hmap = (LinkedHashMap) c;
            Object labelObj = hmap.get("label");
            
            if(labelObj != null){
            
                Integer value = (Integer)hmap.get("value");
                String label = (String) labelObj;
                
                componentsList.add(new ComponentValueDropdown(value, label));
            }
        });
        
        return null;
    }
    
}

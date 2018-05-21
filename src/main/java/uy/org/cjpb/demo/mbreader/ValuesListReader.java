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
import javax.json.Json;
import javax.json.stream.JsonParser;
import uy.org.cjpb.demo.interprete.ComponentValueDropdown;
import uy.org.cjpb.demo.interprete.ComponentValueInt;
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

//    @Override
//    public List<IComponentValue> readFrom(Class<List<IComponentValue>> type, Type genericType, Annotation[] annotations, MediaType mediaType, 
//            MultivaluedMap<String, String> httpHeaders, InputStream entityStream) throws IOException, WebApplicationException {
//        
//        List<Object> components = null;
//        List<IComponentValue> componentsList = new ArrayList<>();
//        ObjectMapper mapper = new ObjectMapper();
//        
//        components = mapper.readValue(entityStream, List.class);
//        
//        components.forEach( c -> {
//        
//            LinkedHashMap hmap = (LinkedHashMap) c;
//            Object labelObj = hmap.get("label");
//            
//            if(labelObj != null){
//            
//                Integer value = (Integer)hmap.get("value");
//                String label = (String) labelObj;
//                
//                componentsList.add(new ComponentValueDropdown(value, label));
//            }else{
//            
//                Object valueObj = hmap.get("value");
//                if(valueObj instanceof String){
//                
//                    String value = (String) valueObj;
//                    componentsList.add(new ComponentValueString(value));
//                }else if(valueObj instanceof Integer){
//                
//                    Integer value = (Integer) valueObj;
//                    componentsList.add(new ComponentValueInt(value));
//                }
//                
//            }
//        });
//        
//        return componentsList;
//    }
    
      @Override
    public List<IComponentValue> readFrom(Class<List<IComponentValue>> type, Type genericType, Annotation[] annotations, MediaType mediaType, 
            MultivaluedMap<String, String> httpHeaders, InputStream entityStream) throws IOException, WebApplicationException {
        
        List<Object> components = null;
        List<IComponentValue> componentsList = new ArrayList<>();
        
        JsonParser parser = Json.createParser(entityStream);
        
        while(parser.hasNext()){
            JsonParser.Event event = parser.next();
            switch(event){
                case KEY_NAME:
                    String keyName = parser.getString();
                    
                    event = parser.next();
                    
                    if("value".equalsIgnoreCase(keyName)){
                    
                        if(event == event.VALUE_STRING){

                             componentsList.add(new ComponentValueString(parser.getString()));
                             
                        }else if(event == event.VALUE_NUMBER) {
                            Integer value = parser.getInt();
                            event = parser.next();
                            if(event == event.KEY_NAME && "label".equalsIgnoreCase(parser.getString())){
                                //It's a dropdown
                                
                                parser.next();
                                componentsList.add(new ComponentValueDropdown( value, parser.getString()));
                            }else{
                            
                                componentsList.add(new ComponentValueInt(value));
                            }
                        }
                    }
            }
            
        }
        return componentsList;
    }
    
}

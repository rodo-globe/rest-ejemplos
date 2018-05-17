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
import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;
import uy.org.cjpb.demo.interprete.IComponentValue;

/**
 *
 * @author rodo
 */
@Provider
@Consumes("application/json")
public class ValuesReader implements MessageBodyReader<IComponentValue>{

    @Override
    public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return true;
    }

    @Override
    public IComponentValue readFrom(Class<IComponentValue> type, Type genericType, Annotation[] annotations, 
            MediaType mediaType, MultivaluedMap<String, String> httpHeaders, InputStream entityStream) throws IOException, WebApplicationException {
        
        IComponentValue component = null;
        ObjectMapper mapper = new ObjectMapper();
        
        component = mapper.readValue(entityStream, IComponentValue.class);
        
        return component;
    }
    
}

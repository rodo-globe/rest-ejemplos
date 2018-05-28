/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.org.cjpb.demo.shape;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author rodo
 */
@Provider
public class ColorConverterProvider implements ParamConverterProvider {

    @Override
    public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, Annotation[] annotations) {

        if (!rawType.equals(Color.class)) {
            return null;
        }

        return new ParamConverter<T>() {
            @Override
            public T fromString(String value) {

                ColorConverter cc = new ColorConverter();
                return rawType.cast(cc.fromString(value));
            }

            @Override
            public String toString(T value) {

                if (value == null) {
                    return null;
                }
                
                ColorConverter cc = new ColorConverter();
                return cc.toString((Color) value);                
            }
        };
    }
}

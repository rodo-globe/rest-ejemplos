/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.org.cjpb.demo.service.rest;

import com.itextpdf.text.Jpeg;
import java.util.List;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.PathSegment;
import uy.org.cjpb.demo.shape.Color;

/**
 *
 * @author rodow
 */
@Path("/mercedes")
public class MercedesService {
    
    /*@GET
    @Path("/e55/{year}")
    @Produces("image/jpeg")
    public Jpeg getE55Picture(@PathParam("year") String year, @QueryParam("page") int page, 
            @MatrixParam("color") String color, @MatrixParam("automatic") Boolean automcatic){
    
        return null;
    }*/
    
    //http://example.cars.com/mercedes/e55;color=black;automatic=true/2006?page=1
    
    @GET
    @Path("/{model:e55}/{year}")
    @Produces("image/jpeg")
    public Jpeg getE55Picture(@PathParam("model") PathSegment e55, @PathParam("year") String year, @QueryParam("page") int page){
            //@MatrixParam("color") String color, @MatrixParam("automatic") Boolean automcatic){
    
        MultivaluedMap<String, String> matrix = e55.getMatrixParameters();
        List<String> colors = matrix.get("color");
        if(colors != null)
        colors.forEach( c -> System.out.println("color " + c));
        
        List<String> automatics = matrix.get("automatic");
        if(automatics != null)
        automatics.forEach( a -> System.out.println("authomatic " + a));    
        
        return null;
    }
    
    @GET
    @Path("/clase-C")
    public Jpeg getClaseC(@MatrixParam("color") Color color){
    
        System.out.println("Clase C color " + color.getColor());
        
        return null;
    }
    
}





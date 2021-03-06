/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.org.cjpb.demo.service.rest;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Response;

/**
 *
 * @author rodo
 */
@Path("/store")
public class StoreService {
    
    
    //http://store.com/categories;name=clothes/product;name=shirt;color=red?page=1;

    @GET
    @Path("/{cat:categories}/product")
    public Response getProductsByCategory(@PathParam("cat") PathSegment categories, 
            @MatrixParam("name") String name, @MatrixParam("color") String color, @QueryParam("page") int page){
        
        MultivaluedMap<String, String> matrix = categories.getMatrixParameters();
        List<String> names = matrix.get("name");
        if(names != null){
            names.forEach( c -> System.out.println("category name " + c));
        }
        
        System.out.println("product name " + name);
        System.out.println("product color " + color);
        
        System.out.println("page " + page);
        
        return Response.ok().build();
    }
    
    @GET
    @Path("/products")
    public Response getProducts(@QueryParam("start") int start, @QueryParam("size") int size, @QueryParam("orderBy") List<String> orderBy){
    
            System.out.println("product start " + start);
            System.out.println("product size " + size);
            System.out.println("product orderBy " );
            orderBy.forEach( o -> System.out.println(o));
        
            return Response.ok().build();        
    }
    
}

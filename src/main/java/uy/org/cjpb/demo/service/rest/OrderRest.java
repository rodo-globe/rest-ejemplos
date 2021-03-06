/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.org.cjpb.demo.service.rest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.jboss.logging.Logger;
import uy.org.cjpb.demo.dto.OrderDto;

/**
 *
 * @author rodo
 */

@Path("/orders")
public class OrderRest {
    
    List<OrderDto> orderList = new ArrayList<>();
    
    public OrderRest(){
    
        OrderDto dto = new OrderDto();
        dto.setAmount(new BigDecimal(100));
        dto.setId(1);
        dto.setCustomerName("Juan Perez");
       
        orderList.add(dto);
        
        OrderDto dto2 = new OrderDto();
        dto2.setAmount(new BigDecimal(200));
        dto2.setId(2);
        dto2.setCustomerName("Maria Lopez");
        
        orderList.add(dto2); 
        
        OrderDto dto3 = new OrderDto();
        dto3.setAmount(new BigDecimal(200));
        dto3.setId(3);
        dto3.setCustomerName("Laura Lopez");
        
        orderList.add(dto3); 
    }
        
    @GET
    @Path("{id}")  
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public OrderDto getOrder(@PathParam("id") int id){
        
        Logger.getLogger(this.getClass(), "ejecutó getOrder( " + id + " )");
        
        return orderList.stream()
                .filter( o -> o.getId() == id)
                .findFirst().get();
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<OrderDto> finByParams(@QueryParam("name") String name){
    
        Logger.getLogger(this.getClass(), "ejecutó findByParams( " +name + " )");
         
        if(name == null || name.isEmpty()){
            return orderList;
        }else{
            return orderList.stream()
                .filter(o -> o.getCustomerName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
        }
    }
    
    @PUT
    @Path("{id}") 
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void update(@PathParam("id") int id, OrderDto order){
        
         Logger.getLogger(this.getClass(), "ejecutó update "); 
    }
    
    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") int id){
        
         Logger.getLogger(this.getClass(), "ejecutó delete ");     
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public OrderDto insert(OrderDto order){
        
         Logger.getLogger(this.getClass(), "ejecutó insert ");    
         order.setId(999);
         return order;
    }    
}


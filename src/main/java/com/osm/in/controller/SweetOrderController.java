package com.osm.in.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinesweetmart.entity.SweetOrder;
import com.onlinesweetmart.service.SweetOrderService;

@RestController
@RequestMapping("/sweetorder")
public class SweetOrderController {

	
	@Autowired
    private SweetOrderService sweetOrderService;
    
    @PostMapping("/addsweetorder")
    public ResponseEntity<SweetOrder>  addSweetOrder(@RequestBody SweetOrder sweetOrder) {
                   
                   return new ResponseEntity<SweetOrder>(sweetOrderService.addSweetOrder(sweetOrder), HttpStatus.CREATED) ;
    }

    @PutMapping("/updatesweetorder")
    public  ResponseEntity<SweetOrder> updateSweetOrder(@RequestBody SweetOrder sweetOrder) {
                   
                   return new ResponseEntity<SweetOrder>(sweetOrderService.updateSweetOrder(sweetOrder), HttpStatus.CREATED);
    }

    @DeleteMapping("/cancelsweetorder/{sweetOrderId}")
    public  ResponseEntity<SweetOrder> cancelSweetOrder(@PathVariable int sweetOrderId) {
                   
                  return new ResponseEntity<SweetOrder>(sweetOrderService.cancelSweetOrder(sweetOrderId), HttpStatus.ACCEPTED) ;
    }

    @GetMapping("/showallsweetorder")
    public  ResponseEntity<List<SweetOrder>> showAllSweetOrders() {
                   
                   return new ResponseEntity<List<SweetOrder>>(sweetOrderService.showAllSweetOrders(), HttpStatus.CREATED);
    }

   // @GetMapping("/sweetorder/{sweetOrderId}")
    //public ResponseEntity<Double>  calculateTotalCost(@PathVariable int sweetOrderId) {
                   
            //       return null;
    }


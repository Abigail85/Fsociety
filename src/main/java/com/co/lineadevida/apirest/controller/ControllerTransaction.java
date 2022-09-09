package com.co.lineadevida.apirest.controller;

import com.co.lineadevida.apirest.repository.EntityEmployee;
import com.co.lineadevida.apirest.repository.EntityEnterprise;
import com.co.lineadevida.apirest.repository.EntityTransaction;
import com.co.lineadevida.apirest.services.ServicesEmployee;
import com.co.lineadevida.apirest.services.ServicesEnterprise;
import com.co.lineadevida.apirest.services.ServicesTransaction;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Transaction",description = "Metodos para el api transaction")
@RestController
@RequestMapping(value ="/lineadevida/Transaction")
public class ControllerTransaction {

    @Autowired
    ServicesTransaction servicesTransaction;

    @Autowired
    ServicesEnterprise servicesEnterprise;

    @ApiOperation(value = "End point to list Transaction ")
    @GetMapping(path = "/listTransaction",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listTransaction(){
        return new ResponseEntity<Object>(servicesTransaction.toList(), HttpStatus.OK) ;
    }

    @ApiOperation(value = "End point insert Transaction")
    @PostMapping(path = "/Enterprise/{id}/insertTransaction",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean>insertTransaction(@RequestBody EntityTransaction transaction, EntityEnterprise id){

        return new ResponseEntity<Boolean>(servicesTransaction.insertTransaction(transaction,id),HttpStatus.OK);
    }

    @ApiOperation(value = "End ponit search transaction")
    @GetMapping(path = "/searchTransaction/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> searchTransaction(@PathVariable Long id){
        return new ResponseEntity<Object>(servicesTransaction.searchTransaction(id), HttpStatus.OK) ;
    }

    @ApiOperation(value = "End ponit edit transaction")
    @GetMapping(path = "/editTransaction/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> editTransaction(@RequestBody EntityTransaction transaction){
        return new ResponseEntity<Object>(servicesTransaction.editTransaction(transaction), HttpStatus.OK) ;
    }

    @ApiOperation(value = "End ponit delete transaction")
    @GetMapping(path = "/deleteTransaction/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deleteTransaction(@RequestBody EntityTransaction transaction){
        return new ResponseEntity<Object>(servicesTransaction.deleteTransaction(transaction), HttpStatus.OK) ;
    }

}
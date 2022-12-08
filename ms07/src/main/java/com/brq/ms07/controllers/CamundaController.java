package com.brq.ms07.controllers;

import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CamundaController {

    @Autowired
    private RuntimeService runtimeService;

    @GetMapping("processa-idade/{idade}")
    public ResponseEntity<Void> processaIdade(@PathVariable Integer idade){

        this.runtimeService
                .createProcessInstanceByKey("processa-idade")
                .setVariable("idade", idade)
                .execute();

        return ResponseEntity.ok().build();
    }
}
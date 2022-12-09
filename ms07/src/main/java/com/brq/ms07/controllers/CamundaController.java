package com.brq.ms07.controllers;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class CamundaController {

    @Autowired
    private RuntimeService runtimeService;

    @GetMapping ("processa-idade/{idade}")
    public ResponseEntity<Void> processaIdade(@PathVariable Integer idade){

        log.info("Controller");

        final var id = this.runtimeService
                .createProcessInstanceByKey("processa-idade")
                .setVariable("idade", idade)
                .execute()
                .getProcessInstanceId();

        log.info("ID do processo : {}", id);

        return ResponseEntity.ok().build();
    }
}
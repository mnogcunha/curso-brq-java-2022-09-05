package com.brq.ms07.delegates;
import javax.inject.Named;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Named("processaIdade")
public class ProcessarIdadeDelegate implements JavaDelegate{

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        log.info("Processar idade......");

    }
}
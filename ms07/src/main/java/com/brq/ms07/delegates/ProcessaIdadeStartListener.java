package com.brq.ms07.delegates;

import javax.inject.Named;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Named("processaIdadeStartListener")
public class ProcessaIdadeStartListener
        implements ExecutionListener{

    @Override
    public void notify(DelegateExecution execution) throws Exception {
        log.info("Start Listener Processa Idade");
    }
}
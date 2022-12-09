package com.brq.ms07.delegates;

import javax.inject.Named;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

import com.brq.ms07.models.CadastroModel;
import com.brq.ms07.services.ICadastroService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Named("reprovarCadastro")
public class ReprovarCadastroDelegate
        implements JavaDelegate{

    @Autowired
    private ICadastroService service;

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        final var idade = (Integer) execution.getVariable("idade");

        log.info("Reprovar Cadastro : idade {}", idade);

        CadastroModel model = new CadastroModel();
        model.setIdade(idade);

        service.create(model);
    }
}
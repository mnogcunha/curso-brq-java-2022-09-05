package com.brq.ms01.controllers;

import com.brq.ms01.dtos.FinanciamentoDTO;
import com.brq.ms01.dtos.FinanciamentoNewDTO;
import com.brq.ms01.services.FinanciamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class FinanciamentoController {

    // private FinanciamentoService finServ = new FinanciamentoService(); (usado conforme abaixo)
    // @Autowired é importante pois permite que o Spring "instancie" o objeto do tipo FinanciamentoService
    @Autowired
    private FinanciamentoService finServ;

    // O @GetMapping permite associoar o verbo GET com a rota /financiamentos
    @GetMapping("financiamentos")
    public List<FinanciamentoDTO> getAllFinanciamentos() {

        finServ.mostrarMensagemService();
        return finServ.getAllFinanciamentos();
    }

    // O @PostMapping permite associar o verbo POST com a rota /financiamentos
    @PostMapping("financiamentos")
    public FinanciamentoDTO create(@Valid @RequestBody FinanciamentoNewDTO financiamento) {
        //   UsuarioModel u = usuServ.create(usuario)
        return finServ.create(financiamento);
    }

    // O @PatchMapping permite associar o verbo PATCH com a rota /usuarios/{id}
    @PatchMapping("financiamentos/{id}")
    public FinanciamentoDTO update(@RequestBody FinanciamentoDTO financiamentoBody, @PathVariable int id ) {
        //        UsuarioModel u = usuService.update(id, usuarioBody);
        //        return u;
        return finServ.update(id, financiamentoBody);
    }

    // O @DeleteMapping permite associar o verbo DELETE com a rota /usuarios/{id}
    @DeleteMapping("financiamentos/{id}")
    public String delete(@PathVariable int id) {
        //String response = usuService.delete(id);
        //return response;
        return finServ.delete(id);
    }

    // O @GetMapping permite associoar o verbo GET(getOne) com a rota /usuarios/{id}
    // busca por apenas um usuário (pelo id)
    @GetMapping("financiamentos/{id}")
    public FinanciamentoDTO getOne(@PathVariable int id) {
        //        FinanciamentoModel u = finService.getOne(id);
        //        return u;
        //
        return finServ.getOne(id);
    }
}
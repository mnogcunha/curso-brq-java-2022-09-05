package com.brq.ms01.services;

import com.brq.ms01.dtos.FinanciamentoDTO;
import com.brq.ms01.models.FinanciamentoModel;
import com.brq.ms01.repositories.FinanciamentoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class FinanciamentoService {

    // Este ArrayList é didático, pois está simulando um banco de dados
    //private ArrayList<FinanciamentoModel> financiamentos = new ArrayList<>();
    //private int counter = 1;

    @Autowired
    private FinanciamentoRepository finRepository;

    public void mostrarMensagemService() {
        System.out.println("Mensagem do servico");
    }

    // Uso do verbo GET com a rota /usuarios
    public List<FinanciamentoDTO> getAllFinanciamentos() {
        // a repository vai executar : SELECT * FROM usuarios;
        List<FinanciamentoModel> list = finRepository.findAll();

        // Como converter uma lista MODEL para lista DTO?
        List<FinanciamentoDTO> listDTO = new ArrayList<>();

        // Tipo de variável (carrega ArrayList listaDTO com list (lista FinanciamentoModel)
        for (FinanciamentoModel balde : list) {
            listDTO.add(balde.toDTO());
        }
        return listDTO;
    }

    // Uso do verbo POST com a rota /usuarios
    public FinanciamentoDTO create(FinanciamentoDTO financiamento) {

        FinanciamentoModel financiamentoDTOtoModel = new FinanciamentoModel();
        financiamentoDTOtoModel.setNumeroContrato( financiamento.getNumeroContrato() );
        financiamentoDTOtoModel.setValor(financiamento.getValor());
        finRepository.save(financiamentoDTOtoModel);

//      FinanciamentoModel financiamentoSalvo = null
//
//        try{
//            financiamentoSalvo = finRepository.save(financiamento.toModel);
//            log.info(financiamentoSalvo.toString());
//        }
//        catch (Exception exception){
//            log.error("Erro ao salvar o financiamento: " + exception.getMessage());
//        }

        return financiamentoDTOtoModel.toDTO();
    }

    // Uso do verbo PATCH com a rota /usuarios/{id}
    public FinanciamentoDTO update(int id, FinanciamentoDTO financiamentoBody) {
        FinanciamentoModel financiamento = finRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("Financiamento não localizado") );

        financiamento.setNumeroContrato( financiamentoBody.getNumeroContrato() );
        financiamento.setValor( financiamentoBody.getValor());
        return finRepository.save( financiamento ).toDTO();
    }

    // Uso do verbo DELETE com a rota /usuarios/{id}
    public String delete(int id) {
        finRepository.deleteById(id);
        return "Financiamento delatado com sucesso!";
    }

    // Uso do verbo GET(getOne) com a rota /usuarios/{id}
    public FinanciamentoDTO getOne(int id) {
        FinanciamentoModel financiamento = finRepository.findById(id).orElseThrow( () -> new RuntimeException("Financiamento não encontrado"));
        return financiamento.toDTO();
    }
}

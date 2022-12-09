package com.brq.ms07.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brq.ms07.models.CadastroModel;

@Repository
public interface CadastroRepository extends JpaRepository<CadastroModel, Integer> {

}
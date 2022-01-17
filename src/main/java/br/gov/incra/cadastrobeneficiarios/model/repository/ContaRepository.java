package br.gov.incra.cadastrobeneficiarios.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.incra.cadastrobeneficiarios.model.entity.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long>{
    List<Conta> findByCpf(String cpf);
    
}

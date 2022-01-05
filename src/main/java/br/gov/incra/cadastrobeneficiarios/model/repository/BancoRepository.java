package br.gov.incra.cadastrobeneficiarios.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.incra.cadastrobeneficiarios.model.entity.Banco;

public interface BancoRepository extends JpaRepository<Banco, Long> {
    
}

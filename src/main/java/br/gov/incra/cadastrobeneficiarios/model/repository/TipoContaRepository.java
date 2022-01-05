package br.gov.incra.cadastrobeneficiarios.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.incra.cadastrobeneficiarios.model.entity.TipoConta;

public interface TipoContaRepository extends JpaRepository<TipoConta, Long> {
    
}

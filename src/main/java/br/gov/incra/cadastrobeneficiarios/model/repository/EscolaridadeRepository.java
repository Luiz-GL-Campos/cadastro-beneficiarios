package br.gov.incra.cadastrobeneficiarios.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.incra.cadastrobeneficiarios.model.entity.Escolaridade;

public interface EscolaridadeRepository extends JpaRepository<Escolaridade, Long> {
    
}

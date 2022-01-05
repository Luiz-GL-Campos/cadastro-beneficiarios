package br.gov.incra.cadastrobeneficiarios.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.incra.cadastrobeneficiarios.model.entity.TipoTelefone;

public interface TipoTelefoneRepository extends JpaRepository<TipoTelefone, Long> {
    
}

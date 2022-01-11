package br.gov.incra.cadastrobeneficiarios.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.incra.cadastrobeneficiarios.model.entity.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
    
}

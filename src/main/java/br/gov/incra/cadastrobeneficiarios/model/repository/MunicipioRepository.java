package br.gov.incra.cadastrobeneficiarios.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.incra.cadastrobeneficiarios.model.entity.Municipio;

public interface MunicipioRepository extends JpaRepository<Municipio, Long> {
    
}

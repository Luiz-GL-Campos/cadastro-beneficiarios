package br.gov.incra.cadastrobeneficiarios.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.incra.cadastrobeneficiarios.model.entity.Genero;

public interface GeneroRepository extends JpaRepository<Genero, Long> {
    
}

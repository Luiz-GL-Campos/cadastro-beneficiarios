package br.gov.incra.cadastrobeneficiarios.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.incra.cadastrobeneficiarios.model.entity.Beneficiario;

public interface BeneficiarioRepository extends JpaRepository<Beneficiario, String> {
    
}

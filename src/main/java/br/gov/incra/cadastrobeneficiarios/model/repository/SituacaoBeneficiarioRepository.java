package br.gov.incra.cadastrobeneficiarios.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.incra.cadastrobeneficiarios.model.entity.SituacaoBeneficiario;
import br.gov.incra.cadastrobeneficiarios.model.entity.SituacaoBeneficiarioId;

public interface SituacaoBeneficiarioRepository extends JpaRepository<SituacaoBeneficiario, SituacaoBeneficiarioId> {
    
}

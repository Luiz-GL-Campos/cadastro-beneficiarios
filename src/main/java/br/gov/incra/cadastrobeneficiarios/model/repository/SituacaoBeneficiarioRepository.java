package br.gov.incra.cadastrobeneficiarios.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.incra.cadastrobeneficiarios.model.entity.SituacaoBeneficiario;
import br.gov.incra.cadastrobeneficiarios.model.entity.SituacaoBeneficiarioId;

public interface SituacaoBeneficiarioRepository extends JpaRepository<SituacaoBeneficiario, SituacaoBeneficiarioId> {
    @Query("select s from SituacaoBeneficiario s where s.situacaoBeneficiarioId.cpf =: cpf")
    List<SituacaoBeneficiario> listarPorCpf(String cpf);

    @Query("delete s from SituacaoBeneficiario s where s.situacaoBeneficiarioId.cpf =: cpf")
    void deletarPorCpf(String cpf);
}

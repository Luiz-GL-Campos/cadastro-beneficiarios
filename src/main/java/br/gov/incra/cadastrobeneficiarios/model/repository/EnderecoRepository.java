package br.gov.incra.cadastrobeneficiarios.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.incra.cadastrobeneficiarios.model.entity.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    List<Endereco> findByCpf(String cpf);
    void deleteByCpf(String cpf);
}

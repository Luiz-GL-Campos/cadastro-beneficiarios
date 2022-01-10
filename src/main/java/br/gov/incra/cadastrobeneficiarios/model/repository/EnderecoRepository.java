package br.gov.incra.cadastrobeneficiarios.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.incra.cadastrobeneficiarios.model.entity.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    
}

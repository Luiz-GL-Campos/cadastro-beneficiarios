package br.gov.incra.cadastrobeneficiarios.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import br.gov.incra.cadastrobeneficiarios.model.entity.Email;

public interface EmailRepository extends JpaRepository<Email, Long> {
    List<Email> findByCpf(String cpf);
}

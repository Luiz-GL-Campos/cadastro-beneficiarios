package br.gov.incra.cadastrobeneficiarios.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.gov.incra.cadastrobeneficiarios.model.dto.ListarBeneficiarioDTO;
import br.gov.incra.cadastrobeneficiarios.model.repository.BeneficiarioRepository;

@Service
public class ListarBeneficiarioService {

    private final BeneficiarioRepository beneficiarioRepository;

    public ListarBeneficiarioService(BeneficiarioRepository beneficiarioRepository) {
        this.beneficiarioRepository = beneficiarioRepository;
    }

    public List<ListarBeneficiarioDTO> listar(){
        List<ListarBeneficiarioDTO> listaBeneficiario = new ArrayList<>();
        beneficiarioRepository.findAll().forEach(beneficiario -> listaBeneficiario.add(new ListarBeneficiarioDTO(beneficiario)));
        return listaBeneficiario;
    }
}

package br.gov.incra.cadastrobeneficiarios.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.gov.incra.cadastrobeneficiarios.model.dto.BeneficiarioDTO;
import br.gov.incra.cadastrobeneficiarios.model.entity.Beneficiario;
import br.gov.incra.cadastrobeneficiarios.model.entity.SituacaoBeneficiario;
import br.gov.incra.cadastrobeneficiarios.model.repository.BeneficiarioRepository;
import br.gov.incra.cadastrobeneficiarios.model.repository.SituacaoBeneficiarioRepository;

@Service
public class DetalhaBeneficiarioService {

    private final BeneficiarioRepository beneficiarioRepository;
    private final SituacaoBeneficiarioRepository situacaoBeneficiarioRepository;

    public DetalhaBeneficiarioService(BeneficiarioRepository beneficiarioRepository, 
        SituacaoBeneficiarioRepository situacaoBeneficiarioRepository) {
            this.beneficiarioRepository = beneficiarioRepository;
            this.situacaoBeneficiarioRepository = situacaoBeneficiarioRepository;
    }

    public BeneficiarioDTO obterPor(String cpf){
        Optional<Beneficiario> optBeneficiario = beneficiarioRepository.findById(cpf);
        if (optBeneficiario.isPresent()){
            BeneficiarioDTO beneficiarioDTO = new BeneficiarioDTO(optBeneficiario.get());
            List<SituacaoBeneficiario> situacoes = situacaoBeneficiarioRepository.listarPorCpf(cpf);
            situacoes.forEach(situacaoBeneficiario -> beneficiarioDTO.adicionaSituacao(situacaoBeneficiario));
            return beneficiarioDTO;
        }
        return new BeneficiarioDTO();     
    }
}

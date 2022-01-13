package br.gov.incra.cadastrobeneficiarios.service.executor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.gov.incra.cadastrobeneficiarios.form.CadastroBeneficiarioForm;
import br.gov.incra.cadastrobeneficiarios.form.EnderecoForm;
import br.gov.incra.cadastrobeneficiarios.model.entity.Municipio;
import br.gov.incra.cadastrobeneficiarios.model.repository.MunicipioRepository;
import br.gov.incra.cadastrobeneficiarios.service.AcaoCadastroBeneficiario;

@Service
public class ExecutorCadastroMunicipio implements AcaoCadastroBeneficiario {

    private final MunicipioRepository municipioRepository;

    public ExecutorCadastroMunicipio(MunicipioRepository municipioRepository){
        this.municipioRepository = municipioRepository;
    }

    @Override
    public void executa(CadastroBeneficiarioForm form) {
        List<Municipio> listaMunicipio = new ArrayList<>();
        for (EnderecoForm endereco : form.getEnderecos()) {
            listaMunicipio.add(new Municipio(endereco.getMunicipioForm()));
        }
        municipioRepository.saveAll(listaMunicipio);
    }
    
}

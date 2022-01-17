package br.gov.incra.cadastrobeneficiarios.service.executor;

import br.gov.incra.cadastrobeneficiarios.form.CadastroBeneficiarioForm;
import br.gov.incra.cadastrobeneficiarios.model.entity.Municipio;
import br.gov.incra.cadastrobeneficiarios.model.repository.MunicipioRepository;
import br.gov.incra.cadastrobeneficiarios.service.AcaoCadastroBeneficiario;

public abstract class AbstractExecutorCadastroMunicipio implements AcaoCadastroBeneficiario {
    private final MunicipioRepository municipioRepository;

    public AbstractExecutorCadastroMunicipio(MunicipioRepository municipioRepository){
        this.municipioRepository = municipioRepository;
    }

    public void executa(CadastroBeneficiarioForm form){
        // Municipio municipios = new Municipio();
        // Endereco enderecos = new Endereco();
        // form.getEnderecos().forEach(municipio -> enderecos.add(new Endereco(municipio, form.getBeneficiario())));
        // municipioRepository.saveAll(municipios);
    }
}

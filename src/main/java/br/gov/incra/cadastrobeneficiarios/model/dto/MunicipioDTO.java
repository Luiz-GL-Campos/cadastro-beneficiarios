package br.gov.incra.cadastrobeneficiarios.model.dto;

import br.gov.incra.cadastrobeneficiarios.model.entity.Municipio;

public class MunicipioDTO {
    private Long idMunicipio;
    private String nomeMunicipio;
    private EstadoDTO estado;

    public MunicipioDTO(Municipio municipio) {
        this.idMunicipio = municipio.getIdMunicipio();
        this.nomeMunicipio = municipio.getNomeMunicipio();
        this.estado = new EstadoDTO(municipio.getEstado());
    }
}

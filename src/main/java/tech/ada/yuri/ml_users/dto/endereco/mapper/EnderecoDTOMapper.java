package tech.ada.yuri.ml_users.dto.endereco.mapper;

import tech.ada.yuri.ml_users.dto.endereco.EnderecoDTO;
import tech.ada.yuri.ml_users.model.Endereco;

public class EnderecoDTOMapper {
    public static Endereco toEntity(EnderecoDTO enderecoDTO) {
        Endereco endereco = new Endereco();
        endereco.setCep(enderecoDTO.getCep());
        endereco.setLogradouro(enderecoDTO.getLogradouro());
        endereco.setBairro(enderecoDTO.getBairro());
        endereco.setLocalidade(enderecoDTO.getCidade());
        return endereco;
    }


    public static EnderecoDTO toDto(Endereco endereco) {
        EnderecoDTO enderecoDto = new EnderecoDTO();
        enderecoDto.setCep(endereco.getCep());
        enderecoDto.setLogradouro(endereco.getLogradouro());
        enderecoDto.setBairro(endereco.getBairro());
        enderecoDto.setCidade(endereco.getLocalidade());
        return enderecoDto;
    }
}

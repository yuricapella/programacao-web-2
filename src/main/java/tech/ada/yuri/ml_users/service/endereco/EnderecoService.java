package tech.ada.yuri.ml_users.service.endereco;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tech.ada.yuri.ml_users.dto.endereco.EnderecoDTO;
import tech.ada.yuri.ml_users.dto.endereco.mapper.EnderecoDTOMapper;
import tech.ada.yuri.ml_users.model.Endereco;

@Service
public class EnderecoService {

    @Value("${url.viacep}")
    private String urlViacep;

    public Endereco obterEnderecoPorCep(String cep) {
        RestTemplate restTemplate = new RestTemplate();
        EnderecoDTO enderecoViaCep = restTemplate.getForObject(String.format(urlViacep, cep), EnderecoDTO.class, cep);
        return EnderecoDTOMapper.toEntity(enderecoViaCep);
    }
}

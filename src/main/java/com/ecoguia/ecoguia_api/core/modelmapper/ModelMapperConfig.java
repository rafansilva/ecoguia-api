package com.ecoguia.ecoguia_api.core.modelmapper;

import com.ecoguia.ecoguia_api.api.model.EnderecoModel;
import com.ecoguia.ecoguia_api.api.model.input.EstadoInput;
import com.ecoguia.ecoguia_api.domain.model.Endereco;
import com.ecoguia.ecoguia_api.domain.model.Estado;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {


    @Bean
    public ModelMapper modelMapper() {
        var modelMapper = new ModelMapper();

        var enderecoToEnderecoModelTypeMap = modelMapper.createTypeMap(
                Endereco.class, EnderecoModel.class);

//        enderecoToEnderecoModelTypeMap.<String>addMapping(
//                enderecoSrc -> enderecoSrc.getCidade().getEstado().getNome(),
//                (enderecoModelDest, value) -> enderecoModelDest.getCidade().setEstado(value));

        return modelMapper;
    }
}

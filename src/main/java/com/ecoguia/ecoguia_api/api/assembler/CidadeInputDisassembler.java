package com.ecoguia.ecoguia_api.api.assembler;

import com.ecoguia.ecoguia_api.api.model.input.CidadeInput;
import com.ecoguia.ecoguia_api.domain.model.Cidade;
import com.ecoguia.ecoguia_api.domain.model.Estado;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CidadeInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Cidade toDomainObject(CidadeInput cidadeInput) {
        return modelMapper.map(cidadeInput, Cidade.class);
    }

    public void copyToDomainObject(CidadeInput cidadeInput, Cidade cidade) {

        cidade.setEstado(new Estado());

        modelMapper.map(cidadeInput, cidade);
    }

}

package com.ecoguia.ecoguia_api.api.assembler;

import com.ecoguia.ecoguia_api.api.model.input.EcopontoInput;
import com.ecoguia.ecoguia_api.domain.model.Cidade;
import com.ecoguia.ecoguia_api.domain.model.Ecoponto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EcopontoInputDissambler {

    @Autowired
    private ModelMapper modelMapper;

    public Ecoponto toDomainObject(EcopontoInput ecopontoInput) {
        return modelMapper.map(ecopontoInput, Ecoponto.class);
    }

    public void copyToDomainObject(EcopontoInput ecopontoInput, Ecoponto ecoponto) {
        if (ecoponto.getEndereco() != null) {
            ecoponto.getEndereco().setCidade(new Cidade());
        }

        modelMapper.map(ecopontoInput, ecoponto);
    }
}

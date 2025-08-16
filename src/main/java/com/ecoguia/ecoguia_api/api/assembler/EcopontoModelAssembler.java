package com.ecoguia.ecoguia_api.api.assembler;

import com.ecoguia.ecoguia_api.api.model.EcopontoModel;
import com.ecoguia.ecoguia_api.domain.model.Ecoponto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EcopontoModelAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public EcopontoModel toModel(Ecoponto ecoponto) {
        return modelMapper.map(ecoponto, EcopontoModel.class);
    }

    public List<EcopontoModel> toCollectionModel(List<Ecoponto> ecopontos) {
        return ecopontos.stream()
                .map(ecoponto -> toModel(ecoponto))
                .collect(Collectors.toList());
    }
}

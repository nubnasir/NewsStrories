package com.nubnasir.newsstories.common.converter;

import java.util.List;

public interface ModelConverterInterface <E, O> {

    E convertDtoToEntity(O o);
    O convertEntityToDto(E o);
    List<O> convertEntitiesToDtos(List<E> es);

}

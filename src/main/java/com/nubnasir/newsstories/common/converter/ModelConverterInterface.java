package com.nubnasir.newsstories.common.converter;

import java.util.List;

/**
 * Created by root on 9/10/18.
 */
public interface ModelConverterInterface <E, O> {

    E convertDtoToEntity(O o);
    O convertEntityToDto(E o);
    List<E> convertDtosToEntities(List<O> os);
    List<O> convertEntitiesToDtos(List<E> es);

}

package com.etiquette.Mapping;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

public class CustomMap {

    static ModelMapper modelMapper = new ModelMapper();

    public static <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source
        .stream()
        .map(element -> modelMapper.map(element, targetClass))
        .collect(Collectors.toList());
    }

    @SuppressWarnings("unchecked")
    public static <S, T> List<T> mapIterable(Iterable<S> source, Class<T> targetClass) {
        return ((Collection<T>) source)
        .stream()
        .map(element -> modelMapper.map(element, targetClass))
        .collect(Collectors.toList());
    }
    
}

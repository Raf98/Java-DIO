package one.digitalinnovation.beerstock.mapper;

import one.digitalinnovation.beerstock.dto.BeerDTO;
import one.digitalinnovation.beerstock.entity.Beer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BeerMapper {

    BeerMapper INSTANCE = Mappers.getMapper(BeerMapper.class);

    @Mapping(target="brand", source="brand")
    @Mapping(target="name", source="name")
    @Mapping(target="max", source="max")
    @Mapping(target="quantity", source="quantity")
    @Mapping(target="type", source="type")
    Beer toModel(BeerDTO beerDTO);

    BeerDTO toDTO(Beer beer);
}

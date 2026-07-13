package edu.mx.tecdesoftware.marketbackend_3A.pesistence.mapper;

import edu.mx.tecdesoftware.marketbackend_3A.domain.Category;
import edu.mx.tecdesoftware.marketbackend_3A.pesistence.entity.Categoria;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")

public interface CategoryMapper {

    @Mappings({
            @Mapping(source = "idCategoria",
                    target = "categoryId"),
            @Mapping(source = "descripcion",
                    target = "category"),
            @Mapping(source = "estado",
                    target = "active")
    })
    Category toCategory(Categoria categoria);

        @InheritInverseConfiguration(name = "toCategory")
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(Category category);


}

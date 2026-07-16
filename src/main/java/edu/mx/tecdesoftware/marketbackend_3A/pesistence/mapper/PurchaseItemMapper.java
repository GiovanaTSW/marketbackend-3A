package edu.mx.tecdesoftware.marketbackend_3A.pesistence.mapper;

import edu.mx.tecdesoftware.marketbackend_3A.domain.PurchaseItem;
import edu.mx.tecdesoftware.marketbackend_3A.pesistence.entity.CompraProducto;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {

    @Mappings({
            @Mapping(source = "id.idProducto", target = "productId"),
            @Mapping(source = "cantidad", target = "amount"),
            // total se mapea automático porque se llaman igual
            @Mapping(source = "estado", target = "active")
    })
    PurchaseItem toPurchaseItem(CompraProducto producto);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "compra", ignore = true),
            @Mapping(target = "producto", ignore = true),
            @Mapping(target = "id.idCompra", ignore = true)
    })
    CompraProducto toCompraProducto(PurchaseItem item);
}
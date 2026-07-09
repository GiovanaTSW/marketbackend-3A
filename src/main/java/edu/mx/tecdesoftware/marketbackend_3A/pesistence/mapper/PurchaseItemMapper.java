package edu.mx.tecdesoftware.marketbackend_3A.pesistence.mapper;

import edu.mx.tecdesoftware.marketbackend_3A.domain.PurchaseItem;
import edu.mx.tecdesoftware.marketbackend_3A.pesistence.entity.CompraProducto;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface PurchaseItemMapper {

    @Mapping(source = "producto.idProducto", target = "productId")
    PurchaseItem toPurchaseItem(CompraProducto compraProducto);

    @InheritInverseConfiguration
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "compra", ignore = true)
    @Mapping(target = "producto", ignore = true)
    CompraProducto toCompraProducto(PurchaseItem purchaseItem);
}
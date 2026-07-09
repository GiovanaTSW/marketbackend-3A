package edu.mx.tecdesoftware.marketbackend_3A.pesistence.mapper;

import edu.mx.tecdesoftware.marketbackend_3A.domain.Purchase;
import edu.mx.tecdesoftware.marketbackend_3A.pesistence.entity.Compra;
import org.mapstruct.*;
import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {

    @Mappings({
            @Mapping(source = "idCompra", target = "purchaseId"),
            @Mapping(source = "idCliente", target = "clientId"),
            @Mapping(source = "productos", target = "products"),
    })
    Purchase toPurchase(Compra compra);

    @InheritInverseConfiguration
    @Mapping(target = "cliente", ignore = true)
    Compra toCompra(Purchase purchase);
}
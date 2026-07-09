package edu.mx.tecdesoftware.marketbackend_3A.pesistence;

import edu.mx.tecdesoftware.marketbackend_3A.domain.Purchase;
import edu.mx.tecdesoftware.marketbackend_3A.domain.repository.PurchaseRepository;
import edu.mx.tecdesoftware.marketbackend_3A.pesistence.crud.CompraCrudRepository;
import edu.mx.tecdesoftware.marketbackend_3A.pesistence.entity.Compra;
import edu.mx.tecdesoftware.marketbackend_3A.pesistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PurchaseRepositoryImpl implements PurchaseRepository {

    @Autowired
    private CompraCrudRepository compraCrudRepository;

    @Autowired
    private PurchaseMapper purchaseMapper;

    @Override
    public List<Purchase> getAll() {
        List<Compra> compras = (List<Compra>) compraCrudRepository.findAll();
        return compras.stream().map(purchaseMapper::toPurchase).collect(Collectors.toList());
    }

    @Override
    public Optional<List<Purchase>> getByClient(int clientId) {
        List<Compra> compras = compraCrudRepository.findByIdCliente(String.valueOf(clientId));
        return Optional.of(compras.stream().map(purchaseMapper::toPurchase).collect(Collectors.toList()));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = purchaseMapper.toCompra(purchase);
        compra.getProductos().forEach(producto -> producto.setCompra(compra)); // <- el paso crítico
        return purchaseMapper.toPurchase(compraCrudRepository.save(compra));
    }
}
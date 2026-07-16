package edu.mx.tecdesoftware.marketbackend_3A.domain.repository;

import edu.mx.tecdesoftware.marketbackend_3A.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<Purchase> getAll();
    Purchase save(Purchase purchase);
    Optional<Purchase> getByClientId(String clienteId);
}

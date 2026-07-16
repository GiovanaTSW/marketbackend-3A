package edu.mx.tecdesoftware.marketbackend_3A.domain.service;

import edu.mx.tecdesoftware.marketbackend_3A.domain.Purchase;
import edu.mx.tecdesoftware.marketbackend_3A.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<Purchase> getAll() {
        return purchaseRepository.getAll();
    }

    public Optional<Purchase> getByClientId(String idCliente) {
        return purchaseRepository.getByClientId(idCliente);
    }
    public Purchase save(Purchase purchase) { return purchaseRepository.save(purchase); }
}
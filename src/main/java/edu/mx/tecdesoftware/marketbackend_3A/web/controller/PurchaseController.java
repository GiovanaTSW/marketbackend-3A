package edu.mx.tecdesoftware.marketbackend_3A.web.controller;

import edu.mx.tecdesoftware.marketbackend_3A.domain.Purchase;
import edu.mx.tecdesoftware.marketbackend_3A.domain.service.PurchaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/purchase")
@Tag(name = "Purchase", description = "Manage purchases in the store")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/all") // Eliminado /all
    @Operation(summary = "Get all purchases", description = "Returned a list of purchases")
    @ApiResponse(responseCode = "200", description = "Succesful retrieval of purchases")
    @ApiResponse(responseCode = "404", description = "Purchase not found")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    public ResponseEntity<List<Purchase>> getAll() {
        return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/client/{clientId}")
    @Operation(summary = "Get client by ID", description = "Returned client by ID if it exists")
    @ApiResponse(responseCode = "200", description = "Client found successfully")
    @ApiResponse(responseCode = "404", description = "Client not found")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    public ResponseEntity<Purchase> getByClient(
            @PathVariable @Parameter(description = "ID of the client retrieved",
                    example = "2552243", required = true) String clientId) { // Cambiar String por int
        return purchaseService.getByClientId(clientId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/save") // Eliminado /save
    @Operation(summary = "Save a new product", description = "Register a new purchase and return the created purchase",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            examples = @ExampleObject(
                                    name = "Example Purchase",
                                    value = """
                                        {
                                          "clientId": "2552243",
                                          "date": "2026-07-16T14:34:15.398Z",
                                          "paymentMethod": "E",
                                          "comment": "Compra de prueba",
                                          "state": "P",
                                              "items": [
                                                    {
                                                      "productId": 6,
                                                      "amount": 3,
                                                      "total": 870.0,
                                                      "active": true
                                                    }
                                              ]
                                        }
                                    """
                            )
                    )
            )
    )

    @ApiResponse(responseCode = "201", description = "Purchase created succesfully")
    @ApiResponse(responseCode = "400", description = "Invalid purchase data")
    @ApiResponse(responseCode = "401", description = "Unauthorized")
    @ApiResponse(responseCode = "403", description = "Forbidden")
    @ApiResponse(responseCode = "409", description = "Purchase conflict (duplicate code or SKU)")
    @ApiResponse(responseCode = "500", description = "Internal server error")

    public ResponseEntity<Purchase> save(@RequestBody Purchase purchase) {
        return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED);
    }
}
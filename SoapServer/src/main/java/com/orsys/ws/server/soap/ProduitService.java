package com.orsys.ws.server.soap;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;

import java.util.Optional;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface ProduitService {

    @WebMethod
    String getProduits();
    @WebMethod
    Produit create(Produit p);
    @WebMethod
    Optional<Produit> findById(@WebParam(name="id") int id);
    @WebMethod
    void deleteProduit(@WebParam(name="id")int id);
    @WebMethod
    void updateProduit(Produit p);
}

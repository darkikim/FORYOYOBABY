package com.orsys.ws.server.soap;

import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@WebService(endpointInterface = "com.orsys.ws.server.soap.ProduitService")
public class ProduitServiceImpl implements ProduitService{
    @Autowired
    ProduitRepository produitRepository;


    @Override
    public String getProduits() {
        System.err.println("Voici la liste des produits");
        return "JAXB n'aime pas les interfaces";
    }

    @Override
    public Produit create(Produit p) {
        produitRepository.save(p);
        System.err.println("le produit a était crée");
        return p;
    }

    @Override
    public Optional<Produit> findById(@WebParam(name="id") int id){
        Optional<Produit> p=produitRepository.findById(id);
        return p;
    }

    @Override
    public void deleteProduit(@WebParam(name="id")int id) {
        produitRepository.deleteById(id);
        System.err.println("le produit a était supprimé");
    }

    @Override
    public void updateProduit(Produit p) {
        produitRepository.save(p);
        System.err.println("le produit a était modifié");
    }

}

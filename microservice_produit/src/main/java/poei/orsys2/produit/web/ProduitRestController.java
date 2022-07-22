package poei.orsys2.produit.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import poei.orsys2.produit.dao.ProduitRepository;
import poei.orsys2.produit.entities.Produit;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class ProduitRestController {
    @Autowired
    private final ProduitRepository produitRepository;

    public ProduitRestController(ProduitRepository produitRepository)
    {
        this.produitRepository = produitRepository;
    }

    @GetMapping("/produits")
    public List<Produit> getProduits()
    {
        return produitRepository.findAll();
    }
    @GetMapping("/produits/{id}")
    public Produit getProduitByIdPath(@PathVariable int id)
    {
        return produitRepository.findById(id).orElseThrow();
    }
}


package poei.orsys2.produit.dao;
import poei.orsys2.produit.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit,Integer> {
    Page<Produit> findByTitreContaining(String titre);
    List<Produit> searchProduct(String search);
}



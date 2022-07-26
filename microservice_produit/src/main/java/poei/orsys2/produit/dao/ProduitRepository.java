package poei.orsys2.produit.dao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import poei.orsys2.produit.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProduitRepository extends JpaRepository<Produit,Integer> {
    /***
     *
     * @param search
     * @return
     */
    @Query("SELECT p FROM Produit p WHERE " +
            "p.titre LIKE CONCAT('%',:search, '%')" +
            "Or p.description LIKE CONCAT('%', :search, '%')")
    List<Produit> searchProduit(String search);
}



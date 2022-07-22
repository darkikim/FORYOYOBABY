package poei.orsys2.commande.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import poei.orsys2.commande.model.Commande;

public interface CommandeDAO extends JpaRepository<Commande, Long> {

    Page<Commande> findAll(Pageable pageable);
}

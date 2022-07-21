package poei.orsys2.paiement.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import poei.orsys2.paiement.entities.Payment;

public interface PaiementRepository  extends JpaRepository<Payment, Long> {
}

package poei.orsys2.paiement.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import poei.orsys2.paiement.DAO.PaiementRepository;
import poei.orsys2.paiement.entities.Payment;

import java.util.List;
import java.util.Optional;

@Controller
public class PaiementController {
    @Autowired
    private PaiementRepository paiementRepository;

    @RequestMapping(value="/paiements", method= RequestMethod.GET)
    public String all(Model model){
        List<Payment> paymentList=paiementRepository.findAll();
        model.addAttribute("listPaiements",paymentList);
        return "paiements";
    }


    @RequestMapping(value="/paiements/{paiementId}", method= RequestMethod.GET)
    public String one(Model model, @PathVariable Long paiementId) throws Exception {
        Payment payment=paiementRepository.findById(paiementId).orElseThrow(()-> new Exception("Paiement non trouvé"));
        model.addAttribute("paiement",payment);
        return "paiement";
    }

    @RequestMapping(value="/paiements/add")
    public String create(Model model, Payment paiement) {
        if (null==paiement){
            Payment payment = new Payment();
            model.addAttribute("paiement",payment);
            return "add";
        }
        paiementRepository.save(paiement);
        return "redirect:/paiements";
    }
}

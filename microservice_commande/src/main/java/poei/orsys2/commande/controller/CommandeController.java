package poei.orsys2.commande.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import poei.orsys2.commande.dao.CommandeDAO;
import poei.orsys2.commande.model.Commande;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class CommandeController {
    @Autowired
    CommandeDAO commandeDAO;

    @RequestMapping(value = "/commandes")
    public String consulterCommandes(Model model,
                                     @RequestParam(name = "page", defaultValue = "0") int page,
                                     @RequestParam(name = "size", defaultValue = "4") int size){
        Page<Commande> commandePages = commandeDAO.findAll(PageRequest.of(page, size));
        model.addAttribute("commandes", commandePages.getContent());
        int[] pages = new int[commandePages.getTotalPages()];
        model.addAttribute("pages", pages);
        model.addAttribute("pageCourante", page);
        return "commandes";
    }

    @PostMapping(value = "/commandes/add")
    @ResponseBody
    public Commande ajouterCommande(@RequestBody @Valid Commande commande) {
        Commande nouvelleCommande = commandeDAO.save(commande);

        return nouvelleCommande;
    }

    @PostMapping(value = "/commandes/paye")
    public Commande payerCommande(@RequestBody Commande commande) {
        commande.setCommandePayee(true);
        Commande nouvelleCommande = commandeDAO.save(commande);

        return nouvelleCommande;
    }

    @GetMapping(value = "/commandes/{id}")
    public String recupererUneCommande(@PathVariable Long id, Model model) throws CommandeNotFoundException {

        Optional<Commande> commande = commandeDAO.findById(id);
        if(!commande.isPresent()) throw new CommandeNotFoundException("Cette commande n'existe pas");
        model.addAttribute("commande", commande);

        return "commande";
    }
}

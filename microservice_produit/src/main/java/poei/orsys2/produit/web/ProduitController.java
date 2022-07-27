package poei.orsys2.produit.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import poei.orsys2.produit.dao.ProduitRepository;
import poei.orsys2.produit.entities.Produit;

import java.util.List;

@Controller
public class ProduitController {
    @Autowired
    ProduitRepository produitRepository;

    ///get all produit
    @RequestMapping(value={"/produit","/"},method = RequestMethod.GET)
    public String  index(Model model,
                         @RequestParam(name="page",defaultValue = "0") int page ,
                         @RequestParam(name="size",defaultValue = "4") int size) {
        Page<Produit> listProduits = produitRepository.findAll(PageRequest.of(page,size));
        int[] pages = new int[listProduits.getTotalPages()];

        model.addAttribute("listPrd",listProduits.getContent());
        model.addAttribute("prd", new Produit());
        model.addAttribute("pages",pages);
        return "produits";
    }
    @RequestMapping(value="/produit/edit",method =RequestMethod.GET)
    public String editProduit(Model model,@RequestParam int id) {
        // Produit prd = produitRepository.findById(id);
//        System.out.print(prd);
//        model.addAttribute("prd", prd);
        return "produits";
    }

    //add a new enterprise
    @RequestMapping(value="/produit/create",method =RequestMethod.POST)
    public String  newProduit(Model model,Produit prd) {

            produitRepository.save(prd);
            System.err.println("the product has been added");
            return "redirect:/produit";
        }

    @RequestMapping(value="/produit/update",method =RequestMethod.POST)
    public String  updateProduit(@ModelAttribute(value="prd") Produit prd) {
        produitRepository.save(prd);
        return "redirect:/produit";
    }
    @RequestMapping(value="/produit/delete",method =RequestMethod.GET)
    public String  deleteProduit(@RequestParam int id) {
        produitRepository.deleteById(id);
        return "redirect:/produit";
    }
    @RequestMapping(value="/produit/search",method = RequestMethod.GET)
    public String searchProducts(@RequestParam String keyword, Model model,
                                 @RequestParam(name="page",defaultValue = "0") int page ,
                                 @RequestParam(name="size",defaultValue = "4") int size){
        List<Produit> produits = produitRepository.searchProduit(keyword);
        System.err.println(produits);
        Pageable p=PageRequest.of(page,size);
        Page<Produit> searchPage = new PageImpl<>(produits,p,produits.size());

        int[] pages = new int[searchPage.getTotalPages()];
        model.addAttribute("pages",pages);
        model.addAttribute("listPrd", searchPage.getContent());
        model.addAttribute("prd", new Produit());
        model.addAttribute("keyword", keyword);
        return "produits";
    }

}

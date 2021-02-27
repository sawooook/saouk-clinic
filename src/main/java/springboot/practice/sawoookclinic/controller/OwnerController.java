package springboot.practice.sawoookclinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import springboot.practice.sawoookclinic.domain.Owner;
import springboot.practice.sawoookclinic.domain.dto.OwnerForm;
import springboot.practice.sawoookclinic.repository.OwnerRepository;
import springboot.practice.sawoookclinic.service.OwnerService;

import java.util.List;
import java.util.Map;

@Controller
public class OwnerController {

    @Autowired
    OwnerService ownerServic;

    private static final String VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "owner/createOrUpdateOwnerForm";


    @GetMapping("/owners/new")
    public String createForm(Model model) {
        model.addAttribute("ownerForm",new OwnerForm());
        return "owener/createOwenerForm";
    }

    @GetMapping("/owners")
    public String ownersList(Model model) {
        List<Owner> ownersList = ownerServic.findAll();
        model.addAttribute("owner", ownersList);
        return "owner/ownersList";
    }

    @GetMapping("/owners/find")
    public String ownersFind(Model model) {
        List<Owner> ownersList = ownerServic.findAll();
        model.addAttribute("owner", ownersList);
        return "owner/findOwners";
    }

}

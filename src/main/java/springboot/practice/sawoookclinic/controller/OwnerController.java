package springboot.practice.sawoookclinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import springboot.practice.sawoookclinic.domain.Owner;
import springboot.practice.sawoookclinic.repository.OwnerRepository;
import springboot.practice.sawoookclinic.service.OwnerService;

import java.util.List;
import java.util.Map;

@Controller
public class OwnerController {

    @Autowired
    OwnerService ownerServic;

    private static final String VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "owner/createOrUpdateOwnerForm";

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

    @GetMapping("/owners/new")
    public String initCreationForm(Map<String, Object> model) {
        Owner owner = new Owner();
        model.put("owner", owner);
        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
    }
}

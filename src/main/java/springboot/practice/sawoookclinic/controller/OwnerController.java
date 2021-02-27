package springboot.practice.sawoookclinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import springboot.practice.sawoookclinic.domain.Owner;
import springboot.practice.sawoookclinic.domain.dto.OwnerForm;
import springboot.practice.sawoookclinic.domain.dto.OwnerListResponseDto;
import springboot.practice.sawoookclinic.repository.OwnerRepository;
import springboot.practice.sawoookclinic.service.OwnerService;

import java.util.List;
import java.util.Map;

@Controller
public class OwnerController {

    @Autowired
    OwnerService ownerService;

    @GetMapping("/owners")
    public String ownersList(Model model) {
        List<OwnerListResponseDto> Response = ownerService.findAll();
        model.addAttribute("owner", Response);
        return "owner/ownersList";
    }

//    @GetMapping("/owners/find")
//    public String ownersFind(Model model) {
//        List<Owner> ownersList = ownerService.findAll();
//        model.addAttribute("owner", ownersList);
//        return "owner/findOwners";
//    }

    @GetMapping("/owners/new")
    public String CreateForm(Model model) {
        model.addAttribute("ownerForm", new OwnerForm());
        return "owner/createOwnerForm";
    }

    @PostMapping("/owners/new")
    public String create(OwnerForm ownerForm) {
        Owner owner = Owner.builder().name(ownerForm.getName())
                .age(ownerForm.getAge()).city(ownerForm.getCity()).telephone(ownerForm.getTelephone()).build();

        ownerService.join(owner);


        return "/welcome";
    }
}

package springboot.practice.sawoookclinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import springboot.practice.sawoookclinic.domain.Owner;
import springboot.practice.sawoookclinic.domain.dto.owner.OwnerForm;
import springboot.practice.sawoookclinic.domain.dto.owner.OwnerResponseDto;
import springboot.practice.sawoookclinic.service.OwnerService;

import java.util.List;

@Controller
public class OwnerController {

    @Autowired
    OwnerService ownerService;

    @GetMapping("/owners")
    public String ownersList(Model model) {
        List<OwnerResponseDto> Response = ownerService.findAll();
        model.addAttribute("owner", Response);
        return "owner/ownersList";
    }

    @GetMapping("/owners/new")
    public String createForm(Model model) {
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

    @GetMapping("/owner/{id}")
    public String ownerDetail(@PathVariable Long id, Model model) {
        Owner owner = ownerService.findOne(id);

        OwnerResponseDto ownerResponseDto = new OwnerResponseDto(owner);

        model.addAttribute("owner", ownerResponseDto);
        return "owner/ownerDetail";
    }
}

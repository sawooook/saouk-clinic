package springboot.practice.sawoookclinic.controller;

import lombok.RequiredArgsConstructor;
import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import springboot.practice.sawoookclinic.domain.Doctor;
import springboot.practice.sawoookclinic.domain.dto.doctor.DoctorRequestDto;
import springboot.practice.sawoookclinic.domain.dto.doctor.DoctorResponseDto;
import springboot.practice.sawoookclinic.service.DoctorService;

import javax.print.Doc;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping("/doctors")
    public String doctorList(Model model) {
        List<DoctorResponseDto> doctorList = doctorService.findAll();
        model.addAttribute("doctor", doctorList);
        return "doctor/doctorList";
    }

    @GetMapping("/doctor/{id}")
    public String doctorDetail(@PathVariable Long id, Model model) {
        Doctor doctor = doctorService.findOne(id);
        DoctorResponseDto doctorResponseDto = new DoctorResponseDto(doctor);
        model.addAttribute("doctor", doctorResponseDto);
        return "doctor/doctorDetail";
    }

    @GetMapping("/doctor/new")
    public String doctorCreate(Model model) {
        DoctorRequestDto doctorRequestDto = new DoctorRequestDto();
        model.addAttribute("doctor", doctorRequestDto);
        return "doctor/doctorNew";
    }

    @PostMapping("/doctor/new")
    public String doctorAdd(DoctorRequestDto doctorRequestDto) {
        System.out.println("===============");
        System.out.println(doctorRequestDto.getName());
        Doctor doctor = Doctor.builder().name(doctorRequestDto.getName()).build();
        doctorService.save(doctor);
        return "/welcome";
    }
}

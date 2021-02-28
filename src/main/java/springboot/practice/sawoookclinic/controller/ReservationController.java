package springboot.practice.sawoookclinic.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import springboot.practice.sawoookclinic.domain.Doctor;
import springboot.practice.sawoookclinic.domain.dto.Reservation.ReservationRequestDto;
import springboot.practice.sawoookclinic.domain.dto.Reservation.ReservationResponseDto;
import springboot.practice.sawoookclinic.domain.dto.doctor.DoctorRequestDto;
import springboot.practice.sawoookclinic.domain.dto.doctor.DoctorResponseDto;
import springboot.practice.sawoookclinic.domain.dto.owner.OwnerResponseDto;
import springboot.practice.sawoookclinic.repository.DoctorRepository;
import springboot.practice.sawoookclinic.service.DoctorService;
import springboot.practice.sawoookclinic.service.OwnerService;
import springboot.practice.sawoookclinic.service.ReservationService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;
    private final DoctorService doctorService;
    private final OwnerService ownerService;

    @GetMapping("/reserve/new")
    public String createReserve(Model model) {
        model.addAttribute("reservation", new ReservationRequestDto());

        List<OwnerResponseDto> owners = ownerService.findAll();
        model.addAttribute("owner", owners);

        List<DoctorResponseDto> doctors = doctorService.findAll();
        model.addAttribute("doctor", doctors);
        return "reservation/reservationNew";
    }

    @PostMapping("/reserve/new")
    public String addReserve(ReservationRequestDto reservationResponseDto) {
        System.out.println("============");
        System.out.println(reservationResponseDto.getDoctorId());
        reservationService.save(reservationResponseDto);
        return "/welcome";
    }

    @GetMapping("/reserves")
    public String reserveList(Model model) {
        List<ReservationResponseDto> reserveList = reservationService.findAll();
        for (ReservationResponseDto reservationResponseDto : reserveList) {
            System.out.println("============");
            System.out.println(reservationResponseDto);
        }

        model.addAttribute("reserve", reserveList);
        return "reservation/reserveList";
    }
}

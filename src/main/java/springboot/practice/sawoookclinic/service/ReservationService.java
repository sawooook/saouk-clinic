package springboot.practice.sawoookclinic.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.practice.sawoookclinic.domain.Doctor;
import springboot.practice.sawoookclinic.domain.Owner;
import springboot.practice.sawoookclinic.domain.Reservation;
import springboot.practice.sawoookclinic.domain.dto.Reservation.ReservationRequestDto;
import springboot.practice.sawoookclinic.domain.dto.Reservation.ReservationResponseDto;
import springboot.practice.sawoookclinic.repository.DoctorRepository;
import springboot.practice.sawoookclinic.repository.OwnerRepository;
import springboot.practice.sawoookclinic.repository.ReservationRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final DoctorRepository doctorRepository;
    private final OwnerRepository ownerRepository;

    public boolean save(ReservationRequestDto reservationRequestDto) {

        System.out.println("===============1111=========");
        System.out.println(reservationRequestDto.getDoctorId());

        Doctor doctor = doctorRepository.finOne(reservationRequestDto.getDoctorId());
        Owner owner = ownerRepository.findOne(reservationRequestDto.getOwnerId());

        if (!doctor.checkReservation(reservationRequestDto.getReservationTime())) {
            throw new IllegalStateException("이미 에약이 되어있습니다");
        }

        Reservation reservation = Reservation.builder().doctor(doctor).owner(owner)
                .reservationTime(reservationRequestDto.getReservationTime()).build();

        reservationRepository.save(reservation);
        return true;
    }

    public List<ReservationResponseDto> findAll() {
        List<ReservationResponseDto> reserveLists = reservationRepository.findAll().stream().map(reservation -> new ReservationResponseDto(reservation)).collect(Collectors.toList());
        return reserveLists;
    }
}

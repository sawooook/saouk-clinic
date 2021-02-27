package springboot.practice.sawoookclinic.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.practice.sawoookclinic.domain.Doctor;
import springboot.practice.sawoookclinic.domain.Owner;
import springboot.practice.sawoookclinic.domain.Reservation;
import springboot.practice.sawoookclinic.domain.dto.Reservation.ReservationRequestDto;
import springboot.practice.sawoookclinic.repository.DoctorRepository;
import springboot.practice.sawoookclinic.repository.OwnerRepository;
import springboot.practice.sawoookclinic.repository.ReservationRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final DoctorRepository doctorRepository;
    private final OwnerRepository ownerRepository;

    public boolean save(ReservationRequestDto reservationRequestDto) {

        Doctor doctor = doctorRepository.finOne(reservationRequestDto.getDoctorId());
        Owner owner = ownerRepository.findOne(reservationRequestDto.getOwnerId());

        if (!doctor.checkReservation(reservationRequestDto.getReservationTime())) {
            return false;
        }

        Reservation.builder().doctor(doctor).owner(owner)
                .reservationTime(reservationRequestDto.getReservationTime()).build();

        return true;
    }

}

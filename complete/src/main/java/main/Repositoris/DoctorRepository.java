package main.Repositoris;

import main.Models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by vakhtanggelashvili on 11/29/15.
 */
@Transactional
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findByPhoneAndPin(@Param("phone") String username, @Param("pin") String pin);

}

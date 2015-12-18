package main.Repositoris;

import main.Models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by vakhtanggelashvili on 11/29/15.
 */
@Transactional
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}

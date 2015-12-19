package main.Repositoris;

import main.Models.Call;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vakhtanggelashvili on 12/18/15.
 */
@Transactional
public interface CallRepository extends JpaRepository<Call, Long> {
}

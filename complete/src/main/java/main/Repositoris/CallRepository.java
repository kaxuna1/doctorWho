package main.Repositoris;

import main.Models.Call;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by vakhtanggelashvili on 12/18/15.
 */
@Transactional
public interface CallRepository extends JpaRepository<Call, Long> {
    @Query("select u from Call u WHERE u.date > :date")
    List<Call> findByDate(@Param("date")Date date);


}

package main.Repositoris;

import main.Models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

/**
 * Created by vakhtanggelashvili on 12/19/15.
 */
@Transactional
public interface SessionRepository extends JpaRepository<Session, Long> {
}


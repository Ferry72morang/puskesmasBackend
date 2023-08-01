package puskesmas.app.patientservice.puskesmasbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import puskesmas.app.patientservice.puskesmasbackend.model.Personal;

import java.util.List;

public interface PersonalRepository extends JpaRepository<Personal, Long> {
    List<Personal> findAll();
}

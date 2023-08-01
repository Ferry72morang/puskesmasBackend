package puskesmas.app.patientservice.puskesmasbackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "personal")
public @Data
class Personal {
    @Id
    @Column(name = "personal_id")
    private Long personalId;

    @Column(name = "personal_name")
    private String personalName;

    @Column(name = "personal_birth_date")
    private Timestamp personalBirthDate;

    @Column(name = "personal_birth_place")
    private String personalBirthPlace;

    @Column(name = "personal_phone_number")
    private String personalPhoneNumber;

    @Column(name = "personal_is_active")
    private Boolean personalIsActive;

}

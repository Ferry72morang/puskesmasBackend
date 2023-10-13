package id.puskesmas.backend.model;


import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "personal")
public class Personal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private boolean personalIsActive;
}

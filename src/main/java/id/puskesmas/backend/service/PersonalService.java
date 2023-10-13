package id.puskesmas.backend.service;

import id.puskesmas.backend.model.Personal;

import java.util.List;

public interface PersonalService {
    List<Personal>listPersonal();
    void addPersonal(Personal personal);
}

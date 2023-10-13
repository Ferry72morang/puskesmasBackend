package id.puskesmas.backend;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestDataPersonal {

    public boolean checkDataPersonal(){

        return true;
    }

    @Test
    public void isPersonalData(){
        Assertions.assertTrue(checkDataPersonal());
    }
}

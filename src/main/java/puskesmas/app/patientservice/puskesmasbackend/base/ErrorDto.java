package puskesmas.app.patientservice.puskesmasbackend.base;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.ToString;

@Data
@AllArgsConstructor
@JsonInclude(value = Include.NON_EMPTY)
@ToString
public class ErrorDto implements Serializable {
    private Timestamp timestamp;
    private String message;
    private String path;
    private String stackTrace;
}

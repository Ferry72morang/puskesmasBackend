package id.puskesmas.backend.model;

import lombok.Data;

import java.util.Set;

@Data
public class ProduceDto {
    private String action;
    private String fromTable;
    private Set<String> toTable;
    private Object payload;
    private String status;
}

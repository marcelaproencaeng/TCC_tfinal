package com.bluerecycling.bluerecycling.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransporteDTO {

    private Long idTransporte;

    private Boolean hasLicença;
}

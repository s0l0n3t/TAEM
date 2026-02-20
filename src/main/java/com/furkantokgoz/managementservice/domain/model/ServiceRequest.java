package com.furkantokgoz.managementservice.domain.model;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceRequest {
    // Validation will be on business layer.
    @NotBlank (message = "Name is needed") String serviceName;
    String serviceDescription; //Includes workflow like color.
    @NotBlank (message = "Path is needed") String dataFileName;
    ZonedDateTime serviceEndDate;
    ZonedDateTime serviceStartDate;//Current date


}

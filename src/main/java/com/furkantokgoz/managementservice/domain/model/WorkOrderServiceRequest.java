package com.furkantokgoz.managementservice.domain.model;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkOrderServiceRequest {
    // Validation will be on business layer.
    @NotBlank (message = "Name is needed") private String serviceCustomerDescription;
    private String serviceDescription; //Includes workflow like color.
    @NotBlank (message = "Path is needed") private String serviceDataPath;
    private ZonedDateTime serviceEndDate;
    private ZonedDateTime serviceStartDate;//Current date


}

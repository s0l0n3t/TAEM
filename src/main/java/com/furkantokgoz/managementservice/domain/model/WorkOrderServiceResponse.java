package com.furkantokgoz.managementservice.domain.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkOrderServiceResponse {
    String id;
    String serviceName;
    String serviceDescription;
    String dataFileName;
    ZonedDateTime serviceStartDate;
    ZonedDateTime serviceEndDate;


}

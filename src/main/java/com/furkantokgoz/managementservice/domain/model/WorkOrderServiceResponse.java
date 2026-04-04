package com.furkantokgoz.managementservice.domain.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkOrderServiceResponse {
    String id;
    String serviceCustomerDescription;
    String serviceDescription;
    String serviceDataPath;
    File serviceMultipartFile;
    ZonedDateTime serviceUploadDate;
    ZonedDateTime serviceStartDate;//current time
    ZonedDateTime serviceEndDate;
}

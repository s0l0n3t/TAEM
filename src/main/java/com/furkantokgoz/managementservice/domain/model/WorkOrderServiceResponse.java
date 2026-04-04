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
    private String id;
    private String serviceCustomerDescription;
    private String serviceDescription;
    private String serviceDataPath;
    private File serviceMultipartFile;
    private ZonedDateTime serviceUploadDate;
    private ZonedDateTime serviceStartDate;//current time
    private ZonedDateTime serviceEndDate;
}

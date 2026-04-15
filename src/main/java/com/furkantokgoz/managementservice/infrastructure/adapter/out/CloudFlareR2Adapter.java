package com.furkantokgoz.managementservice.infrastructure.adapter.out;

import com.furkantokgoz.managementservice.application.port.ImageStoragePort;
import com.furkantokgoz.managementservice.infrastructure.adapter.out.persistence.CloudFlareR2RepositoryImpl;
import org.springframework.web.multipart.MultipartFile;

public class CloudFlareR2Adapter implements ImageStoragePort {
    //identify s3client

    private final CloudFlareR2RepositoryImpl cloudFlareR2Repository;

    public CloudFlareR2Adapter(CloudFlareR2RepositoryImpl cloudFlareR2Repository) {
        this.cloudFlareR2Repository = cloudFlareR2Repository;
    }

    @Override
    public void uploadPhoto(String filePath) {
        //Cloudflare file deployment logic
    }
    @Override
    public MultipartFile downloadPhoto(String filePath) {
        //Cloudflare file download logic
        return null;
    }
}

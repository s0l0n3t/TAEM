package com.furkantokgoz.managementservice.infrastructure.persistence.pgdb.adapter;

import com.furkantokgoz.managementservice.domain.port.ImageStoragePort;

public class CloudFlareR2Adapter implements ImageStoragePort {
    //identify s3client

    @Override
    public void uploadPhoto(String filePath) {
        //Cloudflare file deployment logic
    }
    @Override
    public void downloadPhoto(String filePath) {
        //Cloudflare file download logic
    }
}

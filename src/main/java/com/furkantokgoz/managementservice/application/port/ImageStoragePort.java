package com.furkantokgoz.managementservice.application.port;

import org.springframework.web.multipart.MultipartFile;

public interface ImageStoragePort {
    public void uploadPhoto(String filePath);
    public MultipartFile downloadPhoto(String filePath);//return value will change
}

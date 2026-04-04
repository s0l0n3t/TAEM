package com.furkantokgoz.managementservice.application.port;

public interface ImageStoragePort {
    public void uploadPhoto(String filePath);
    public void downloadPhoto(String filePath);//return value will change
}

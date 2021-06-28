package com.example.remessa_cnab.conexao.sftp;

public interface FileTransferService {

    boolean uploadFile(String localFilePath, String remoteFilePath);

    boolean downloadFile(String localFilePath, String remoteFilePath);
}

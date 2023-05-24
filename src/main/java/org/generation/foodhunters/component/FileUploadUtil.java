package org.generation.foodhunters.component;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.*;

/**
 * Azure Blob Storage quickstart
 */
import com.azure.storage.blob.*;
import com.azure.storage.blob.models.*;

public class FileUploadUtil {

    public static void saveFile(String uploadDir1, String fileName,
                                MultipartFile multipartFile) throws IOException {
//        Uploads for local folder
//        Path uploadPath1 = Paths.get(uploadDir1);
//        try (InputStream inputStream = multipartFile.getInputStream()) {
//
//
//            Path filePath1 = uploadPath1.resolve(fileName);
//            Files.copy(inputStream, filePath1, StandardCopyOption.REPLACE_EXISTING);
//        } catch (IOException ioe) {
//            throw new IOException("Could not save image file: " + fileName, ioe);
//        }
//    }

        /* This is the setup using Azure storage */
        String connectStr2 = "Put your own connection string";
        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder().connectionString(connectStr2).buildClient();
        String containerName = "prodimage";


        BlobContainerClient containerClient = blobServiceClient.getBlobContainerClient(containerName);


        BlobClient blobClient = containerClient.getBlobClient(fileName);


        InputStream inputStream = multipartFile.getInputStream();
        blobClient.upload(inputStream);

    }
}
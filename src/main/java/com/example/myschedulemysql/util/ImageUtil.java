package com.example.myschedulemysql.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.util.Objects;
import java.util.UUID;

public class ImageUtil {

    private static final String BASE_UPLOAD_DIR = "src/main/resources/static/assets/images/";

    public static String saveImage(MultipartFile file, String folder) throws IOException {

        if (file == null || file.isEmpty()) {
            return null;
        }

        Path uploadPath = Paths.get(BASE_UPLOAD_DIR, folder);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        String originalFilename = file.getOriginalFilename();

        String extension = "";

        if (originalFilename != null && originalFilename.contains(".")) {
            extension = originalFilename.substring(originalFilename.lastIndexOf("."));
        }

        String fileName = UUID.randomUUID() + extension;

        Path filePath = uploadPath.resolve(fileName);

        Files.copy(
                file.getInputStream(),
                filePath,
                StandardCopyOption.REPLACE_EXISTING
        );

        return "/assets/images/" + folder + "/" + fileName;
    }

    public static String getImage(String imagePath) {
        if (Objects.isNull(imagePath) || imagePath.isBlank()) {
            throw new IllegalArgumentException("Please provide the image path.");
        }
        return Enpoint.url + imagePath;
    }
}
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package hkmu.wadd.service;

import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageService {
    private final Path root = Paths.get("uploads");

    public FileStorageService() {
        try {
            Files.createDirectories(this.root);
        } catch (IOException var2) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }

    public List<String> saveFiles(List<MultipartFile> files) {
        List<String> fileUrls = new ArrayList();

        for(MultipartFile file : files) {
            if (!file.isEmpty()) {
                long var10000 = System.currentTimeMillis();
                String fileName = var10000 + "_" + file.getOriginalFilename();

                try {
                    Files.copy(file.getInputStream(), this.root.resolve(fileName), new CopyOption[0]);
                    fileUrls.add("/uploads/" + fileName);
                } catch (IOException var7) {
                    throw new RuntimeException("Could not store the file: " + fileName);
                }
            }
        }

        return fileUrls;
    }
}

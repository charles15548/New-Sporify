package com.sporify.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadService {

	private String folder = "Audio"+File.separator;
	
	public String saveAudio(MultipartFile file) throws IOException {
		if(!file.isEmpty()) {
			 String uniqueFileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
		        byte[] bytes = file.getBytes();
		        Path path = Paths.get(folder);
		        
		        // Verificar si el directorio existe, si no, crearlo
		        if (!Files.exists(path)) {
		            Files.createDirectories(path);
		        }
		        
		        // Guardar el archivo
		        path = path.resolve(uniqueFileName);
		        Files.write(path, bytes);
		        return uniqueFileName;
		}
		return "default.jpg";
	}
	
}

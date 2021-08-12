package edu.poly.shop.service;

import java.io.IOException;
import java.nio.file.Path;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

	void init();

	void delete(String storedFilename) throws IOException;

	Path load(String fileName);

	Resource loadAsResource(String filename);

	void store(MultipartFile file, String storedFilename);

	String getStorageFileName(MultipartFile file, String id);

}

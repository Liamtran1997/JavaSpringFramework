package edu.poly.shop.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.apache.commons.io.FilenameUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import edu.poly.shop.config.StorageProperties;
import edu.poly.shop.exception.StorageException;
import edu.poly.shop.service.StorageService;

@Service
public class FileSystemStorageServiceImpl implements StorageService {
	
	private final Path rootlocation;
	
	
	@Override
	public String getStorageFileName(MultipartFile file,String id) {
		String ext = FilenameUtils.getExtension(file.getOriginalFilename());
		return "p" + id + "." + ext;
	}
	
	public FileSystemStorageServiceImpl(StorageProperties properties) {
		this.rootlocation = Paths.get(properties.getLocation());
	}
	
	
	@Override
	public void store(MultipartFile file,String storedFilename) {
		try {
			if (file.isEmpty()) {
				throw new StorageException("Failed to store empty file");
			}
			
			Path destinationFile = this.rootlocation.resolve(Paths.get(storedFilename))
					.normalize().toAbsolutePath();
			if (!destinationFile.getParent().
				equals(this.rootlocation.toAbsolutePath())) {
				throw new StorageException("Cannot store file outside current directory");
			}
			try(InputStream inputStream = file.getInputStream()){
				Files.copy(inputStream,destinationFile,
				StandardCopyOption.REPLACE_EXISTING);
			}
		} catch (Exception e) {
			throw new StorageException("Failed to store file",e);
			}
		}
	
	
	
	@Override
	public Resource loadAsResource(String filename) {
		try {
			Path file = load(filename);
			Resource resource = new UrlResource(file.toUri());
			
			if (resource.exists() || resource.isReadable()) {
				return resource;
			}
			
			throw new StorageException("Could not read file: "+ filename);
		} catch (Exception e) {
			throw new StorageException("Could not read file: "+ filename);
		}	
	}
	
	@Override
	public Path load(String fileName) {
		return rootlocation.resolve(fileName);
	}
	
	

	@Override
	public void delete(String storedFilename) throws IOException {
		Path destinationFile = rootlocation.resolve(Paths.get(storedFilename))
				.normalize().toAbsolutePath();
		
		Files.delete(destinationFile);
	}
	
	
	
	@Override
	public void init() {
		try {
			Files.createDirectories(rootlocation);
			System.out.println(rootlocation.toString());
		} catch (Exception e) {
			throw new StorageException("Could not initialize storage ",e);
		}
	}
}

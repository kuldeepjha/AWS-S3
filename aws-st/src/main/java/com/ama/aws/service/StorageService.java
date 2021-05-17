package com.ama.aws.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @author 
 *
 */
public interface StorageService {
	
	public String uploadFile(MultipartFile file) ;
	
	public byte[] downloadFile(String fileName);
	
	public String deleteFile(String fileName);
	
}

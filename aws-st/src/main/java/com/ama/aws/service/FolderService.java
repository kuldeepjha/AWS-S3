package com.ama.aws.service;

/**
 * 
 * @author 
 *
 */
public interface FolderService {

	public String CreateFolder(String folderName);
	
	public String CreateSubFolder(String folderName);

	public String deleteFolder(String folderName);
}

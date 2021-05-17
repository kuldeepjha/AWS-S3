package com.ama.aws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ama.aws.service.FolderService;

/**
 * 
 * @author 
 *
 */
@RestController
@RequestMapping("/folder")
public class FolderController {

	@Autowired
	FolderService folderService;

	/**
	 * 
	 * @param folderName
	 * @return
	 */
	@GetMapping("/createFolder/{folderName}")
	public ResponseEntity<String> folderName(@PathVariable String folderName) {
		return new ResponseEntity<>(folderService.CreateFolder(folderName), HttpStatus.OK);
	}

	/**
	 * 
	 * @param folderName
	 * @return
	 */
	@DeleteMapping("/deleteFolder/{folderName}")
	public ResponseEntity<String> deteleFolder(@PathVariable String folderName) {
		return new ResponseEntity<>(folderService.deleteFolder(folderName), HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param folderName
	 * @return
	 */
	@GetMapping("/createSubFolder/{folderName}")
	public ResponseEntity<String> folderSubName(@PathVariable String folderName) {
		return new ResponseEntity<>(folderService.CreateSubFolder(folderName), HttpStatus.OK);
	}

}

package com.ama.aws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ama.aws.service.BucketService;

/**
 * 
 * @author 
 *
 */
@RestController
@RequestMapping("/bucket")
public class BucketController {
	
	@Autowired
	BucketService bucketService;

	/**
	 * 
	 * @param bucketName
	 * @return
	 */
	@GetMapping("/createBucket/{bucketName}")
	public ResponseEntity<String> bucketName(@PathVariable String bucketName) {
		return new ResponseEntity<>(bucketService.createBucket(bucketName), HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param bucketName
	 * @return
	 */
	@DeleteMapping("/deleteBucket/{bucketName}")
	public ResponseEntity<String> deleteName(@PathVariable String bucketName) {
		return new ResponseEntity<>(bucketService.deleteBucket(bucketName), HttpStatus.OK);
	}
	
}

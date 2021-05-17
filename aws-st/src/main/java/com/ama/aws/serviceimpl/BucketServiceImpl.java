package com.ama.aws.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ama.aws.service.BucketService;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CreateBucketRequest;
import com.amazonaws.services.s3.model.DeleteBucketRequest;

/**
 * 
 * @author
 *
 */
@Service
public class BucketServiceImpl implements BucketService {

	@Value("${cloud.aws.region.static}")
	private String region;

	@Value("${application.bucket.name}")
	private String bucketName;

	@Autowired
	private AmazonS3 s3Client;

	/**
	 * This method for create a new bucket
	 * 
	 * @param folderName
	 */
	@Override
	public String createBucket(String bucketName) {

		// create bucket
		CreateBucketRequest createBucketRequest = new CreateBucketRequest(bucketName);
		s3Client.createBucket(createBucketRequest);

		// or

		// s3Client.createBucket(bucketName);

		return "Success...";
	}

	/**
	 * This method for create a new bucket
	 * 
	 * @param folderName
	 */
	@Override
	public String deleteBucket(String bucketName) {

		// deletes bucket
		DeleteBucketRequest deleteBucketRequest = new DeleteBucketRequest(bucketName);
		s3Client.deleteBucket(deleteBucketRequest);

		// or

		// s3client.deleteBucket(bucketName);

		return "Success...";
	}

}

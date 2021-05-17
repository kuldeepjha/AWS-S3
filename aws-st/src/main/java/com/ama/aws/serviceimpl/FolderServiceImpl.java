package com.ama.aws.serviceimpl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ama.aws.service.FolderService;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3ObjectSummary;

/**
 * 
 * @author
 *
 */
@Service
public class FolderServiceImpl implements FolderService {

	@Value("${cloud.aws.region.static}")
	private String region;

	@Value("${application.bucket.name}")
	private String bucketName;

	@Autowired
	private AmazonS3 s3Client;

	/**
	 * 
	 * @param folderName
	 */
	@Override
	public String CreateFolder(String folderName) {

		createFolder(bucketName, folderName, s3Client);
		return "Success...";
	}

	/**
	 * This method for create folder inside the bucket
	 * 
	 * @param bucketName
	 * @param folderName
	 * @param client
	 */
	private static void createFolder(String bucketName, String folderName, AmazonS3 client) {

		// create meta-data for your folder and set content-length to 0
		ObjectMetadata metadata = new ObjectMetadata();
		metadata.setContentLength(0);

		// create empty content
		InputStream emptyContent = new ByteArrayInputStream(new byte[0]);

		// create a PutObjectRequest passing the folder name suffixed by /
		PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, folderName + "/", emptyContent, metadata);

		// send request to S3 to create folder
		client.putObject(putObjectRequest);
	}

	/**
	 * 
	 * @param folderName
	 */
	@Override
	public String deleteFolder(String folderName) {

		deleteFolder(bucketName, folderName, s3Client);
		return "Success...";
	}

	/**
	 * This method first deletes all the files in given folder and than the folder
	 * itself
	 * 
	 * @param bucketName
	 * @param folderName
	 * @param client
	 */
	public static void deleteFolder(String bucketName, String folderName, AmazonS3 client) {

		// get all list of data and file inside the folder
		List<S3ObjectSummary> fileList = client.listObjects(bucketName, folderName).getObjectSummaries();

		for (S3ObjectSummary file : fileList) {
			// delete the data and file
			client.deleteObject(bucketName, file.getKey());
		}

		// delete the folder
		client.deleteObject(bucketName, folderName);
	}

	@Override
	public String CreateSubFolder(String folderName) {
		createSubFolder(bucketName, folderName, s3Client);
		return "Success...";
	}

	/**
	 * This method for create Sub-folder inside the bucket
	 * 
	 * @param bucketName
	 * @param folderName
	 * @param client
	 */
	private static void createSubFolder(String bucketName, String folderName, AmazonS3 client) {

		// create meta-data for your folder and set content-length to 0
		ObjectMetadata metadata = new ObjectMetadata();
		metadata.setContentLength(0);

		// create empty content
		InputStream emptyContent = new ByteArrayInputStream(new byte[0]);

		// create a PutObjectRequest passing the folder name suffixed by /
		PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, "Org" + "/" + folderName + "/", emptyContent, metadata);

		// send request to S3 to create folder
		client.putObject(putObjectRequest);
	}

}

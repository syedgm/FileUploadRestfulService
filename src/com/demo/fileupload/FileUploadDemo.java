package com.demo.fileupload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;


@Path("/uploadfile")
public class FileUploadDemo {

	@POST
	@Path("/upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadFile(
							@FormDataParam("file") InputStream input,
							@FormDataParam("file") FormDataContentDisposition fileDetail) {
		
		String path = "d://" + fileDetail.getFileName();
		try {  
            FileOutputStream out = new FileOutputStream(new File(path));  
            int read = 0;  
            byte[] bytes = new byte[1024];  
            out = new FileOutputStream(new File(path));  
            while ((read = input.read(bytes)) != -1) {  
                out.write(bytes, 0, read);  
            }  
            out.flush();  
            out.close();  
        } catch (IOException e) {
        	e.printStackTrace();
        }  
        	String output = "File successfully uploaded to : " + path;  
        return Response.status(200).entity(output).build(); 
		
	}
	
}

package com.mmarques.resource;

import java.io.*;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.WebServiceException;

@WebService
public class WebServiceSOAPEnviaRecebeArquivo {
    @WebMethod
    public void upload(String fileName, byte[] imageBytes){
        String filePath = "d:/temp/upload/" + fileName;
        try{
            FileOutputStream fos = new FileOutputStream(filePath);
            BufferedOutputStream outputStream = new BufferedOutputStream(fos);
            outputStream.write(imageBytes);
            outputStream.close();
        }catch(IOException e){
            System.err.println(e);
            throw new WebServiceException(e);
        }
    }
    
    @WebMethod
    public byte[] download(String fileName){
        String filePath = "d:/temp/download/" + fileName;
        try{
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream inputStream = new BufferedInputStream(fis);
            byte[] fileBytes = new byte[(int) file.length()];
            inputStream.read(fileBytes);
            inputStream.close();
            return fileBytes;
        }catch(IOException e){
            System.err.println(e);
            throw new WebServiceException(e);
        }
    }
}

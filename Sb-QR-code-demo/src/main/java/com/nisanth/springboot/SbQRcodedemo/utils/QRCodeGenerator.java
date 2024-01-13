package com.nisanth.springboot.SbQRcodedemo.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import com.nisanth.springboot.SbQRcodedemo.model.student.Student;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class QRCodeGenerator
{
    public static void generateQRCode(Student student) throws WriterException, IOException
    {
        String qrCodepath = "/Users/sujiths/ nisanth/new/";

        String qrCodeName= qrCodepath+student.getFirstName()+student.getId()+"-QRCode.png";
      var qrCodeWriter=new QRCodeWriter();
        BitMatrix bitMatrix=qrCodeWriter.encode(
                "ID:"+student.getId()+"\n"+
                        "FirstName:"+student.getFirstName()+"\n"+
                        "LastName:"+student.getLastName()+"\n"+
                        "Email:"+student.getEmail()+"\n"+
                        "MobileNumber:"+student.getMobile(),
                BarcodeFormat.QR_CODE,400,400);

        Path path= FileSystems.getDefault().getPath(qrCodeName);
        MatrixToImageWriter.writeToPath(bitMatrix,"PNG",path);
       // System.out.println("QR Code Path: " + qrCodeName);

    }
}

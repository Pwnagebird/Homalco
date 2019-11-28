package com.homalco.ims.services;

import lombok.Getter;
import net.glxn.qrgen.javase.QRCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
@Getter
public class QRCodeService{

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

    private File qrCodeImage;

    public void createQRCode(String id) {
        this.qrCodeImage = QRCode.from(id).file("product_" + String.join("_", id.toLowerCase().split("\\s")) + "_");
        printQRCode();
    }

    public void printQRCode() {
        LOGGER.info("Created QR code at: " + this.qrCodeImage.getAbsolutePath());
    }
}

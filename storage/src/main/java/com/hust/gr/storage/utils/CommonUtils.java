package com.hust.gr.storage.utils;

import lombok.experimental.UtilityClass;
import org.springframework.http.MediaType;
import org.springframework.web.HttpMediaTypeNotSupportedException;

import java.util.Objects;

@UtilityClass
public class CommonUtils {
    public MediaType getMediaTypeByFileName(String fileName) throws HttpMediaTypeNotSupportedException {
        String extra = getExtraFile(fileName);
        switch (extra.toUpperCase()) {
            case "PNG":
                return MediaType.IMAGE_PNG;
            case "HTML":
                return MediaType.TEXT_HTML;
            case "PDF":
                return MediaType.APPLICATION_PDF;
            default:
                throw new HttpMediaTypeNotSupportedException("Not support your type");
        }
    }

    public String getExtraFile(String fileName) {
        if (Objects.isNull(fileName)) return "";
        int index = fileName.lastIndexOf(".");
        if (index <= 0) return "";
        return fileName.substring(index + 1);
    }
}

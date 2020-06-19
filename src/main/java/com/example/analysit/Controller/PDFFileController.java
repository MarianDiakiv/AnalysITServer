package com.example.analysit.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
public class PDFFileController {

    @GetMapping("/download")
    @CrossOrigin(origins = "http://localhost:4200")
    public  void downloadFile( HttpServletResponse res) throws IOException, URISyntaxException {
        String fileName = "static/StatisticsFilePDF.pdf";
        res.setHeader("Content_Disposition","attachement; filename"+ fileName);
        res.getOutputStream().write(contentOf(fileName));
    }

    private byte[] contentOf(String fileName) throws URISyntaxException, IOException {
        //Files.readAllBytes(fileName);
       return Files.readAllBytes(Paths.get(getClass().getClassLoader().getResource(fileName).toURI()));
    }
}

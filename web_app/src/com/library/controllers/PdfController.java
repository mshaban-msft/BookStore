package com.library.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.library.jasper.report;

@Controller
public class PdfController {

	@RequestMapping(value="/getpdf", method=RequestMethod.GET)
	public ResponseEntity<byte[]> getPDF() throws IOException {

	    // generate the file
		report generator = new report() ;
		generator.createReport();
		
		// retrieve contents of "C:/tmp/report.pdf" that were written in showHelp
		Path path = Paths.get("C:/Users/Saed Hamdy/workspace/book_2/src/report/rep.pdf");
		byte[] contents = Files.readAllBytes(path);
		
		
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.parseMediaType("application/pdf"));
	    String filename = "output.pdf";
	 //   headers.setContentDispositionFormData(filename, filename);
	    headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
	    ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(contents, headers, HttpStatus.OK);
	    return response;
	}
	
}

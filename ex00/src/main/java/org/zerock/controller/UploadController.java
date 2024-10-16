package org.zerock.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class UploadController {

	@GetMapping("/uploadForm")
	public void uploadForm() {
		log.info("uploadForm");
		// /WEB-INF/views/uploadForm.jsp
	}
	
	/**
	 * 
	 * @param uploadfile <input name="uploadfile">
	 */
	@PostMapping("/uploadForm")
	public void uploadForm(MultipartFile[] uploadFile, Model model) {
		log.info("post uploadForm");
		String uploadFolder = "c:/upload";
		
		for (MultipartFile file: uploadFile) {
		
			log.info(file.getOriginalFilename());
			log.info(file.getSize()); // 15558 15.1KB (15,558 바이트)
			
			
			File saveFile = new File(uploadFolder, file.getOriginalFilename());
			try {
				file.transferTo(saveFile);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		
	}
}

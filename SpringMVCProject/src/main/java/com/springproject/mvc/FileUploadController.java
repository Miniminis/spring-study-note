package com.springproject.mvc;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.springproject.mvc.domain.Report;

@Controller
public class FileUploadController {
	
	String path = "/uploadedfile";
	
	@RequestMapping("/fileupload/uploadForm")
	public String getForm() {
		return "fileupload/uploadForm";
	}
	
	@RequestMapping(value = "/fileupload/upload1", method = RequestMethod.POST)
	public String upload(
			@RequestParam("snum") String snum,
			@RequestParam("sreport") MultipartFile file,
			Model model, 
			HttpServletRequest request
			) {
				
		model.addAttribute("snum", snum);
		model.addAttribute("filename", file.getOriginalFilename());
		model.addAttribute("filesize", file.getSize());
		
		String dir = request.getSession().getServletContext().getRealPath(path);
		
		try {
			if(!file.isEmpty() && file.getSize()>0) {
				file.transferTo(new File(dir, snum+"_"+file.getOriginalFilename()));
			}
			
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "fileupload/upload";
	}
	
	@RequestMapping(value = "/fileupload/upload02", method = RequestMethod.POST)
	public String upload2(
			MultipartHttpServletRequest request,
			Model model
			) {
		
		String snum = request.getParameter("snum");
		MultipartFile file = request.getFile("sreport");
		
		model.addAttribute("snum", snum);
		model.addAttribute("filename", file.getOriginalFilename());
		model.addAttribute("filesize", file.getSize());
		System.out.println("퉷");
		return "fileupload/upload";
	}
	
	                        
	@RequestMapping(value = "/fileupload/upload03", method = RequestMethod.POST)
	public String upload3(Report report) {
		System.out.println("퉷!");
		System.out.println(report.getSnum());
		return "fileupload/upload";
	}
	

}

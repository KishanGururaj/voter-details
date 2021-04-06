package com.wolken.wolkenapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.wolken.wolkenapp.dto.VoterServletDTO;
import com.wolken.wolkenapp.service.VoterServiceServlet;
import com.wolken.wolkenapp.service.VoterServiceServletImpl;

@WebServlet(urlPatterns="/vote",loadOnStartup=+9)
public class VoterServelet extends HttpServlet {
	VoterServletDTO voterServletDTO=new VoterServletDTO();
	VoterServiceServlet voterServiceServlet=new VoterServiceServletImpl();
		
	
	
	public VoterServelet() {
		// TODO Auto-generated constructor stub
		System.out.println("request object created");
	}
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name =req.getParameter("name");
		String place=req.getParameter("place");
		String age=req.getParameter("age");
		int age1=Integer.parseInt(age);
		
		voterServletDTO.setName(name);
		voterServletDTO.setPlace(place);
		voterServletDTO.setAge(age1);
		voterServiceServlet.validateAndSave(voterServletDTO);
		PrintWriter printWriter=resp.getWriter();
		printWriter.print("come to party  "+name);
		printWriter.flush();
		printWriter.close();
	}
}

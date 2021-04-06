package com.wolken.wolkenapp.service;

import java.sql.SQLException;

import com.wolken.wolkenapp.dao.VoterServletDAO;
import com.wolken.wolkenapp.dao.VoterServletDAOImpl;
import com.wolken.wolkenapp.dto.VoterServletDTO;

public class VoterServiceServletImpl implements VoterServiceServlet{
	VoterServletDAO voterServletDAO=new VoterServletDAOImpl();
	VoterServletDTO voterServletDTO=new VoterServletDTO();
	@Override
	public void validateAndSave(VoterServletDTO voterServletDTO) {
		// TODO Auto-generated method stub
		if(voterServletDTO.getName()!=null) {
			if(voterServletDTO.getPlace()!=null) {
				if(voterServletDTO.getAge()>0) {
					try {
						voterServletDAO.add(voterServletDTO);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
	

}

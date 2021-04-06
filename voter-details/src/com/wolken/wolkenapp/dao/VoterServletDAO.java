package com.wolken.wolkenapp.dao;

import java.sql.SQLException;

import com.wolken.wolkenapp.dto.VoterServletDTO;

public interface VoterServletDAO {
	public void add(VoterServletDTO voterServletDTO ) throws SQLException;
}

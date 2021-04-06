package com.wolken.wolkenapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.wolken.wolkenapp.dto.VoterServletDTO;

public class VoterServletDAOImpl implements VoterServletDAO {
	VoterServletDTO voterServletDTO = new VoterServletDTO();

	@Override
	public void add(VoterServletDTO voterServletDTO) throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try (Connection con = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/wolken?user=root&password=Password@1234567890")) {
			// TODO Auto-generated method stub
			try (PreparedStatement pre = con.prepareStatement("insert into wolken.voter_table values(?,?,?)");) {
				pre.setString(2, voterServletDTO.getName());
				pre.setString(3, voterServletDTO.getPlace());
				pre.setInt(1, voterServletDTO.getAge());
				pre.executeUpdate();
				System.out.println("inmate data is added ");
				pre.close();
				System.out.println("data added is been");
			}
			con.close();
		}
	}
}

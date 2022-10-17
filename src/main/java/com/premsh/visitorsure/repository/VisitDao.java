package com.premsh.visitorsure.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import com.premsh.visitorsure.models.Visit;

@Repository
public class VisitDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private BeanPropertyRowMapper<Visit> visitRowMapper = BeanPropertyRowMapper.newInstance(Visit.class);
	
	public List<Visit> getAllVisits(){
		return jdbcTemplate.query("select * from visit", visitRowMapper);
	}
	public List<Visit> getById(Integer id){
		return jdbcTemplate.query("select * from visit where visit_id=%d".formatted(id), visitRowMapper);
	}
	public List<Visit> getByPasscode(Integer passcode){
		return jdbcTemplate.query("select * from visit where pass_code=%d".formatted(passcode), visitRowMapper);
	}
	
	public boolean createVisit(final Visit visit) {
		
		return jdbcTemplate.execute("insert into visit(visitor_id, employee_id, office_id, visit_start_date, visit_end_date, pass_code) values(?,?,?,?,?,?)",
				new PreparedStatementCallback<Boolean>(){  
		    public Boolean doInPreparedStatement(PreparedStatement ps)  
		            throws SQLException, DataAccessException {  
		              
		        ps.setInt(1, visit.getVisitorId()); 
		        ps.setInt(2, visit.getEmployeeId()); 
		        ps.setInt(3, visit.getOfficeId()); 
		        ps.setDate(4, visit.getVisitStartDate()); 
		        ps.setDate(5, visit.getVisitEndDate()); 
		        ps.setInt(6, visit.getPassCode()); 

		              
		        return ps.execute();  
		              
		    }  
		    });  
		}  
	
	public boolean updateVisit(final Visit visit, final Integer id) {
		
		return jdbcTemplate.execute("update visit set visitor_id =?, employee_id=?, office_id=?, visit_start_date=?, visit_end_date=?, pass_code=? "
				+ "where visit_id = ?;", new PreparedStatementCallback<Boolean>() {
					
					public Boolean doInPreparedStatement(PreparedStatement ps)
							throws SQLException, DataAccessException {

				        ps.setInt(1, visit.getVisitorId()); 
				        ps.setInt(2, visit.getEmployeeId()); 
				        ps.setInt(3, visit.getOfficeId()); 
				        ps.setDate(4, visit.getVisitStartDate()); 
				        ps.setDate(5, visit.getVisitEndDate()); 
				        ps.setInt(6, visit.getPassCode()); 
						ps.setInt(7, id);
						return ps.execute();
					}
				});
	}
	
	public boolean deleteVisit(final Integer id) {
		return (jdbcTemplate.update("delete from visit where visit_id="+id+";") != 0);
	}
}

package edu.kosmo.ex.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import edu.kosmo.ex.mapper.EmpMapper;
import edu.kosmo.ex.vo.EmpVO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class EmpService {
   
   @Inject
   private EmpMapper empMapper;
   
	/*
	 * public EmpVO getUser(String empNo){ log.info("readUser .. "); return
	 * empMapper.readUser(empNo); }
	 */
   public EmpVO getUser(String ename){
	      log.info("readUser .. ");
	     
			/*
			 * Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			 * user_id = auth.getName(); System.out.println("유저 아이디:" + user_id );
			 */
	        
	      EmpVO empVO = empMapper.readUser(ename);
	      empVO.setAuthList(empMapper.readAuthority(ename));
	      
	      return empVO;
	   }
}
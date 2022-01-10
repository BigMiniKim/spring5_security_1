package edu.kosmo.ex.mapper;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import edu.kosmo.ex.vo.AuthVO;
import edu.kosmo.ex.vo.EmpVO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

@Mapper
public interface EmpMapper {
   
   @Select("select * from emp where ename = #{ename}")
   public EmpVO readUser(String name);
   
   
   @Select("select ename,case when job='MANAGER' then 'ROLE_ADMIN' else  'ROLE_USER' end authority from emp where ename = #{ename}")
   public List<AuthVO> readAuthority(String name);
   
}
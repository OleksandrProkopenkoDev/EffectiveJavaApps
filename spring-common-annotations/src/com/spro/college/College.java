package com.spro.college;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component("collegeBean") //id = collegeBean

@Component // -default bean id will be "college"
public class College {
	@Value("${college.name}")
	private String collegeName;
	@Autowired
	private Principal principal;
	@Autowired
	@Qualifier("scienceTeacher")
	private Teacher teacher;
	
	

	public College() {
	}



	public College(Principal principal) {
		this.principal = principal;
	}



	public void test() {
		principal.principalInfo();
		teacher.teach();
		System.out.println("College name is "+collegeName);
		System.out.println("testing...");
	}

	

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}



	public void setPrincipal(Principal principal) {
		this.principal = principal;
	}
	
	
}

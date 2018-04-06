package com.fqw.manager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fqw.manager.dao.UserMapper;
import com.fqw.manager.vo.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManagerApplicationTests {
	
	@Autowired
	UserMapper usermapper;

	@Test
	public void contextLoads() {
		
		User user = usermapper.selectUser("admin", "123456");
		if(user != null) {
			System.out.println("不等于空");
		}else {
			System.out.println("等于空");
		}
	}

}

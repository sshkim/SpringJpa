package java;

import com.sshkim.instagram.config.RootConfig;
import com.sshkim.instagram.entity.User;
import com.sshkim.instagram.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by sshkim on 2016. 9. 20..
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class TestSpringInitializer {

    @Autowired
    private UserService userService;

    @Test
    public void createUser(){
        User user = new User();
        user.setName("김승환");
        user.setPassword("12345");
        user.setEmail("sshkim@gmail.com");

        User saveUser = userService.create(user);
        User result = userService.findOneById(saveUser.getId());

        assertEquals("김승환", result.getName());

    }
}

import com.sshkim.instagram.entity.User;
import com.sshkim.instagram.service.UserService;
import com.sshkim.instagram.web.config.AppInitializer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by sshkim on 2016. 9. 10..
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= AppInitializer.class)
public class TestSpringAppInitializer {

    @Autowired
    private UserService userService;

    @Test
    public void userCreate(){

        User user = new User();
        user.setName("관리자");
        user.setEmail("sshkim88@gmail.com");
        user.setPassword("880218");

        userService.create(user);
    }
}

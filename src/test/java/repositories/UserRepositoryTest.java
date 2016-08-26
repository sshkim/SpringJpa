package repositories;

import com.sshkim.instagram.config.AppInitializer;
import com.sshkim.instagram.model.User;
import com.sshkim.instagram.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by sshkim on 2016. 8. 26..
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppInitializer.class)
public class UserRepositoryTest {

    @Autowired
    UserRepository repository;

    @Test
    public void sameTestCase(){
        User sshkim = new User();
        sshkim.setName("sshkim");
        sshkim = repository.save(sshkim);

        User shkim = new User();
        shkim.setName("shkim");
        shkim = repository.save(shkim);

        List<User> result = repository.findByName("sshkim");
        assertThat(result.size(), is(1));
        assertThat(result, hasItem(sshkim));
    }

}

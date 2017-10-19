import com.qf.house.domain.User;
import com.qf.house.service.UserService;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:app.xml")
public class UserTest {

    @Autowired
    private UserService userService;

    @Test
    public void testRegist(){
        User user=new User();
        user.setUsername("a");
        user.setPassword("123456");
        user.setRealname("stark");
        user.setTel("9090910");
        user.setAdmin(true);
        boolean boo=userService.register(user);
        Assert.assertTrue(boo);
    }

    @Test
    public void testLogin(){
        User user=new User();
        user.setUsername("a");
        user.setPassword("123456");
        Assert.assertTrue(userService.login(user));
        User user1=new User();
        user.setUsername("a");
        user.setPassword("12345611");
        Assert.assertFalse(userService.login(user1));
    }


}

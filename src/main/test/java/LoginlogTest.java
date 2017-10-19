import com.qf.house.persistence.LoginLogDao;
import com.qf.house.service.UserService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 登陆日志测试
 * @author 羊波
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:app.xml")
public class LoginlogTest {
    @Autowired
    private UserService userService;

    @Autowired
    private LoginLogDao loginLogDao;



}

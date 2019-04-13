import edu.eat.order.EatOrderApplication;
import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 执笔
 * @date 2019/4/13 16:32
 */
@SpringBootTest(classes = EatOrderApplication.class)
@RunWith(SpringRunner.class)
public class PasswordTest {

    @Autowired
    private StringEncryptor encryptor;

    @Test
    public void test(){
        System.out.println(encryptor.encrypt("123456789"));
    }
}

package dynastxu.cdg3s_huawei.service;

import dynastxu.cdg3s_huawei.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTests {
    @Autowired
    private UserService service;

    @Test
    void register() {
        User user = service.register("ZhangSan", "123456");
    }
}

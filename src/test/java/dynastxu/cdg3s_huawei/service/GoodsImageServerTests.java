package dynastxu.cdg3s_huawei.service;

import dynastxu.cdg3s_huawei.entity.GoodsImage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GoodsImageServerTests {
    private final String rootPath = "/images/goods";

    @Autowired
    private GoodsImageService service;

    @Test
    void saveAll() {
        service.save(new GoodsImage(rootPath + "/xiaomi_17t_pro/1.jpg"));
        service.save(new GoodsImage(rootPath + "/xiaomi_17t_pro/2.jpg"));
        service.save(new GoodsImage(rootPath + "/xiaomi_17t_pro/3.jpg"));
        service.save(new GoodsImage(rootPath + "/xiaomi_17t_pro/4.jpg"));
    }
}

package dynastxu.cdg3s_huawei.service;

import dynastxu.cdg3s_huawei.entity.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CategoryServiceTests {

    @Autowired
    private CategoryService service;

    @Test
    void save() {
        Category category = new Category("Xiaomi手机");
        service.save(category);
        assertNotNull(service.findByName("Xiaomi手机"));
    }

    @Test
    void saveAll() {
        service.save(new Category("Xiaomi手机"));
        service.save(new Category("REDMI手机"));
        service.save(new Category("手机配件"));
        service.save(new Category("平板"));
        service.save(new Category("智能穿戴"));
        service.save(new Category("电脑办公"));
        service.save(new Category("电视"));
        service.save(new Category("空调"));
        service.save(new Category("洗衣机"));
        service.save(new Category("冰箱"));
        service.save(new Category("厨房大电"));
        service.save(new Category("小家电"));
        service.save(new Category("智能家居"));
        service.save(new Category("出行运动"));
        service.save(new Category("车周边"));
        service.save(new Category("日用百货"));
        service.save(new Category("小米服务"));
        service.save(new Category("儿童用品"));
        service.save(new Category("有品精选"));

        service.save(new Category("Xiaomi 数字旗舰", service.findByName("Xiaomi手机")));
        service.save(new Category("Xiaomi MIX系列", service.findByName("Xiaomi手机")));
        service.save(new Category("Xiaomi Civi", service.findByName("Xiaomi手机")));
        service.save(new Category("Xiaomi手机套装", service.findByName("Xiaomi手机")));
        service.save(new Category("K系列", service.findByName("REDMI手机")));
        service.save(new Category("Note系列", service.findByName("REDMI手机")));
        service.save(new Category("Turbo系列", service.findByName("REDMI手机")));
        service.save(new Category("数字系列", service.findByName("REDMI手机")));
    }

    @Test
    void listChild() {
        Category phone = service.findByName("手机");
        List<Category> child = service.listChild(phone);

        System.out.println("父分类: " + phone.getName() + " (id=" + phone.getId() + ")");
        System.out.println("子分类数量: " + (child != null ? child.size() : 0));
        if (child != null) {
            child.forEach(c -> System.out.println("  - " + c.getName() + " (id=" + c.getId() + ")"));
        }
    }

    @Test
    void listRoots() {
        List<Category> categories = service.listRoots();

        System.out.println("根分类");
        if (categories != null) {
            categories.forEach(c -> System.out.println("  - " + c.getName()));
        }
    }
}

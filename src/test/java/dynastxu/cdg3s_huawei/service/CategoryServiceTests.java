package dynastxu.cdg3s_huawei.service;

import dynastxu.cdg3s_huawei.entity.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CategoryServiceTests {

    @Autowired
    private CategoryService service;

    @Test
    void save() {
        Category category = new Category("Xiaomi手机");
        service.saveOrUpdate(category);
        assertNotNull(service.findByName("Xiaomi手机"));
    }

    @Test
    void saveAll() {
        List<Category> categories = new ArrayList<>();

        categories.add(new Category("Xiaomi手机"));
        categories.add(new Category("REDMI手机"));
        categories.add(new Category("手机配件"));
        categories.add(new Category("平板"));
        categories.add(new Category("智能穿戴"));
        categories.add(new Category("电脑办公"));
        categories.add(new Category("电视"));
        categories.add(new Category("空调"));
        categories.add(new Category("洗衣机"));
        categories.add(new Category("冰箱"));
        categories.add(new Category("厨房大电"));
        categories.add(new Category("小家电"));
        categories.add(new Category("智能家居"));
        categories.add(new Category("出行运动"));
        categories.add(new Category("车周边"));
        categories.add(new Category("日用百货"));
        categories.add(new Category("小米服务"));
        categories.add(new Category("儿童用品"));
        categories.add(new Category("有品精选"));

        categories.add(new Category("Xiaomi 数字旗舰", service.findByName("Xiaomi手机")));
        categories.add(new Category("Xiaomi MIX系列", service.findByName("Xiaomi手机")));
        categories.add(new Category("Xiaomi Civi", service.findByName("Xiaomi手机")));
        categories.add(new Category("Xiaomi手机套装", service.findByName("Xiaomi手机")));

        categories.add(new Category("K系列", service.findByName("REDMI手机")));
        categories.add(new Category("Note系列", service.findByName("REDMI手机")));
        categories.add(new Category("Turbo系列", service.findByName("REDMI手机")));
        categories.add(new Category("数字系列", service.findByName("REDMI手机")));

        categories.forEach((category) -> service.saveOrUpdate(category));
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

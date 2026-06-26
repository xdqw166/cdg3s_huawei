package dynastxu.cdg3s_huawei.controller;

import dynastxu.cdg3s_huawei.entity.Category;
import dynastxu.cdg3s_huawei.service.BaseService;
import dynastxu.cdg3s_huawei.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController extends BaseController<CategoryService> {
    public CategoryController(CategoryService service) {
        super(service);
    }

    @RequestMapping("/listChild")
    @ResponseBody
    public List<Category> listChild(Category category) {
        return service.listChild(category);
    }

    @RequestMapping("/listRoots")
    @ResponseBody
    public List<Category> listRoots() {
        return service.listRoots();
    }
}

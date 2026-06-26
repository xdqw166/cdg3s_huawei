package dynastxu.cdg3s_huawei.service;

import dynastxu.cdg3s_huawei.entity.Category;
import dynastxu.cdg3s_huawei.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public Category save(Category category) {
        return repository.save(category);
    }

    public Category saveOrUpdate(Category category) {
        Category existing = findByName(category.getName());
        if (existing != null) {
            existing.setParent(category.getParent());
            return save(existing);
        }
        return save(category);
    }

    public Category findByName(String name) {
        return repository.findByName(name).orElse(null);
    }

    public List<Category> listChild(Category category) {
        return repository.findAllByParent(category);
    }

    public List<Category> listRoots() {
        return repository.findAllByParentIsNull();
    }
}

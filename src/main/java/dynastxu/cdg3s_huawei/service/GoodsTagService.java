package dynastxu.cdg3s_huawei.service;

import dynastxu.cdg3s_huawei.entity.GoodsTag;
import dynastxu.cdg3s_huawei.repository.GoodsTagRepository;
import org.springframework.stereotype.Service;

@Service
public class GoodsTagService extends BaseService<GoodsTagRepository> {
    public GoodsTagService(GoodsTagRepository repository) {
        super(repository);
    }

    public GoodsTag saveOrUpdate(GoodsTag tag) {
        GoodsTag existing = repository.findByName(tag.getName()).orElse(null);
        if (existing != null) {
            tag.setId(existing.getId());
            return repository.save(tag);
        }
        return repository.save(tag);
    }

    public GoodsTag findByName(String name) {
        return repository.findByName(name).orElse(null);
    }

    public GoodsTag findById(Long id) {
        return repository.findById(id).orElse(null);
    }
}

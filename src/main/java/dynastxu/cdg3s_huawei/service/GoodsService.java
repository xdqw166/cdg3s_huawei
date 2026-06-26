package dynastxu.cdg3s_huawei.service;

import dynastxu.cdg3s_huawei.entity.Goods;
import dynastxu.cdg3s_huawei.repository.GoodsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService extends BaseService<GoodsRepository>{
    public GoodsService(GoodsRepository repository) {
        super(repository);
    }

    public Goods saveIfUnique(Goods goods) {
        Goods existing = repository.findByName(goods.getName()).orElse(null);
        if (existing == null) {
            return repository.save(goods);
        }
        return goods;
    }

    public List<Goods> findByCategoryId(Long id) {
        return repository.findByCategory_Id(id);
    }
}

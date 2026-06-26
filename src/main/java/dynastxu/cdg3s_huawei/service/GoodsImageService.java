package dynastxu.cdg3s_huawei.service;

import dynastxu.cdg3s_huawei.entity.GoodsImage;
import dynastxu.cdg3s_huawei.repository.GoodsImageRepository;
import org.springframework.stereotype.Service;

@Service
public class GoodsImageService extends BaseService<GoodsImageRepository> {
    GoodsImageService(GoodsImageRepository repository) {
        super(repository);
    }

    public GoodsImage save(GoodsImage goodsImage) {
        return repository.save(goodsImage);
    }

    public GoodsImage saveIfUnique(GoodsImage goodsImage) {
        if (repository.findByImagePath(goodsImage.getImagePath()).isEmpty()) {
            return repository.save(goodsImage);
        }
        return goodsImage;
    }

    public GoodsImage findById(Long id) {
        return repository.findById(id).orElse(null);
    }
}

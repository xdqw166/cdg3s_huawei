package dynastxu.cdg3s_huawei.controller;

import dynastxu.cdg3s_huawei.entity.GoodsImage;
import dynastxu.cdg3s_huawei.service.GoodsImageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/goodsImage")
public class GoodsImageController extends BaseController<GoodsImageService> {
    public GoodsImageController(GoodsImageService goodsImageService) {
        super(goodsImageService);
    }

    @RequestMapping("/getImage")
    @ResponseBody
    public GoodsImage getImage(Long id) {
        return service.findById(id);
    }
}

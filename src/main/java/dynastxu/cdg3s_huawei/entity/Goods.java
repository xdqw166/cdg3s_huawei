package dynastxu.cdg3s_huawei.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    private Float price;

    private Float discountedPrice;

    private Float startingPrice;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<GoodsTag> goodsTag;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private GoodsImage mainImage;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "goods_id")
    private List<GoodsImage> images;

    public Goods(@NotNull Float price, @NotNull String name) {
        this.price = price;
        this.name = name;
    }

    @Builder
    public Goods(
            Float price,
            @NotNull String name,
            Float discountedPrice,
            List<GoodsTag> goodsTag,
            Category category,
            GoodsImage mainImage,
            List<GoodsImage> images,
            Float startingPrice
    ) {
        this.price = price;
        this.name = name;
        this.discountedPrice = discountedPrice;
        this.goodsTag = goodsTag;
        this.category = category;
        this.mainImage = mainImage;
        this.images = images;
        this.startingPrice = startingPrice;
    }
}

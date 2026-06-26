package dynastxu.cdg3s_huawei.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.*;
import org.jspecify.annotations.NonNull;

@Entity
@Table(name = "t_category")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @Nonnull
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Category parent;

    public Category(@NonNull String name) {
        this.name = name;
    }

    public Category(@NonNull String name, Category parent) {
        this.name = name;
        this.parent = parent;
    }
}

package uz.jvh.prjoectmanagement.entity;


import jakarta.persistence.*;
import lombok.*;
import uz.jvh.prjoectmanagement.enumerators.StatusEnum;


import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity(name = "features")
public class FeatureEntity extends BaseEntity {
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    @ManyToOne
    private UserEntity owner;

    @OneToMany(mappedBy = "feature")
    private List<Task> tasks;

}

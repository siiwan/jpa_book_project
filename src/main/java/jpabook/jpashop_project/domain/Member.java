package jpabook.jpashop_project.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @NotEmpty
    private String name;

    @Embedded
    private Address address;

    // mappedBy : 연관관계 매핑된 거울일 뿐..
    //@JsonIgnore // api 호출시 하기 내용 조회 안되게 함.
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();
}

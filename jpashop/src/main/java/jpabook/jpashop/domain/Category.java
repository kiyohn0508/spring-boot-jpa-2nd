package jpabook.jpashop.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import jpabook.jpashop.domain.Item.Item;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Category {
    @Id @GeneratedValue
    @Column(name="category_id")
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name = "category_item",
        joinColumns = @JoinColumn(name="category_id"),
        inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> items = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> children = new ArrayList<>();
    
    //==연관관계 메서드==//
    public void addChildeCategory(Category child){
        this.children.add(child);
        child.setParent(this);
    }
}

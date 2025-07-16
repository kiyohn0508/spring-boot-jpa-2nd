package jpabook.jpashop.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.Order;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class OrderRepository {
    private final EntityManager em;

    public void save(Order order){
        em.persist(order);
    }

    public Order findOne(Long id){
        return em.find(Order.class, id);
    }

    // 주문 검색 기능
    public List<Order> findAll(OrderSearch OrderSearch){
        return em.createQuery("select o from Order o join o.member m"
        + " where o.status =:status" + " and m.name like :name", Order.class)
        .setParameter("status", OrderSearch.getOrderStatus())
        .setParameter("name", OrderSearch.getMemberName())
        .setMaxResults(100).getResultList();
    }
}

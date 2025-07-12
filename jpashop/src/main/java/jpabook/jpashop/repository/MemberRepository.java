package jpabook.jpashop.repository;

import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository{
    
    @PersistenceContext
    private EntityManager em;

    public void save(Member member){
        em.persist(member);
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }
}
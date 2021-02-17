package com.cg.teddyamazing.service.product.impl;

import com.cg.teddyamazing.model.product.ManageProducts;
import com.cg.teddyamazing.model.product.Product;
import com.cg.teddyamazing.repository.product.ManagerProductRepo;
import com.cg.teddyamazing.service.product.ManagerProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class ManagerServiceImpl implements ManagerProductService {
    @Autowired
    public ManagerProductRepo managerProductRepo;
    @PersistenceContext
    private EntityManager em;

    @Override
    public Page<ManageProducts> findAll(Pageable pageable) {
        return managerProductRepo.findAll(pageable);
    }

    @Override
    public ManageProducts findById(String id) {
        TypedQuery<ManageProducts> query = em.createQuery("select m from ManageProducts m where  m.id=:id", ManageProducts.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public void save(ManageProducts manageProducts) {
        managerProductRepo.save(manageProducts);
    }

    @Override
    public void remove(String id) {
        ManageProducts manageProducts=findById(id);
        managerProductRepo.delete(manageProducts);
    }

    @Override
    public Iterable<ManageProducts> findAllByProduct(Product product) {
        return managerProductRepo.findAllByProduct(product);
    }

    @Override
    public List<ManageProducts> findAllGroupBy() {
        return managerProductRepo.findAllGroupBy();
    }


}

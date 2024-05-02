package com.riwi.vacants.service.interfaces;

import org.springframework.data.domain.Page;

// 6.
public interface CrudService<RQ,RS,ID> {
   public void delete(ID id); // 7

   public RS create(RQ request); //8

   public RS update(ID id, RQ request); //9

   public Page<RS> getAll(int page, int  size); //10 
}

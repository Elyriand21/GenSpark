package com.genspark.assignment2.Second.Repositories;

import com.genspark.assignment2.Second.Entities.OnlineOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<OnlineOrder, Integer> {

}

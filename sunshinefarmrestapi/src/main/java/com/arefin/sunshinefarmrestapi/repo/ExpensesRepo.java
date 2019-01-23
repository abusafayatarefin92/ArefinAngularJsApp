package com.arefin.sunshinefarmrestapi.repo;

import com.arefin.sunshinefarmrestapi.entity.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpensesRepo extends JpaRepository<Expenses, Integer> {

}

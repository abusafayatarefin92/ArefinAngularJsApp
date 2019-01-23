package com.arefin.sunshinefarmrestapi.controller;

import com.arefin.sunshinefarmrestapi.entity.Expenses;
import com.arefin.sunshinefarmrestapi.repo.ExpensesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExpensesController {
    @Autowired
    private ExpensesRepo repo;
    @GetMapping(value = "/expenses-list")
    public List<Expenses> getExpensesList(){
        return repo.findAll();
    }

    @GetMapping(value = "/insert")
    public void insertData(){
        Expenses expenses = new Expenses();
        expenses.setExpenseName("Blower");
        expenses.setAmount(1000.00);
        expenses.setPersonName("Rahim");
        repo.save(expenses);
        System.out.print("Success");
    }
}

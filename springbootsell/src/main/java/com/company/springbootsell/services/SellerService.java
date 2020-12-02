package com.company.springbootsell.services;

public interface SellerService {
    public String saveUser(String  id,String password);
    public String findByIdAndPassword(String id,String passwprd);
}

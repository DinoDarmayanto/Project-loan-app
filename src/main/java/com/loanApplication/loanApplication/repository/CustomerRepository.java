package com.loanApplication.loanApplication.repository;

import com.loanApplication.loanApplication.model.Customer;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Modifying
    @Query(value = "INSERT INTO mst_customer (full_name, address, nik, phone_number, user_id, no_kk, emergency_name, emergency_contact, last_salary, created_at, updated_at) "
            +
            "VALUES (:full_name, :address, :nik, :phone_number, :user_id, :no_kk, :emergency_name, :emergency_contact, :last_salary, :created_at, :updated_at)", nativeQuery = true)
    void createCustomer(String full_name, String address, String nik, String phone_number, Integer user_id,
            String no_kk, String emergency_name, String emergency_contact, Long last_salary, LocalDateTime created_at,
            LocalDateTime updated_at);

    @Query(value = "SELECT * FROM mst_customer", nativeQuery = true)
    List<Customer> getAllCustomers();

    @Query(value = "SELECT * FROM mst_customer WHERE id = :id", nativeQuery = true)
    Customer findCustomerById(@Param("id") Long id);

    @Query(value = "SELECT * FROM mst_customer WHERE full_name = :name", nativeQuery = true)
    List<Customer> findCustomersByName(@Param("name") String name);

    @Modifying
    @Query(value = "UPDATE mst_customer SET full_name = :full_name, address = :address, nik = :nik, phone_number = :phone_number, user_id = :user_id, no_kk = :no_kk, emergency_name = :emergency_name, emergency_contact = :emergency_contact, last_salary = :last_salary, updated_at = :updated_at WHERE id = :id", nativeQuery = true)
    int updateCustomer(
            Long id,
            String full_name,
            String address,
            String nik,
            String phone_number,
            Integer user_id,
            String no_kk,
            String emergency_name,
            String emergency_contact,
            Long last_salary,
            LocalDateTime updated_at);

    @Modifying
    @Query(value = "DELETE FROM mst_customer WHERE id = :id", nativeQuery = true)
    int deleteCustomerById(@Param("id") Long id);

}

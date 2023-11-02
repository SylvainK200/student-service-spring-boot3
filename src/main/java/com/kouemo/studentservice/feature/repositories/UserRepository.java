package com.kouemo.studentservice.feature.repositories;

import com.kouemo.studentservice.feature.dtos.UserDtoInterface;
import com.kouemo.studentservice.feature.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query(nativeQuery = true,
    value = "select fuser.id as userId, " +
            "fuser.username as username, " +
            "fuser.email_address as emailAddress, " +
            "fuser.address as address, " +
            "concat(fuser.firstname,fuser.lastname) as fullName, " +
            "fuser.salary as salary, " +
            "fuser.serial_number as serialNumber " +
            "from studentschema.feature_user as fuser " +
            "where (:search = '' or upper(fuser.firstname) like concat('%',upper(:search),'%')) " +
            "and (:search='' or upper(fuser.lastname) like concat('%',upper(:search),'%')) " +
            "and (:search='' or upper(fuser.email_address) like concat('%',upper(:search),'%')) " +
            "and (:search='' or upper(fuser.serial_number) like concat('%',upper(:search),'%')) "
            ,
    countQuery = "select count(*) from (" +
            "select fuser.id as userId " +
            "from studentschema.feature_user as fuser " +
            "where (:search = '' or upper(fuser.firstname) like concat('%',upper(:search),'%')) " +
            "and (:search='' or upper(fuser.lastname) like concat('%',upper(:search),'%')) " +
            "and (:search='' or upper(fuser.email_address) like concat('%',upper(:search),'%')) " +
            "and (:search='' or upper(fuser.serial_number) like concat('%',upper(:search),'%')) "+
            ")")
    Page<UserDtoInterface> findAllBySearch(String search, Pageable pageable);
}

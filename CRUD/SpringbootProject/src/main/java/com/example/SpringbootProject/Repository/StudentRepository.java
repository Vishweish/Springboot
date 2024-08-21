package com.example.SpringbootProject.Repository;

import com.example.SpringbootProject.Model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel,Integer> {

    @Query("select s from StudentModel s where s.age > 18 ")
    List<StudentModel> getStaticAgeList();

    @Query("select s from StudentModel s where s.age between :age1 and :age2")
    List<StudentModel> getDynamicAgeList(int age1,int age2);

}

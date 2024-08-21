package com.example.SpringbootProject.Service;


import com.example.SpringbootProject.Model.StudentModel;
import com.example.SpringbootProject.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;


    public List<StudentModel> createStudents(List<StudentModel> studentModels) throws Exception {
        List<StudentModel> newStudents = new ArrayList<>();
        try{
            newStudents = studentRepository.saveAll(studentModels);
        }catch (Exception ex)  {
            System.out.println("Exception occurred during student creation " + ex);
            throw new Exception("Exception occurred during student creation " + ex.getMessage());
        }
        return newStudents;
    }


    public String deleteStudentById(StudentModel studentModel){
         studentRepository.deleteById(studentModel.getId());
         return "Student entry for "+studentModel.getId()+" deleted successfully.";
    }

    public String deleteAllstudent(){
        studentRepository.deleteAll();
        return "All students Deleted Successfully";
    }

    public List<StudentModel> getAllStudents(){
        List<StudentModel> AllStudents = new ArrayList<>();
        try {
            AllStudents = studentRepository.findAll();
        }catch (Exception ex){
            System.out.println("Exception occurred during student creation " + ex);
        }
        return AllStudents;
    }

    public StudentModel updateStudent(int id, StudentModel studentModels){
        StudentModel oldData = null;
        oldData = studentRepository.findById(id).orElse(null);
        oldData.setName(studentModels.getName());
        oldData.setAge(studentModels.getAge());
        oldData.setEmail(studentModels.getEmail());
        return studentRepository.save(oldData);
    }

    public StudentModel findById(StudentModel id){
        return studentRepository.findById(id.getId()).orElse(null);
    }

    public List<StudentModel> getAgelistStatic(){
        List<StudentModel> ageStatic = new ArrayList<>();
        try{
            ageStatic = studentRepository.getStaticAgeList();
        }catch (Exception ex){
            System.out.println("Exception occured "+ex);
    }return ageStatic;
    }

    public List<StudentModel> getAgelistDynamic(int age1,int age2){
        List<StudentModel> ageDynamic = new ArrayList<>();
        try{
            ageDynamic = studentRepository.getDynamicAgeList(age1,age2);
        }catch (Exception ex){
            System.out.println("Exception occured "+ex);
        }return ageDynamic;
    }

}

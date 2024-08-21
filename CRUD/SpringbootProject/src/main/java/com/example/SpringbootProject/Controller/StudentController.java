package com.example.SpringbootProject.Controller;


import com.example.SpringbootProject.Model.StudentModel;
import com.example.SpringbootProject.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/Student")
@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

//    @PostMapping("/add")
//    public StudentModel addStudent(@RequestBody StudentModel studentModel){
//        return studentService.createStudent(studentModel);
//    }


    //Create
    @PostMapping("/create")
    public ResponseEntity<List<StudentModel>> createStudents(@RequestBody List<StudentModel> studentModels){
        List<StudentModel> newStudents = new ArrayList<>();
        try{
            newStudents = studentService.createStudents(studentModels);
        }catch(Exception ex){
            return new ResponseEntity<>(newStudents, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(newStudents, HttpStatus.OK);
    }


    //Read
    @GetMapping("/find/{id}")
    public ResponseEntity<StudentModel> find(@PathVariable int id){
        StudentModel student = new StudentModel();
        student.setId(id);
        try{
            student = studentService.findById(student);
        }catch (Exception ex){
            return new ResponseEntity<>(student,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(student,HttpStatus.OK);

    }

    @GetMapping("/getAll")
    public ResponseEntity<List<StudentModel>> getAll(){
        List<StudentModel> all = new ArrayList<>();
        try{
            all= studentService.getAllStudents();
        }catch (Exception ex){
            return new ResponseEntity<>(all,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(all,HttpStatus.OK);
    }


    //Update
    @PutMapping("/update/{id}")
    public ResponseEntity<StudentModel> updateStudent(@PathVariable int id , @RequestBody StudentModel studentModels){
        StudentModel updateStu = new StudentModel();
        try{
           updateStu = studentService.updateStudent(id,studentModels);
        }catch (Exception ex){
            return new ResponseEntity<>(updateStu ,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(updateStu, HttpStatus.OK);
    }


    //Delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id){
        StudentModel student = new StudentModel();
        student.setId(id);
        String status = studentService.deleteStudentById(student);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAll(){
        String status = studentService.deleteAllstudent();
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    //Custom queries
    @GetMapping("/Staticage18")
    public ResponseEntity<List<StudentModel>> getAgeStatic(){
        List<StudentModel> ageStatic = new ArrayList<>();
        try{
            ageStatic = studentService.getAgelistStatic();
        }catch(Exception ex){
            return new ResponseEntity<>(ageStatic,HttpStatus.BAD_REQUEST);
        }return new ResponseEntity<>(ageStatic,HttpStatus.OK);
    }

    @GetMapping("/Dynamicage/{age1}/{age2}")
    public ResponseEntity<List<StudentModel>> ageDynamic(@PathVariable int age1,@PathVariable int age2){
        List<StudentModel> ageDynamic = new ArrayList<>();
        try{
            ageDynamic = studentService.getAgelistDynamic(age1,age2);
        }catch(Exception ex){
            return new ResponseEntity<>(ageDynamic,HttpStatus.BAD_REQUEST);
        }return new ResponseEntity<>(ageDynamic,HttpStatus.OK);
    }
    }


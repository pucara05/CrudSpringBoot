package com.example.CRUD.Controllers;

import com.example.CRUD.Models.User;
import com.example.CRUD.Services.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/v1/users")
public class UserController {

    private UserService userService;
    @Autowired
    public  UserController(UserService userService){
        this.userService = userService;
    }






    @GetMapping("/form")
    public List<User> findAll(){
    return  this.userService.getUsers();

    }


    @PostMapping("/save")
    public ResponseEntity<Object> registarUsuario(@RequestBody User user){
        return this.userService.crearUser(user);

    }

@PutMapping
    public ResponseEntity<Object> actualizarUsuario(@RequestBody User user){
        return this.userService.crearUser(user);

    }

    @DeleteMapping(path = "{userId}")
    public ResponseEntity<Object> eliminar(@PathVariable("userId") Long id){
         return  this.userService.deleteUser(id);
    }



       /*
    @GetMapping("/formulario")
    public String mostrarFormulario(Model model) {
        model.addAttribute("user", new User());
        return "form";
    }
*/


    /*
    metodo personalidado para treaer la List y buscar todos los usuarios
    public List<User> verUsuario(){

        return  this.userService.verUser();

    }
    */

}

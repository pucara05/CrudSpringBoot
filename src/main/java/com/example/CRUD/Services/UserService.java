package com.example.CRUD.Services;

import com.example.CRUD.Models.User;
import com.example.CRUD.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    HashMap<String , Object> datos ;
private final UserRepository userRepository;

@Autowired
public  UserService(UserRepository userRepository){
    this.userRepository = userRepository;
}


    public List<User> getUsers(){
        return  this.userRepository.findAll();

    }

    public ResponseEntity<Object> crearUser(User user) {

        Optional<User> res = userRepository.findUserByName(user.getName());

            datos = new HashMap<>();

        if(res.isPresent() && user.getId_user()==null){
            datos.put("Error", true);
            datos.put("Message", "Ya existe un Usuario con ese Nombre");
          return new ResponseEntity<>(
                  datos,
                  HttpStatus.CONFLICT

          );
        }
        datos.put("Message", "Se guardo con Exito");

        if (user.getId_user()!=null){
            datos.put("Message","se Actualizo con Exito");

        }

        userRepository.save(user);
        datos.put("Data", user);


        return  new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );

    }


    public ResponseEntity<Object> deleteUser(Long id){
        datos = new HashMap<>();
        boolean existe =this.userRepository.existsById(id);
        if (!existe){
            datos.put("Error",true );
            datos.put("Message", "No existe un Usuario con ese ID");
            return  new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );

        }

        userRepository.deleteById(id);
        datos.put("Message", "Usuario Eliminado");
        return  new ResponseEntity<>(
                datos,
                HttpStatus.OK
        );
    }
}

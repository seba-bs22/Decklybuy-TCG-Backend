package com.decklybuytcg.backend.controller;

import com.decklybuytcg.backend.dto.UserDTO;
import com.decklybuytcg.backend.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Tag(name = "Usuarios", description = "Operaciones para la tabla USER de Supabase")
@CrossOrigin(origins = "http://localhost:5173") // Puerto de tu frontend
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // ================================
    // OBTENER TODOS LOS USUARIOS
    // ================================
    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    // ================================
    // BUSCAR USUARIO POR ID
    // ================================
    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    // ================================
    // BUSCAR USUARIO POR NOMBRE
    // ================================
    @GetMapping("/search")
    public List<UserDTO> searchUsersByName(@RequestParam String nombre) {
        return userService.searchUsersByName(nombre);
    }

    // CREAR USUARIO
    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO user) {
        return userService.createUser(user);
    }

    // ACTUALIZAR USUARIO
    @PatchMapping("/{id}")
    public UserDTO updateUser(@PathVariable String id, @RequestBody UserDTO user) {
        return userService.updateUser(id, user);
    }

    // ELIMINAR USUARIO
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id) {
        boolean deleted = userService.deleteUser(id);
        if (deleted) {
            return ResponseEntity.ok("Usuario eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("No se pudo eliminar el usuario");
        }
    }
}

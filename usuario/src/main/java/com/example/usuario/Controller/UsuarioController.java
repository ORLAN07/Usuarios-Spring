/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.usuario.Controller;

import com.example.usuario.exception.ResourceNotFoundException;
import com.example.usuario.model.Usuario;
import com.example.usuario.repository.UsuarioRepository;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author orlando.rubio
 */

@RestController
@RequestMapping(value = "/api")
public class UsuarioController {
    
    @Autowired
    UsuarioRepository usuarioRepository;
    
    //GET ALL USERS
    @GetMapping("/usuario")
    public List<Usuario> getAllUsers(){
        return usuarioRepository.findAll();
    }
    //CREATE USER
    @PostMapping("/usuario")
    public Usuario createUser(@Valid @RequestBody Usuario usuario){
        return usuarioRepository.save(usuario);
    }
    
    //DELETE USER FOR ID
    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<?> DeleteUser(@PathVariable(value = "id") Long userId){
        
        Usuario usuario = usuarioRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Usuario", "Id", userId));
        
        usuarioRepository.delete(usuario);
        
        return ResponseEntity.ok().build();
    }
    
    // SINGEL USER
    @GetMapping("/usuario/{id}")
    public Usuario getUserForId(@PathVariable(value = "id") Long userId){
        return usuarioRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Usuario", "Id", userId));
    }
    
    @PutMapping("/usuario/{id}")
    public Usuario updateUser(@PathVariable(value = "id") Long usuarioId, @Valid  @RequestBody Usuario usuarioDetails){
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new ResourceNotFoundException("Usuario", "Id", usuarioId));
        
        usuario.setNombre(usuarioDetails.getNombre());
        usuario.setApellido(usuarioDetails.getApellido());
        usuario.setEdad(usuarioDetails.getEdad());
        usuario.setCargo(usuarioDetails.getCargo());
        usuario.setEmail(usuarioDetails.getEmail());
        usuario.setPassword(usuarioDetails.getPassword());
        
        Usuario updateUsuario = usuarioRepository.save(usuario);
        
        return updateUsuario;
    }
    
}

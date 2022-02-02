package br.com.folks.english.controller;

import br.com.folks.english.model.Admin;
import br.com.folks.english.service.AdminService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/admin")
@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping
    public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) {
        Admin newAdmin = adminService.addAdmin(admin);

        return new ResponseEntity<>(newAdmin, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Admin> updateAdmin(@RequestBody Admin admin, @PathVariable("id") Long id) {
        Admin patchValue = adminService.updateAdmin(admin, id);

        return new ResponseEntity<>(patchValue, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Admin>> all() {
        List<Admin> admins = adminService.all();
        return new ResponseEntity<>(admins, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Admin> findById(@PathVariable("id") Long id) {
        Admin admin = adminService.findByid(id);

        return new ResponseEntity<>(admin, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable("id") Long id) {

        adminService.deleteAdmin(id);
    }


}

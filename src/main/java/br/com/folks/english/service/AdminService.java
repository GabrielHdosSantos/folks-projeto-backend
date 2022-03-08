package br.com.folks.english.service;

import br.com.folks.english.model.Admin;
import br.com.folks.english.repo.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AdminService {

    @Autowired
    private AdminRepo repo;

    public Admin addAdmin(Admin admin) {
        return repo.save(admin);
    }

    public Admin updateAdmin(Admin admin, Long id) {
        admin.setId(id);
        return repo.save(admin);
    }

    public List<Admin> all() {

        return repo.findAll();
    }

    public Admin findByid(Long id){

        return repo.getById(id);
    }

    public void deleteAdmin(Long id){
        repo.deleteById(id);
    }


}

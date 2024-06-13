package com.SupplementService.SupplementApp.Services;

import com.SupplementService.SupplementApp.Models.Supplement;
import com.SupplementService.SupplementApp.Repositories.SupplementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplementService {

    @Autowired
    private SupplementRepository supplementRepository;

    public List<Supplement> returnSupplements(){
        return supplementRepository.findAll();
    }

    public Supplement returnSupplement(String name){
        return supplementRepository.findByName(name);
    }

    public List<String> returnSupplementName(String query) {
        return supplementRepository.findByNameContainingIgnoreCase(query);
    }
}

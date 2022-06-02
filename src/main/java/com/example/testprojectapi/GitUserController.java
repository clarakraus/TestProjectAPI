package com.example.testprojectapi;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/{github}")

public class GitUserController {

    @GetMapping("/username")
    public List<String> getRepositoryNames(@PathVariable String userName){
        RestTemplate restTemplate = new RestTemplate();
        return Arrays.stream(restTemplate.getForObject("https://api.github.com/users/"+ userName + "/repos", Repo[].class))
                .map(Repo::getName)
                .toList();
    }

    String API_URL = "https://api.github.com/users/USERNAME/repos";



    }


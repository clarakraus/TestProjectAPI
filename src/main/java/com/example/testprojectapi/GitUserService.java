package com.example.testprojectapi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@org.springframework.stereotype.Service
@RequiredArgsConstructor

public class GitUserService {


    public List<String> findByGitUser(String username) {
        RestTemplate restTemplate = new RestTemplate();
        return Arrays.stream(restTemplate.getForObject("https://api.github.com/users/"+ username + "/repos", Repo[].class))
                .map(Repo::getName)
                .toList();
    }
}

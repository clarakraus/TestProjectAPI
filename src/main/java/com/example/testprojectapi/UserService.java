package com.example.testprojectapi;


import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final GitUserRepo gitUserRepo;

    public UserService(GitUserRepo gitUserRepo) {
        this.gitUserRepo = gitUserRepo;


    }
}

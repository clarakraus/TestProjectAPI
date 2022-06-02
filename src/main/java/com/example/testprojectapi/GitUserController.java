package com.example.testprojectapi;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/github")
@RequiredArgsConstructor
public class GitUserController {

    private final GitUserService gitService;

    @GetMapping("/{username}")
    public List<String> getRepositoryNames(@PathVariable String username) {
        return gitService.findByGitUser(username);
    }
    }




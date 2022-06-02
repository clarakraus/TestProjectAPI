package com.example.testprojectapi;

import java.util.ArrayList;
import java.util.List;

public class GitUser {
    private String name;
    private List<String> gitRepo = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getGitRepo() {
        return gitRepo;
    }

    public void setGitRepo(List<String> gitRepo) {
        this.gitRepo = gitRepo;
    }
}

package com.example.testprojectapi;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GitUserControllerTestIT {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private GitUserService gitService;

    /*@Test
    void shouldGetReposFromUser(){
        //given
        String name = "clarakraus";
        List<Repo> repos = new ArrayList<>();

        ResponseEntity<String[]> getResponse = restTemplate.getForEntity("/github/clarakraus", String[].class);
        Assertions.assertThat(getResponse.getStatusCode()).isEqualTo (HttpStatus.OK);
        assertThat(getResponse.getBody().length).isEqualTo(13);
    }

     */
    @Test
    void shouldGetReposFromUser(){
        //given
        String name = "clarakraus";

        when(gitService.findByGitUser(name)).thenReturn(List.of("repoName1", "repoName2"));

        ResponseEntity<String[]> getResponse = restTemplate.getForEntity("/github/" + name, String[].class);
        Assertions.assertThat(getResponse.getStatusCode()).isEqualTo (HttpStatus.OK);
        assertThat(getResponse.getBody().length).isEqualTo(2);
    }



}
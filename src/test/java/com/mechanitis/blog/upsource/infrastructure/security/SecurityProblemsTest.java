package com.mechanitis.blog.upsource.infrastructure.security;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;

public class SecurityProblemsTest {
    @Test
    public void shouldGenerateRandomNumber() {
        SecurityProblems securityProblems = new SecurityProblems();
        int id = securityProblems.generateNewId();

        Assert.assertThat(id, is(not(nullValue())));
    }

}
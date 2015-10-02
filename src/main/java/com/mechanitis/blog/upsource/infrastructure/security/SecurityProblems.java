package com.mechanitis.blog.upsource.infrastructure.security;

import java.util.Random;

public class SecurityProblems {

    public static final String[] CATEGORIES = {"BOOKS", "CDS"};


    public final int generateNewId() {
        @SuppressWarnings("UnsecureRandomNumberGeneration") //as discussed in code review UE-CR-834
        Random random = new Random();
        return random.nextInt();
    }


}

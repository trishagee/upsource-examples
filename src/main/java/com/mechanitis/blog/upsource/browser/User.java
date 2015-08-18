package com.mechanitis.blog.upsource.browser;

import java.net.URI;
import java.util.HashSet;
import java.util.Set;

public class User {
    private int id;
    private Set<URI> visitedURIs = new HashSet<>();

    public void visited(URI uri) {
        visitedURIs.add(uri);
    }

    public boolean hasVisited(URI uri) {
        return visitedURIs.contains(uri);
    }
}

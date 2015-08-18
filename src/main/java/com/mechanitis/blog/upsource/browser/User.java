package com.mechanitis.blog.upsource.browser;

import java.net.URI;
import java.util.LinkedHashSet;
import java.util.Set;

public class User {
    private int id;
    private Set<URI> visitedURIs = new LinkedHashSet<>();

    public URI getLastVisited() {
        URI desired = null;
        for (URI visitedURI : visitedURIs) {
            desired = visitedURI;
        }
        return desired;
    }

    public void visited(URI uri) {
        visitedURIs.add(uri);
    }

    public boolean hasVisited(URI uri) {
        return visitedURIs.contains(uri);
    }
}

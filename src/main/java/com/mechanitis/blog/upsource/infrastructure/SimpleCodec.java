package com.mechanitis.blog.upsource.infrastructure;

public interface SimpleCodec<T> {
    T decode(Reader reader);

    void encode(T value, Writer writer);
}

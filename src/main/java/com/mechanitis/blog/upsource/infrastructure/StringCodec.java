package com.mechanitis.blog.upsource.infrastructure;

/**
 * Converts Point objects into DBObjects for querying only.  When saving entities with Points in, this converter should not be used.
 */
public class StringCodec implements SimpleCodec<String> {

    @Override
    public String decode(Reader reader) {
        throw new UnsupportedOperationException("Should never have to decode a String object");
    }

    @Override
    public void encode(final String value, Writer writer) {
        writer.writeString(value);
    }
}

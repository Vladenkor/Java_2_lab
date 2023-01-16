package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.ArrayList;
import java.util.Objects;

@JsonDeserialize(builder = Song.Builder.class)
public class Song {
    @JsonProperty
    private String name;
    @JsonProperty
    private String album;
    @JsonProperty
    private GENRES genre;

    public Song fromStringSerialize(String content) {
        Song song = new Song();
        String[] carString = content.split(",");
        var values = new ArrayList<String>();
        for (String item : carString) {
            String[] innerItem = item.split("=");
            values.add(innerItem[1]);
        }
        song.name = values.get(0).trim();
        song.album = values.get(1).trim();
        song.genre = GENRES.valueOf(values.get(2).trim());
        return song;
    }

    public String toStringSerialize() {
        return "name=" + name +
                ",album=" + album +
                ",genre=" + genre;
    }

    @JsonPOJOBuilder(buildMethodName = "build", withPrefix = "set")
    public static class Builder {
        private Song song;

        public Builder() {
            song = new Song();
        }

        public Builder setName(String name) {
            song.name = name;
            return this;
        }

        public Builder setAlbum(String album) {
            song.album = album;
            return this;
        }

        public Builder setGenre(GENRES genre) {
            song.genre = genre;
            return this;
        }

        public Song build() {
            return song;
        }
    }

    /**
     * Overriding toString method
     *
     * @return information on the object
     */
    @Override
    public String toString() {
        return "{\"name\":" + name + ",\"album\":" + album + ",\"genre\":" + genre + "}";
    }

    /**
     * This is the method which tells you whether object are equal or not.
     *
     * @param object
     * @return if objects are equal
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Song song = (Song) object;
        return Objects.equals(name, song.name)
                && Objects.equals(album, song.album)
                && Objects.equals(genre, song.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, album, genre);
    }


}

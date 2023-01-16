package org.example;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonDeserialize(builder = Singer.Builder.class)
public class Singer {
    private String name;
    private List<Song> songs = new ArrayList<>();

    public static class Builder {
        private Singer singer;

        public Builder() {
            singer = new Singer();
        }

        public Builder setName(String name) {
            singer.name = name;
            return this;
        }

        public Builder setSongs(List<Song> songs) {
            singer.songs = songs;
            return this;
        }

        public Singer build() {
            return singer;
        }
    }

    /**
     * Overriding toString method
     *
     * @return information on the object
     */
    @Override
    public String toString() {
        return "SINGER:\n" + "Name: " + name + "\nSongs: " + songs.toString()
                + "\n___________________________\n";
    }

    /**
     * This is the method which tells you whether object are equal or not.
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
        Singer singer = (Singer) object;
        return Objects.equals(name, singer.name)
                && Objects.equals(songs, singer.songs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, songs);
    }
}

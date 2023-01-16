package org.example;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SongTest {
    @Test
    public void testEqualSong() {
        Song song1 = new Song.Builder().setName("Bones").setGenre(GENRES.ROCK).build();
        Song song2 = new Song.Builder().setName("Bones").setGenre(GENRES.ROCK).build();
        Assert.assertEquals(song1, song2);
    }

    @Test
    public void negativeTestEqualSong() {
        Song song1 = new Song.Builder().setName("Bones").setGenre(GENRES.ROCK).build();
        Song song2 = new Song.Builder().setName("Bones").setGenre(GENRES.ROCK).setAlbum("Mercury").build();
        Assert.assertNotEquals(song1, song2);
    }

    @DataProvider(name = "hashcode-provider")
    public Object[][] testHashCodeProvider() {
        return new Object[][]{
                {
                        new Song.Builder()
                                .setName("Enter Sandman")
                                .setGenre(GENRES.ROCK)
                                .build().hashCode(),

                        new Song.Builder()
                                .setName("Enter Sandman")
                                .setGenre(GENRES.ROCK)
                                .build().hashCode()
                },
                {
                        new Song.Builder()
                                .setName("Nothing Else Matters")
                                .setGenre(GENRES.ROCK)
                                .setAlbum("Metallica")
                                .build().hashCode(),

                        new Song.Builder()
                                .setName("Nothing Else Matters")
                                .setGenre(GENRES.ROCK)
                                .setAlbum("Metallica")
                                .build().hashCode()
                }
        };
    }

    @Test(dataProvider = "hashcode-provider")
    public void testHashCode(int p1, int p2) {
        Assert.assertEquals(p1, p2);
    }


    @DataProvider(name = "hashcode-provider-neg")
    public Object[][] testNegativeHashCodeProvider() {
        return new Object[][]{
                {
                        new Song.Builder()
                                .setName("Enter Sandman")
                                .setGenre(GENRES.ROCK)
                                .build().hashCode(),

                        new Song.Builder()
                                .setName("Enter Sandman")
                                .setGenre(GENRES.POP)
                                .build().hashCode()
                },
                {
                        new Song.Builder()
                                .setName("Nothing Else Matters")
                                .setGenre(GENRES.ROCK)
                                .setAlbum("Metallica")
                                .build().hashCode(),

                        new Song.Builder()
                                .setName("Nothing Else Matters")
                                .setGenre(GENRES.ROCK)
                                .setAlbum("Inquisition Symphony")
                                .build().hashCode()
                }
        };
    }

    @Test(dataProvider = "hashcode-provider-neg")
    public void testNegativeHashCode(int p1, int p2) {
        Assert.assertNotEquals(p1, p2);
    }

}

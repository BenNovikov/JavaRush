package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Ben on 2017-10-04.
 */
public class AdvertisementStorage {
    private static AdvertisementStorage advertisementStorage = new AdvertisementStorage();
    private final List<Advertisement> videos = new ArrayList<>();

    public static AdvertisementStorage getInstance() {
        return advertisementStorage;
    }

    private AdvertisementStorage() {
        Object someContent = new Object();
        add(new Advertisement(someContent, "First Video", 5000, 5, 3 * 60)); // 3 min
        add(new Advertisement(someContent, "Second Video", 100, 3, 15 * 60)); //15 min
        add(new Advertisement(someContent, "Third Video", 400, 2, 10 * 60));   //10 min
        Random rand = new Random();
        for (int i = 0; i < 3; i++) {
            add(new Advertisement(
                    someContent,
                    String.format("Video#%02d", i),
                    rand.nextInt(5000),
                    rand.nextInt(3) + 1,
                    rand.nextInt(15) * 60
            ));
        }
    }

    public List<Advertisement> list() {
        return videos;
    }

    public void add(Advertisement advertisement) {
        this.videos.add(advertisement);
    }
}

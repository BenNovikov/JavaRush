package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 Текущее задание — реализовать п.2.2 предыдущего задания с помощью рекурсии.
 (подобрать список видео из доступных, просмотр которых обеспечивает максимальную выгоду)
 Рекурсивный метод должен выбрать набор рекламных роликов, которые будут показаны посетителю.

 Этот набор должен удовлетворять следующим требованиям:
 1. сумма денег, полученная от показов, должна быть максимальной из всех возможных вариантов
 2. общее время показа рекламных роликов НЕ должно превышать время приготовления блюд для текущего заказа;
 3. для одного заказа любой видео-ролик показывается не более одного раза;
 4. если существует несколько вариантов набора видео-роликов с одинаковой суммой денег, полученной от показов, то:
 4.1. выбрать тот вариант, у которого суммарное время максимальное;
 4.2. если суммарное время у этих вариантов одинаковое, то выбрать вариант с минимальным количеством роликов;
 5. количество показов у любого рекламного ролика из набора — положительное число.

 При локальном тестировании учитывайте, что необходимо отобразить все рекламные ролики, отобранные для показа, в порядке уменьшения стоимости показа одного рекламного ролика в копейках.
 Также не забудь реализовать п.2.4 из предыдущего задания (вывести на экран все подходящие ролики).
 Для каждого показанного видео-ролика должен быть вызван метод revalidate().
 */
public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() throws NoVideoAvailableException, InterruptedException {
        if (storage.list().isEmpty())
            throw new NoVideoAvailableException();
        List<Advertisement> toShow = getVideosToShow(storage.list(), timeSeconds);
        for (Advertisement ad : toShow) {
            ConsoleHelper.writeMessage("Advertisement " + ad.getName());
//            Thread.currentThread().sleep(ad.getDuration() * 1000);
            ConsoleHelper.writeMessage(" shown.");
        }
    }

    //add videos if there is one to fit the show duration time frame
    public List<Advertisement> getVideosToShow(List<Advertisement> videosFromStorage, int showDurationSeconds) {
        List<Advertisement> videosToShow = new ArrayList<>();

        if (!videosFromStorage.isEmpty()) {
            int minDurationOfVideoFromStorage = videosFromStorage.stream()
                    .mapToInt(Advertisement::getDuration).min().orElse(showDurationSeconds + 100);

            if (minDurationOfVideoFromStorage >= showDurationSeconds) {
                Advertisement mostValuableVideoFromStorage = videosFromStorage.stream()
                        .filter(x -> x.getHits() > 0)
                        .max((x, y) -> {
                            return (int) (x.getAmountPerOneDisplaying() - y.getAmountPerOneDisplaying());
                        })
                        .get();

                videosFromStorage.remove(mostValuableVideoFromStorage);
                if (mostValuableVideoFromStorage.getDuration() <= showDurationSeconds) {
                    showDurationSeconds -= mostValuableVideoFromStorage.getDuration();
                    mostValuableVideoFromStorage.revalidate();
                }
                else {
                    mostValuableVideoFromStorage = null;
                }
                videosToShow = getVideosToShow(videosFromStorage, showDurationSeconds);
                videosToShow.add(mostValuableVideoFromStorage);
            }
        }

        return videosToShow;
    }
}
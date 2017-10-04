package com.javarush.task.task27.task2712.ad;

/**
 * Created by Ben on 2017-10-04.
 **/
public class Advertisement {
    private Object content;
    private String name;
    private long initialAmount; // начальная сумма, стоимость рекламы в копейках
    private int hits; // количество оплаченных показов
    private int duration; // продолжительность в секундах
    private long amountPerOneDisplaying;

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        amountPerOneDisplaying = initialAmount/hits;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }

    public int getHits() {
        return hits;
    }

    public void revalidate() {
        if (hits <= 0)
            throw new UnsupportedOperationException();
        hits--;
    }
}

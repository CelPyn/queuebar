package com.livelypower.queuebar;

import com.livelypower.queuebar.impl.Cereal;
import com.livelypower.queuebar.impl.DefaultOrder;
import com.livelypower.queuebar.impl.OrderLine;
import com.livelypower.queuebar.impl.RedWine;

import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Main {

    private static final BarService barService = new BarService();
    private static final ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1);

    public static void main(String[] args) {

        while (true) {
            final Random rand = new Random();
            final int delay = rand.nextInt(15) + 1;
            final ScheduledFuture<?> schedule = executorService.schedule(addOrder(), delay, TimeUnit.SECONDS);
            try {
                schedule.get(delay + 1, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                throw new IllegalStateException("Interrupted!", e);
            } catch (ExecutionException e) {
                throw new IllegalStateException("Execution failure!", e);
            } catch (TimeoutException e) {
                throw new IllegalStateException("Timeout failure!", e);
            }

        }

    }

    private static Runnable addOrder() {
        return () -> {
            final Random rand = new Random();
            final int amountOfOrders = rand.nextInt(5) + 1;

            for (int i = 0; i < amountOfOrders; i++) {
                final int amountOfWine = rand.nextInt(4) + 1;
                final int amountOfCereal = rand.nextInt(4) + 1;

                final List<OrderLine> orderLines = List.of(new OrderLine(new RedWine(), amountOfWine),
                        new OrderLine(new Cereal(), amountOfCereal));

                barService.addOrder(new DefaultOrder(orderLines));
            }
        };
    }

}

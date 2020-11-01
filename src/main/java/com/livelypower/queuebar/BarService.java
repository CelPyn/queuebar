package com.livelypower.queuebar;

import com.livelypower.queuebar.domain.Order;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class BarService {

    private final Queue<Order> queue;
    private final ScheduledExecutorService executorService;

    public BarService() {
        queue = new ConcurrentLinkedQueue<>();
        executorService = new ScheduledThreadPoolExecutor(4);
        executorService.scheduleAtFixedRate(getHandleOrder(), 2, 2, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(getDisplayQueue(),5, 5, TimeUnit.SECONDS);
    }

    private Runnable getHandleOrder() {
        return () -> {
            final Order order = queue.poll();
            if (order != null) {
                doHandleOrder(order);
            }
        };
    }

    private void doHandleOrder(final Order order) {
        executorService.schedule(() -> System.out.println("Handled order: " + order), order.getProducts().size(), TimeUnit.SECONDS);
    }

    private Runnable getDisplayQueue() {
        return () -> System.out.println("Backlog size: " + queue.size());
    }

    public void addOrder(final Order order) {
        queue.add(order);
        System.out.println("Added order to queue: " + order);
    }
}

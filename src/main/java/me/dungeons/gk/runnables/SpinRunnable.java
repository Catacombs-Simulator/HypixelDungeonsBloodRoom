package me.dungeons.gk.runnables;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.scheduler.BukkitRunnable;

public class SpinRunnable extends BukkitRunnable {


    private final Entity entity;

    public SpinRunnable(Entity entity) {
        this.entity = entity;
    }

    @Override
    public void run() {
        if(entity.isDead()) {
            cancel();
        }
        Location loc = entity.getLocation();
        loc.setPitch(loc.getPitch() + 2);
    }
}

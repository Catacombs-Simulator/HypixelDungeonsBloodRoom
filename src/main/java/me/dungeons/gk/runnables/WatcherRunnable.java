package me.dungeons.gk.runnables;

import me.dungeons.gk.Main;
import me.dungeons.gk.Utils.SkullUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.ArrayList;

public class WatcherRunnable extends BukkitRunnable {

    private final ArmorStand armorstand;
    private final ArrayList<Location> paths;
    private final Double speed;
    private boolean finished = false;
    private Location target;

    public WatcherRunnable(ArmorStand armorstand, ArrayList<Location> paths, Double speed) {
        this.armorstand = armorstand;
        this.paths = paths;
        this.speed = speed;
        this.armorstand.setVisible(false);
        this.armorstand.getEquipment().setHelmet(SkullUtils.getSkull("https://textures.minecraft.net/texture/17db1923d03c4ef4e9f6e872c5a6ad2578b1aff2b281fbc3ffa7466c825fb9"));
    }

    @Override
    public void run() {
        if(this.finished) {
            this.armorstand.setHealth(0);
            this.finished = false;
            if(this.paths.size() == 0) {
                startPathFinding();
            }
            cancel();
        } else {
            startPathFinding();
        }
    }

    private void startPathFinding() {
        Location point = armorstand.getLocation();
        Location target = this.paths.get(0);
        if(this.target == armorstand.getLocation())  {
            this.finished = true;
            return;
        }
        this.target = target;
        this.paths.remove(0);
        if(this.paths.size() == 0) {
            this.finished = true;
            return;
        }
        if(target.getWorld().getNearbyEntities(target,0.5,0.5,0.5).contains(armorstand)) {
            armorstand.teleport(target);
        }
        double angle = Math.atan2(target.getZ() - point.getZ(), target.getX() - point.getX());
        point.add(Math.cos(angle) * speed, 0, Math.sin(angle) * speed);
        armorstand.teleport(point);
    }

}

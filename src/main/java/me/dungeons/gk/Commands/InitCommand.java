<<<<<<< HEAD
package me.dungeons.gk.Commands;

import me.dungeons.gk.Main;
import me.dungeons.gk.entities.Blood.BloodRoomCore;
import me.dungeons.gk.runnables.WatcherRunnable;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Locale;


public class InitCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if (args[0].toString().toLowerCase().equals("setup")) {
                if (!args[1].isEmpty() || !args[2].isEmpty() || !args[3].isEmpty() || !args[4].isEmpty() || !args[5].isEmpty() || !args[6].isEmpty()) {
                    ArrayList<Integer> coords = new ArrayList<>();
                    try {
                        coords.add(Integer.parseInt(args[1]));
                        coords.add(Integer.parseInt(args[2]));
                        coords.add(Integer.parseInt(args[3]));
                        coords.add(Integer.parseInt(args[4]));
                        coords.add(Integer.parseInt(args[5]));
                        coords.add(Integer.parseInt(args[6]));
                        Location loc1 = new Location(p.getWorld(), coords.get(0), coords.get(1), coords.get(2));
                        Location loc2 = new Location(p.getWorld(), coords.get(3), coords.get(4), coords.get(5));
                        p.sendMessage(loc1 + " " + loc2);
                        BloodRoomCore.init(loc1, loc2);
                    } catch (Exception e) {
                        p.sendMessage("\u00a7cInvalid Syntax: /blood setup <x1> <y1> <z1> <x2> <y2> <z2>");
                        e.printStackTrace();
                        return false;
                    }
                }
            }
            if (args[0].equals("watchertest")) {
                if (!args[2].isEmpty() || !args[3].isEmpty() || !args[4].isEmpty()) {
                    ArrayList<Integer> coords = new ArrayList<>();
                    try {
                        coords.add(Integer.parseInt(args[2]));
                        coords.add(Integer.parseInt(args[3]));
                        coords.add(Integer.parseInt(args[4]));
                        Location loc1 = new Location(p.getWorld(), coords.get(0), coords.get(1), coords.get(2));
                        ArmorStand as = p.getWorld().spawn(p.getLocation().add(0.0, 3.0, 0), ArmorStand.class);
                        as.setGravity(false);
                        new WatcherRunnable(as, loc1, Double.parseDouble(args[1])).runTaskTimer(Main.getInstance(), 0,1);
                    } catch (Exception e) {
                        p.sendMessage("\u00a7cInvalid Syntax: /blood watchertest <speed> <x> <y> <z>");
                        e.printStackTrace();
                        return false;
                    }
                }
            }
        }
        return false;
    }
}
=======
package me.dungeons.gk.Commands;

import me.dungeons.gk.Main;
import me.dungeons.gk.entities.Blood.BloodRoomCore;
import me.dungeons.gk.runnables.WatcherRunnable;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Locale;


public class InitCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if (args[0].toString().toLowerCase().equals("setup")) {
                if (!args[1].isEmpty() || !args[2].isEmpty() || !args[3].isEmpty() || !args[4].isEmpty() || !args[5].isEmpty() || !args[6].isEmpty()) {
                    ArrayList<Integer> coords = new ArrayList<>();
                    try {
                        coords.add(Integer.parseInt(args[1]));
                        coords.add(Integer.parseInt(args[2]));
                        coords.add(Integer.parseInt(args[3]));
                        coords.add(Integer.parseInt(args[4]));
                        coords.add(Integer.parseInt(args[5]));
                        coords.add(Integer.parseInt(args[6]));
                        Location loc1 = new Location(p.getWorld(), coords.get(0), coords.get(1), coords.get(2));
                        Location loc2 = new Location(p.getWorld(), coords.get(3), coords.get(4), coords.get(5));
                        p.sendMessage(loc1 + " " + loc2);
                        BloodRoomCore.init(loc1, loc2);
                    } catch (Exception e) {
                        p.sendMessage("\u00a7cInvalid Syntax: /blood setup <x1> <y1> <z1> <x2> <y2> <z2>");
                        e.printStackTrace();
                        return false;
                    }
                }
            }
            if (args[0].equals("watchertest")) {
                if (!args[2].isEmpty() || !args[3].isEmpty() || !args[4].isEmpty()) {
                    ArrayList<Integer> coords = new ArrayList<>();
                    try {
                        coords.add(Integer.parseInt(args[2]));
                        coords.add(Integer.parseInt(args[3]));
                        coords.add(Integer.parseInt(args[4]));
                        Location loc1 = new Location(p.getWorld(), coords.get(0), coords.get(1), coords.get(2));
                        ArmorStand as = p.getWorld().spawn(p.getLocation().add(0.0, 3.0, 0), ArmorStand.class);
                        as.setGravity(false);
                        new WatcherRunnable(as, loc1, Double.parseDouble(args[1])).runTaskTimer(Main.getInstance(), 0,1);
                    } catch (Exception e) {
                        p.sendMessage("\u00a7cInvalid Syntax: /blood watchertest <speed> <x> <y> <z>");
                        e.printStackTrace();
                        return false;
                    }
                }
            }
        }
        return false;
    }
}
>>>>>>> 3257bff (balls)

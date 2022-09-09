package me.dungeons.gk.entities.Blood;

import com.cryptomorin.xseries.XMaterial;
import me.dungeons.gk.Main;
import me.dungeons.gk.Utils.SkullUtils;
import me.dungeons.gk.runnables.WatcherRunnable;
import net.minecraft.server.v1_8_R3.BlockPosition;
import net.minecraft.server.v1_8_R3.TileEntitySkull;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.Skull;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.entity.ArmorStand;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class BloodRoomCore {

    private static final ArrayList<BloodMobs.MOBS> mobs = new ArrayList<>();
    private static final HashMap<BloodMobs.MOBS, Location> heads = new HashMap<>();

    public static void init(Location loc1, Location loc2) {
        mobs.addAll(Arrays.asList(BloodMobs.MOBS.values()));
        if(replaceWool(loc1, loc2)) {
//            mobs.addAll(Arrays.asList(BloodMobs.MOBS.values()));
//            int random = new Random().nextInt(mobs.size());
//            if(random == 0) { random++; }
//            BloodMobs.MOBS mob = mobs.get(random);
//            mobs.remove(mob);
//            Location target = heads.get(mob);
//            ArmorStand as = loc1.getWorld().spawn(loc1.add(15,15,15), ArmorStand.class);
//            as.setGravity(false);
//            new WatcherRunnable(as, target).runTaskTimer(Main.getInstance(),0,20);
        }

    }



    public static boolean replaceWool(Location p1, Location p2) {
        List<Block> blocks = getAllBlocksInArea(p1,p2);
        blocks.forEach(block -> {
            Block gw = p1.getWorld().getBlockAt(161, 117, 345);
            
            if(block.getData() == gw.getData() && block.getType() == gw.getType()) {
                int random;
                if(mobs.size() == 0) {
                    return;
                } else {
                    random = new Random().nextInt(mobs.size());
                }

                System.out.println(Math.abs(random));
                BloodMobs.MOBS mob = mobs.get(Math.abs(random));
                mobs.remove(mob);
                heads.put(mob, block.getLocation());


                block.setType(Material.SKULL);
                Skull skulldata = (Skull) block.getState();
                skulldata.setSkullType(SkullType.PLAYER);
                TileEntitySkull skullTile = (TileEntitySkull) ((CraftWorld)block.getWorld()).getHandle().getTileEntity(new BlockPosition(block.getX(), block.getY(), block.getZ()));
                skullTile.setGameProfile(SkullUtils.createGameProfile(mob.getURL()));
                skullTile.update();
            }
        });
        System.out.println(mobs);
        mobs.clear();
        return true;
    }

    public static List<Block> getAllBlocksInArea(Location loc1, Location loc2) {
        List<Block> blocks = new ArrayList<Block>();

        int topBlockX = (loc1.getBlockX() < loc2.getBlockX() ? loc2.getBlockX() : loc1.getBlockX());
        int bottomBlockX = (loc1.getBlockX() > loc2.getBlockX() ? loc2.getBlockX() : loc1.getBlockX());

        int topBlockY = (loc1.getBlockY() < loc2.getBlockY() ? loc2.getBlockY() : loc1.getBlockY());
        int bottomBlockY = (loc1.getBlockY() > loc2.getBlockY() ? loc2.getBlockY() : loc1.getBlockY());

        int topBlockZ = (loc1.getBlockZ() < loc2.getBlockZ() ? loc2.getBlockZ() : loc1.getBlockZ());
        int bottomBlockZ = (loc1.getBlockZ() > loc2.getBlockZ() ? loc2.getBlockZ() : loc1.getBlockZ());

        for(int x = bottomBlockX; x <= topBlockX; x++)
        {
            for(int z = bottomBlockZ; z <= topBlockZ; z++)
            {
                for(int y = bottomBlockY; y <= topBlockY; y++)
                {
                    Block block = loc1.getWorld().getBlockAt(x, y, z);

                    blocks.add(block);
                }
            }
        }

        return blocks;
    }


}

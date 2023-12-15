package net.dijon.herapp.item;

import net.dijon.herapp.HerobrineApple;
import net.minecraft.entity.EntityStatuses;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.World;

public class HerobrineAppleLighter extends Item {
    public HerobrineAppleLighter(Settings settings){
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {

        PlayerEntity player = (PlayerEntity) user;
        summonLightning(player);
        player.getWorld().sendEntityStatus(player, EntityStatuses.USE_TOTEM_OF_UNDYING);

        return super.finishUsing(stack, world, user);
    }

    private static void summonLightning(PlayerEntity player) {
        LightningEntity lightning = new LightningEntity(EntityType.LIGHTNING_BOLT, player.getWorld());
        lightning.setPosition(player.getPos());
        player.getWorld().spawnEntity(lightning);
        for (int i = 0; i < 10; i++) {
            player.getWorld().spawnEntity(lightning);
        }
    }
}

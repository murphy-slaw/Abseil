package me.dienes.abseil;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class AbseilBlocks {
    public static final ClimbingRopeBlock CLIMBING_ROPE_BLOCK;

    static {
        CLIMBING_ROPE_BLOCK = new ClimbingRopeBlock(
                FabricBlockSettings.create()
                        .nonOpaque()
                        .noCollision()
                        .burnable()
                        .sounds(AbseilBlockSoundGroups.CLIMBING_ROPE_BLOCK)
        );
    }

    public static void registerBlocks() {
        Registry.register(Registries.BLOCK, new Identifier(Abseil.MOD_ID, "climbing_rope"), CLIMBING_ROPE_BLOCK);

        FlammableBlockRegistry.getDefaultInstance().add(CLIMBING_ROPE_BLOCK, 30, 60); // Values taken from wool
    }
}

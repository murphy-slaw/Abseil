package me.dienes.abseil;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class AbseilItems {
    public static final ClimbingRopeItem CLIMBING_ROPE_ITEM;

    static {
        CLIMBING_ROPE_ITEM = new ClimbingRopeItem(new FabricItemSettings().maxCount(16));
    }

    public static void registerItems() {
        Registry.register(Registries.ITEM, new Identifier(Abseil.MOD_ID, "climbing_rope"), CLIMBING_ROPE_ITEM);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> content.add(CLIMBING_ROPE_ITEM));
    }
}

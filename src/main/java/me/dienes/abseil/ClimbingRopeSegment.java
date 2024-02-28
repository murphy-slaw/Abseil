package me.dienes.abseil;

import net.minecraft.util.StringIdentifiable;

public enum ClimbingRopeSegment implements StringIdentifiable {
    TOP("top"),
    MIDDLE("middle"),
    BOTTOM("bottom"),
    TOP_BOTTOM("top_bottom");

    private final String name;

    ClimbingRopeSegment(String name) {
        this.name = name;
    }

    @Override
    public String asString() {
        return this.name;
    }
}


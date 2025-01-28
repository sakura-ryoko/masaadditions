package com.red.masaadditions.tweakeroo_additions.config;

import com.google.common.collect.ImmutableList;
import com.red.masaadditions.MasaAdditions;

import fi.dy.masa.malilib.config.IConfigBase;
import fi.dy.masa.malilib.config.IHotkeyTogglable;
import fi.dy.masa.malilib.config.options.*;

public class ConfigsExtended {
    private static final String GENERIC_KEY = MasaAdditions.MOD_ID+ ".config.configs_extended2.generic";
    public static class Generic {
        public static final ConfigInteger BLOCK_BREAKING_PARTICLE_LIMIT = new ConfigInteger("blockBreakingParticleLimit", 8, 1, 1024).apply(GENERIC_KEY);
        public static final ConfigDouble BLOCK_BREAKING_PARTICLE_SCALE = new ConfigDouble("blockBreakingParticleScale", 1, 0, 20).apply(GENERIC_KEY);
        public static final ConfigDouble BLOCK_BREAKING_PARTICLE_SPEED = new ConfigDouble("blockBreakingParticleSpeedMultiplier", 1, 0, 20).apply(GENERIC_KEY);
        public static final ConfigBoolean CLICK_RECIPE_CRAFT = new ConfigBoolean("clickRecipeCraft", false).apply(GENERIC_KEY);
        public static final ConfigDouble CLOUD_HEIGHT = new ConfigDouble("cloudHeight", 128, 0, 256).apply(GENERIC_KEY);
        public static final ConfigBoolean DERPY_CHICKEN = new ConfigBoolean("derpyChicken", false).apply(GENERIC_KEY);
        public static final ConfigBoolean HAND_RESTOCK_CONTINUOUS = new ConfigBoolean("handRestockContinuous", false).apply(GENERIC_KEY);
        public static final ConfigBoolean GRID_RESTRICT_X = new ConfigBoolean("gridRestrictX", true).apply(GENERIC_KEY);
        public static final ConfigBoolean GRID_RESTRICT_Y = new ConfigBoolean("gridRestrictY", true).apply(GENERIC_KEY);
        public static final ConfigBoolean GRID_RESTRICT_Z = new ConfigBoolean("gridRestrictZ", true).apply(GENERIC_KEY);
        public static final ConfigInteger SCOREBOARD_SIDEBAR_MAX_LENGTH = new ConfigInteger("scoreboardSidebarMaxLength", 15, 1, 30).apply(GENERIC_KEY);
        public static final ConfigInteger SKY_TIME_OVERRIDE = new ConfigInteger("skyTimeOverride", 0, 0, 24000).apply(GENERIC_KEY);
        public static final ConfigString WINDOW_TITLE_OVERRIDE = new ConfigString("windowTitleOverride", "").apply(GENERIC_KEY);

        public static final ImmutableList<IConfigBase> ADDITIONAL_OPTIONS = ImmutableList.of(
                BLOCK_BREAKING_PARTICLE_LIMIT,
                BLOCK_BREAKING_PARTICLE_SCALE,
                BLOCK_BREAKING_PARTICLE_SPEED,
                CLICK_RECIPE_CRAFT,
                CLOUD_HEIGHT,
                DERPY_CHICKEN,
                HAND_RESTOCK_CONTINUOUS,
                GRID_RESTRICT_X,
                GRID_RESTRICT_Y,
                GRID_RESTRICT_Z,
                SCOREBOARD_SIDEBAR_MAX_LENGTH,
                SKY_TIME_OVERRIDE,
                WINDOW_TITLE_OVERRIDE
        );
    }

    private static final String LISTS_KEY = MasaAdditions.MOD_ID+ ".config.configs_extended2.lists";
    public static class Lists {
        public static final ConfigStringList PERIMETER_OUTLINE_BLOCKS_LIST = new ConfigStringList("perimeterOutlineBlocksList", ImmutableList.of()).apply(LISTS_KEY);
        public static final ConfigStringList PREVENT_ATTACK_ENTITIES_LIST = new ConfigStringList("preventAttackEntitiesList", ImmutableList.of()).apply(LISTS_KEY);
        public static final ConfigStringList SWAP_ALMOST_BROKEN_TOOLS_WHITELIST = new ConfigStringList("swapAlmostBrokenToolsWhitelist", ImmutableList.of()).apply(LISTS_KEY);
        public static final ConfigStringList SWAP_ALMOST_BROKEN_TOOLS_BLACKLIST = new ConfigStringList("swapAlmostBrokenToolsBlacklist", ImmutableList.of()).apply(LISTS_KEY);

        public static final ImmutableList<IConfigBase> ADDITIONAL_OPTIONS = ImmutableList.of(
                PERIMETER_OUTLINE_BLOCKS_LIST,
                PREVENT_ATTACK_ENTITIES_LIST,
                SWAP_ALMOST_BROKEN_TOOLS_WHITELIST,
                SWAP_ALMOST_BROKEN_TOOLS_BLACKLIST
        );
    }

    private static final String DISABLE_KEY = MasaAdditions.MOD_ID+ ".config.configs_extended2.disable";
    public static class Disable {
        public static final ConfigBooleanHotkeyed DISABLE_BEACON_BEAM_RENDERING = new ConfigBooleanHotkeyed("disableBeaconBeamRendering", false, "").apply(DISABLE_KEY);
        public static final ConfigBooleanHotkeyed DISABLE_BED_EXPLOSIONS = new ConfigBooleanHotkeyed("disableBedExplosions", false, "").apply(DISABLE_KEY);
        public static final ConfigBooleanHotkeyed DISABLE_BLOCK_ATTACKED_PARTICLES = new ConfigBooleanHotkeyed("disableBlockAttackedParticles", false, "").apply(DISABLE_KEY);
        public static final ConfigBooleanHotkeyed DISABLE_BOSS_BAR_RENDERING = new ConfigBooleanHotkeyed("disableBossBarRendering", false, "").apply(DISABLE_KEY);
        public static final ConfigBooleanHotkeyed DISABLE_CHRISTMAS_CHESTS = new ConfigBooleanHotkeyed("disableChristmasChests", false, "").apply(DISABLE_KEY);
        public static final ConfigBooleanHotkeyed DISABLE_DRAGON_EGG_TELEPORTING = new ConfigBooleanHotkeyed("disableDragonEggTeleporting", false, "").apply(DISABLE_KEY);
        public static final ConfigBooleanHotkeyed DISABLE_FARMLAND_MAKING = new ConfigBooleanHotkeyed("disableFarmlandMaking", false, "").apply(DISABLE_KEY);
        public static final ConfigBooleanHotkeyed DISABLE_FOOTSTEP_PARTICLES = new ConfigBooleanHotkeyed("disableFootstepParticles", false, "").apply(DISABLE_KEY);
        public static final ConfigBooleanHotkeyed DISABLE_HONEY_BLOCK_SLOWDOWN = new ConfigBooleanHotkeyed("disableHoneyBlockSlowdown", false, "").apply(DISABLE_KEY);
        public static final ConfigBooleanHotkeyed DISABLE_HONEY_BLOCK_JUMPING = new ConfigBooleanHotkeyed("disableHoneyBlockJumping", true, "").apply(DISABLE_KEY);
        public static final ConfigBooleanHotkeyed DISABLE_ITEM_FRAME_FRAME_RENDERING = new ConfigBooleanHotkeyed("disableItemFrameFrameRendering", false, "").apply(DISABLE_KEY);
        public static final ConfigBooleanHotkeyed DISABLE_OTHER_PLAYER_RENDERING = new ConfigBooleanHotkeyed("disableOtherPlayerRendering", false, "").apply(DISABLE_KEY);
        public static final ConfigBooleanHotkeyed DISABLE_PATH_MAKING = new ConfigBooleanHotkeyed("disablePathMaking", false, "").apply(DISABLE_KEY);
        public static final ConfigBooleanHotkeyed DISABLE_PLANT_BLOCK_MODEL_OFFSET = new ConfigBooleanHotkeyed("disablePlantBlockModelOffset", false, "").apply(DISABLE_KEY);
        public static final ConfigBooleanHotkeyed DISABLE_REALMS_BUTTON = new ConfigBooleanHotkeyed("disableRealmsButton", false, "").apply(DISABLE_KEY);
        public static final ConfigBooleanHotkeyed DISABLE_SCOREBOARD_SIDEBAR_RENDERING = new ConfigBooleanHotkeyed("disableScoreboardSidebarRendering", false, "").apply(DISABLE_KEY);
        public static final ConfigBooleanHotkeyed DISABLE_SLEEPING_NOTIFICATION = new ConfigBooleanHotkeyed("disableSleepingNotification", false, "").apply(DISABLE_KEY);
        public static final ConfigBooleanHotkeyed DISABLE_SLIME_BLOCK_BOUNCING = new ConfigBooleanHotkeyed("disableSlimeBlockBouncing", false, "").apply(DISABLE_KEY);
        public static final ConfigBooleanHotkeyed DISABLE_SNOW_LAYER_STACKING = new ConfigBooleanHotkeyed("disableSnowLayerStacking", false, "").apply(DISABLE_KEY);
        public static final ConfigBooleanHotkeyed DISABLE_SPRINTING_UNDERWATER = new ConfigBooleanHotkeyed("disableSprintingUnderwater", true, "").apply(DISABLE_KEY);
        public static final ConfigBooleanHotkeyed DISABLE_STUCK_ARROWS_RENDERING = new ConfigBooleanHotkeyed("disableStuckArrowsRendering", false, "").apply(DISABLE_KEY);
        public static final ConfigBooleanHotkeyed DISABLE_SWIMMING = new ConfigBooleanHotkeyed("disableSwimming", false, "").apply(DISABLE_KEY);

        public static final ImmutableList<IHotkeyTogglable> ADDITIONAL_OPTIONS = ImmutableList.of(
                DISABLE_BEACON_BEAM_RENDERING,
                DISABLE_BED_EXPLOSIONS,
                DISABLE_BLOCK_ATTACKED_PARTICLES,
                DISABLE_BOSS_BAR_RENDERING,
                DISABLE_CHRISTMAS_CHESTS,
                DISABLE_DRAGON_EGG_TELEPORTING,
                DISABLE_FARMLAND_MAKING,
                DISABLE_FOOTSTEP_PARTICLES,
                DISABLE_HONEY_BLOCK_SLOWDOWN,
                DISABLE_HONEY_BLOCK_JUMPING,
                DISABLE_ITEM_FRAME_FRAME_RENDERING,
                DISABLE_OTHER_PLAYER_RENDERING,
                DISABLE_PATH_MAKING,
                DISABLE_PLANT_BLOCK_MODEL_OFFSET,
                DISABLE_REALMS_BUTTON,
                DISABLE_SCOREBOARD_SIDEBAR_RENDERING,
                DISABLE_SLEEPING_NOTIFICATION,
                DISABLE_SLIME_BLOCK_BOUNCING,
                DISABLE_SNOW_LAYER_STACKING,
                DISABLE_SPRINTING_UNDERWATER,
                DISABLE_STUCK_ARROWS_RENDERING,
                DISABLE_SWIMMING
        );
    }

    private static final String INTERNAL_KEY = MasaAdditions.MOD_ID+ ".config.configs_extended2.internal";
    public static class Internal {
        public static final ConfigDouble HONEY_BLOCK_VELOCITY_MULTIPLIER_ORIGINAL = new ConfigDouble("honeyBlockVelocityMultiplierOriginal", 0.4, 0, 1).apply(INTERNAL_KEY);
        public static final ConfigDouble HONEY_BLOCK_JUMP_VELOCITY_MULTIPLIER_ORIGINAL = new ConfigDouble("honeyBlockJumpVelocityMultiplierOriginal", 0.5, 0, 1).apply(INTERNAL_KEY);

        public static final ImmutableList<IConfigBase> ADDITIONAL_OPTIONS = ImmutableList.of(
                HONEY_BLOCK_VELOCITY_MULTIPLIER_ORIGINAL,
                HONEY_BLOCK_JUMP_VELOCITY_MULTIPLIER_ORIGINAL
        );
    }
}

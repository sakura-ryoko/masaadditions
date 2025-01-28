package com.red.masaadditions.tweakeroo_additions.config;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.red.masaadditions.MasaAdditions;

import fi.dy.masa.malilib.config.ConfigType;
import fi.dy.masa.malilib.config.IConfigBoolean;
import fi.dy.masa.malilib.config.IConfigNotifiable;
import fi.dy.masa.malilib.config.IHotkeyTogglable;
import fi.dy.masa.malilib.gui.GuiBase;
import fi.dy.masa.malilib.hotkeys.IKeybind;
import fi.dy.masa.malilib.hotkeys.KeyCallbackToggleBooleanConfigWithMessage;
import fi.dy.masa.malilib.hotkeys.KeybindMulti;
import fi.dy.masa.malilib.hotkeys.KeybindSettings;
import fi.dy.masa.malilib.interfaces.IValueChangeCallback;
import fi.dy.masa.malilib.util.StringUtils;
import fi.dy.masa.tweakeroo.Reference;
import fi.dy.masa.tweakeroo.Tweakeroo;

public enum FeatureToggleExtended implements IHotkeyTogglable, IConfigNotifiable<IConfigBoolean> {
    TWEAK_ALWAYS_RENDER_BARRIER_PARTICLES("tweakAlwaysRenderBarrierParticles", false, ""),
    TWEAK_BLOCK_BREAKING_PARTICLES("tweakBlockBreakingParticleTweaks", false, ""),
    TWEAK_FORCE_SWAP_GEAR("tweakForceSwapGear", false, ""),
    TWEAK_INSANE_BLOCK_BREAKING_PARTICLES("tweakInsaneBlockBreakingParticles", false, ""),
    TWEAK_ITEM_NAME_COPY("tweakItemNameCopy", false, ""),
    TWEAK_LLAMA_STEERING("tweakLlamaSteering", false, ""),
    TWEAK_MOVEMENT_HOLD("tweakMovementHold", false, "", KeybindSettings.PRESS_ALLOWEXTRA),
    TWEAK_NAME_TAG_PIGLINS("tweakNameTagPiglins", false, ""),
    TWEAK_ONE_HIT_KILL("tweakOneHitKill", false, ""),
    TWEAK_OVERRIDE_SKY_TIME("tweakOverrideSkyTime", false, ""),
    TWEAK_OVERRIDE_WINDOW_TITLE("tweakOverrideWindowTitle", false, ""),
    TWEAK_PERIMETER_WALL_DIG_HELPER("tweakPerimeterWallDigHelper", false, ""),
    TWEAK_PREVENT_ATTACK_ENTITIES("tweakPreventAttackEntities", false, ""),
    TWEAK_RAINBOW_LEAVES("tweakRainbowLeaves", false, ""),
    TWEAK_RESPAWN_ON_DEATH("tweakRespawnOnDeath", false, "");

    // todo add i18n entries to en_us.json from now on; this is the config key prefix
    private final static String FEATURE_KEY = MasaAdditions.MOD_ID+ ".config.feature_toggle_extended";

    private final String name;
    private String comment;
    private String prettyName;
    private String translatedName;
    private final IKeybind keybind;
    private final boolean defaultValueBoolean;
    private final boolean singlePlayer;
    private boolean valueBoolean;
    private IValueChangeCallback<IConfigBoolean> callback;

    FeatureToggleExtended(String name, boolean defaultValue, String defaultHotkey) {
        this(name, defaultValue, false, defaultHotkey, KeybindSettings.DEFAULT,
             buildTranslateName(name, "comment"),
             buildTranslateName(name, "prettyName"),
             buildTranslateName(name, "name"));
    }

    FeatureToggleExtended(String name, boolean defaultValue, boolean singlePlayer, String defaultHotkey) {
        this(name, defaultValue, singlePlayer, defaultHotkey, KeybindSettings.DEFAULT,
             buildTranslateName(name, "comment"),
             buildTranslateName(name, "prettyName"),
             buildTranslateName(name, "name"));
    }

    FeatureToggleExtended(String name, boolean defaultValue, String defaultHotkey, KeybindSettings settings) {
        this(name, defaultValue, false, defaultHotkey, settings,
             buildTranslateName(name, "comment"),
             buildTranslateName(name, "prettyName"),
             buildTranslateName(name, "name"));
    }

    FeatureToggleExtended(String name, boolean defaultValue, String defaultHotkey, String comment) {
        this(name, defaultValue, false, defaultHotkey, KeybindSettings.DEFAULT,
             comment,
             buildTranslateName(name, "prettyName"),
             buildTranslateName(name, "name"));
    }

    FeatureToggleExtended(String name, boolean defaultValue, boolean singlePlayer, String defaultHotkey, String comment) {
        this(name, defaultValue, singlePlayer, defaultHotkey, KeybindSettings.DEFAULT,
             comment,
             buildTranslateName(name, "prettyName"),
             buildTranslateName(name, "name"));
    }

    FeatureToggleExtended(String name, boolean defaultValue, String defaultHotkey, KeybindSettings settings, String comment) {
        this(name, defaultValue, false, defaultHotkey, settings,
             comment,
             buildTranslateName(name, "prettyName"),
             buildTranslateName(name, "name"));
    }

    FeatureToggleExtended(String name, boolean defaultValue, boolean singlePlayer, String defaultHotkey, KeybindSettings settings, String comment) {
        this(name, defaultValue, singlePlayer, defaultHotkey, settings,
             comment,
             buildTranslateName(name, "prettyName"),
             buildTranslateName(name, "name"));
    }

    FeatureToggleExtended(String name, boolean defaultValue, String defaultHotkey, String comment, String prettyName) {
        this(name, defaultValue, false, defaultHotkey, KeybindSettings.DEFAULT,
             comment,
             prettyName,
             buildTranslateName(name, "name"));
    }

    FeatureToggleExtended(String name, boolean defaultValue, boolean singlePlayer, String defaultHotkey, String comment, String prettyName) {
        this(name, defaultValue, singlePlayer, defaultHotkey, KeybindSettings.DEFAULT,
             comment,
             prettyName,
             buildTranslateName(name, "name"));
    }

    FeatureToggleExtended(String name, boolean defaultValue, boolean singlePlayer, String defaultHotkey, KeybindSettings settings, String comment, String prettyName, String translatedName) {
        this.name = name;
        this.valueBoolean = defaultValue;
        this.defaultValueBoolean = defaultValue;
        this.singlePlayer = singlePlayer;
        this.comment = comment;
        this.prettyName = prettyName;
        this.translatedName = translatedName;
        this.keybind = KeybindMulti.fromStorageString(defaultHotkey, settings);
        this.keybind.setCallback(new KeyCallbackToggleBooleanConfigWithMessage(this));
    }

    @Override
    public ConfigType getType() {
        return ConfigType.HOTKEY;
    }

    @Override
    public String getName() {
        if (this.singlePlayer) {
            return GuiBase.TXT_GOLD + this.getName() + GuiBase.TXT_RST;
        }

        return this.name;
    }

    @Override
    public String getConfigGuiDisplayName() {
        String name = StringUtils.getTranslatedOrFallback(this.translatedName, this.name);

        if (this.singlePlayer) {
            name = GuiBase.TXT_GOLD + name + GuiBase.TXT_RST;
        }

        return name;
    }

    private static String buildTranslateName(String name, String type) {
        return FEATURE_KEY + "." + type + "." + name;
    }

    @Override
    public String getTranslatedName() {
        String name = StringUtils.getTranslatedOrFallback(this.translatedName, this.name);

        if (this.singlePlayer) {
            name = GuiBase.TXT_GOLD + name + GuiBase.TXT_RST;
        }

        return name;
    }

    @Override
    public void setPrettyName(String prettyName) {
        this.prettyName = prettyName;
    }

    @Override
    public void setTranslatedName(String translatedName) {
        this.translatedName = translatedName;
    }

    @Override
    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String getPrettyName() {
        return StringUtils.getTranslatedOrFallback(this.prettyName,
                                                   !this.prettyName.isEmpty() ? this.prettyName
                                                   : StringUtils.splitCamelCase(this.name.substring(5)));
    }

    @Override
    public String getStringValue() {
        return String.valueOf(this.valueBoolean);
    }

    @Override
    public String getDefaultStringValue() {
        return String.valueOf(this.defaultValueBoolean);
    }

    @Override
    public void setValueFromString(String value) {
    }

    @Override
    public void onValueChanged() {
        if (this.callback != null) {
            this.callback.onValueChanged(this);
        }
    }

    @Override
    public void setValueChangeCallback(IValueChangeCallback<IConfigBoolean> callback) {
        this.callback = callback;
    }

    @Override
    public String getComment() {
        String comment = StringUtils.getTranslatedOrFallback(this.comment, this.comment);

        if (comment != null && this.singlePlayer) {
            return comment + "\n" + StringUtils.translate("tweakeroo.label.config_comment.single_player_only");
        }

        return comment;
    }

    @Override
    public IKeybind getKeybind() {
        return this.keybind;
    }

    @Override
    public boolean getBooleanValue() {
        return this.valueBoolean;
    }

    @Override
    public boolean getDefaultBooleanValue() {
        return this.defaultValueBoolean;
    }

    @Override
    public void setBooleanValue(boolean value) {
        boolean oldValue = this.valueBoolean;
        this.valueBoolean = value;

        if (oldValue != this.valueBoolean) {
            this.onValueChanged();
        }
    }

    @Override
    public boolean isModified() {
        return this.valueBoolean != this.defaultValueBoolean;
    }

    @Override
    public boolean isModified(String newValue) {
        return Boolean.parseBoolean(newValue) != this.defaultValueBoolean;
    }

    @Override
    public void resetToDefault() {
        this.valueBoolean = this.defaultValueBoolean;
    }

    @Override
    public JsonElement getAsJsonElement() {
        return new JsonPrimitive(this.valueBoolean);
    }

    @Override
    public void setValueFromJsonElement(JsonElement element) {
        try {
            if (element.isJsonPrimitive()) {
                this.valueBoolean = element.getAsBoolean();
            } else {
                MasaAdditions.logger.warn("Failed to set config value for '{}' from the JSON element '{}'", this.getName(), element);
            }
        } catch (Exception e) {
            MasaAdditions.logger.warn("Failed to set config value for '{}' from the JSON element '{}'", this.getName(), element, e);
        }
    }
}

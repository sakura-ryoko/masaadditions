package com.red.masaadditions.tweakeroo_additions.config;

import com.google.common.collect.ImmutableList;
import com.red.masaadditions.MasaAdditions;

import fi.dy.masa.malilib.config.options.ConfigHotkey;
import fi.dy.masa.malilib.hotkeys.KeybindSettings;

import java.util.List;

public class HotkeysExtended {
    private static final String HOTKEYS_KEY = MasaAdditions.MOD_ID+ ".config.hotkeys_extended2";

    public static final ConfigHotkey BLINK_DRIVE = new ConfigHotkey("blinkDrive", "").apply(HOTKEYS_KEY);
    public static final ConfigHotkey BLINK_DRIVE_Y_LEVEL = new ConfigHotkey("blinkDriveYLevel", "").apply(HOTKEYS_KEY);
    public static final ConfigHotkey REPLACEMENT_MODE = new ConfigHotkey("replacementMode", "", KeybindSettings.MODIFIER_INGAME).apply(HOTKEYS_KEY);

    public static final List<ConfigHotkey> EXTENDED_HOTKEY_LIST = ImmutableList.of(
            BLINK_DRIVE,
            BLINK_DRIVE_Y_LEVEL,
            REPLACEMENT_MODE
    );
}

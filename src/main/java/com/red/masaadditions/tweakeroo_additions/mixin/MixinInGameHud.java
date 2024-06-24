package com.red.masaadditions.tweakeroo_additions.mixin;

import com.red.masaadditions.tweakeroo_additions.config.ConfigsExtended;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.scoreboard.ScoreboardObjective;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class MixinInGameHud {
    @Inject(method = "renderScoreboardSidebar(Lnet/minecraft/client/gui/DrawContext;Lnet/minecraft/scoreboard/ScoreboardObjective;)V", at = @At("HEAD"), cancellable = true)
    private void getOffsetType(DrawContext drawContext, ScoreboardObjective objective, CallbackInfo ci) {
        if (ConfigsExtended.Disable.DISABLE_SCOREBOARD_SIDEBAR_RENDERING.getBooleanValue()) {
            ci.cancel();
        }
    }

    @ModifyConstant(method = "renderScoreboardSidebar(Lnet/minecraft/client/gui/DrawContext;Lnet/minecraft/scoreboard/ScoreboardObjective;)V", constant = @Constant(longValue = 15))
    private long scoreboardSidebarMaxLength(long val) {
        return ConfigsExtended.Generic.SCOREBOARD_SIDEBAR_MAX_LENGTH.getIntegerValue();
    }
}
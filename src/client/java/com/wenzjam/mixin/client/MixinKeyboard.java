package com.wenzjam.mixin.client;

import com.wenzjam.ImeFixer;
import net.minecraft.client.Keyboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Keyboard.class)
public class MixinKeyboard {
    @Inject(at = @At("HEAD"), method = "onKey")
    private void onKey(long window, int key, int scancode, int action, int modifiers, CallbackInfo ci) {
        if (!ImeFixer.in_editor()) return;
        if (action != 1) return;
        if ((char)key < 128) ImeFixer.onAlphaKeyDown();
    }
}

package com.wenzjam.mixin.client;

import com.wenzjam.ImeFixer;
import net.minecraft.client.gui.screen.ChatScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ChatScreen.class)
public class MixinChatScreen {
    @Inject(at = @At("HEAD"), method = "sendMessage", cancellable = true)
    private void sendMessage(String chatText, boolean addToHistory, CallbackInfo ci) {
        if(ImeFixer.in_ime()) {
            ci.cancel();
        }
    }
}

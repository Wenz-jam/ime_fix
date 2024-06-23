package com.wenzjam.mixin.client;

import com.wenzjam.ImeFixer;
import net.minecraft.client.gui.screen.ChatScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ChatScreen.class)
public class MixinChatScreen {
    @Inject(at = @At("HEAD"), method = "sendMessage", cancellable = true)
    private void sendMessage(String chatText, boolean addToHistory, CallbackInfoReturnable<Boolean> cir) {
        if(ImeFixer.in_ime()) {
            cir.setReturnValue(false);
            cir.cancel();
        }
    }
}

package com.wenzjam.mixin.client;

import com.wenzjam.ImeFixer;
import net.minecraft.client.gui.widget.TextFieldWidget;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TextFieldWidget.class)
public class MixinTextFieldWidget {

    @Inject(at = @At("TAIL"), method = "<init>(Lnet/minecraft/client/font/TextRenderer;IIIILnet/minecraft/client/gui/widget/TextFieldWidget;Lnet/minecraft/text/Text;)V")
    private void init(CallbackInfo info) {
        ImeFixer.enter_editor();
    }

    @Inject(at = @At("HEAD"), method = "write")
    private void write(CallbackInfo info) {
        ImeFixer.onCharType();
    }

    @Inject(at = @At("HEAD"), method = "erase", cancellable = true)
    private void erase(int offset, CallbackInfo info) {
        if (ImeFixer.in_ime()){
            info.cancel();
            ImeFixer.erase();
        }
    }
}
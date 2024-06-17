package com.wenzjam.mixin.client;

import com.wenzjam.ImeFixer;
import net.minecraft.client.util.SelectionManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SelectionManager.class)
public class MixInSelectionManager {

    @Inject(at = @At("TAIL"), method = "<init>")
    private void init(CallbackInfo info) {
        ImeFixer.enter_editor();
    }

    @Inject(at = @At("HEAD"), method = "delete*", cancellable = true)
    private void delete(int offset, SelectionManager.SelectionType selectionType, CallbackInfo info) {
        if (ImeFixer.in_ime()){
            info.cancel();
            ImeFixer.erase();
        }
    }
}

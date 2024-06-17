package com.wenzjam;

import net.minecraft.client.gui.screen.Screen;


public class ImeFixer {
    static boolean in_editor = false;
    static int cursor_off = 0;

    public static boolean in_editor() {
        return in_editor;
    }

    public static boolean in_ime() {
        // if in ime should not delete or erase
        // now when shift or ctrl is pressed , it should delete.
        cursor_off = Math.max(cursor_off, 0);
        return !(Screen.hasShiftDown() || Screen.hasControlDown()) && in_editor && cursor_off != 0;

    }

    public static void onAlphaKeyDown() {
        cursor_off += 1;
    }

    public static void onCharType() {
        cursor_off = 0;
    }

    public static void erase() {
        cursor_off -= 1;
    }

    public static void enter_editor() {
        in_editor = true;
        cursor_off = 0;
    }

    public static void exit_editor() {
        in_editor = false;
    }
}

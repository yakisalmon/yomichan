package utils;

import org.jetbrains.annotations.NotNull;

import java.util.prefs.Preferences;

public class BotPreferences {
    public static final String PREF_PATH = "jlwe80jiombfxmkqeapolfkmr3443";

    private static final Preferences pref = Preferences.userRoot().node(PREF_PATH);

    public static final String VOICE = "voice";
    public static int getVoice(@NotNull Long guildID){
        return pref.getInt(guildID + VOICE, 0);
    }
    public static void setVoice(@NotNull Long guildID, int voice){
        pref.putInt(guildID + VOICE, voice);
    }
}

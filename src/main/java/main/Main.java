package main;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import utils.FilePaths;

import javax.security.auth.login.LoginException;
import java.io.File;

import static utils.Commands.*;

public class Main {
    public static final String TOKEN = "ODY3NDM2NjA4OTg1NDk3NjAw.YPhFSw.loafVGjIMX3HxYUqgD_Zm8cTx9s";

    public static void main(String[] args) {
        createFolderIfNotExists(FilePaths.CACHE_PATH);
        createFolderIfNotExists(FilePaths.SFX);

        try {
            JDA jda = JDABuilder.createDefault(TOKEN).build();
            jda.addEventListener(new BotManager());

            jda.updateCommands()
                    .addCommands(new CommandData(HELP, "マニュアルを呼び出す"))
                    .addCommands(new CommandData(JOIN, "読み上げを始める"))
                    .addCommands(new CommandData(SET_VOICE, "ボイスの設定").addOption(
                            OptionType.INTEGER, "id", "ボイスID"))
                    .addCommands(new CommandData(PURIFY, "空気清浄機"))
                    .addCommands(new CommandData(LEAVE, "読み上げを終了します"))
                    .queue();

        } catch (LoginException e) {
            e.printStackTrace();
        }
    }

    private static boolean createFolderIfNotExists(String path) {
        File f = new File(path);
        if (!f.exists()){
            return f.mkdir();
        }
        return true;
    }

}
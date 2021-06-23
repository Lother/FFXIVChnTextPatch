package name.yumao.ffxiv.chn;

import name.yumao.ffxiv.chn.swing.ProcessPanel;
import name.yumao.ffxiv.chn.util.res.Config;

import java.io.File;

public class FFXIVPatchMain {
    public static void main(String[] args) {
        Config.setConfigResource("conf" + File.separator + "global.properties");
        String path = Config.getProperty("GamePath");
        new ProcessPanel();
    }

}

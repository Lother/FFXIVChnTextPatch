package name.yumao.ffxiv.chn.thread;

import name.yumao.ffxiv.chn.replace.UnpackEXDF;
import name.yumao.ffxiv.chn.swing.PercentPanel;
import name.yumao.ffxiv.chn.swing.ProcessPanel;

import javax.swing.*;
import java.io.File;

public class UnpackThread implements Runnable{

    private final String inputFolder;
    private final String compareFolder;
    private final ProcessPanel processPanel;

    public UnpackThread(String resourceFolder,String compareFolder, ProcessPanel processPanel){
        this.inputFolder = resourceFolder;
        this.compareFolder = compareFolder;
        this.processPanel = processPanel;
    }
    @Override
    public void run() {
        try {
            processPanel.unpackButton.setEnabled(false);
            PercentPanel percentPanel = new PercentPanel("拆包");
            //汉化补丁

            new UnpackEXDF(inputFolder + File.separator + "0a0000.win32.index",percentPanel).unpack("merge");
            new UnpackEXDF(compareFolder + File.separator + "0a0000.win32.index",percentPanel).unpack("compare");

            JOptionPane.showMessageDialog(null, "Success", "Success", JOptionPane.PLAIN_MESSAGE);
            percentPanel.dispose();
            processPanel.unpackButton.setEnabled(true);
        }catch (Exception exception){
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            exception.printStackTrace();
        }
    }
}

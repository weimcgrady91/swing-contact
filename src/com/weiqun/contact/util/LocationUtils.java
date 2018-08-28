package com.weiqun.contact.util;

import javax.swing.*;
import java.awt.*;

public class LocationUtils {
    public static void setLocation(JFrame jFrame, int width, int height) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        int screenWidth = toolkit.getScreenSize().width;
        int screenHeight = toolkit.getScreenSize().height;
        jFrame.setLocation((screenWidth - width) / 2, (screenHeight - height) / 2);
    }
}

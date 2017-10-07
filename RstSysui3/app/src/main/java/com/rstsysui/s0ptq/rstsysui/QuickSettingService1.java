package com.rstsysui.s0ptq.rstsysui;

import android.service.quicksettings.TileService;
import android.widget.Toast;
import shell.Shell;

/**
 * Created by S0ptq on 2017/10/5.
 */

public class QuickSettingService1 extends TileService {

    @Override
    public void onClick() {
        Toast.makeText(getApplicationContext(), "设定为Permissive", Toast.LENGTH_SHORT).show();
        Shell.SU.run("setenforce 0");
    }


}

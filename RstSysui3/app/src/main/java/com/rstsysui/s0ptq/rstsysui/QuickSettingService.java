package com.rstsysui.s0ptq.rstsysui;

import android.service.quicksettings.TileService;
import android.widget.Toast;
import shell.Shell;

/**
 * Created by S0ptq on 2017/10/4.
 */


public class QuickSettingService extends TileService {

    @Override
    public void onClick() {
        Toast.makeText(this, "重启中", Toast.LENGTH_SHORT).show();
        Shell.SU.run("pkill -f com.android.systemui");
    }


}
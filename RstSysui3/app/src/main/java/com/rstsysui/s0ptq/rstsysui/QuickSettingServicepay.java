package com.rstsysui.s0ptq.rstsysui;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.service.quicksettings.TileService;
import android.view.ContextThemeWrapper;
import android.widget.Toast;


import shell.Shell;

/**
 * Created by S0ptq on 2017/10/6.
 */

public class QuickSettingServicepay extends TileService {
    @Override
    public void onClick ( ){
        String[] items1={ "支付宝扫码", "支付宝付款码", "微信扫码" ,"微信付款码"};
        AlertDialog.Builder Paybuilder = new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.AppTheme_NoActionBar));
        Paybuilder.setTitle("支付");
        Paybuilder.setItems(items1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        Toast.makeText(getApplicationContext(), "跳转至支付宝扫码", Toast.LENGTH_SHORT).show();
                        Shell.SU.run("am start -n com.eg.android.AlipayGphone/com.alipay.mobile.scan.as.main.MainCaptureActivity");
                        break;
                    case 1:
                        Toast.makeText(getApplicationContext(), "跳转至支付宝付款", Toast.LENGTH_SHORT).show();
                        Shell.SU.run("am start -n com.eg.android.AlipayGphone/com.alipay.mobile.onsitepay9.payer.OspTabHostActivity");
                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(), "跳转至微信扫码", Toast.LENGTH_SHORT).show();
                        Shell.SU.run("am start -n com.tencent.mm/com.tencent.mm.plugin.scanner.ui.BaseScanUI");
                        break;
                    case 3:
                        Toast.makeText(getApplicationContext(), "跳转至微信付款", Toast.LENGTH_SHORT).show();
                        Shell.SU.run("am start -n com.tencent.mm/com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI");
                        break;
                    default:
                        break;
                }
            }
        });
        Paybuilder.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
            }
        });
        showDialog(Paybuilder.create());
    }
}

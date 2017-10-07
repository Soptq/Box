package com.rstsysui.s0ptq.rstsysui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Toast;
import shell.Shell;
import android.widget.ListView;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import android.app.AlertDialog;

public class MainActivity extends AppCompatActivity {

    String[] Title={
            " 重启用户界面",
            " 更改Selinux",
            " 去除感叹号",
            " 高级重启",
            " Shell终端"
    };

    String [] Descrip={
            "  需要Root权限",
            "  需要Root权限",
            "  需要Root权限，完成后请手动开关飞行模式以生效",
            "  如同标题说的一样，高级重启，需要Root权限",
            "  运行你的Shell命令"
    };

    int[] imgid={
            R.drawable.tile_icon,
            R.drawable.tile_icon1,
            R.drawable.ic_network,
            R.drawable.advanrestart,
            R.drawable.ic_sort_black_24dp
    };


    ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.idListView);
        List<HashMap<String , String>> list = new ArrayList<>();
        CustomListAdapter adapter=new CustomListAdapter(this,Title,Descrip,imgid);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               switch (i){

                   case 0:
                       AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                       builder.setCancelable(true);
                       builder.setTitle("重启用户界面");
                       builder.setMessage("确定重启用户界面？");
                       builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialog, int id) {
                               Toast.makeText(getApplicationContext(), "重启中", Toast.LENGTH_SHORT).show();
                               Shell.SU.run("pkill -f com.android.systemui");
                           }
                       })
                               .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                   @Override
                                   public void onClick(DialogInterface dialog, int which) {
                                   }
                               });
                       builder.create().show();
                       break;

                   case 1:
                       AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                       builder1.setCancelable(true);
                       builder1.setTitle("关闭Selinux");
                       builder1.setMessage("Selinux可以有效保护您的设备，确定关闭Selinux？");
                       builder1.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialog, int id) {
                               Toast.makeText(getApplicationContext(), "设定为Permissive", Toast.LENGTH_SHORT).show();
                               Shell.SU.run("setenforce 0");
                           }
                       })
                               .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                   @Override
                                   public void onClick(DialogInterface dialog, int which) {
                                   }
                               });
                       builder1.create().show();
                       break;

                   case 2:
                       AlertDialog.Builder builder2 = new AlertDialog.Builder(MainActivity.this);
                       builder2.setCancelable(true);
                       builder2.setTitle("清除网络感叹号");
                       builder2.setMessage("完成后请手动开关飞行模式以刷新");
                       builder2.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialog, int id) {
                               Toast.makeText(getApplicationContext(), "更改服务器中", Toast.LENGTH_SHORT).show();
                               Shell.SU.run("settings put global captive_portal_server http://connect.rom.miui.com/generate_204");
                               Shell.SU.run("settings put global captive_portal_http_url http://connect.rom.miui.com/generate_204" );
                               Shell.SU.run("settings put global captive_portal_http_url https://connect.rom.miui.com/generate_204" );
                           }
                       })
                               .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                   @Override
                                   public void onClick(DialogInterface dialog, int which) {
                                   }
                               });
                       builder2.create().show();
                       break;

                   case 3:
                       final String[] items={ "Recovery", "BootLoader", "Edl(9008)模式" ,"软重启"};
                       AlertDialog.Builder builder3 = new AlertDialog.Builder(MainActivity.this);
                       builder3.setTitle("高级重启");
                       builder3.setItems(items, new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialog, int which) {
                               switch (which){

                                   case 0:

                                       AlertDialog.Builder builder4 = new AlertDialog.Builder(MainActivity.this);
                                       builder4.setCancelable(true);
                                       builder4.setTitle("重启进入Recovery");
                                       builder4.setMessage("命令在某些厂商的定制化系统上可能不会生效，请查阅官方文档手动进入Recovery模式");
                                       builder4.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                           @Override
                                           public void onClick(DialogInterface dialog, int id) {
                                               Shell.SU.run("reboot recovery");
                                           }
                                       })
                                               .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                                   @Override
                                                   public void onClick(DialogInterface dialog, int which) {
                                                   }
                                               });
                                       builder4.create().show();
                                       break;

                                   case 1:
                                       AlertDialog.Builder builder5 = new AlertDialog.Builder(MainActivity.this);
                                       builder5.setCancelable(true);
                                       builder5.setTitle("重启进入BootLoader");
                                       builder5.setMessage("命令在某些厂商的定制化系统上可能不会生效，请查阅官方文档手动进入BootLoader模式");
                                       builder5.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                           @Override
                                           public void onClick(DialogInterface dialog, int id) {
                                               Shell.SU.run("reboot bootloader");
                                           }
                                       })
                                               .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                                   @Override
                                                   public void onClick(DialogInterface dialog, int which) {
                                                   }
                                               });
                                       builder5.create().show();
                                       break;

                                   case 2:
                                       AlertDialog.Builder builder6 = new AlertDialog.Builder(MainActivity.this);
                                       builder6.setCancelable(true);
                                       builder6.setTitle("重启进入Edl(9008)");
                                       builder6.setMessage("Edl(9008)模式只针对高通CPU机型，且大部分手机厂商已经封堵命令进入Edl模式的方法，如果这个命令您运行成功了，说明您的手机Rom有重大安全漏洞，任何人可以无视任何安全措施强刷您的手机");
                                       builder6.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                           @Override
                                           public void onClick(DialogInterface dialog, int id) {
                                               Shell.SU.run("reboot edl");
                                           }
                                       })
                                               .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                                   @Override
                                                   public void onClick(DialogInterface dialog, int which) {
                                                   }
                                               });
                                       builder6.create().show();
                                       break;

                                   case 3:
                                       AlertDialog.Builder builder7 = new AlertDialog.Builder(MainActivity.this);
                                       builder7.setCancelable(true);
                                       builder7.setTitle("软重启");
                                       builder7.setMessage("警告：软重启通过强制关闭系统根服务来刷新系统状态，将可能导致无法预料的情况，例如破坏电池评估的精准度等。建议非特殊情况，请重启而非软重启");
                                       builder7.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                           @Override
                                           public void onClick(DialogInterface dialog, int id) {
                                               Shell.SU.run("killall zygote");
                                           }
                                       })
                                               .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                                   @Override
                                                   public void onClick(DialogInterface dialog, int which) {
                                                   }
                                               });
                                       builder7.create().show();
                                       break;
                               }

                           }
                       });
                       builder3.create().show();
                       break;
                   case 4:
                       AlertDialog.Builder builder8 = new AlertDialog.Builder(MainActivity.this);
                       builder8.setCancelable(true);
                       builder8.setTitle("Shell终端");
                       builder8.setMessage("注意:此页面的完成完全是由于作者朋友的需要(懒),所以这个页面源代码全部来源于GitHub开源项目的示例，若您认为这个终端做的不错，请前往'关于'页面中开源协议的地址为原作者点星");
                       builder8.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialog, int id) {
                               Intent i = new Intent(MainActivity.this,ShellInputActivity.class);
                               startActivity(i);
                           }
                       })
                               .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                   @Override
                                   public void onClick(DialogInterface dialog, int which) {
                                   }
                               });
                       builder8.create().show();
                       break;
               }
            }
        });



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Developed By Soptq, Still learning Android Studio...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Intent i = new Intent(this,MainActivity2.class);
                startActivity(i);
                return true;

        }

        int id = item.getItemId();

        if (id == R.id.item1) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }






}

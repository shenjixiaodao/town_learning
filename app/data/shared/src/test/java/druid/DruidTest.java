package druid;

import com.alibaba.druid.filter.config.ConfigTools;

/**
 * Created by jinhui on 2017/11/22.
 */
public class DruidTest {

    public static void main(String[] strs) throws Exception {
        String key = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAIDIgZhZ5EdF4ON3SJWua3jH8c5fLFwlwFsSkHZvuSFh27SMdOSY3k3rA1S125e8Mpv5ayzbeTH777/YWNKtMmcCAwEAAQ==";
        String chiText = "DmI8adSezThIIqakAv7OjnbfhJarQX3QddvIhY0q8tODMiA2k8mrF8bwBnvhbJKKPTHfxm/VULwibgY9tB7EOw==";
        String res = ConfigTools.decrypt(key,chiText);
        System.out.println(res);
    }
}
